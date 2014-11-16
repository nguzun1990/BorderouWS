package md.usarb.borderou.service;

import java.util.Collection;

import md.usarb.borderou.common.FormatedList;
import md.usarb.borderou.dao.StudentDao;
import md.usarb.borderou.entities.licenta.Student;
import md.usarb.borderou.exception.DaoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
		
	@Autowired
	StudentDao dao;
	
	
	public FormatedList<Student> getListStudents(int idDisciplina, int idGrupa, int semestru, String promotia, int idProfesor) {
		Collection<Student> list;
		FormatedList<Student> formatedList = new FormatedList<Student>();
		try {
			list = dao.getListStudents(idDisciplina, idGrupa, semestru, promotia, idProfesor);
			formatedList.setList(list);
			formatedList.setSuccess(true);
		} catch (DaoException e) {
			formatedList.setSuccess(false);
		}
		
		 return formatedList;
	}


}
