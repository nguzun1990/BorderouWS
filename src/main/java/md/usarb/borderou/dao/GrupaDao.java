package md.usarb.borderou.dao;

import java.util.Collection;

import md.usarb.borderou.entities.licenta.Disciplina;
import md.usarb.borderou.entities.licenta.Grupa;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class GrupaDao implements BaseDao{
	
	private static final Logger log = Logger.getLogger(GrupaDao.class.getName());
	private static GrupaDao instance;
	private static SessionFactory factory;

	private GrupaDao() {
		try {
			Configuration configuration = new Configuration();
	    	configuration.configure("hibernate.cfg.xml");
			factory = configuration.buildSessionFactory();
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();			
		}
	}
	
	public static GrupaDao getInstance() {
		if (instance == null) {
			instance = new GrupaDao();
		}
		return instance;
	}
	
	public Collection<Grupa> getListGrupa(int idGrupa) {
 		
    	Session session = factory.openSession();
		Collection<Grupa> list;
		
		Criteria criteria = session.createCriteria(Grupa.class, "grupa");
		criteria.createAlias("grupa.specialitate", "specialitate");
		criteria.add(Restrictions.eq("specialitate.id", idGrupa));
//		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		list = criteria.list();
		
		return list;
		
	}

}
