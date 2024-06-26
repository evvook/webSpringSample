package org.jobseeker.welcome.service;

import java.util.List;
import java.util.Map;

import org.jobseeker.welcome.repo.ClassRepository;
import org.jobseeker.welcome.repo.WelcomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {
	
	@Autowired
	ClassRepository classRepository;
	
	public List<Map<String,String>> retrieveClassList(Map<String, String> param){
		return classRepository.retrieveClassList(param);
	}

	public Map<String, String> retrieveClass(Map<String, String> param) {
		// TODO Auto-generated method stub
		return classRepository.retrieveClass(param);
	}

	public List<Map<String, Object>> retrieveStudents(Map<String, String> param) {
		// TODO Auto-generated method stub
		return classRepository.retrieveStudents(param);
	}

	public Map<String, Object> updateClass(Map<String, Object> param) {
		// TODO Auto-generated method stub
		int result1 = classRepository.updateClass(param);
		
		List<Map<String,Object>> gridData = (List<Map<String, Object>>)param.get("gridData");
		for(Map<String,Object> rowData:gridData) {
			rowData.put("class_id", param.get("class_id"));
		}
		int result2 = classRepository.updateStudents(gridData);
		
		return param;
	}

	public Map<String, Object> insertStudents(Map<String, Object> param) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> gridData = (List<Map<String, Object>>)param.get("gridData");
		for(Map<String,Object> rowData:gridData) {
			rowData.put("class_id", param.get("class_id"));
		}
		int result1 = classRepository.insertStudents(gridData);
		
		return param;
	}

	public Map<String, Object> deleteStudents(Map<String, Object> param) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> gridData = (List<Map<String, Object>>)param.get("gridData");
		for(Map<String,Object> rowData:gridData) {
			rowData.put("class_id", param.get("class_id"));
		}
		int result1 = classRepository.deleteStudents(gridData);
		
		return param;
	}

	public Map<String, Object> insertClass(Map<String, Object> param) {
		// TODO Auto-generated method stub
		int result1 = classRepository.insertClass(param);
		
		List<Map<String,Object>> gridData = (List<Map<String, Object>>)param.get("gridData");
		for(Map<String,Object> rowData:gridData) {
			rowData.put("class_id", param.get("class_id"));
		}
		int result2 = classRepository.insertStudents(gridData);
		
		return param;
	}

	public Map<String, Object> deleteClass(Map<String, Object> param) {
		// TODO Auto-generated method stub
		int result1 = classRepository.deleteClass(param);
		int result2 = classRepository.deleteClassStudents(param);
		return param;
	}
}
