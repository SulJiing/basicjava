package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class FreeBoardDAO {
	// 1. 싱글톤 만들기
	private static FreeBoardDAO instance = null;
	private FreeBoardDAO() {}
	public static FreeBoardDAO getInstance() {
		if(instance == null) 
			instance = new FreeBoardDAO();
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	// Controller > Service > Dao > Database
	// Controller < Service < Dao < Database
	
	public List<Map<String, Object>> list(){
		String sql = "SELECT * FROM BOARD";	// 쿼리를 만들어준다
		return jdbc.selectList(sql);
	}
	public Map<String, Object> list(String bo_no){
		List<Object> param = new ArrayList<Object>();
		param.add(bo_no);
		String sql = "SELECT * FROM BOARD where BO_NO = ? ";	// 쿼리를 만들어준다
		return jdbc.selectOne(sql,param);
	}
}
