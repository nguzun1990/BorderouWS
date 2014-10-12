package md.usarb.borderou.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class HelloController {
	
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
 
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;
 
	}
 
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
 
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page - Admin Page!");
		model.setViewName("admin");
 
		return model;
 
	}
 
	@RequestMapping(value = "/dba**", method = RequestMethod.GET)
	public ModelAndView dbaPage() {
 
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page - Database Page!");
		model.setViewName("admin");
 
		return model;
 
	}
	
//	@RequestMapping("/helloWorld")
//    public ModelAndView helloWorld() {
//		ModelAndView model = new ModelAndView();
//		model.addObject("title", "Spring Security Hello World yyy");
//		model.addObject("message", "This is protected page - Database Page! xxx");
//		model.setViewName("helloWorld");
//		
//		return model;
//    }
	
	@RequestMapping("/helloWorld")
//	@ResponseBody
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hello World!");
        return "helloWorld";
    }
	
	@RequestMapping(value = "/pets/{petId}", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public String getPet(@PathVariable String petId, Model model) {
	    return "test 1990" + petId;
	}
 
}