package md.usarb.borderou.web.controller;

import java.util.Collection;

import md.usarb.borderou.common.FormatedList;
import md.usarb.borderou.dao.DisciplinaDao;
import md.usarb.borderou.dao.FacultateDao;
import md.usarb.borderou.dao.GrupaDao;
import md.usarb.borderou.dao.PlanStudiiDao;
import md.usarb.borderou.dao.SpecialitateDao;
import md.usarb.borderou.entities.licenta.Disciplina;
import md.usarb.borderou.entities.licenta.Facultate;
import md.usarb.borderou.entities.licenta.Grupa;
import md.usarb.borderou.entities.licenta.PlanStudii;
import md.usarb.borderou.entities.licenta.Promotia;
import md.usarb.borderou.entities.licenta.Semestru;
import md.usarb.borderou.entities.licenta.Specialitate;
import md.usarb.borderou.factory.DaoFactory;
import md.usarb.borderou.service.DisciplinaService;
import md.usarb.borderou.service.FacultateService;
import md.usarb.borderou.service.GrupaService;
import md.usarb.borderou.service.PlanStudiiService;
import md.usarb.borderou.service.SpecialitateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
public class SelectBoxController {
	
	@Autowired
	FacultateService facultateService;

	@Autowired
	SpecialitateService specialitateService;
	
	@Autowired
	GrupaService grupaService;
	
	@Autowired
	DisciplinaService disciplinaService;
	
	@Autowired
	PlanStudiiService planStudiiService;
//	@RequestMapping(value = "api/list/faculties",  headers = "Access-Control-Allow-Origin: *")
	@RequestMapping(value = "api/list/faculties")
	@ResponseBody
	public FormatedList<Facultate> getFaculties(Model model) {
		
		return this.facultateService.getListFacultate();
	}
	
	@RequestMapping(value = "api/list/promotii")
	@ResponseBody
	public FormatedList<Promotia> getPromotii(Model model) {
		
		return this.planStudiiService.getListPromotii();
	}
	
	@RequestMapping(value = "api/list/specialties", method = RequestMethod.GET)
	@ResponseBody
	public FormatedList<Specialitate> getSpecialties(@RequestParam("idFacultate") Integer idFacultate, Model model) {
		
		return this.specialitateService.getListSpecialitate(idFacultate);
	}
	
	@RequestMapping(value = "api/list/groups", method = RequestMethod.GET)
	@ResponseBody
	public FormatedList<Grupa> getGroups(@RequestParam("idSpecialtate") Integer idSpecialitate, Model model) {
		
		return this.grupaService.getListGrupa(idSpecialitate);
		
	}
	
	@RequestMapping(value = "api/list/semesters", method = RequestMethod.GET)
	@ResponseBody
	public FormatedList<Semestru> getSemestre(@RequestParam("idSpecialtate") Integer idSpecialitate, Model model) {
		
		return this.specialitateService.getListSemestre(idSpecialitate);
	}
	
	@RequestMapping(value = "api/list/courses", method = RequestMethod.GET)
	@ResponseBody
	public FormatedList<Disciplina> getSemestre(
			@RequestParam("idSpecialitate") Integer idSpecialitate,
			@RequestParam("semestru") Integer semestru,
			@RequestParam("idGrupa") Integer idGrupa,
			@RequestParam("promotia") String promotia,
			@RequestParam("idProfesor") Integer idProfesor,			
			Model model) {
		
		return this.disciplinaService.getListDisciplina(idSpecialitate, semestru, idGrupa, promotia, idProfesor);	
		
	}
	
}
