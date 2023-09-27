package service;

import dao.BookmarkDao;
import util.ScanUtil;
import util.View;

import java.util.List;
import java.util.Map;

import controller.Controller;

public class BookmarkService {
	
	private static BookmarkService instance = null;
	private BookmarkService() {}
	public static BookmarkService getInstance() {
		if (instance == null)
			instance = new BookmarkService();
		return instance;
	}
	
	BookmarkDao bookmarkdao = BookmarkDao.getInstance();
	String memId = (String) Controller.sessionStorage.get("MEM_ID");
//	
//    private BookmarkDao bookmarkDao;
//    
//
//    public BookmarkService() {
//        this.bookmarkDao = BookmarkDao.getInstance();
//    }

    // 음식점을 즐겨찾기에 추가하는 메서드
    public int addBookmark() {
    	String STO_NO = ScanUtil.nextLine();
        return bookmarkdao.addBookmark(STO_NO, memId);
    }

    // 특정 사용자의 모든 즐겨찾기 목록을 가져오는 메서드
    public List<Map<String, Object>> getAllBookmarks() {
        return bookmarkdao.getAllBookmarks(memId);
    }

    // 특정 사용자의 즐겨찾기에서 특정 음식점을 삭제하는 메서드
    public int removeBookmark() {
    	String STO_NO = ScanUtil.nextLine();
        return bookmarkdao.removeBookmark(memId, STO_NO);
    }
    
    public int bookMark() {
    	int result=View.BOOKMARK;
    	System.out.println();
    	System.out.println("맛집 찾기");
		System.out.println("1.즐겨찾기 추가 2.즐겨찾기 목록  3.즐겨찾기 삭제 4.뒤로가기");
		System.out.println("=========================");
		System.out.print("번호 입력 >> ");
		switch(ScanUtil.nextInt()) {
		case 1: addBookmark();
		case 2: getAllBookmarks();
		case 3: removeBookmark();
		case 4: result = View.UI_HOME;
		default : System.out.println("잘못된 입력입니다.");
		return result;
		}
		
		
    	
    }
    
    
}