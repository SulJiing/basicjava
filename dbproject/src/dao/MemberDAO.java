package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class MemberDAO {
	private static MemberDAO instance = null;
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		if(instance == null) instance = new MemberDAO();
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public Map<String, Object> login(String id, String pass) {
		return jdbc.selectOne("SELECT * FROM MEMBER "
				+ " WHERE MEM_ID='"+id+"' AND MEM_PASS='"+pass+"' ");
	}
	public int signUp(List<Object> param) {
		return jdbc.update("INSERT INTO MEMBER (MEM_ID, MEM_PASS) VALUES (?, ?)", param);
	}
	
	public int update(String sql, String memID) {
		List<Object> param = new ArrayList<Object>();
		param.add(memID);
		
		return jdbc.update(sql,param);
	}
}







