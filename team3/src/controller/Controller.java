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
//		PrintUtil.intro();
		new Controller().start();
	}

	private void start() {
		sessionStorage.put("update_check", 0);
		sessionStorage.put("login", false);
		sessionStorage.put("loginInfo", null);
		int view = View.HOME;
		while (true) {
			switch (view) {
			// 첫 유저 선택 화면
			case View.HOME:
				view = home();
				break;

			// 로그인
			case View.USER_LOGIN:
				view = memberService.login();
				break;

			// 회원가입
			case View.USER_SIGNUP:
				view = memberService.signUp();
				break;

			// 비회원 및 회원 로그인 >> 프로그램 기능메뉴 화면
			case View.UI_HOME:
				view = home2();
				break;
			

			// 회원정보 수정
			case View.USER_UPDATE:
				view = memberService.infoUpdate();
				break;

			// 검색 메인화면 (매장 전체리스트 출력 및 세부검색 선택)
			case View.SEARCH:
				view = storeService.searchHome();
				break;

			// 1.가게명 검색
			case View.STO_SC:
				view = storeService.listStoreName();
				break;
			// 2.식당분류별단
			case View.STO_TYPE:
				view = storeService.typeSC();
				break;
			// 3.별점별 검색
			case View.STO_RANK:
				view = storeService.stoRank();
				break;

			// 즐겨찾기
			case View.BOOKMARK:
				view = bookmarkService.myBookmark();
				break;
			case View.BOOKMARK2:
				view = bookmarkService.bookmarkHome();
				break;

			// 리뷰 홈단
			case View.REVIEW:
				view = reviewService.reviewHome();
				break;

			// 프로그램종료
			case View.EXIT:
				PrintUtil.bar();
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			}
		}
	}

	// 로그인 화면
	private int home() {
		PrintUtil.bar();
		PrintUtil.title1();
		switch (ScanUtil.nextInt()) {
		// 1.로그인
		case 1:
			return View.USER_LOGIN;
		// 2.회원가입
		case 2:
			return View.USER_SIGNUP;
		// 3.비회원로그인
		case 3:
			return View.UI_HOME;
		// 4.프로그램종료
		case 4:
			return View.EXIT;
		// 5.예외처리 및 홈단 화면
		default:
			System.out.println("잘못된 입력입니다.");
			return View.HOME;
		}
	}

	// 프로그램 기능메뉴 화면
	private int home2() {
		PrintUtil.userHome();

		switch (ScanUtil.nextInt()) {
		// 1.검색
		case 1:
			return View.SEARCH;
		// 2.즐겨찾기
		case 2:
			return View.BOOKMARK;
		// 3.리뷰
		case 3:
			return View.REVIEW;
		// 4.회원정보수정
		case 4:
			return View.USER_UPDATE;
		// 5.프로그램종료
		case 5:
			return View.EXIT;
		// 예외 처리 및 기능메뉴 화면
		default:
			System.out.println();
			System.out.println("잘못된 입력입니다.");
			return View.UI_HOME;
		}
	}
}