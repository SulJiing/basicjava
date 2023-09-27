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
			// ù ���� ���� ȭ��
			case View.HOME:
				view = home();
				break;

			// �α���
			case View.USER_LOGIN:
				view = memberService.login();
				break;

			// ȸ������
			case View.USER_SIGNUP:
				view = memberService.signUp();
				break;

			// ��ȸ�� �� ȸ�� �α��� >> ���α׷� ��ɸ޴� ȭ��
			case View.UI_HOME:
				view = home2();
				break;
			

			// ȸ������ ����
			case View.USER_UPDATE:
				view = memberService.infoUpdate();
				break;

			// �˻� ����ȭ�� (���� ��ü����Ʈ ��� �� ���ΰ˻� ����)
			case View.SEARCH:
				view = storeService.searchHome();
				break;

			// 1.���Ը� �˻�
			case View.STO_SC:
				view = storeService.listStoreName();
				break;
			// 2.�Ĵ�з�����
			case View.STO_TYPE:
				view = storeService.typeSC();
				break;
			// 3.������ �˻�
			case View.STO_RANK:
				view = storeService.stoRank();
				break;

			// ���ã��
			case View.BOOKMARK:
				view = bookmarkService.myBookmark();
				break;
			case View.BOOKMARK2:
				view = bookmarkService.bookmarkHome();
				break;

			// ���� Ȩ��
			case View.REVIEW:
				view = reviewService.reviewHome();
				break;

			// ���α׷�����
			case View.EXIT:
				PrintUtil.bar();
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
				break;
			}
		}
	}

	// �α��� ȭ��
	private int home() {
		PrintUtil.bar();
		PrintUtil.title1();
		switch (ScanUtil.nextInt()) {
		// 1.�α���
		case 1:
			return View.USER_LOGIN;
		// 2.ȸ������
		case 2:
			return View.USER_SIGNUP;
		// 3.��ȸ���α���
		case 3:
			return View.UI_HOME;
		// 4.���α׷�����
		case 4:
			return View.EXIT;
		// 5.����ó�� �� Ȩ�� ȭ��
		default:
			System.out.println("�߸��� �Է��Դϴ�.");
			return View.HOME;
		}
	}

	// ���α׷� ��ɸ޴� ȭ��
	private int home2() {
		PrintUtil.userHome();

		switch (ScanUtil.nextInt()) {
		// 1.�˻�
		case 1:
			return View.SEARCH;
		// 2.���ã��
		case 2:
			return View.BOOKMARK;
		// 3.����
		case 3:
			return View.REVIEW;
		// 4.ȸ����������
		case 4:
			return View.USER_UPDATE;
		// 5.���α׷�����
		case 5:
			return View.EXIT;
		// ���� ó�� �� ��ɸ޴� ȭ��
		default:
			System.out.println();
			System.out.println("�߸��� �Է��Դϴ�.");
			return View.UI_HOME;
		}
	}
}