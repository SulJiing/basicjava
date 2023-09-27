package service;

import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.ReviewDao;
import util.ScanUtil;
import util.View;

public class ReviewService {
	private static ReviewService instance = null;

	private ReviewService() {
	}

	public static ReviewService getInstance() {
		if (instance == null)
			instance = new ReviewService();
		return instance;
	}

	ReviewDao reviewdao = ReviewDao.getInstance();

	String id = (String)Controller.sessionStorage.get("MEM_ID");

	public int reviewHome() {

		List<Map<String, Object>> reviewList = reviewdao.allReview();
		// ���������
		System.out.println("-------��ü ���-------");
		for (int i = 0; i < reviewList.size(); i++) {
			Map<String, Object> map = reviewList.get(i);
			System.out.println(map.get("STO_NAME") + "\t" + map.get("RVW_SCORE") + "\t" + map.get("RVW_REMARK"));
			System.out.println("-------------------");
		}
		System.out.println("1.�� ���� 2.���Ժ� ����");
		System.out.print("����>");
		int choice = ScanUtil.nextInt();
		int view = 0;
		switch (choice) {
		case 1:
			view = myReview();
			break;
		case 2:
			view = View.UI_HOME;
			break;
		default : 
			view = View.REVIEW;
			break;
		}
		return view;
	}

	public int myReview() {
		int view = 0;
		if (Controller.sessionStorage.containsKey("MEM_ID")) {
			List<Map<String, Object>> mayReviewList = reviewdao.myReview();
			for (int i = 0; i < mayReviewList.size(); i++) {
				Map<String, Object> map = mayReviewList.get(i);
				System.out.println(map.get("STO_NAME") + "\t" + map.get("RVW_SCORE") + "\t" + map.get("RVW_REMARK"));
				System.out.println();
				System.out.println("����Ű�� �Է��Ͻø� �ڷ� ���ư��ϴ�");
				String a = ScanUtil.nextLine();
			}
			view = View.REVIEW;
		} else {
			System.out.println();
			System.out.println("ȸ���� �̿밡���մϴ�.");
			System.out.println("1.�α���  2.ȸ������ 3.�ڷΰ���");
			System.out.print("�Է�>");
			int choice = ScanUtil.nextInt();
			if(choice == 2) {
				System.out.println("ȸ������ ȭ������ �̵��մϴ�");
				view = View.USER_SIGNUP;
			} else if(choice == 3) {
				System.out.println("���� ȭ������ ���ư��ϴ�");
				view = View.REVIEW;
			} else if(choice ==1 ) {
				System.out.println("�α��� ȭ������ �̵��մϴ�");
				view = View.USER_LOGIN;
			} else {
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				view = View.REVIEW;
			}
		}
		return view;
	}

}
