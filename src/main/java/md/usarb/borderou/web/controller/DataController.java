package md.usarb.borderou.web.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DataController {

	@RequestMapping(value = "testtest", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public String getPet(Model model) {
	    return "test 1990";
	}
	
	@RequestMapping("student")
	public @ResponseBody
	Student getStudent() {
		return new Student(23, "meghna", "Naidu", "meghna@gmail.com",
				"8978767878");
	}

	
	@RequestMapping("studentlist")
	public @ResponseBody
	List<Student> getStudentList() {
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(23, "Meghna", "Naidu", "meghna@gmail.com",
				"8978767878"));
		studentList.add(new Student(3, "Robert", "Parera", "robert@gmail.com",
				"8978767878"));
		studentList.add(new Student(93, "Andrew", "Strauss",
				"andrew@gmail.com", "8978767878"));
		studentList.add(new Student(239, "Eddy", "Knight", "knight@gmail.com",
				"7978767878"));

		return studentList;
	}

}
