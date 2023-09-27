package dao;

import java.util.List;
import java.util.Map;

import controller.Controller;
import util.JDBCUtil;

public class ReviewDao {
	private static ReviewDao instance = null;
	private ReviewDao() {	}
	public static ReviewDao getInstance() {
		if (instance == null)
			instance = new ReviewDao();
		return instance;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	
	
	
	public List<Map<String, Object>> allReview() {
		String sql = "select a.REVIEW_NO, b.STO_NAME, a.STO_NO, a.MEM_ID, a.RVW_SCORE, a.RVW_REMARK  from review a, store b where a.STO_NO = b.STO_NO";
		return jdbc.selectList(sql);
	}
	
	public List<Map<String, Object>> myReview() {
		
		String id = (String)Controller.sessionStorage.get("MEM_ID");
		String sql = "select a.REVIEW_NO, b.STO_NAME, a.STO_NO, a.MEM_ID, a.RVW_SCORE, a.RVW_REMARK  from review a, store b where a.STO_NO = b.STO_NO and a.MEM_ID = '"+id+"'";
		return jdbc.selectList(sql);
	}
	
	
	
}
