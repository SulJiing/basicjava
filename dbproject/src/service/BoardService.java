package service;

import java.util.List;
import java.util.Map;

import dao.BoardDAO;
import util.ScanUtil;
import util.View;

public class BoardService {
	private static BoardService instance = null;
	private BoardService() {}
	public static BoardService getInstance() {
		if(instance == null) instance = new BoardService();
		return instance;
	}
	
	BoardDAO dao = BoardDAO.getInstance();
	
	public int list() {
		System.out.println("-- 게시판 목록 --");
		System.out.println("번호\t제목\t작성자\t작성일");
		List<Map<String, Object>> list = dao.list();
		// List 
		// 0 Map
		// 1 Map
		// 2 Map
		// ...
		for(Map<String, Object> item : list) {
			System.out.print(item.get("BOARD_NUMBER"));
			System.out.print("\t" + item.get("TITLE"));
			System.out.print("\t" + item.get("WRITER"));
			System.out.print("\t" + item.get("DATETIME"));
			System.out.println();
		}
		System.out.println("---------------------------------------");
		System.out.println("1.상세 2.등록 3.수정 4.삭제 0.종료");
		System.out.print("번호 선택 >> ");
		switch(ScanUtil.nextInt()) {
		case 1: return View.BOARD_DETAIL;
		case 2: return View.BOARD_INSERT;
		case 3: return View.BOARD_UPDATE;
		case 4: return View.BOARD_DELETE;
		default: return View.HOME;
		}
	}
}










