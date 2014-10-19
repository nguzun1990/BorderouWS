package md.usarb.borderou.web.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import md.usarb.borderou.dao.FacultateDao;
import md.usarb.borderou.dao.SpecialitateDao;
import md.usarb.borderou.entities.licenta.Facultate;
import md.usarb.borderou.entities.licenta.Specialitate;
import md.usarb.borderou.factory.DaoFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class SelectBoxController {
	
	@RequestMapping(value = "pets123")
	@ResponseBody
	public Collection<Facultate> getPet(Model model) {
		
		FacultateDao dao5 = DaoFactory.buildObject(FacultateDao.class);
//		System.out.println(dao5.getSemestre(21).size());
		
//		List<Integer> res = new ArrayList<Integer>();
//		res.add(new Integer(12));
//		res.add(new Integer(23));
//		res.add(new Integer(34));
//		System.out.println(res);
	    return  dao5.getListFacultate();
	}
	
	@RequestMapping(value = "pets1234")
	@ResponseBody
	public Collection<Specialitate> getPetSingle(Model model) {
		
		FacultateDao dao5 = DaoFactory.buildObject(FacultateDao.class);
//		System.out.println(dao5.getSemestre(21).size());
		
//		List<Integer> res = new ArrayList<Integer>();
//		res.add(new Integer(12));
//		res.add(new Integer(23));
//		res.add(new Integer(34));
//		System.out.println(res);
	    return  dao5.getListFacultate().iterator().next().getSpecialitates();
	}
	
}
