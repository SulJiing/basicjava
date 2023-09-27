package controller;

import java.util.HashMap;
import java.util.Map;

import service.BoardService;
import service.FreeBoardService;
import service.LoginService;
import service.MemberService;
import service.TestBoardService;
import util.ScanUtil;
import util.View;

public class Controller {
	// 세션
	static public Map<String, Object> sessionStorage = new HashMap<>();
	
	//////
	MemberService memberService = MemberService.getInstance();
	LoginService loginService = LoginService.getInstance();
	BoardService boardService = BoardService.getInstance();
	FreeBoardService freeboardService = FreeBoardService.getInstance();
	TestBoardService testBoardService = TestBoardService.getInstance();
	
	public static void main(String[] args) {
		new Controller().start();
	}
	
	private void start() {
		sessionStorage.put("login", false);	// false: 로그인 안됨
		sessionStorage.put("loginInfo", null);
		int view = View.HOME;
		while(true) {
			switch (view) {
			// 팀장
			case View.HOME: 
				view = home(); 
				break;
			
			// 멤버담당 팀원
			case View.MEMBER_LOGIN: 
				view = loginService.login();
				break;
			case View.MEMBER_SIGNUP: 
				view = memberService.signUp(); 
				break;
			case View.MEMBER_UPDATE:
				view = memberService.inforUpdate();
			
			// 보드담당 팀원
			case View.BOARD_LIST: view = boardService.list(); break;
//			case View.BOARD_DETAIL: view = boardService.detail(); break;
//			case View.BOARD_INSERT: view = boardService.insert(); break;
//			case View.BOARD_UPDATE: view = boardService.update(); break;
//			case View.BOARD_DELETE: view = boardService.delete(); break;
			
			// 이태영 - 자유게시판
			case View.FREE_LIST:
				view = freeboardService.list();
				break;
//			case View.FREE_INSERT:
//				view = freeboardService.insert();
//				break;
//			case View.FREE_DETAIL:
//				view = freeboardService.detail();
//				break;
//			case View.FREE_UPDATE:
//				view = freeboardService.update();
//				break;
//			case View.FREE_DELETE:
//				view = freeboardService.delete();
//				break;
			case View.TEST_LIST:
				view = testBoardService.list();
				break;
			}
		}
	}

	private int home() {
//		System.out.println(sessionStorage.get("login"));
//		System.out.println(sessionStorage.get("loginInfo"));
		
		System.out.println("==== 대덕인재 개발원 ====");
		System.out.println("   1.로그인 2.회원가입 3.회원정보수정 4.자유게시판 5.테스트게시판");
		System.out.println("=========================");
		System.out.print("번호 입력 >> ");
		switch (ScanUtil.nextInt()) {
		case 1: 
			return View.MEMBER_LOGIN;
		case 2: return View.MEMBER_SIGNUP;
		case 3: return View.MEMBER_UPDATE;
		case 4: return View.FREE_LIST;
		case 5: return View.TEST_LIST;
		default: return View.HOME;
		}
	}

}
