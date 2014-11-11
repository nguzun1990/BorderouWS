package md.usarb.borderou.dao;

import java.util.Collection;

import md.usarb.borderou.entities.licenta.Disciplina;
import md.usarb.borderou.entities.licenta.Student;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

public class StudentDao implements BaseDao{
	
	private static final Logger log = Logger.getLogger(StudentDao.class.getName());
	private static StudentDao instance;
	private static SessionFactory factory;

	private StudentDao() {
		try {
			Configuration configuration = new Configuration();
	    	configuration.configure("hibernate.cfg.xml");
			factory = configuration.buildSessionFactory();
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();			
		}
	}
	
	public static StudentDao getInstance() {
		if (instance == null) {
			instance = new StudentDao();
		}
		return instance;
	}
	
public Collection<Student> getListStudents(int idDisciplina, int idGrupa, int semestru, int idProfesor) {
 		
    	Session session = factory.openSession();
		Collection<Student> list;
		
		Criteria criteria = session.createCriteria(Student.class, "student");
		criteria.createAlias("student.planStudentList", "planStudent", JoinType.LEFT_OUTER_JOIN);
//		criteria.createAlias("student.planStudentList", "planStudent");
//		criteria.add(Restrictions.eq("planStudent.idProfesor", idProfesor));
		criteria.createAlias("planStudent.planDisciplina", "planDisciplina");
		criteria.add(Restrictions.eq("planDisciplina.semestrul", semestru));
		criteria.createAlias("planDisciplina.disciplina", "disciplina");
		criteria.add(Restrictions.eq("disciplina.id", idDisciplina));
		criteria.createAlias("student.grupa", "grupa");
		criteria.add(Restrictions.eq("grupa.id", idGrupa));
//		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		list = criteria.list();
		
		
		return list;
		
	}


}
