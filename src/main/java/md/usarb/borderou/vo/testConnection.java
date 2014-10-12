package md.usarb.borderou.vo;

import java.sql.*;
import java.util.Collection;

import md.usarb.borderou.entities.licenta.Facultate;
import md.usarb.borderou.entities.licenta.Specialitate;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class testConnection {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	SessionFactory factory =configuration.buildSessionFactory();
    	Session session = factory.openSession();
		Collection<Specialitate> userList;
		
		Criteria criteria = session.createCriteria(Specialitate.class, "specialitate");
		criteria.createAlias("specialitate.facultate", "facultate");
		criteria.add(Restrictions.eq("facultate.id", 24));
		userList = criteria.list();
		System.out.println(userList);
		System.out.println(userList.iterator().next().denumirea);
		
//		Criteria c = session.createCriteria(Dokument.class, "dokument");
//		c.createAlias("dokument.role", "role"); // inner join by default
//		c.createAlias("role.contact", "contact");
//		c.add(Restrictions.eq("contact.lastName", "Test"));
//		return c.list();
	}

}
