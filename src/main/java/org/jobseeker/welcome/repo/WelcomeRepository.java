package org.jobseeker.welcome.repo;

import java.util.List;
import java.util.Map;

public interface WelcomeRepository {

	public List<Map<String,String>> retrieveClass(Map<String, String> param);
}
