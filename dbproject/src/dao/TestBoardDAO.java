package dao;

import util.JDBCUtil;

public class TestBoardDAO {
	private static TestBoardDAO instance = null;
	private TestBoardDAO() {}
	public static TestBoardDAO getInstance() {
		if(instance == null) instance = new TestBoardDAO();
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
}
