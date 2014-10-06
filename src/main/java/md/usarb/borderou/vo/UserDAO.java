package md.usarb.borderou.vo;

import java.net.HttpRetryException;
import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;




/**
 *
 * @author Guzun
 */
public class UserDAO {

    public static final String GET_USER_ERROR_MSG = "Error on get user with id ";
    public static final String GET_USER_LIST_ERROR_MSG = "Errore get list of users";
    public static final String UPDATE_USER_ERROR_MSG = "Errore on update user with id ";
    public static final String CREATE_USER_ERROR_MSG = "Errore on create user";
    public static final String DELETE_USER_ERROR_MSG = "Errore on delete user";

    

    private static SessionFactory factory; 



    
    public static void test() {
    	Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	SessionFactory factory =configuration.buildSessionFactory();
    	
    	
//    	try {
//			factory = new Configuration().configure().buildSessionFactory();
//		} catch (Throwable ex) {
//			System.err.println("Failed to create sessionFactory object. " + ex);
//			throw new ExceptionInInitializerError(ex);
//		}
    	
    	
    	Session session = factory.openSession();
		Collection<User1> userList;
		
		Criteria criteria = session.createCriteria(User.class);
		userList = criteria.list();
		System.out.println(userList);
    }
    
    public static void main(String[] args) {
    	test();
    }

}
