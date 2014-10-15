package md.usarb.borderou.dao;

import java.util.ArrayList;
import java.util.Collection;

import md.usarb.borderou.entities.licenta.Disciplina;
import md.usarb.borderou.entities.licenta.Specialitate;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class SpecialitateDao implements BaseDao {

	private static final Logger log = Logger.getLogger(SpecialitateDao.class
			.getName());
	private static SpecialitateDao instance;
	private static SessionFactory factory;

	private SpecialitateDao() {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			factory = configuration.buildSessionFactory();
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
		}
	}

	public static SpecialitateDao getInstance() {
		if (instance == null) {
			instance = new SpecialitateDao();
		}
		return instance;
	}

	public Collection<Specialitate> getListSpecialitate(int idFacultate) {

		Session session = factory.openSession();
		Collection<Specialitate> list;

		Criteria criteria = session.createCriteria(Specialitate.class,
				"specialitate");
		criteria.createAlias("specialitate.facultate", "facultate");
		criteria.add(Restrictions.eq("facultate.id", idFacultate));
		// criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		list = criteria.list();

		return list;

	}

	public Collection<Integer> getSemestre(int idSpecialitate) {

		Session session = factory.openSession();
		Collection<Integer> list = new ArrayList<Integer>();

		Specialitate specialitate = (Specialitate) session.get(Specialitate.class, idSpecialitate);
		
		
		int nrSemestre = specialitate.getNrAniStudiu() * 2;
		for(int i = 1; i<= nrSemestre; i++) {
			list.add(i);
		}
		
		return list;

	}

}
