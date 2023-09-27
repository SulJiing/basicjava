package service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dao.StoreDao;
import util.ScanUtil;
import util.View;

public class StoreService {
   StoreDao dao = StoreDao.getInstance();
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

   public int searchHome() {
      int result = 0;
      List<Map<String, Object>> storeList = dao.list();

      for (int i = 0; i < storeList.size(); i++) {
         Map<String, Object> map = storeList.get(i);
         System.out.println("���Ը� : " + map.get("STO_NAME"));
         System.out.println();
      }

      System.out.println();
      System.out.println("������ ���� �޴��� �����Ұſ���? >>> ");
      System.out.println("1. ���� ��������(���Ը� �Է�) 2. �з��� ���� ����  3. ������ ���� ����");
      System.out.println("   4. Ȩ���� ����        5. ���α׷� ����");
      System.out.print("��ȣ �Է� : ");

      int input = sc.nextInt();
      switch (input) {
      case 1:
         System.out.println("���� ��������(���Ը� �Է�) Ŭ��!");
         result = View.STO_SC;
         break;
      case 2:
         System.out.println("�з��� ���� ����!");
         result = View.STO_TYPE;
         break;
      case 3:
         System.out.println("������ ���� ���� Ŭ��!");
         result = View.STO_RANK;
         break;
      case 4:
         System.out.println("Ȩ���ΰ��� Ŭ��!");
         result = View.SEARCH;
         break;
      case 5:
         System.out.println("=========================");
         System.out.println("���α׷��� �����մϴ�.");
         System.exit(0);
         break;
      default:
         break;
      }
      return result;
   }

   public int listStoreName() {
      int result = 0;

      // ���Ը� �Է�
      System.out.println();
      System.out.print("���Ը��� �Է����ּ��� : ");
      String input = ScanUtil.nextLine();

      // ���Ը� �˻�
      List<Map<String, Object>> storeList = dao.list3(input);
      boolean found = false;

      // �˻� ��� ���
      for (int i = 0; i < storeList.size(); i++) {
         Map<String, Object> map = storeList.get(i);

         if (map.containsKey("STO_NAME")) {
            System.out.println("==========  ��������  =========");
            System.out.println("���Ը�   : " + map.get("STO_NAME"));
            System.out.println("�з�      : " + map.get("TYPE_NAME"));
            System.out.println("����      : " + map.get("STO_RANK"));
            System.out.println("�����ð�: " + map.get("STO_TIME"));
            System.out.println("�Ÿ�      : " + map.get("STO_DISTANCE"));
            System.out.println("��ȭ��ȣ: " + map.get("STO_TEL"));
            System.out.println("�ּ�      : " + map.get("STO_ADDRESS"));
            System.out.println("���డ�ɿ���: " + map.get("STO_RESERVATION"));
            System.out.println();
            found = true;
         }
      }
      // �˻��� ���԰� ���� ���
      if (!found) {
         System.out.println("���Ը� ã�� �� �����ϴ�.");
         System.out.println("1. Ȩ���� ����  2. ���α׷� ���� 3. �ٽð˻�");
         System.out.print("��ȣ �Է� : ");
         int input3 = sc.nextInt();
         switch (input3) {
         case 1:
            System.out.println("�ڷΰ��� Ŭ��!");
            result = View.SEARCH;
            break;
         case 2:
            System.out.println("=========================");
            System.out.println("���α׷��� �����մϴ�.");
            System.exit(0);
            break;
         case 3:
            listStoreName();
            break;
         default:
            break;
         }
      } else {
         System.out.print("��Ȯ�� ���Ը��� �Է����ּ���: ");
         String selectedStoreName = ScanUtil.nextLine();
         result = stoNameView();
         // ���⼭ ������ ���Ը��� ����Ͽ� ���� �ۼ� ���� �۾��� ������ �� �ֽ��ϴ�.
         // selectedStoreName ������ ������ ���Ը��� ����˴ϴ�.
         // ���� ���, selectedStoreName�� �̿��Ͽ� ���� �ۼ� ����� ������ �� �ֽ��ϴ�.

         // ���� �ۼ� �޴��� �̵��ϴ� �ڵ带 �߰��ϼ���.
      }

      return result;
   }

   public int stoSc() {
      int result = listStoreName();
      return result;
   }

   public int stoNameView() {
      int result = 0;
      System.out.println("������ ���� �޴��� �����Ұſ���? >>> ");
      System.out.println("1. ���亸�� 2. ���侲��  3. ���ã��");
      System.out.println("4. Ȩ���� ����    5. ���α׷� ����");
      System.out.print("��ȣ �Է� : ");
      int input2 = sc.nextInt();
      switch (input2) {
      case 1:
         System.out.println("���亸��!");
         result = View.STO_SC;
         break;
      case 2:
         System.out.println("���侲��!");
         result = View.STO_SC;
         break;
      case 3:
         System.out.println("���ã��");
         result = View.STO_SC;
         break;
      case 4:
         System.out.println("Ȩ���ΰ��� Ŭ��!");
         result = View.SEARCH;
         break;
      case 5:
         System.out.println("=========================");
         System.out.println("���α׷��� �����մϴ�.");
         System.exit(0);
         break;
      default:
         stoNameView();
         break;
      }
      return result;
   }

   public int typeMa() {
      int result = listStoreName();
      return result;
   }

   public int typeSC() {
      int result = 0;

      System.out.println("1.�ѽ�  2.�Ͻ�   3.�߽�   4.���  5.�н�  6.��Ÿ");
      int choice = ScanUtil.nextInt();
      switch (choice) {
      case 1:
         List<Map<String, Object>> storeList = dao.list2("�ѽ�");
         for (int i = 0; i < storeList.size(); i++) {
            Map<String, Object> map = storeList.get(i);
            System.out.println("���Ը� : " + map.get("STO_NAME"));
            System.out.println();
         }
         result = listStoreName();
         break;
      case 2:
         List<Map<String, Object>> storeList1 = dao.list2("�Ͻ�");
         for (int i = 0; i < storeList1.size(); i++) {
            Map<String, Object> map = storeList1.get(i);
            System.out.println("���Ը� : " + map.get("STO_NAME"));
            System.out.println();
         }
         result = listStoreName();
         break;
      case 3:
         List<Map<String, Object>> storeList2 = dao.list2("�߽�");
         for (int i = 0; i < storeList2.size(); i++) {
            Map<String, Object> map = storeList2.get(i);
            System.out.println("���Ը� : " + map.get("STO_NAME"));
            System.out.println();
         }
         result = listStoreName();
         break;
      case 4:
         List<Map<String, Object>> storeList3 = dao.list2("���");
         for (int i = 0; i < storeList3.size(); i++) {
            Map<String, Object> map = storeList3.get(i);
            System.out.println("���Ը� : " + map.get("STO_NAME"));
            System.out.println();
         }
         result = listStoreName();
         break;
      case 5:
         List<Map<String, Object>> storeList4 = dao.list2("�н�");
         for (int i = 0; i < storeList4.size(); i++) {
            Map<String, Object> map = storeList4.get(i);
            System.out.println("���Ը� : " + map.get("STO_NAME"));
            System.out.println();
         }
         result = listStoreName();
         break;
      case 6:
         List<Map<String, Object>> storeList5 = dao.list2("��Ÿ");
         for (int i = 0; i < storeList5.size(); i++) {
            Map<String, Object> map = storeList5.get(i);
            System.out.println("���Ը� : " + map.get("STO_NAME"));
            System.out.println();
         }
         result = listStoreName();
         break;
      default:
         System.out.println("�߸��� �Է��Դϴ�.");
         return View.STO_TYPE;
      }
      return result;
   }

   public int stoRank() {
      StoreDao dao = StoreDao.getInstance();

      // ����ڷκ��� ���� �̻��� �Է¹���
      System.out.print("�ּ� ������ �Է��ϼ���: ");
      int minRating = ScanUtil.nextInt();

      List<Map<String, Object>> storeList = dao.listRank(minRating);

      if (storeList == null || storeList.isEmpty()) {
         System.out.println("���� " + minRating + " �̻��� ���԰� �����ϴ�.");
         stoRank();
      } else {
         System.out.println("���� " + minRating + " �̻��� ���� ���:");
         for (Map<String, Object> map : storeList) {
            System.out.println("���Ը�: " + map.get("STO_NAME"));
            listStoreName();
         }
      }

      // ���� ����� ũ�⸦ ��ȯ
      return (storeList != null) ? storeList.size() : 0;
   }
}