package md.usarb.borderou.dao;

import java.util.Collection;

import md.usarb.borderou.entities.licenta.Student;
import md.usarb.borderou.exception.DaoException;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao implements BaseDao{
	
	private static final Logger log = Logger.getLogger(StudentDao.class.getName());
	
	@Autowired
	private SessionFactory sessionFactory;

	public Collection<Student> getListStudents(int idDisciplina, int idGrupa, int semestru, String promotia, int idProfesor) throws DaoException {
 		Collection<Student> list;
//		try {
			StatelessSession session = this.sessionFactory.openStatelessSession();	
			Criteria criteria = session.createCriteria(Student.class, "student");
			criteria.createAlias("student.planStudentList", "planStudent", JoinType.LEFT_OUTER_JOIN);
	//		criteria.createAlias("student.planStudentList", "planStudent");
	//		criteria.add(Restrictions.eq("planStudent.idProfesor", idProfesor));
			criteria.createAlias("planStudent.planDisciplina", "planDisciplina");
			criteria.add(Restrictions.eq("planDisciplina.semestrul", semestru));
			criteria.createAlias("planDisciplina.planStudii", "planStudii");
			criteria.add(Restrictions.eq("planStudii.promotia", promotia));
			criteria.createAlias("planDisciplina.disciplina", "disciplina");
			criteria.add(Restrictions.eq("disciplina.id", idDisciplina));
			criteria.createAlias("student.grupa", "grupa");
			criteria.add(Restrictions.eq("grupa.id", idGrupa));
	//		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			list = criteria.list();
//		} catch (Exception ex) {
//			throw new DaoException("Student DAO Exception" + ex.getMessage(), log);
//		}
		
		return list;
		
	}


}
