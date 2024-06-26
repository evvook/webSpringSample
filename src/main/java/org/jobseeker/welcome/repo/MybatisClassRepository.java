package org.jobseeker.welcome.repo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisClassRepository implements ClassRepository{

	private String nameSpace = "ClassMapper";
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Map<String,String>> retrieveClassList(Map<String,String> param){
		return session.selectList(nameSpace+".retrieveClassList", param);
	}

	@Override
	public Map<String, String> retrieveClass(Map<String, String> param) {
		// TODO Auto-generated method stub
		return session.selectOne(nameSpace+".retrieveClass", param);
	}

	@Override
	public List<Map<String, Object>> retrieveStudents(Map<String, String> param) {
		// TODO Auto-generated method stub
		return session.selectList(nameSpace+".retrieveStudents", param);
	}

	@Override
	public int updateClass(Map<String, Object> param) {
		// TODO Auto-generated method stub
		int result = session.update(nameSpace+".updateClass", param);
		if(result == 1) {
			System.out.println("업데이트 성공?");
		}
		if(result == 0) {
			System.out.println("업데이트 실패?");
		}
		return result;
	}

	@Override
	public int updateStudents(List<Map<String, Object>> param) {
		// TODO Auto-generated method stub
		int result = session.update(nameSpace+".updateStudents", param);
		if(result == 1) {
			System.out.println("업데이트 성공?");
		}
		if(result == 0) {
			System.out.println("업데이트 실패?");
		}
		return result;
	}

	@Override
	public int insertStudents(List<Map<String, Object>> param) {
		// TODO Auto-generated method stub
		int result = session.insert(nameSpace+".insertStudents", param);
		if(result == 1) {
			System.out.println("인서트 성공?");
		}
		if(result == 0) {
			System.out.println("인서트 실패?");
		}
		return result;
	}

	@Override
	public int deleteStudents(List<Map<String, Object>> param) {
		// TODO Auto-generated method stub
		int result = session.delete(nameSpace+".deleteStudents", param);
		if(result == 1) {
			System.out.println("딜리트 성공?");
		}
		if(result == 0) {
			System.out.println("딜리트 실패?");
		}
		return result;
	}

	@Override
	public int insertClass(Map<String, Object> param) {
		// TODO Auto-generated method stub
		int result = session.insert(nameSpace+".insertClass", param);
		if(result == 1) {
			System.out.println("인서트 성공?");
		}
		if(result == 0) {
			System.out.println("인서트 실패?");
		}
		return result;
	}

	@Override
	public int deleteClass(Map<String, Object> param) {
		// TODO Auto-generated method stub
		int result = session.delete(nameSpace+".deleteClass", param);
		if(result == 1) {
			System.out.println("딜리트 성공?");
		}
		if(result == 0) {
			System.out.println("딜리트 실패?");
		}
		return result;
	}

	@Override
	public int deleteClassStudents(Map<String, Object> param) {
		// TODO Auto-generated method stub
		int result = session.delete(nameSpace+".deleteClassStudents", param);
		if(result == 1) {
			System.out.println("딜리트 성공?");
		}
		if(result == 0) {
			System.out.println("딜리트 실패?");
		}
		return result;
	}

	@Override
	public int insertStudentsExcel(List<Map<String, Object>> excelDataList) {
		// TODO Auto-generated method stub
		int result = session.insert(nameSpace+".insertStudentsExcel", excelDataList);
		if(result == 1) {
			System.out.println("인서트 성공?");
		}
		if(result == 0) {
			System.out.println("인서트 실패?");
		}
		return result;
	}
}
