package service;

import dao.TestBoardDAO;

public class TestBoardService {
	private static TestBoardService instance = null;
	private TestBoardService() {}
	public static TestBoardService getInstance() {
		if(instance == null) instance = new TestBoardService();
		return instance;
	}
	
	TestBoardDAO dao = TestBoardDAO.getInstance();
	
	public int list(){
		// 관리자면 모든 기능이 가능
		// 사용자이지만 내가 작성한 게시글에 대해서만 수정, 삭제가 가능
		
		// 게시판 전체 리스트가 보여지고
		// 1. 등록 2. 수정 3. 삭제
		
		return 0;
	}
}
