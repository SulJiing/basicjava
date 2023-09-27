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
		// 데이터출력
		System.out.println("-------전체 목록-------");
		for (int i = 0; i < reviewList.size(); i++) {
			Map<String, Object> map = reviewList.get(i);
			System.out.println(map.get("STO_NAME") + "\t" + map.get("RVW_SCORE") + "\t" + map.get("RVW_REMARK"));
			System.out.println("-------------------");
		}
		System.out.println("1.내 리뷰 2.가게별 리뷰");
		System.out.print("선택>");
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
				System.out.println("엔터키를 입력하시면 뒤로 돌아갑니다");
				String a = ScanUtil.nextLine();
			}
			view = View.REVIEW;
		} else {
			System.out.println();
			System.out.println("회원만 이용가능합니다.");
			System.out.println("1.로그인  2.회원가입 3.뒤로가기");
			System.out.print("입력>");
			int choice = ScanUtil.nextInt();
			if(choice == 2) {
				System.out.println("회원가입 화면으로 이동합니다");
				view = View.USER_SIGNUP;
			} else if(choice == 3) {
				System.out.println("이전 화면으로 돌아갑니다");
				view = View.REVIEW;
			} else if(choice ==1 ) {
				System.out.println("로그인 화면으로 이동합니다");
				view = View.USER_LOGIN;
			} else {
				System.out.println("잘못입력하셨습니다.");
				view = View.REVIEW;
			}
		}
		return view;
	}

}
