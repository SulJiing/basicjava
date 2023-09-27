//package service;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Scanner;
//
//import dao.StoreDao;
//import util.PrintUtil;
//import util.ScanUtil;
//import util.View;
//
//public class StoreService {
//	private int result = 0;
//	private static StoreService instance = null;
//	Scanner sc = new Scanner(System.in);
//
//	private StoreService() {
//	}
//
//	// 싱글톤
//	public static StoreService getInstance() {
//		if (instance == null)
//			instance = new StoreService();
//		return instance;
//	}
//
//	// STORE DAO 생성
//	StoreDao storeDao = StoreDao.getInstance();
//	
//	//1.View Service
//	// Controller >> View.SEARH >> 가게정보, 분류, 별점 별 보기
//	public int searchHome() {
//		while (true) {
//			PrintUtil.bar();
//			System.out.println("\t- 전체 맛집 리스트 -\n");
//
//			List<Map<String, Object>> storeList = storeDao.list();
//
//			for (int i = 0; i < storeList.size(); i++) {
//				Map<String, Object> map = storeList.get(i);
//				System.out.printf("\t%2d.%s\n", (i + 1), map.get("STO_NAME"));
//
//				if ((i + 1) % 5 == 0) {
//					System.out.println("   ----------------------------- [▲] scroll [▼]");
//				}
//			}
//			PrintUtil.searchPage();
//			int input = sc.nextInt();
//			switch (input) {
//			case 1:
//				result = View.STO_SC;
//				break;
//			case 2:
//				System.out.println("분류별 가게 보기!");
//				result = View.STO_TYPE;
//				break;
//			case 3:
//				System.out.println("별점별 가게 보기 클릭!");
//				result = View.STO_RANK;
//				break;
//			case 4:
//				System.out.println("홈으로가기 클릭!");
//				result = View.UI_HOME;
//				break;
//			case 5:
//				System.out.println("=========================");
//				System.out.println("프로그램을 종료합니다.");
//				System.exit(0);
//				break;
//			default:
//				break;
//			}
//			return result;
//
//		}
//	}
//
//	// Controller >> View.STO_SC >> 식당 이름별 선택단 뷰어 메소드
//	public int listStoreName() {
//			int result = 0;
//
//			// 가게명 입력
//			System.out.print("가게명 입력 >> ");
//			String input = ScanUtil.nextLine();
//			PrintUtil.bar();
//			System.out.println("\t▼▼'" + input + "'로 검색한 결과입니다.▼▼");
//
//			// 가게명 검색
//			List<Map<String, Object>> storeList = storeDao.list3(input);
//			boolean found = false;
//
//			// 검색 결과 출력
//			for (int i = 0; i < storeList.size(); i++) {
//				Map<String, Object> map = storeList.get(i);
//
//				if (map.containsKey("STO_NAME")) {
//
//					System.out.println("▷ STORE INFO");
//					System.out.printf("\t%s  : %s\n", "가   게   명", map.get("STO_NAME"));
//					System.out.printf("\t%s  : %s\n", "분         류", map.get("TYPE_NAME"));
//					System.out.printf("\t%s  : %s\n", "별         점", map.get("STO_RANK"));
//					System.out.printf("\t%s  : %s\n", "영 업 시 간", map.get("STO_TIME"));
//					System.out.printf("\t%s  : %s\n", "거         리", map.get("STO_DISTANCE"));
//					System.out.printf("\t%s  : %s\n", "전 화 번 호", map.get("STO_TEL"));
//					System.out.printf("\t%s  : %s\n", "주         소", map.get("STO_ADDRESS"));
//					System.out.printf("\t%s  : %s\n", "예 약 여 부", map.get("STO_RESERVATION"));
//
//					System.out.println("\n▷ STORE MENU");
//					listMenuFor((String) map.get("STO_NAME"));
//					System.out.println("------------------------------------- [▲] scroll [▼]");
//
//					found = true;
//				}
//			}
//			if (!found) {
//				System.out.println("가게를 찾을 수 없습니다.");
//				System.out.println("1. 홈으로 가기  2. 프로그램 종료 3. 다시검색");
//				System.out.print("가게명 입력 >> ");
//				int input3 = ScanUtil.nextInt();
//				switch (input3) {
//				case 1:
//					System.out.println("뒤로가기 클릭!");
//					result = View.SEARCH;
//					break;
//				case 2:
//					System.out.println("=========================");
//					System.out.println("프로그램을 종료합니다.");
//					System.exit(0);
//					break;
//				case 3:
//					listStoreName();
//					break;
//				default:
//					break;
//				}
//			} else {
//				PrintUtil.bar();
//				System.out.println("\"매장의 메뉴 및 상세정보를 보기위해 매장의 전체이름을 입력해주세요.\"");
//				System.out.println("\"만약 첫화면으로 돌아가고싶다면 숫자 '1'입력!!!\"");
//				System.out.print("매장 풀네임 입력>>");
//				String selectedStoreName = ScanUtil.nextLine();
//				if (selectedStoreName.equals("1")) {
//					return View.SEARCH;
//				}
//				result = stoNameView();
//			}
//			return result;
//		}
//	
//	// Controller >> View.STO_TYPE >> 식당 분류별 선택단 뷰어 메소드
//	public int typeSC() {
//		int result = 0;
//
//		System.out.println("1.한식  2.일식   3.중식   4.양식  5.분식  6.기타");
//		int choice = ScanUtil.nextInt();
//		switch (choice) {
//		case 1:
//			List<Map<String, Object>> storeList = storeDao.list2("한식");
//			for (int i = 0; i < storeList.size(); i++) {
//				Map<String, Object> map = storeList.get(i);
//				System.out.println("가게명 : " + map.get("STO_NAME"));
//				System.out.println();
//			}
//			result = listStoreName();
//			break;
//		case 2:
//			List<Map<String, Object>> storeList1 = storeDao.list2("일식");
//			for (int i = 0; i < storeList1.size(); i++) {
//				Map<String, Object> map = storeList1.get(i);
//				System.out.println("가게명 : " + map.get("STO_NAME"));
//				System.out.println();
//			}
//			result = listStoreName();
//			break;
//		case 3:
//			List<Map<String, Object>> storeList2 = storeDao.list2("중식");
//			for (int i = 0; i < storeList2.size(); i++) {
//				Map<String, Object> map = storeList2.get(i);
//				System.out.println("가게명 : " + map.get("STO_NAME"));
//				System.out.println();
//			}
//			result = listStoreName();
//			break;
//		case 4:
//			List<Map<String, Object>> storeList3 = storeDao.list2("양식");
//			for (int i = 0; i < storeList3.size(); i++) {
//				Map<String, Object> map = storeList3.get(i);
//				System.out.println("가게명 : " + map.get("STO_NAME"));
//				System.out.println();
//			}
//			result = listStoreName();
//			break;
//		case 5:
//			List<Map<String, Object>> storeList4 = storeDao.list2("분식");
//			for (int i = 0; i < storeList4.size(); i++) {
//				Map<String, Object> map = storeList4.get(i);
//				System.out.println("가게명 : " + map.get("STO_NAME"));
//				System.out.println();
//			}
//			result = listStoreName();
//			break;
//		case 6:
//			List<Map<String, Object>> storeList5 = storeDao.list2("기타");
//			for (int i = 0; i < storeList5.size(); i++) {
//				Map<String, Object> map = storeList5.get(i);
//				System.out.println("가게명 : " + map.get("STO_NAME"));
//				System.out.println();
//			}
//			result = listStoreName();
//			break;
//		default:
//			System.out.println("잘못된 입력입니다.");
//			return View.STO_TYPE;
//		}
//		return result;
//	}
//
//	// Controller >> View.STO_RANK >> 별점 분류별  선택단 뷰어 메소드
//	public int stoRank() {
//		StoreDao dao = StoreDao.getInstance();
//		// 사용자로부터 별점 이상을 입력받음
//		System.out.print("최소 별점을 입력하세요: ");
//		int minRating = ScanUtil.nextInt();
//
//		List<Map<String, Object>> storeList = dao.listRank(minRating);
//
//		if (storeList == null || storeList.isEmpty()) {
//			System.out.println("별점 " + minRating + " 이상의 가게가 없습니다.");
//			stoRank();
//		} else {
//			System.out.println("별점 " + minRating + " 이상의 가게 목록:");
//			for (Map<String, Object> map : storeList) {
//				System.out.println("가게명: " + map.get("STO_NAME"));
//				listStoreName();
//			}
//		}
//
//		// 가게 목록의 크기를 반환
//		return (storeList != null) ? storeList.size() : 0;
//	}
//	
//	//2.StoreService의 listStoreName의 하부 메소드
//	// stoSc()>> listStroeName()의 최종 return 값
//	public int stoNameView() {
//		int result = 0;
//		System.out.println("다음은 무슨 메뉴를 선택할거예요? >>> ");
//		System.out.println("1. 리뷰보기 2. 리뷰쓰기  3. 즐겨찾기");
//		System.out.println("4. 홈으로 가기    5. 프로그램 종료");
//		System.out.print("번호 입력 : ");
//		int input2 = sc.nextInt();
//		switch (input2) {
//		case 1:
//			System.out.println("리뷰보기!");
//			result = View.STO_SC;
//			break;
//		case 2:
//			System.out.println("리뷰쓰기!");
//			result = View.STO_SC;
//			break;
//		case 3:
//			System.out.println("즐겨찾기");
//			result = View.STO_SC;
//			break;
//		case 4:
//			System.out.println("홈으로가기 클릭!");
//			result = View.UI_HOME;
//			break;
//		case 5:
//			System.out.println("=========================");
//			System.out.println("프로그램을 종료합니다.");
//			System.exit(0);
//			break;
//		default:
//			stoNameView();
//			break;
//		}
//		return result;
//	}
//
//	// stoSc()>> listStroeName()의 메뉴정보 출력 도움 메소드
//	public void listMenuFor(String storeName) {
//		List<Map<String, Object>> menuList = storeDao.listMenuForStore(storeName);
//		for (Map<String, Object> menu : menuList) {
//			System.out.printf("\t%s  : %s\n", "메         뉴", menu.get("MENU_NAME"));
//			System.out.printf("\t%s  : %s\n", "가         격", menu.get("MENU_PRICE"));
//			System.out.println();
//		}
//	}
//
//	// stoSc()>> listStoreName()을 result에 넣어주기 위한 메서드
//	public int typeMa() {
//		int result = listStoreName();
//		return result;
//	}
//
//
//}

package service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dao.StoreDao;
import util.PrintUtil;
import util.ScanUtil;
import util.View;

public class StoreService {
	private int result = 0;
	private static StoreService instance = null;
	Scanner sc = new Scanner(System.in);

	private StoreService() {
	}

	// 싱글톤
	public static StoreService getInstance() {
		if (instance == null)
			instance = new StoreService();
		return instance;
	}

	// STORE DAO 생성
	StoreDao storeDao = StoreDao.getInstance();

	// 1.View Service

	// Controller >> View.SEARH >> 가게정보, 분류, 별점 별 보기
	public int searchHome() {
		while (true) {
			PrintUtil.bar();
			System.out.println("\t▼ 전체 맛집 리스트 ▼\n");
			List<Map<String, Object>> storeList = storeDao.list();

			for (int i = 0; i < storeList.size(); i++) {
				Map<String, Object> map = storeList.get(i);
				System.out.printf("\t%2d.%s\n", (i + 1), map.get("STO_NAME"));

				if ((i + 1) % 5 == 0) {
					System.out.println("   ----------------------------- [▲] scroll [▼]");
				}
			}
			PrintUtil.searchPage();

			int input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				result = View.STO_SC;
				break;
			case 2:
				result = View.STO_TYPE;
				break;
			case 3:
				result = View.STO_RANK;
				break;
			case 4:
				System.out.println("홈으로가기 클릭!");
				result = View.UI_HOME;
				break;
			case 5:
				System.out.println("=========================");
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default: result = View.SEARCH;
            System.out.println("잘못된 입력입니다. 다시 입력해주세요!");
				break;
			}
			return result;

		}
	}

	// Controller >> View.STO_SC >> 식당 이름별 선택단 뷰어 메소드
	public int listStoreName() {
		int result = 0;
		PrintUtil.bar();
		// 가게명 입력
		System.out.print("가게명 입력 >> ");
		String input = ScanUtil.nextLine().trim();
		PrintUtil.bar();
		System.out.println("\t▼▼'" + input + "'로 검색한 결과입니다.▼▼");

		// 가게명 검색
		List<Map<String, Object>> storeList = storeDao.list3(input);

		// 검색 결과 출력
		for (int i = 0; i < storeList.size(); i++) {

			Map<String, Object> map = storeList.get(i);
			if (map.containsKey("STO_NAME")) {

				System.out.println("▷ STORE INFO");
				System.out.printf("\t%s  : %s\n", "가 게 번 호", map.get("STO_NO"));
				System.out.printf("\t%s  : %s\n", "가   게   명", map.get("STO_NAME"));
				System.out.printf("\t%s  : %s\n", "분         류", map.get("TYPE_NAME"));
				System.out.printf("\t%s  : %s\n", "별         점", map.get("STO_RANK"));
				System.out.printf("\t%s  : %s\n", "영 업 시 간", map.get("STO_TIME"));
				System.out.printf("\t%s  : %s\n", "거         리", map.get("STO_DISTANCE"));
				System.out.printf("\t%s  : %s\n", "전 화 번 호", map.get("STO_TEL"));
				System.out.printf("\t%s  : %s\n", "주         소", map.get("STO_ADDRESS"));
				System.out.printf("\t%s  : %s\n", "예 약 여 부", map.get("STO_RESERVATION"));

				System.out.println("\n▷ STORE MENU");
				listMenuFor((String) map.get("STO_NAME"));
				System.out.println("------------------------------------- [▲] scroll [▼]");
			}
		}
		result = stoNameView();
		return result;
	}

	public int typeSC() {
		int result = 0;
		PrintUtil.bar();
		System.out.println("\n\t▼ RESTAURANT TYPE ▼\n");
		System.out.println("\t1.한   식\t2.일   식\t3.중   식\n\n\t4.양   식\t5.분   식\t6.기   타\n");
		PrintUtil.bar();
		System.out.print("[분류 선택] 입력 >>");

		int choice = ScanUtil.nextInt();
		PrintUtil.bar();
		switch (choice) {
		case 1:
			List<Map<String, Object>> storeList = storeDao.list2("한식");
			System.out.println("▼ [한  식] 검색 결과 ▼\n");
			for (int i = 0; i < storeList.size(); i++) {
				Map<String, Object> map = storeList.get(i);
				System.out.println(" " + (i + 1) + ".가게명 : " + map.get("STO_NAME"));
				if ((i + 1) % 5 == 0) {
					System.out.println("----------------------------- [▲] scroll [▼]");
				}
			}
			result = listStoreName();
			break;
		case 2:
			List<Map<String, Object>> storeList1 = storeDao.list2("일식");
			System.out.println("▼ [일  식] 검색 결과 ▼");
			for (int i = 0; i < storeList1.size(); i++) {
				Map<String, Object> map = storeList1.get(i);
				System.out.println(" " + (i + 1) + ".가게명 : " + map.get("STO_NAME"));
				if ((i + 1) % 5 == 0) {
					System.out.println("----------------------------- [▲] scroll [▼]");
				}
			}
			result = listStoreName();
			break;
		case 3:
			List<Map<String, Object>> storeList2 = storeDao.list2("중식");
			System.out.println("▼ [중  식] 검색 결과 ▼");
			for (int i = 0; i < storeList2.size(); i++) {
				Map<String, Object> map = storeList2.get(i);
				System.out.println(" " + (i + 1) + ".가게명 : " + map.get("STO_NAME"));
				if ((i + 1) % 5 == 0) {
					System.out.println("----------------------------- [▲] scroll [▼]");
				}
			}
			result = listStoreName();
			break;
		case 4:
			List<Map<String, Object>> storeList3 = storeDao.list2("양식");
			System.out.println("▼ [양  식] 검색 결과 ▼");
			for (int i = 0; i < storeList3.size(); i++) {
				Map<String, Object> map = storeList3.get(i);
				System.out.println(" " + (i + 1) + ".가게명 : " + map.get("STO_NAME"));
				if ((i + 1) % 5 == 0) {
					System.out.println("----------------------------- [▲] scroll [▼]");
				}
			}
			result = listStoreName();
			break;
		case 5:
			List<Map<String, Object>> storeList4 = storeDao.list2("분식");
			System.out.println("▼ [분  식] 검색 결과 ▼");
			for (int i = 0; i < storeList4.size(); i++) {
				Map<String, Object> map = storeList4.get(i);
				System.out.println(" " + (i + 1) + ".가게명 : " + map.get("STO_NAME"));
				if ((i + 1) % 5 == 0) {
					System.out.println("----------------------------- [▲] scroll [▼]");
				}
			}
			result = listStoreName();
			break;
		case 6:
			List<Map<String, Object>> storeList5 = storeDao.list2("기타");
			System.out.println("▼ [기  타] 검색 결과 ▼");
			for (int i = 0; i < storeList5.size(); i++) {
				Map<String, Object> map = storeList5.get(i);
				System.out.println(" " + (i + 1) + ".가게명 : " + map.get("STO_NAME"));
				if ((i + 1) % 5 == 0) {
					System.out.println("----------------------------- [▲] scroll [▼]");
				}
			}
			result = listStoreName();
			break;
		default:
			System.out.println("잘못된 입력입니다.");
			return View.STO_TYPE;
		}
		return result;
	}

	// Controller >> View.STO_RANK >> 별점 분류별 선택단 뷰어 메소드
	public int stoRank() {
		int view = 0;
		StoreDao dao = StoreDao.getInstance();
		// 사용자로부터 별점 이상을 입력받음
		System.out.print("최소 별점을 입력하세요: ");
		int minRating = ScanUtil.nextInt();

		List<Map<String, Object>> storeList = dao.listRank(minRating);

		if (storeList == null || storeList.isEmpty()) {
			System.out.println("별점 " + minRating + " 이상의 가게가 없습니다.");
			view = stoRank();
		} else {
			PrintUtil.bar();
			System.out.println("\n\t▼ 별점 [" + minRating + "]↑ 가게 목록  ▼");
			for (Map<String, Object> map : storeList) {
				System.out.println("     ---------------------");
				System.out.printf("\t가   게   명: %s\n", map.get("STO_NAME"));
				System.out.print("\t별         점: ");
				System.out.println(map.get("STO_RANK") + " 점");
			}
//	         listStoreName(); 별점 검색 후 리뷰보기를 선택하면 홈화면으로 돌아가는 오류 수정
			view = View.STO_SC;
		}
		return view;
	}

	// 2.StoreService의 listStoreName의 하부 메소드

	// stoSc()>> listStroeName()의 최종 return 값
	public int stoNameView() {
		int result = 0;
		System.out.println();
		System.out.printf("%s  %s  %s  %s  %s\n", "1.리뷰 검색", "2.즐겨찾기", "3.뒤로가기", " 4.홈으로가기", "5.프로그램 종료");
		PrintUtil.bar();
		System.out.println("▼ 메뉴선택 ▼");
		System.out.print("번호 입력 : ");
		int input2 = ScanUtil.nextInt();
		switch (input2) {
		case 1:
			System.out.println("리뷰보기!");
			result = View.REVIEW;
			break;
		case 2:
			System.out.println("즐겨찾기!");
			result = View.BOOKMARK2;
			break;

		case 3:
			System.out.println("뒤로가기!");
			result = View.SEARCH;
			break;
		case 4:
			System.out.println("홈으로가기 클릭!");
			result = View.UI_HOME;
			break;
		case 5:
			PrintUtil.bar();
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
			break;
		default:
			 System.out.println("잘못된 입력입니다. 다시 선택해 주세요");
	         return stoNameView();
		}
		return result;
	}

	// stoSc()>> listStroeName()의 메뉴정보 출력 도움 메소드
	public void listMenuFor(String storeName) {
		List<Map<String, Object>> menuList = storeDao.listMenuForStore(storeName);
		for (Map<String, Object> menu : menuList) {
			System.out.printf("\t%s  : %s\n", "메         뉴", menu.get("MENU_NAME"));
			System.out.printf("\t%s  : %s\n", "가         격", menu.get("MENU_PRICE"));
			System.out.println();
		}
	}

	// stoSc()>> listStoreName()을 result에 넣어주기 위한 메서드
	public int typeMa() {
		int result = listStoreName();
		return result;
	}

}