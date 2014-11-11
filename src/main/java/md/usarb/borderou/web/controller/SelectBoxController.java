package md.usarb.borderou.web.controller;

import java.util.Collection;

import md.usarb.borderou.dao.DisciplinaDao;
import md.usarb.borderou.dao.FacultateDao;
import md.usarb.borderou.dao.GrupaDao;
import md.usarb.borderou.dao.SpecialitateDao;
import md.usarb.borderou.entities.licenta.Disciplina;
import md.usarb.borderou.entities.licenta.Facultate;
import md.usarb.borderou.entities.licenta.Grupa;
import md.usarb.borderou.entities.licenta.Semestru;
import md.usarb.borderou.entities.licenta.Specialitate;
import md.usarb.borderou.factory.DaoFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
public class SelectBoxController {
	
	@RequestMapping(value = "api/list/faculties")
	@ResponseBody
	public Collection<Facultate> getFaculties(Model model) {
		
		FacultateDao dao = DaoFactory.buildObject(FacultateDao.class);
	    return  dao.getListFacultate();
	}
	
	@RequestMapping(value = "api/list/specialties", method = RequestMethod.GET)
	@ResponseBody
	public Collection<Specialitate> getSpecialties(@RequestParam("idFacultate") Integer idFacultate, Model model) {
		
		SpecialitateDao dao = DaoFactory.buildObject(SpecialitateDao.class);
	    return  dao.getListSpecialitate(idFacultate);
	}
	
	@RequestMapping(value = "api/list/groups", method = RequestMethod.GET)
	@ResponseBody
	public Collection<Grupa> getGroups(@RequestParam("idSpecialtate") Integer idSpecialtate, Model model) {
		
		GrupaDao dao = DaoFactory.buildObject(GrupaDao.class);
	    return  dao.getListGrupa(idSpecialtate);
	}
	
	@RequestMapping(value = "api/list/semesters", method = RequestMethod.GET)
	@ResponseBody
	public Collection<Semestru> getSemestre(@RequestParam("idSpecialtate") Integer idSpecialtate, Model model) {
		
		SpecialitateDao dao = DaoFactory.buildObject(SpecialitateDao.class);;
	    return  dao.getSemestre(idSpecialtate);
	}
	
	@RequestMapping(value = "api/list/courses", method = RequestMethod.GET)
	@ResponseBody
	public Collection<Disciplina> getSemestre(
			@RequestParam("idSpecialitate") Integer idSpecialitate,
			@RequestParam("semestru") Integer semestru,
			@RequestParam("idGrupa") Integer idGrupa,
			@RequestParam("idProfesor") Integer idProfesor,			
			Model model) {
		DisciplinaDao dao = DaoFactory.buildObject(DisciplinaDao.class);
	    return  dao.getListDisciplina(idSpecialitate, semestru, idGrupa, idProfesor);
	}
	
}
