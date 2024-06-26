package org.jobseeker.welcome.service;

import java.util.List;
import java.util.Map;

import org.jobseeker.welcome.repo.WelcomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
	
	@Autowired
	WelcomeRepository welcomeRepository;
	
	public List<Map<String,String>> retrieveClass(Map<String, String> param){
		return welcomeRepository.retrieveClass(param);
	}
}
