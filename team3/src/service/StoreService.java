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
//	// �̱���
//	public static StoreService getInstance() {
//		if (instance == null)
//			instance = new StoreService();
//		return instance;
//	}
//
//	// STORE DAO ����
//	StoreDao storeDao = StoreDao.getInstance();
//	
//	//1.View Service
//	// Controller >> View.SEARH >> ��������, �з�, ���� �� ����
//	public int searchHome() {
//		while (true) {
//			PrintUtil.bar();
//			System.out.println("\t- ��ü ���� ����Ʈ -\n");
//
//			List<Map<String, Object>> storeList = storeDao.list();
//
//			for (int i = 0; i < storeList.size(); i++) {
//				Map<String, Object> map = storeList.get(i);
//				System.out.printf("\t%2d.%s\n", (i + 1), map.get("STO_NAME"));
//
//				if ((i + 1) % 5 == 0) {
//					System.out.println("   ----------------------------- [��] scroll [��]");
//				}
//			}
//			PrintUtil.searchPage();
//			int input = sc.nextInt();
//			switch (input) {
//			case 1:
//				result = View.STO_SC;
//				break;
//			case 2:
//				System.out.println("�з��� ���� ����!");
//				result = View.STO_TYPE;
//				break;
//			case 3:
//				System.out.println("������ ���� ���� Ŭ��!");
//				result = View.STO_RANK;
//				break;
//			case 4:
//				System.out.println("Ȩ���ΰ��� Ŭ��!");
//				result = View.UI_HOME;
//				break;
//			case 5:
//				System.out.println("=========================");
//				System.out.println("���α׷��� �����մϴ�.");
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
//	// Controller >> View.STO_SC >> �Ĵ� �̸��� ���ô� ��� �޼ҵ�
//	public int listStoreName() {
//			int result = 0;
//
//			// ���Ը� �Է�
//			System.out.print("���Ը� �Է� >> ");
//			String input = ScanUtil.nextLine();
//			PrintUtil.bar();
//			System.out.println("\t���'" + input + "'�� �˻��� ����Դϴ�.���");
//
//			// ���Ը� �˻�
//			List<Map<String, Object>> storeList = storeDao.list3(input);
//			boolean found = false;
//
//			// �˻� ��� ���
//			for (int i = 0; i < storeList.size(); i++) {
//				Map<String, Object> map = storeList.get(i);
//
//				if (map.containsKey("STO_NAME")) {
//
//					System.out.println("�� STORE INFO");
//					System.out.printf("\t%s  : %s\n", "��   ��   ��", map.get("STO_NAME"));
//					System.out.printf("\t%s  : %s\n", "��         ��", map.get("TYPE_NAME"));
//					System.out.printf("\t%s  : %s\n", "��         ��", map.get("STO_RANK"));
//					System.out.printf("\t%s  : %s\n", "�� �� �� ��", map.get("STO_TIME"));
//					System.out.printf("\t%s  : %s\n", "��         ��", map.get("STO_DISTANCE"));
//					System.out.printf("\t%s  : %s\n", "�� ȭ �� ȣ", map.get("STO_TEL"));
//					System.out.printf("\t%s  : %s\n", "��         ��", map.get("STO_ADDRESS"));
//					System.out.printf("\t%s  : %s\n", "�� �� �� ��", map.get("STO_RESERVATION"));
//
//					System.out.println("\n�� STORE MENU");
//					listMenuFor((String) map.get("STO_NAME"));
//					System.out.println("------------------------------------- [��] scroll [��]");
//
//					found = true;
//				}
//			}
//			if (!found) {
//				System.out.println("���Ը� ã�� �� �����ϴ�.");
//				System.out.println("1. Ȩ���� ����  2. ���α׷� ���� 3. �ٽð˻�");
//				System.out.print("���Ը� �Է� >> ");
//				int input3 = ScanUtil.nextInt();
//				switch (input3) {
//				case 1:
//					System.out.println("�ڷΰ��� Ŭ��!");
//					result = View.SEARCH;
//					break;
//				case 2:
//					System.out.println("=========================");
//					System.out.println("���α׷��� �����մϴ�.");
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
//				System.out.println("\"������ �޴� �� �������� �������� ������ ��ü�̸��� �Է����ּ���.\"");
//				System.out.println("\"���� ùȭ������ ���ư���ʹٸ� ���� '1'�Է�!!!\"");
//				System.out.print("���� Ǯ���� �Է�>>");
//				String selectedStoreName = ScanUtil.nextLine();
//				if (selectedStoreName.equals("1")) {
//					return View.SEARCH;
//				}
//				result = stoNameView();
//			}
//			return result;
//		}
//	
//	// Controller >> View.STO_TYPE >> �Ĵ� �з��� ���ô� ��� �޼ҵ�
//	public int typeSC() {
//		int result = 0;
//
//		System.out.println("1.�ѽ�  2.�Ͻ�   3.�߽�   4.���  5.�н�  6.��Ÿ");
//		int choice = ScanUtil.nextInt();
//		switch (choice) {
//		case 1:
//			List<Map<String, Object>> storeList = storeDao.list2("�ѽ�");
//			for (int i = 0; i < storeList.size(); i++) {
//				Map<String, Object> map = storeList.get(i);
//				System.out.println("���Ը� : " + map.get("STO_NAME"));
//				System.out.println();
//			}
//			result = listStoreName();
//			break;
//		case 2:
//			List<Map<String, Object>> storeList1 = storeDao.list2("�Ͻ�");
//			for (int i = 0; i < storeList1.size(); i++) {
//				Map<String, Object> map = storeList1.get(i);
//				System.out.println("���Ը� : " + map.get("STO_NAME"));
//				System.out.println();
//			}
//			result = listStoreName();
//			break;
//		case 3:
//			List<Map<String, Object>> storeList2 = storeDao.list2("�߽�");
//			for (int i = 0; i < storeList2.size(); i++) {
//				Map<String, Object> map = storeList2.get(i);
//				System.out.println("���Ը� : " + map.get("STO_NAME"));
//				System.out.println();
//			}
//			result = listStoreName();
//			break;
//		case 4:
//			List<Map<String, Object>> storeList3 = storeDao.list2("���");
//			for (int i = 0; i < storeList3.size(); i++) {
//				Map<String, Object> map = storeList3.get(i);
//				System.out.println("���Ը� : " + map.get("STO_NAME"));
//				System.out.println();
//			}
//			result = listStoreName();
//			break;
//		case 5:
//			List<Map<String, Object>> storeList4 = storeDao.list2("�н�");
//			for (int i = 0; i < storeList4.size(); i++) {
//				Map<String, Object> map = storeList4.get(i);
//				System.out.println("���Ը� : " + map.get("STO_NAME"));
//				System.out.println();
//			}
//			result = listStoreName();
//			break;
//		case 6:
//			List<Map<String, Object>> storeList5 = storeDao.list2("��Ÿ");
//			for (int i = 0; i < storeList5.size(); i++) {
//				Map<String, Object> map = storeList5.get(i);
//				System.out.println("���Ը� : " + map.get("STO_NAME"));
//				System.out.println();
//			}
//			result = listStoreName();
//			break;
//		default:
//			System.out.println("�߸��� �Է��Դϴ�.");
//			return View.STO_TYPE;
//		}
//		return result;
//	}
//
//	// Controller >> View.STO_RANK >> ���� �з���  ���ô� ��� �޼ҵ�
//	public int stoRank() {
//		StoreDao dao = StoreDao.getInstance();
//		// ����ڷκ��� ���� �̻��� �Է¹���
//		System.out.print("�ּ� ������ �Է��ϼ���: ");
//		int minRating = ScanUtil.nextInt();
//
//		List<Map<String, Object>> storeList = dao.listRank(minRating);
//
//		if (storeList == null || storeList.isEmpty()) {
//			System.out.println("���� " + minRating + " �̻��� ���԰� �����ϴ�.");
//			stoRank();
//		} else {
//			System.out.println("���� " + minRating + " �̻��� ���� ���:");
//			for (Map<String, Object> map : storeList) {
//				System.out.println("���Ը�: " + map.get("STO_NAME"));
//				listStoreName();
//			}
//		}
//
//		// ���� ����� ũ�⸦ ��ȯ
//		return (storeList != null) ? storeList.size() : 0;
//	}
//	
//	//2.StoreService�� listStoreName�� �Ϻ� �޼ҵ�
//	// stoSc()>> listStroeName()�� ���� return ��
//	public int stoNameView() {
//		int result = 0;
//		System.out.println("������ ���� �޴��� �����Ұſ���? >>> ");
//		System.out.println("1. ���亸�� 2. ���侲��  3. ���ã��");
//		System.out.println("4. Ȩ���� ����    5. ���α׷� ����");
//		System.out.print("��ȣ �Է� : ");
//		int input2 = sc.nextInt();
//		switch (input2) {
//		case 1:
//			System.out.println("���亸��!");
//			result = View.STO_SC;
//			break;
//		case 2:
//			System.out.println("���侲��!");
//			result = View.STO_SC;
//			break;
//		case 3:
//			System.out.println("���ã��");
//			result = View.STO_SC;
//			break;
//		case 4:
//			System.out.println("Ȩ���ΰ��� Ŭ��!");
//			result = View.UI_HOME;
//			break;
//		case 5:
//			System.out.println("=========================");
//			System.out.println("���α׷��� �����մϴ�.");
//			System.exit(0);
//			break;
//		default:
//			stoNameView();
//			break;
//		}
//		return result;
//	}
//
//	// stoSc()>> listStroeName()�� �޴����� ��� ���� �޼ҵ�
//	public void listMenuFor(String storeName) {
//		List<Map<String, Object>> menuList = storeDao.listMenuForStore(storeName);
//		for (Map<String, Object> menu : menuList) {
//			System.out.printf("\t%s  : %s\n", "��         ��", menu.get("MENU_NAME"));
//			System.out.printf("\t%s  : %s\n", "��         ��", menu.get("MENU_PRICE"));
//			System.out.println();
//		}
//	}
//
//	// stoSc()>> listStoreName()�� result�� �־��ֱ� ���� �޼���
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

	// �̱���
	public static StoreService getInstance() {
		if (instance == null)
			instance = new StoreService();
		return instance;
	}

	// STORE DAO ����
	StoreDao storeDao = StoreDao.getInstance();

	// 1.View Service

	// Controller >> View.SEARH >> ��������, �з�, ���� �� ����
	public int searchHome() {
		while (true) {
			PrintUtil.bar();
			System.out.println("\t�� ��ü ���� ����Ʈ ��\n");
			List<Map<String, Object>> storeList = storeDao.list();

			for (int i = 0; i < storeList.size(); i++) {
				Map<String, Object> map = storeList.get(i);
				System.out.printf("\t%2d.%s\n", (i + 1), map.get("STO_NAME"));

				if ((i + 1) % 5 == 0) {
					System.out.println("   ----------------------------- [��] scroll [��]");
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
				System.out.println("Ȩ���ΰ��� Ŭ��!");
				result = View.UI_HOME;
				break;
			case 5:
				System.out.println("=========================");
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
				break;
			default: result = View.SEARCH;
            System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���!");
				break;
			}
			return result;

		}
	}

	// Controller >> View.STO_SC >> �Ĵ� �̸��� ���ô� ��� �޼ҵ�
	public int listStoreName() {
		int result = 0;
		PrintUtil.bar();
		// ���Ը� �Է�
		System.out.print("���Ը� �Է� >> ");
		String input = ScanUtil.nextLine().trim();
		PrintUtil.bar();
		System.out.println("\t���'" + input + "'�� �˻��� ����Դϴ�.���");

		// ���Ը� �˻�
		List<Map<String, Object>> storeList = storeDao.list3(input);

		// �˻� ��� ���
		for (int i = 0; i < storeList.size(); i++) {

			Map<String, Object> map = storeList.get(i);
			if (map.containsKey("STO_NAME")) {

				System.out.println("�� STORE INFO");
				System.out.printf("\t%s  : %s\n", "�� �� �� ȣ", map.get("STO_NO"));
				System.out.printf("\t%s  : %s\n", "��   ��   ��", map.get("STO_NAME"));
				System.out.printf("\t%s  : %s\n", "��         ��", map.get("TYPE_NAME"));
				System.out.printf("\t%s  : %s\n", "��         ��", map.get("STO_RANK"));
				System.out.printf("\t%s  : %s\n", "�� �� �� ��", map.get("STO_TIME"));
				System.out.printf("\t%s  : %s\n", "��         ��", map.get("STO_DISTANCE"));
				System.out.printf("\t%s  : %s\n", "�� ȭ �� ȣ", map.get("STO_TEL"));
				System.out.printf("\t%s  : %s\n", "��         ��", map.get("STO_ADDRESS"));
				System.out.printf("\t%s  : %s\n", "�� �� �� ��", map.get("STO_RESERVATION"));

				System.out.println("\n�� STORE MENU");
				listMenuFor((String) map.get("STO_NAME"));
				System.out.println("------------------------------------- [��] scroll [��]");
			}
		}
		result = stoNameView();
		return result;
	}

	public int typeSC() {
		int result = 0;
		PrintUtil.bar();
		System.out.println("\n\t�� RESTAURANT TYPE ��\n");
		System.out.println("\t1.��   ��\t2.��   ��\t3.��   ��\n\n\t4.��   ��\t5.��   ��\t6.��   Ÿ\n");
		PrintUtil.bar();
		System.out.print("[�з� ����] �Է� >>");

		int choice = ScanUtil.nextInt();
		PrintUtil.bar();
		switch (choice) {
		case 1:
			List<Map<String, Object>> storeList = storeDao.list2("�ѽ�");
			System.out.println("�� [��  ��] �˻� ��� ��\n");
			for (int i = 0; i < storeList.size(); i++) {
				Map<String, Object> map = storeList.get(i);
				System.out.println(" " + (i + 1) + ".���Ը� : " + map.get("STO_NAME"));
				if ((i + 1) % 5 == 0) {
					System.out.println("----------------------------- [��] scroll [��]");
				}
			}
			result = listStoreName();
			break;
		case 2:
			List<Map<String, Object>> storeList1 = storeDao.list2("�Ͻ�");
			System.out.println("�� [��  ��] �˻� ��� ��");
			for (int i = 0; i < storeList1.size(); i++) {
				Map<String, Object> map = storeList1.get(i);
				System.out.println(" " + (i + 1) + ".���Ը� : " + map.get("STO_NAME"));
				if ((i + 1) % 5 == 0) {
					System.out.println("----------------------------- [��] scroll [��]");
				}
			}
			result = listStoreName();
			break;
		case 3:
			List<Map<String, Object>> storeList2 = storeDao.list2("�߽�");
			System.out.println("�� [��  ��] �˻� ��� ��");
			for (int i = 0; i < storeList2.size(); i++) {
				Map<String, Object> map = storeList2.get(i);
				System.out.println(" " + (i + 1) + ".���Ը� : " + map.get("STO_NAME"));
				if ((i + 1) % 5 == 0) {
					System.out.println("----------------------------- [��] scroll [��]");
				}
			}
			result = listStoreName();
			break;
		case 4:
			List<Map<String, Object>> storeList3 = storeDao.list2("���");
			System.out.println("�� [��  ��] �˻� ��� ��");
			for (int i = 0; i < storeList3.size(); i++) {
				Map<String, Object> map = storeList3.get(i);
				System.out.println(" " + (i + 1) + ".���Ը� : " + map.get("STO_NAME"));
				if ((i + 1) % 5 == 0) {
					System.out.println("----------------------------- [��] scroll [��]");
				}
			}
			result = listStoreName();
			break;
		case 5:
			List<Map<String, Object>> storeList4 = storeDao.list2("�н�");
			System.out.println("�� [��  ��] �˻� ��� ��");
			for (int i = 0; i < storeList4.size(); i++) {
				Map<String, Object> map = storeList4.get(i);
				System.out.println(" " + (i + 1) + ".���Ը� : " + map.get("STO_NAME"));
				if ((i + 1) % 5 == 0) {
					System.out.println("----------------------------- [��] scroll [��]");
				}
			}
			result = listStoreName();
			break;
		case 6:
			List<Map<String, Object>> storeList5 = storeDao.list2("��Ÿ");
			System.out.println("�� [��  Ÿ] �˻� ��� ��");
			for (int i = 0; i < storeList5.size(); i++) {
				Map<String, Object> map = storeList5.get(i);
				System.out.println(" " + (i + 1) + ".���Ը� : " + map.get("STO_NAME"));
				if ((i + 1) % 5 == 0) {
					System.out.println("----------------------------- [��] scroll [��]");
				}
			}
			result = listStoreName();
			break;
		default:
			System.out.println("�߸��� �Է��Դϴ�.");
			return View.STO_TYPE;
		}
		return result;
	}

	// Controller >> View.STO_RANK >> ���� �з��� ���ô� ��� �޼ҵ�
	public int stoRank() {
		int view = 0;
		StoreDao dao = StoreDao.getInstance();
		// ����ڷκ��� ���� �̻��� �Է¹���
		System.out.print("�ּ� ������ �Է��ϼ���: ");
		int minRating = ScanUtil.nextInt();

		List<Map<String, Object>> storeList = dao.listRank(minRating);

		if (storeList == null || storeList.isEmpty()) {
			System.out.println("���� " + minRating + " �̻��� ���԰� �����ϴ�.");
			view = stoRank();
		} else {
			PrintUtil.bar();
			System.out.println("\n\t�� ���� [" + minRating + "]�� ���� ���  ��");
			for (Map<String, Object> map : storeList) {
				System.out.println("     ---------------------");
				System.out.printf("\t��   ��   ��: %s\n", map.get("STO_NAME"));
				System.out.print("\t��         ��: ");
				System.out.println(map.get("STO_RANK") + " ��");
			}
//	         listStoreName(); ���� �˻� �� ���亸�⸦ �����ϸ� Ȩȭ������ ���ư��� ���� ����
			view = View.STO_SC;
		}
		return view;
	}

	// 2.StoreService�� listStoreName�� �Ϻ� �޼ҵ�

	// stoSc()>> listStroeName()�� ���� return ��
	public int stoNameView() {
		int result = 0;
		System.out.println();
		System.out.printf("%s  %s  %s  %s  %s\n", "1.���� �˻�", "2.���ã��", "3.�ڷΰ���", " 4.Ȩ���ΰ���", "5.���α׷� ����");
		PrintUtil.bar();
		System.out.println("�� �޴����� ��");
		System.out.print("��ȣ �Է� : ");
		int input2 = ScanUtil.nextInt();
		switch (input2) {
		case 1:
			System.out.println("���亸��!");
			result = View.REVIEW;
			break;
		case 2:
			System.out.println("���ã��!");
			result = View.BOOKMARK2;
			break;

		case 3:
			System.out.println("�ڷΰ���!");
			result = View.SEARCH;
			break;
		case 4:
			System.out.println("Ȩ���ΰ��� Ŭ��!");
			result = View.UI_HOME;
			break;
		case 5:
			PrintUtil.bar();
			System.out.println("���α׷��� �����մϴ�.");
			System.exit(0);
			break;
		default:
			 System.out.println("�߸��� �Է��Դϴ�. �ٽ� ������ �ּ���");
	         return stoNameView();
		}
		return result;
	}

	// stoSc()>> listStroeName()�� �޴����� ��� ���� �޼ҵ�
	public void listMenuFor(String storeName) {
		List<Map<String, Object>> menuList = storeDao.listMenuForStore(storeName);
		for (Map<String, Object> menu : menuList) {
			System.out.printf("\t%s  : %s\n", "��         ��", menu.get("MENU_NAME"));
			System.out.printf("\t%s  : %s\n", "��         ��", menu.get("MENU_PRICE"));
			System.out.println();
		}
	}

	// stoSc()>> listStoreName()�� result�� �־��ֱ� ���� �޼���
	public int typeMa() {
		int result = listStoreName();
		return result;
	}

}