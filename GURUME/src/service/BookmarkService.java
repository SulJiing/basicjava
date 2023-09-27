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

    // �������� ���ã�⿡ �߰��ϴ� �޼���
    public int addBookmark() {
    	String STO_NO = ScanUtil.nextLine();
        return bookmarkdao.addBookmark(STO_NO, memId);
    }

    // Ư�� ������� ��� ���ã�� ����� �������� �޼���
    public List<Map<String, Object>> getAllBookmarks() {
        return bookmarkdao.getAllBookmarks(memId);
    }

    // Ư�� ������� ���ã�⿡�� Ư�� �������� �����ϴ� �޼���
    public int removeBookmark() {
    	String STO_NO = ScanUtil.nextLine();
        return bookmarkdao.removeBookmark(memId, STO_NO);
    }
    
    public int bookMark() {
    	int result=View.BOOKMARK;
    	System.out.println();
    	System.out.println("���� ã��");
		System.out.println("1.���ã�� �߰� 2.���ã�� ���  3.���ã�� ���� 4.�ڷΰ���");
		System.out.println("=========================");
		System.out.print("��ȣ �Է� >> ");
		switch(ScanUtil.nextInt()) {
		case 1: addBookmark();
		case 2: getAllBookmarks();
		case 3: removeBookmark();
		case 4: result = View.UI_HOME;
		default : System.out.println("�߸��� �Է��Դϴ�.");
		return result;
		}
		
		
    	
    }
    
    
}