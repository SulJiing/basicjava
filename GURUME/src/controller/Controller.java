package controller;

import java.util.HashMap;
import java.util.Map;

import service.BookmarkService;
import service.MemberService;
import service.ReviewService;
import service.StoreService;
import util.PrintUtil;
import util.ScanUtil;
import util.View;

public class Controller {
	static public Map<String, Object> sessionStorage = new HashMap<>();

	MemberService memberService = MemberService.getInstance();
	BookmarkService bookmarkService = BookmarkService.getInstance();
	ReviewService reviewService = ReviewService.getInstance();
	StoreService storeService = StoreService.getInstance();

	public static void main(String[] args) {
		new PrintUtil();
		new Controller().start();
	}

	private void start() {
		sessionStorage.put("login", false);	
		sessionStorage.put("loginInfo", null);
		int view = View.HOME;
		while (true) {
			switch (view) {
			case View.HOME:
				view = home();
				break;
			case View.USER_LOGIN:
				view = memberService.login();
				break;
			case View.USER_SIGNUP:
				view = memberService.signUp();
				break;
			case View.USER_UNKNOWN:
				view = home2();
				break;
			case View.UI_HOME:
				view = home2();
				break;
			case View.SEARCH:
				view = storeService.searchHome();
				break;
//			case View.SEARCH_TYPE:
//	            view = storeService.listType();
//	            break;
			case View.STO_RANK:
				view = storeService.stoRank();
				break;
			case View.STO_SC:
				view = storeService.stoSc();
				break;
			case View.STO_TYPE:
				view = storeService.typeSC();
				break;
			case View.BOOKMARK:
				bookmarkService.bookMark();
				break;
			case View.REVIEW:
				view = reviewService.reviewHome();
				break;
			case View.USER_UPDATE:
				view = memberService.infoUpdate();
				break;
			case View.ADMIN:
				view = home2();
				break;
			case View.EXIT:
				System.out.println("=========================");
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			}
		}
	}

	private int home() {
//		System.out.println("===================================");
//		System.out.println("맛집 찾기");
//		System.out.println("1.로그인");
//		System.out.println("2.회원가입");									
//		System.out.println("3.비회원로그인");
//		System.out.println("4.프로그램 종료");
//		System.out.println("===================================");
//		System.out.print("입력 >");
//		switch (ScanUtil.nextInt()) {
//		case 1: return View.USER_LOGIN;
//		case 2: return View.USER_SIGNUP;
//		case 3: return View.USER_UNKNOWN;
//		case 4: return View.EXIT;
//		default : 
//			System.out.println("잘못된 입력입니다.");
//			return View.HOME;
//		}
		PrintUtil.bar();
		PrintUtil.title1();
		switch (ScanUtil.nextInt()) {
		case 1:
			return View.USER_LOGIN;
		case 2:
			return View.USER_SIGNUP;
		case 3:
			return View.USER_UNKNOWN;
		case 4:
			return View.EXIT;
		default:
			System.out.println("잘못된 입력입니다.");
			return View.HOME;
		}
	}

	private int home2() {
//		System.out.println();
//		System.out.println("맛집 찾기");
//		System.out.println("1.검색 2.즐겨찾기  3.리뷰  4.회원정보수정 5.프로그램 종료   ");
//		System.out.println("=========================");
//		System.out.print("번호 입력 > ");
//		switch (ScanUtil.nextInt()) {
//		case 1: return View.SEARCH;
//		case 2: return View.BOOKMARK;
//		case 3: return View.REVIEW;
//		case 4: return View.USER_UPDATE;
//		case 5: return View.EXIT;
//		default : 
//			System.out.println();
//			System.out.println("잘못된 입력입니다.");
//			return View.UI_HOME;
//		}
		PrintUtil.userHome();

		switch (ScanUtil.nextInt()) {
		case 1:
			return View.SEARCH;
		case 2:
			return View.BOOKMARK;
		case 3:
			return View.REVIEW;
		case 4:
			return View.USER_UPDATE;
		case 5:
			return View.EXIT;
		default:
			System.out.println();
			System.out.println("잘못된 입력입니다.");
			return View.UI_HOME;
		}
	}

//	private int admin() {
//		
//		
//	}
}
