package md.usarb.borderou.web.controller;

import md.usarb.borderou.common.FormatedList;
import md.usarb.borderou.dao.StudentDao;
import md.usarb.borderou.entities.licenta.Student;
import md.usarb.borderou.factory.DaoFactory;
import md.usarb.borderou.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value = "api/list/students", method = RequestMethod.GET)
	@ResponseBody
	public FormatedList<Student> getStudents(
			@RequestParam("idDisciplina") Integer idDisciplina,
			@RequestParam("semestru") Integer semestru,
			@RequestParam("idGrupa") Integer idGrupa,
			@RequestParam("promotia") String promotia,
			@RequestParam("idProfesor") Integer idProfesor,			
			Model model) {
		StudentDao dao = DaoFactory.buildObject(StudentDao.class);
		
		return this.studentService.getListStudents(idDisciplina, idGrupa, semestru, promotia, idProfesor);
		
	}
	
}
