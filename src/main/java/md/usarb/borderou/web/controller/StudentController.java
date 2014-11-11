package md.usarb.borderou.web.controller;

import java.util.Collection;

import md.usarb.borderou.dao.StudentDao;
import md.usarb.borderou.entities.licenta.Student;
import md.usarb.borderou.factory.DaoFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
public class StudentController {
	
	
	@RequestMapping(value = "api/list/students", method = RequestMethod.GET)
	@ResponseBody
	public Collection<Student> getStudents(
			@RequestParam("idDisciplina") Integer idDisciplina,
			@RequestParam("semestru") Integer semestru,
			@RequestParam("idGrupa") Integer idGrupa,
			@RequestParam("idProfesor") Integer idProfesor,			
			Model model) {
		StudentDao dao = DaoFactory.buildObject(StudentDao.class);
		
		return dao.getListStudents(idDisciplina, idGrupa, semestru, idProfesor);
	}
	
}
