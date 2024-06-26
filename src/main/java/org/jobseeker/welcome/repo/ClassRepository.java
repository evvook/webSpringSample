package org.jobseeker.welcome.repo;

import java.util.List;
import java.util.Map;

public interface ClassRepository {

	public List<Map<String,String>> retrieveClassList(Map<String, String> param);

	public Map<String, String> retrieveClass(Map<String, String> param);

	public List<Map<String, Object>> retrieveStudents(Map<String, String> param);

	public int updateClass(Map<String, Object> param);

	public int updateStudents(List<Map<String, Object>> param);

	public int insertStudents(List<Map<String, Object>> param);

	public int deleteStudents(List<Map<String, Object>> param);

	public int insertClass(Map<String, Object> param);

	public int deleteClass(Map<String, Object> param);

	public int deleteClassStudents(Map<String, Object> param);

	public int insertStudentsExcel(List<Map<String, Object>> excelDataList);
}
