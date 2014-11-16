package md.usarb.borderou.dao;

import java.util.Collection;

import md.usarb.borderou.entities.licenta.Disciplina;
import md.usarb.borderou.exception.DaoException;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DisciplinaDao implements BaseDao {

	private static final Logger log = Logger.getLogger(DisciplinaDao.class.getName());
	
	@Autowired
	private SessionFactory sessionFactory;

	public Collection<Disciplina> getListDisciplina(int idSpecialitatea,
			int semestrul, int idGrupa, String promotia, int idProfesor) throws DaoException {
		Collection<Disciplina> list = null;
		try {
			StatelessSession session = this.sessionFactory.openStatelessSession();

			Criteria criteria = session.createCriteria(Disciplina.class,
					"disciplina");
			criteria.createAlias("disciplina.incadrareaProfesorilorList",
					"incadrareaProfesorilor");
			criteria.add(Restrictions.eq("incadrareaProfesorilor.idProfesor",
					idProfesor));
			criteria.createAlias("disciplina.planDisciplinaList",
					"planDisciplina");
			criteria.createAlias("planDisciplina.planStudii", "planStudii");
			criteria.add(Restrictions.eq("planStudii.promotia", promotia));
			criteria.createAlias("planStudii.specialitate", "specialitate");
			criteria.createAlias("specialitate.grupaList", "grupa");
			criteria.add(Restrictions.eq("specialitate.id", idSpecialitatea));
			criteria.add(Restrictions.eq("planDisciplina.semestrul", semestrul));
			criteria.add(Restrictions.eq("grupa.id", idGrupa));
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			list = criteria.list();

		} catch (Exception ex) {
			throw new DaoException("Disciplina DAO Exception" + ex.getMessage(), log);
		}
		return list;

	}
}
