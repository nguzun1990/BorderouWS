package md.usarb.borderou.dao;

import java.util.Collection;

import md.usarb.borderou.entities.licenta.Disciplina;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class DisciplinaDao implements BaseDao{
	
	private static final Logger log = Logger.getLogger(DisciplinaDao.class.getName());
	private static DisciplinaDao instance;
	private static SessionFactory factory;

	private DisciplinaDao() {
		try {
			Configuration configuration = new Configuration();
	    	configuration.configure("hibernate.cfg.xml");
			factory = configuration.buildSessionFactory();
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();			
		}
	}
	
	public static DisciplinaDao getInstance() {
		if (instance == null) {
			instance = new DisciplinaDao();
		}
		return instance;
	}
	
	public Collection<Disciplina> getListDisciplina(int idSpecialitatea, int semestrul, int idGrupa, int idProfesor) {
 		
    	Session session = factory.openSession();
		Collection<Disciplina> list;
		
		Criteria criteria = session.createCriteria(Disciplina.class, "disciplina");
		criteria.createAlias("disciplina.incadrareaProfesorilorList", "incadrareaProfesorilor");
		criteria.add(Restrictions.eq("incadrareaProfesorilor.idProfesor", idProfesor));
		criteria.createAlias("disciplina.planDisciplinaList", "planDisciplina");
		criteria.createAlias("planDisciplina.planStudii", "planStudii");
		criteria.createAlias("planStudii.specialitate", "specialitate");
		criteria.createAlias("specialitate.grupaList", "grupa");
		criteria.add(Restrictions.eq("specialitate.id", idSpecialitatea));
		criteria.add(Restrictions.eq("planDisciplina.semestrul", semestrul));
		criteria.add(Restrictions.eq("grupa.id", idGrupa));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		list = criteria.list();
		
		return list;
		
	}

}
