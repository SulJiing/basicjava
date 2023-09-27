package service;

import java.util.ArrayList;
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
//   StoreService storeservice = StoreService.getInstance();
	StoreDao dao = StoreDao.getInstance();
	String id = (String) Controller.sessionStorage.get("MEM_ID");

	public int reviewHome() {

		List<Map<String, Object>> reviewList = reviewdao.allReview();
		// ���������

		System.out.println("\t�� ALL REIVIEW LIST ��\n");
		try {
			for (int i = 0; i < reviewList.size(); i++) {
				Map<String, Object> map = reviewList.get(i);
				System.out.println("-----------------------------------------------");
				System.out.println("\t\t\t\t�� ���� [" + (i + 1) + "]��");
				System.out.printf(" �Ĵ�� : %-20s \n", map.get("STO_NAME"));
				System.out.printf(" ��   �� :%2.0f\n", map.get("RVW_SCORE"));
				System.out.printf(" ��   �� :\"%s\"\n", map.get("RVW_REMARK"));
				System.out.print(" �ۼ��� :\"");
				System.out.print(((String) map.get("MEM_ID")).substring(0, 2));
				System.out.printf("%s\"\n", "**");
			}
		} catch (Exception e) {
			System.out.println("�������");
		}
		PrintUtil.bar();

		System.out.println("1.�� ���� 2.���Ժ� ���� 3.���� �ۼ� 4.Ȩȭ������ ���ư���");
		System.out.print("����>");
		int choice = ScanUtil.nextInt();
		int view = 0;
		switch (choice) {
		case 1:
			view = myReview();
			break;
		case 2:
			view = stoReview();
			break;
		case 3:
			view = writeReview();
			break;
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
				for (int i = 0; i < myReviewList.size(); i++) {
					Map<String, Object> map = myReviewList.get(i);
					System.out
							.println(map.get("STO_NAME") + "\t" + map.get("RVW_SCORE") + "\t" + map.get("RVW_REMARK"));
				}
			} catch (Exception e) {
				System.out.println("�Է��� ���䰡 �����ϴ�.");
			}
			System.out.println();
			System.out.println("����Ű�� �Է��Ͻø� �ڷ� ���ư��ϴ�");
			ScanUtil.nextLine();
			view = View.REVIEW;
		} else {
			System.out.println();
			System.out.println("ȸ���� �̿밡���մϴ�.");
			System.out.println("1.�α���  2.ȸ������ 3.�ڷΰ���");
			System.out.print("�Է�>");
			int choice = ScanUtil.nextInt();
			if (choice == 2) {
				System.out.println("ȸ������ ȭ������ �̵��մϴ�");
				view = View.USER_SIGNUP;
			} else if (choice == 3) {
				System.out.println("���� ȭ������ ���ư��ϴ�");
				view = View.REVIEW;
			} else if (choice == 1) {
				System.out.println("�α��� ȭ������ �̵��մϴ�");
				view = View.USER_LOGIN;
			} else {
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				view = View.REVIEW;
			}
		}
		return view;
	}

	public int writeReview() {
	      int view = 0;
	      if (Controller.sessionStorage.containsKey("MEM_ID")) {

	         PrintUtil.bar();
	         System.out.println("\t- ��ü ���� ����Ʈ -\n");

	         List<Map<String, Object>> storeList = dao.list();

	         for (int i = 0; i < storeList.size(); i++) {
	            Map<String, Object> map = storeList.get(i);
	            System.out.printf("\t%2d.%s\n", (i + 1), map.get("STO_NAME"));

	            if ((i + 1) % 5 == 0) {
	               System.out.println("   ----------------------------- [��] scroll [��]");
	            }
	         }
	         while (true) {
	            System.out.print("���Թ�ȣ  :");
	            int k = ScanUtil.nextInt();

	            if (k <= storeList.size() && k > 0) {

	               List<Map<String, Object>> storenolist = reviewdao.storeNoList(String.valueOf(k));
	               if (k > 10000) {
	                  System.out.println("�߸��Է��ϼ̽��ϴ�");
	                  return writeReview();
	               } else if (storenolist == null || storenolist.size() == 0) {
	                  System.out.println("�������� �ʴ� ���Թ�ȣ�Դϴ�");
	                  return writeReview();
	               }

	               System.out.print("����(1~10) : ");
	               /*
	                * int review_score = 0; while (true) { review_score = ScanUtil.nextInt(); if
	                * (review_score >= 0 && review_score <= 10) { break; } else {
	                * System.out.println("�ٽ� �Է����ּ���"); } } String string_score =
	                * String.valueOf(review_score);
	                */
	               int score = 0;
	               while (true) {
	                  score = ScanUtil.nextInt();
	                  if (score > 10 || score < 1) {
	                     System.out.println("�Է� ������ ������ϴ�.");
	                     System.out.println("�ٽ� �Է����ּ���.");
	                  } else {
	                     break;
	                  }
	               }
	               String str_score = String.valueOf(score);
//	               String string_score = ScanUtil.nextLine();
//	               int int_score = Integer.valueOf(string_score);
//	               if(int_score > 10 || int_score < 1) {
//	                  System.out.println("�Է� ������ ������ϴ�.");
//	                  System.out.println("�ٽ� �Է����ּ���.");
//	               }
	               System.out.print("������ : ");
	               String review_remark = ScanUtil.nextLine();
//	            int a = reviewdao.writeReview(sto_no, review_score, review_remark);
	               reviewdao.writeReview(String.valueOf(k), str_score, review_remark);
	               System.out.println("������Ʈ �Ϸ�!");
	               System.out.println("���� ȭ������ ���ư��ϴ�~");
	               view = View.REVIEW;
	               reviewdao.updateStoRank();
	               break;
	            } else {
	               System.out.println("�߸��Է��ϼ̽��ϴ�.");

	            }
	         }

	      } else {
	         System.out.println();
	         System.out.println("ȸ���� �̿밡���մϴ�.");
	         System.out.println("1.�α���  2.ȸ������ 3.�ڷΰ���");
	         System.out.print("�Է�>");
	         int choice = ScanUtil.nextInt();
	         if (choice == 2) {
	            System.out.println("ȸ������ ȭ������ �̵��մϴ�");
	            view = View.USER_SIGNUP;
	         } else if (choice == 3) {
	            System.out.println("���� ȭ������ ���ư��ϴ�");
	            view = View.REVIEW;
	         } else if (choice == 1) {
	            System.out.println("�α��� ȭ������ �̵��մϴ�");
	            view = View.USER_LOGIN;
	         } else {
	            System.out.println("�߸��Է��ϼ̽��ϴ�.");
	            view = View.REVIEW;
	         }
	      }
	      return view;
	   }

	public int stoReview() {
		int view = 0;
		System.out.println("1.���Ը� �˻� 2.���Թ�ȣ �˻� 3.�ڷΰ��� 4.���α׷� ����");
		System.out.print("�Է� >");
		int i = ScanUtil.nextInt();
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
			System.out.println("�߸��� �Է��Դϴ�.");
			view = stoReview();
			break;
		}
		return view;
	}

	public int storeNameReview() {
		int view = 0;
//      List storeNoList = new ArrayList();
		// ���Ը� �Է�
		System.out.println();
		System.out.print("���Ը��� �Է����ּ��� : ");
		String input = ScanUtil.nextLine();

		// ���Ը� �˻� �� ���
		List<Map<String, Object>> storeList = dao.list3(input);
		if (storeList != null && !storeList.isEmpty()) {
			for (int i = 0; i < storeList.size(); i++) {
				String stoNm = (String) storeList.get(i).get("STO_NAME");
//         storeNoList.add(stoNm);
				System.out.println((i + 1) + " : " + stoNm);
			}
			// ��µ� ���� ���� �� ���� ���
			System.out.println();
			System.out.println("���Ͻô� ���Ը� �����ϼ���");
			System.out.print("��ȣ ���� >");
			int a = ScanUtil.nextInt();
			if (a > 0 && a <= storeList.size()) {
				String stoNo = (String) storeList.get(a - 1).get("STO_NO");
				view = storeNoReview(stoNo);
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				view = stoReview();
			}

		} else {
			System.out.println();
			System.out.println("�Է��Ͻ� ���԰� �������� �ʽ��ϴ�.");
			view = stoReview();
		}

//      return stoReview();
		return view;
	}

	public int storeNoReview() {
		System.out.print("���Թ�ȣ �Է� >");
		int no = ScanUtil.nextInt();
		if (no > 10000) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			System.out.println("����â���� ���ư��ϴ�.");
			stoReview();
		}
		String s_no = String.valueOf(no);
		List<Map<String, Object>> storeview = reviewdao.stoReview(s_no);
		if (storeview != null && !storeview.isEmpty()) {
			for (int h = 0; h < storeview.size(); h++) {
				Map<String, Object> map = storeview.get(h);
				System.out.println(map.get("STO_NAME") + "\t" + map.get("RVW_SCORE") + "\t" + map.get("RVW_REMARK"));
			}
		} else {
			System.out.println("�������� �ʴ� �����̰ų� �ش� ���Կ� ���� ���䰡 �����ϴ�.");
		}

		return stoReview();
	}

	public int storeNoReview(String no) {

		List<Map<String, Object>> storeview = reviewdao.stoReview(no);
		if (storeview != null && !storeview.isEmpty()) {
			for (int h = 0; h < storeview.size(); h++) {
				Map<String, Object> map = storeview.get(h);
				System.out.println(map.get("STO_NAME") + "\t" + map.get("RVW_SCORE") + "\t" + map.get("RVW_REMARK"));
			}
		} else {
			System.out.println("�ش� ������ ���䰡 �����ϴ�.");
		}

		return stoReview();
	}

}