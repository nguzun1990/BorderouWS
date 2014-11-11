package md.usarb.borderou.dao;

import java.util.Collection;

import md.usarb.borderou.entities.licenta.Disciplina;
import md.usarb.borderou.entities.licenta.Facultate;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

//@Repository
public class FacultateDao implements BaseDao{
	
	private static final Logger log = Logger.getLogger(FacultateDao.class.getName());
	private static FacultateDao instance;
	private static SessionFactory factory;

	private FacultateDao() {
		try {
			Configuration configuration = new Configuration();
	    	configuration.configure("hibernate.cfg.xml");
			factory = configuration.buildSessionFactory();
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();			
		}
	}
	
	public static FacultateDao getInstance() {
		if (instance == null) {
			instance = new FacultateDao();
		}
		return instance;
	}
	
	public Collection<Facultate> getListFacultate() {
 		
    	Session session = factory.openSession();
		Collection<Facultate> list;
		
		Criteria criteria = session.createCriteria(Facultate.class, "facultate");
		criteria.add(Restrictions.isNotNull("facultate.codUniversitar"));
		list = criteria.list();
		
		return list;
		
	}

}
