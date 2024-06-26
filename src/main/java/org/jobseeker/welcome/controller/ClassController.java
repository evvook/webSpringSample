package org.jobseeker.welcome.controller;

import java.util.List;
import java.util.Map;

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
	WelcomeService welcomeService;
	
	@ResponseBody
	@RequestMapping(value="/retrieveClassList",method={RequestMethod.GET, RequestMethod.POST})
	public List<Map<String,String>> retrieveClass(@RequestBody Map<String,String> param) {
		return welcomeService.retrieveClass(param);
	}
}
