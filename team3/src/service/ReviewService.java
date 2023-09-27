package service;

import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.ReviewDao;
import dao.StoreDao;
import util.PrintUtil;
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
	StoreDao dao = StoreDao.getInstance();
	String id = (String) Controller.sessionStorage.get("MEM_ID");

	public int reviewHome() {

		List<Map<String, Object>> reviewList = reviewdao.allReview();
		// 데이터출력

		System.out.println("\t▼ ALL REIVIEW LIST ▼\n");
		try {
			for (int i = 0; i < reviewList.size(); i++) {
				Map<String, Object> map = reviewList.get(i);
				System.out.println("-----------------------------------------------");
				System.out.println("\t\t\t\t★ 리뷰 [" + (i + 1) + "]번");
				System.out.printf(" 식당명 : %-20s \n", map.get("STO_NAME"));
				System.out.printf(" 별   점 :%2.0f\n", map.get("RVW_SCORE"));
				System.out.printf(" 리   뷰 :\"%s\"\n", map.get("RVW_REMARK"));
				System.out.print(" 작성자 :\"");
				System.out.print(((String) map.get("MEM_ID")).substring(0, 2));
				System.out.printf("%s\"\n", "**");
			}
		} catch (Exception e) {
			System.out.println("비어있음");
		}
		PrintUtil.bar();
		System.out.println("▷ REVIEW MENU");
		System.out.println(" 1.내 리뷰  2.가게별 리뷰  3.리뷰 작성  4.홈화면으로 돌아가기");
		int choice = ScanUtil.nextInt(" 입력>>");
		int view = 0;
		switch (choice) {
		// 1.내 리뷰
		case 1:
			view = myReview();
			break;
		// 2.가게별 리뷰
		case 2:
			view = stoReview();
			break;
		// 3.리뷰 작성
		case 3:
			view = writeReview();
			break;
		// 4.홈
		case 4:
			view = View.UI_HOME;
			break;
		default:
			view = View.REVIEW;
			break;
		}
		return view;
	}

	public int myReview() {
		int view = 0;
		if (Controller.sessionStorage.containsKey("MEM_ID")) {
			List<Map<String, Object>> myReviewList = reviewdao.myReview();
			try {
				PrintUtil.bar();
				System.out.println("▼ MY REVIEW ▼");
				for (int i = 0; i < myReviewList.size(); i++) {
					Map<String, Object> map = myReviewList.get(i);
					System.out.println("-----------------------------------------------");
					System.out.println("\t\t\t\t★ 리뷰 [" + (i + 1) + "]번");
					System.out.printf(" 식당명 : %-20s \n", map.get("STO_NAME"));
					System.out.printf(" 별   점 :%2.0f\n", map.get("RVW_SCORE"));
					System.out.printf(" 리   뷰 :\"%s\"\n", map.get("RVW_REMARK"));
//					System.out
//							.printf(map.get("STO_NAME") + "\t" + map.get("RVW_SCORE") + "\t" + map.get("RVW_REMARK"));
				}
			} catch (Exception e) {
				PrintUtil.bar();
				System.out.println("\"입력한 리뷰가 없습니다.\"");
			}
			PrintUtil.bar();
			System.out.println("▷ 엔터키를 눌러 뒤로 돌아갑니다");
			ScanUtil.nextLine();
			view = View.REVIEW;
		} else {
			PrintUtil.bar();
			System.out.println("\"회원만 이용가능합니다.\"\n▷ 메뉴를 선택해주세요");
			System.out.println("1.로그인  2.회원가입  3.뒤로가기");
			System.out.println("-----------------------------------------------");
			System.out.print("입력>");
			int choice = ScanUtil.nextInt();
			PrintUtil.bar();

			if (choice == 1) {
				view = View.USER_LOGIN;
			} else if (choice == 2) {
				view = View.USER_SIGNUP;
			} else if (choice == 3) {
				view = View.REVIEW;
			} else {
				System.out.println("잘못입력하셨습니다.");
				view = View.REVIEW;
			}
		}
		return view;
	}

	public int writeReview() {
		int view = 0;
		if (Controller.sessionStorage.containsKey("MEM_ID")) {

			PrintUtil.bar();
			System.out.println("\t- 전체 맛집 리스트 -\n");

			List<Map<String, Object>> storeList = dao.list();

			for (int i = 0; i < storeList.size(); i++) {
				Map<String, Object> map = storeList.get(i);
				System.out.printf("\t%2d.%s\n", (i + 1), map.get("STO_NAME"));

				if ((i + 1) % 5 == 0) {
					System.out.println("   ----------------------------- [▲] scroll [▼]");
				}
			}
			while (true) {
				System.out.print("가게번호  :");
				int k = ScanUtil.nextInt();

				if (k <= storeList.size() && k > 0) {

					List<Map<String, Object>> storenolist = reviewdao.storeNoList(String.valueOf(k));
					if (k > 10000) {
						System.out.println("잘못입력하셨습니다");
						return writeReview();
					} else if (storenolist == null || storenolist.size() == 0) {
						System.out.println("존재하지 않는 가게번호입니다");
						return writeReview();
					}

					System.out.print("평점(1~10) : ");

					int score = 0;
					while (true) {
						score = ScanUtil.nextInt();
						if (score > 10 || score < 1) {
							System.out.println("입력 범위를 벗어났습니다.");
							System.out.println("다시 입력해주세요.");
						} else {
							break;
						}
					}
					String str_score = String.valueOf(score);

					System.out.print("한줄평 : ");
					String review_remark = ScanUtil.nextLine();

					reviewdao.writeReview(String.valueOf(k), str_score, review_remark);
					System.out.println("업데이트 완료!");
					System.out.println("리뷰 화면으로 돌아갑니다~");
					view = View.REVIEW;
					reviewdao.updateStoRank();
					break;
				} else {
					System.out.println("잘못입력하셨습니다.");
				}
			}
		} else {
			System.out.println();
			System.out.println("회원만 이용가능합니다.");
			System.out.println("1.로그인  2.회원가입 3.뒤로가기");
			System.out.print("입력>");
			int choice = ScanUtil.nextInt();
			if (choice == 1) {
				view = View.USER_LOGIN;
			} else if (choice == 2) {
				view = View.USER_SIGNUP;
			} else if (choice == 3) {
				view = View.REVIEW;
			} else {
				System.out.println("잘못입력하셨습니다.");
				view = View.REVIEW;
			}
		}
		return view;
	}

	// 가게별 리뷰
	public int stoReview() {
		int view = 0;
		PrintUtil.bar();
		System.out.println("▷ SEARCH DETAIL REVIEW MENU");
		System.out.println(" 1.가게명 검색  2.가게번호 검색  3.뒤로가기  4.프로그램 종료");
		System.out.print(" 입력 >>");
		int i = ScanUtil.nextInt();
		System.out.println("-----------------------------------------------");
		switch (i) {
		case 1:
			view = storeNameReview();
			break;
		case 2:
			view = storeNoReview();
			break;
		case 3:
//         view = reviewHome();
			view = View.REVIEW;
			break;
		case 4:
			view = View.EXIT;
			break;
		default:
			System.out.println("잘못된 입력입니다.");
			view = stoReview();
			break;
		}
		return view;
	}

	public int storeNameReview() {
		int view = 0;
//	      List storeNoList = new ArrayList();
		// 가게명 입력
		System.out.print("\"가게명을 입력해주세요\"\n 입력 >> ");
		String input = ScanUtil.nextLine();
		PrintUtil.bar();
		System.out.println("\t▼▼'" + input + "'로 검색한 결과입니다.▼▼\n");

		// 가게명 검색 후 출력
		List<Map<String, Object>> storeList = dao.list3(input);

		if (storeList != null && !storeList.isEmpty()) {
			for (int i = 0; i < storeList.size(); i++) {
				String stoNm = (String) storeList.get(i).get("STO_NAME");
//	         storeNoList.add(stoNm);
				System.out.println("\t" + (i + 1) + " : " + stoNm);
			}
			// 출력된 가게 선택 후 리뷰 출력
			while (true) {
				PrintUtil.bar();
				System.out.println("▼ 원하시는 가게의 번호를 입력해주세요");
				System.out.print(" 번호 입력 >>");
				int a = ScanUtil.nextInt();
				if (a > 0 && a <= storeList.size()) {
					String stoNo = (String) storeList.get(a - 1).get("STO_NO");
					view = storeNoReview(stoNo);
					break;
				} else {
					System.out.println("잘못 입력하셨습니다.");
				}
			}
		} else {
			System.out.println();
			System.out.println("입력하신 가게가 존재하지 않습니다.");
			view = stoReview();
		}
		return view;
	}

	// 가게번호 검색
	public int storeNoReview() {
		 PrintUtil.bar();
	      System.out.println("\t- 전체 맛집 리스트 -\n");

	      List<Map<String, Object>> storeList = dao.list();

	      for (int i = 0; i < storeList.size(); i++) {
	         Map<String, Object> map = storeList.get(i);
	         System.out.printf("\t%2d.%s\n", (i + 1), map.get("STO_NAME"));

	         if ((i + 1) % 5 == 0) {
	            System.out.println("   ----------------------------- [▲] scroll [▼]");
	         }
	      }
		System.out.print("가게번호 입력 >");
		int no = ScanUtil.nextInt();
		if (no > 10000) {
			System.out.println("잘못 입력하셨습니다.");
			System.out.println("선택창으로 돌아갑니다.");
			stoReview();
		}
		String s_no = String.valueOf(no);
		List<Map<String, Object>> storeview = reviewdao.stoReview(s_no);
		if (storeview != null && !storeview.isEmpty()) {
			for (int h = 0; h < storeview.size(); h++) {
				Map<String, Object> map = storeview.get(h);
				System.out.println("-----------------------------------------------");
				System.out.println("\t\t\t\t★ 리뷰 [" + (h + 1) + "]번");
				System.out.printf(" 식당명 : %-20s \n", map.get("STO_NAME"));
				System.out.printf(" 별   점 :%2.0f\n", map.get("RVW_SCORE"));
				System.out.printf(" 리   뷰 :\"%s\"\n", map.get("RVW_REMARK"));
			}
		} else {
			System.out.println("존재하지 않는 가게이거나 해당 가게에 대한 리뷰가 없습니다.");
		}

		return stoReview();
	}

	public int storeNoReview(String no) {

		List<Map<String, Object>> storeview = reviewdao.stoReview(no);
		if (storeview != null && !storeview.isEmpty()) {
			for (int h = 0; h < storeview.size(); h++) {
				Map<String, Object> map = storeview.get(h);
				System.out.println("-----------------------------------------------");
				System.out.println("\t\t\t\t★ 리뷰 [" + (h + 1) + "]번");
				System.out.printf(" 식당명 : %-20s \n", map.get("STO_NAME"));
				System.out.printf(" 별   점 :%2.0f\n", map.get("RVW_SCORE"));
				System.out.printf(" 리   뷰 :\"%s\"\n", map.get("RVW_REMARK"));
			}
		} else {
			System.out.println("해당 가게의 리뷰가 없습니다.");
		}

		return stoReview();
	}

}

//public int reviewHome() {
//
//	List<Map<String, Object>> reviewList = reviewdao.allReview();
//
//	// 데이터출력
//	PrintUtil.bar();
//	System.out.println("\t▼ ALL REIVIEW LIST ▼\n");
//	for (int i = 0; i < reviewList.size(); i++) {
//		Map<String, Object> map = reviewList.get(i);
//		System.out.println("\t\t\t\t★ 리뷰 [" + (i + 1) + "]번");
//		System.out.printf(" 식당명 : %-20s \n", map.get("STO_NAME"));
//		System.out.printf(" 별   점 :%2.0f\n", map.get("RVW_SCORE"));
//		System.out.printf(" 리   뷰 :\"%s\"\n", map.get("RVW_REMARK"));
//		System.out.print(" 작성자 :\"");
//		System.out.print(((String) map.get("MEM_ID")).substring(0, 2));
//		System.out.printf("%s\"\n", "**");
//
//		System.out.println("-----------------------------------------------");
////		if ((i + 1) % 5 == 0) {
////			System.out.println("   ----------------------------- [▲] scroll [▼]");
////		}
//	}
//	PrintUtil.bar();
//	System.out.println("1.내 리뷰  2.가게별 리뷰  3.홈으로");
//	System.out.print("선택>");
//	int choice = ScanUtil.nextInt();
//	int view = 0;
//	switch (choice) {
//	case 1:
//		view = myReview();
//		break;
//	case 2:
//		view = View.UI_HOME;
//		break;
//	case 3:
//		view = View.UI_HOME;
//	default:
//		view = View.REVIEW;
//		break;
//	}
//	return view;
//}