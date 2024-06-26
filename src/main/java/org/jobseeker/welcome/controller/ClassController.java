package org.jobseeker.welcome.controller;

import java.util.List;
import java.util.Map;

import org.jobseeker.welcome.service.ClassService;
import org.jobseeker.welcome.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ClassController {

	@Autowired
	ClassService classService;
	
	@ResponseBody
	@RequestMapping(value="/retrieveClassList",method={RequestMethod.GET, RequestMethod.POST})
	public List<Map<String,String>> retrieveClassList(@RequestBody Map<String,String> param) {
		return classService.retrieveClassList(param);
	}
	
	@ResponseBody
	@RequestMapping(value="/retrieveClass",method={RequestMethod.GET, RequestMethod.POST})
	public Map<String,String> retrieveClass(@RequestBody Map<String,String> param) {
		return classService.retrieveClass(param);
	}
	
	@ResponseBody
	@RequestMapping(value="/retrieveStudents",method={RequestMethod.GET, RequestMethod.POST})
	public List<Map<String,Object>> retrieveStudents(@RequestBody Map<String,String> param) {
		return classService.retrieveStudents(param);
	}
	
	@ResponseBody
	@RequestMapping(value="/insertClass",method={RequestMethod.GET, RequestMethod.POST})
	public Map<String,Object> insertClass(@RequestBody Map<String,Object> param) {
		return classService.insertClass(param);
	}
	
	@ResponseBody
	@RequestMapping(value="/updateClass",method={RequestMethod.GET, RequestMethod.POST})
	public Map<String,Object> updateClass(@RequestBody Map<String,Object> param) {
		return classService.updateClass(param);
	}
	
	@ResponseBody
	@RequestMapping(value="/insertStudents",method={RequestMethod.GET, RequestMethod.POST})
	public Map<String,Object> insertStudents(@RequestBody Map<String,Object> param) {
		return classService.insertStudents(param);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteStudents",method={RequestMethod.GET, RequestMethod.POST})
	public Map<String,Object> deleteStudents(@RequestBody Map<String,Object> param) {
		return classService.deleteStudents(param);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteClass",method={RequestMethod.GET, RequestMethod.POST})
	public Map<String,Object> deleteClass(@RequestBody Map<String,Object> param) {
		return classService.deleteClass(param);
	}
}
