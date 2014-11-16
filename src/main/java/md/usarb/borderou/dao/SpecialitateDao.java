package md.usarb.borderou.dao;

import java.util.ArrayList;
import java.util.Collection;

import md.usarb.borderou.entities.licenta.Semestru;
import md.usarb.borderou.entities.licenta.Specialitate;
import md.usarb.borderou.exception.DaoException;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SpecialitateDao implements BaseDao {

	private static final Logger log = Logger.getLogger(SpecialitateDao.class
			.getName());

	@Autowired
	private SessionFactory sessionFactory;

	public Collection<Specialitate> getListSpecialitate(int idFacultate) throws DaoException {
		Collection<Specialitate> list;
		try {
			StatelessSession session = this.sessionFactory.openStatelessSession();	
			Criteria criteria = session.createCriteria(Specialitate.class,
					"specialitate");
			criteria.createAlias("specialitate.facultate", "facultate");
			criteria.add(Restrictions.eq("facultate.id", idFacultate));
			// criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			list = criteria.list();
		} catch (Exception ex) {
			throw new DaoException("Specialitatea DAO Exception" + ex.getMessage(), log);
		}
		return list;

	}

	public Collection<Semestru> getSemestre(int idSpecialitate) throws DaoException {
		Collection<Semestru> list = new ArrayList<Semestru>();
		Semestru semestru;
		try {
			StatelessSession session = this.sessionFactory.openStatelessSession();		
			Specialitate specialitate = (Specialitate) session.get(Specialitate.class, idSpecialitate);
			int nrSemestre = specialitate.getNrAniStudiu() * 2;
			for(int i = 1; i<= nrSemestre; i++) {
				semestru = new Semestru(i);
				list.add(semestru);
			}
		} catch (Exception ex) {
			throw new DaoException("Specialitatea DAO Exception" + ex.getMessage(), log);
		}
		return list;

	}

}
