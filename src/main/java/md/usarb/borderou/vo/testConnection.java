package md.usarb.borderou.vo;

import java.sql.*;
import java.util.Collection;

import md.usarb.borderou.dao.DisciplinaDao;
import md.usarb.borderou.dao.FacultateDao;
import md.usarb.borderou.dao.GrupaDao;
import md.usarb.borderou.dao.SpecialitateDao;
import md.usarb.borderou.dao.StudentDao;
import md.usarb.borderou.entities.licenta.Facultate;
import md.usarb.borderou.entities.licenta.Specialitate;
import md.usarb.borderou.factory.DaoFactory;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;


public class testConnection {

	public static void main(String[] args) {
//		Configuration configuration = new Configuration();
//    	configuration.configure("hibernate.cfg.xml");
//    	SessionFactory factory =configuration.buildSessionFactory();
//    	Session session = factory.openSession();
//		Collection<Specialitate> userList;
//		
//		Criteria criteria = session.createCriteria(Specialitate.class, "specialitate");
//		criteria.createAlias("specialitate.facultate", "facultate");
//		criteria.add(Restrictions.eq("facultate.id", 24));
//		userList = criteria.list();
//		System.out.println(userList);
//		System.out.println(userList.iterator().next().denumirea);
		
//		DisciplinaDao dao = DaoFactory.buildObject(DisciplinaDao.class);
//		System.out.println(dao.getListDisciplina(22, 1, 51, 98).size());
//		System.out.println(dao.getListDisciplina(22, 1, 51, 98).iterator().next().denumirea);
//		
//		FacultateDao dao2 = DaoFactory.buildObject(FacultateDao.class);
//		System.out.println(dao2.getListFacultate().size());
//		System.out.println(dao2.getListFacultate().iterator().next().denumirea);
//		
//		SpecialitateDao dao3 = DaoFactory.buildObject(SpecialitateDao.class);
//		System.out.println(dao3.getListSpecialitate(22).size());
//		System.out.println(dao3.getListSpecialitate(22).iterator().next().denumirea);
//		
//		GrupaDao dao4 = DaoFactory.buildObject(GrupaDao.class);
//		System.out.println(dao4.getListGrupa(21).size());
//		System.out.println(dao4.getListGrupa(21).iterator().next().denumirea);
//		
//		SpecialitateDao dao5 = DaoFactory.buildObject(SpecialitateDao.class);
//		System.out.println(dao5.getSemestre(21).size());
//		System.out.println(dao5.getSemestre(21).iterator().next());
		
		
		StudentDao dao = DaoFactory.buildObject(StudentDao.class);
		System.out.println(dao.getListStudents(0, 0, 0, 0).size());
//		System.out.println(dao.getListDisciplina(22, 1, 51, 98).size());
//		System.out.println(dao.getListDisciplina(22, 1, 51, 98).iterator().next().denumirea);
	}

}
