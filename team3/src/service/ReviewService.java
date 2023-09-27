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
		System.out.println("�� REVIEW MENU");
		System.out.println(" 1.�� ����  2.���Ժ� ����  3.���� �ۼ�  4.Ȩȭ������ ���ư���");
		int choice = ScanUtil.nextInt(" �Է�>>");
		int view = 0;
		switch (choice) {
		// 1.�� ����
		case 1:
			view = myReview();
			break;
		// 2.���Ժ� ����
		case 2:
			view = stoReview();
			break;
		// 3.���� �ۼ�
		case 3:
			view = writeReview();
			break;
		// 4.Ȩ
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
				System.out.println("�� MY REVIEW ��");
				for (int i = 0; i < myReviewList.size(); i++) {
					Map<String, Object> map = myReviewList.get(i);
					System.out.println("-----------------------------------------------");
					System.out.println("\t\t\t\t�� ���� [" + (i + 1) + "]��");
					System.out.printf(" �Ĵ�� : %-20s \n", map.get("STO_NAME"));
					System.out.printf(" ��   �� :%2.0f\n", map.get("RVW_SCORE"));
					System.out.printf(" ��   �� :\"%s\"\n", map.get("RVW_REMARK"));
//					System.out
//							.printf(map.get("STO_NAME") + "\t" + map.get("RVW_SCORE") + "\t" + map.get("RVW_REMARK"));
				}
			} catch (Exception e) {
				PrintUtil.bar();
				System.out.println("\"�Է��� ���䰡 �����ϴ�.\"");
			}
			PrintUtil.bar();
			System.out.println("�� ����Ű�� ���� �ڷ� ���ư��ϴ�");
			ScanUtil.nextLine();
			view = View.REVIEW;
		} else {
			PrintUtil.bar();
			System.out.println("\"ȸ���� �̿밡���մϴ�.\"\n�� �޴��� �������ּ���");
			System.out.println("1.�α���  2.ȸ������  3.�ڷΰ���");
			System.out.println("-----------------------------------------------");
			System.out.print("�Է�>");
			int choice = ScanUtil.nextInt();
			PrintUtil.bar();

			if (choice == 1) {
				view = View.USER_LOGIN;
			} else if (choice == 2) {
				view = View.USER_SIGNUP;
			} else if (choice == 3) {
				view = View.REVIEW;
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

					System.out.print("������ : ");
					String review_remark = ScanUtil.nextLine();

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
			if (choice == 1) {
				view = View.USER_LOGIN;
			} else if (choice == 2) {
				view = View.USER_SIGNUP;
			} else if (choice == 3) {
				view = View.REVIEW;
			} else {
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				view = View.REVIEW;
			}
		}
		return view;
	}

	// ���Ժ� ����
	public int stoReview() {
		int view = 0;
		PrintUtil.bar();
		System.out.println("�� SEARCH DETAIL REVIEW MENU");
		System.out.println(" 1.���Ը� �˻�  2.���Թ�ȣ �˻�  3.�ڷΰ���  4.���α׷� ����");
		System.out.print(" �Է� >>");
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
			System.out.println("�߸��� �Է��Դϴ�.");
			view = stoReview();
			break;
		}
		return view;
	}

	public int storeNameReview() {
		int view = 0;
//	      List storeNoList = new ArrayList();
		// ���Ը� �Է�
		System.out.print("\"���Ը��� �Է����ּ���\"\n �Է� >> ");
		String input = ScanUtil.nextLine();
		PrintUtil.bar();
		System.out.println("\t���'" + input + "'�� �˻��� ����Դϴ�.���\n");

		// ���Ը� �˻� �� ���
		List<Map<String, Object>> storeList = dao.list3(input);

		if (storeList != null && !storeList.isEmpty()) {
			for (int i = 0; i < storeList.size(); i++) {
				String stoNm = (String) storeList.get(i).get("STO_NAME");
//	         storeNoList.add(stoNm);
				System.out.println("\t" + (i + 1) + " : " + stoNm);
			}
			// ��µ� ���� ���� �� ���� ���
			while (true) {
				PrintUtil.bar();
				System.out.println("�� ���Ͻô� ������ ��ȣ�� �Է����ּ���");
				System.out.print(" ��ȣ �Է� >>");
				int a = ScanUtil.nextInt();
				if (a > 0 && a <= storeList.size()) {
					String stoNo = (String) storeList.get(a - 1).get("STO_NO");
					view = storeNoReview(stoNo);
					break;
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}
			}
		} else {
			System.out.println();
			System.out.println("�Է��Ͻ� ���԰� �������� �ʽ��ϴ�.");
			view = stoReview();
		}
		return view;
	}

	// ���Թ�ȣ �˻�
	public int storeNoReview() {
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
				System.out.println("-----------------------------------------------");
				System.out.println("\t\t\t\t�� ���� [" + (h + 1) + "]��");
				System.out.printf(" �Ĵ�� : %-20s \n", map.get("STO_NAME"));
				System.out.printf(" ��   �� :%2.0f\n", map.get("RVW_SCORE"));
				System.out.printf(" ��   �� :\"%s\"\n", map.get("RVW_REMARK"));
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
				System.out.println("-----------------------------------------------");
				System.out.println("\t\t\t\t�� ���� [" + (h + 1) + "]��");
				System.out.printf(" �Ĵ�� : %-20s \n", map.get("STO_NAME"));
				System.out.printf(" ��   �� :%2.0f\n", map.get("RVW_SCORE"));
				System.out.printf(" ��   �� :\"%s\"\n", map.get("RVW_REMARK"));
			}
		} else {
			System.out.println("�ش� ������ ���䰡 �����ϴ�.");
		}

		return stoReview();
	}

}

//public int reviewHome() {
//
//	List<Map<String, Object>> reviewList = reviewdao.allReview();
//
//	// ���������
//	PrintUtil.bar();
//	System.out.println("\t�� ALL REIVIEW LIST ��\n");
//	for (int i = 0; i < reviewList.size(); i++) {
//		Map<String, Object> map = reviewList.get(i);
//		System.out.println("\t\t\t\t�� ���� [" + (i + 1) + "]��");
//		System.out.printf(" �Ĵ�� : %-20s \n", map.get("STO_NAME"));
//		System.out.printf(" ��   �� :%2.0f\n", map.get("RVW_SCORE"));
//		System.out.printf(" ��   �� :\"%s\"\n", map.get("RVW_REMARK"));
//		System.out.print(" �ۼ��� :\"");
//		System.out.print(((String) map.get("MEM_ID")).substring(0, 2));
//		System.out.printf("%s\"\n", "**");
//
//		System.out.println("-----------------------------------------------");
////		if ((i + 1) % 5 == 0) {
////			System.out.println("   ----------------------------- [��] scroll [��]");
////		}
//	}
//	PrintUtil.bar();
//	System.out.println("1.�� ����  2.���Ժ� ����  3.Ȩ����");
//	System.out.print("����>");
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