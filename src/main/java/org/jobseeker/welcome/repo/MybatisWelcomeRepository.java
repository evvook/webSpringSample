package org.jobseeker.welcome.repo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisWelcomeRepository implements WelcomeRepository{

	private String nameSpace = "WelcomeMapper";
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Map<String,String>> retrieveClass(Map<String,String> param){
		return session.selectList(nameSpace+".retrieveClass", param);
	}
}
