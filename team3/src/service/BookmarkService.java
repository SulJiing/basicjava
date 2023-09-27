package service;

import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.BookmarkDao;
import dao.StoreDao;
import util.PrintUtil;
import util.ScanUtil;
import util.View;

public class BookmarkService {

   private static BookmarkService instance = null;

   private BookmarkService() {

   }

   public static BookmarkService getInstance() {
      if (instance == null)
         instance = new BookmarkService();
      return instance;
   }

   BookmarkDao bookmarkDao = BookmarkDao.getInstance();
   StoreService stoSer = StoreService.getInstance();
   StoreDao dao = StoreDao.getInstance();

   public int myBookmark() {
      int view = 0;
      if (Controller.sessionStorage.get("login") == (Object) false) {
         System.out.println("�α����� ���� �����ؾ��մϴ�.");
         view = View.HOME;
      } else {
         PrintUtil.bar();
         System.out.println("\n\t\t�� BOOKMARK MENU ��\n");
         System.out.println("1.�� ���ã�� ���   2.���ã�� �߰�   3.���ã�� ����   4.Ȩ����\n\n");
         PrintUtil.bar();
         boolean flag = true;
         while (flag) {
            System.out.print("�Է� >>");
            int num = ScanUtil.nextInt();
            switch (num) {
            case 1:
               view = myBookmarkList();
               flag = false;
               break;
            case 2:
               view = addBookmark(View.BOOKMARK);
               flag = false;
               break;
            case 3:
               view = removeBookmark(View.BOOKMARK);
               flag = false;
               break;
            case 4:
               view = View.UI_HOME;
               flag = false;
               break;
            default:
               System.out.println("�߸� �Է��ϼ̽��ϴ�");
               System.out.println("�ٽ� �Է����ּ���.");
            }
         }
      }
      return view;
   }

   public int myBookmarkList() {
      int view = 0;
      PrintUtil.bar();
      System.out.println("\n\t�� MY BOOKMARK ��\n");
      if (Controller.sessionStorage.containsKey("MEM_ID")) {
         try {
            List<Map<String, Object>> myList = bookmarkDao.myBookmark();
            for (int i = 0; i < myList.size(); i++) {
               Map<String, Object> map = myList.get(i);
               System.out.print("\t�� �� �� ȣ :");
               System.out.println(map.get("STO_NO"));
               System.out.printf("\t��   ��   �� :%s\n", map.get("STO_NAME"));
               System.out.println();
               if ((i + 1) % 5 == 0) {
                  System.out.println("   ----------------------------- [��] scroll [��]");
               }
            }
            PrintUtil.bar();
            System.out.println("����Ű�� �Է��Ͻø� �ڷ� ���ư��ϴ�.");
            ScanUtil.nextLine();
         } catch (NullPointerException e) {
            System.out.println("\"�߰��� ���ã�Ⱑ �����ϴ�.\"");
         } finally {
            view = myBookmark();
         }
      } else {
         System.out.println("�α����� �ϼ���");
         view = View.HOME;
      }
      return view;
   }

   public int bookmarkHome() {
      int view = 0;
      if (Controller.sessionStorage.containsKey("MEM_ID")) {
         boolean flag = true;
         while (flag) {
            System.out.println("==== ���ã�� ====");
            System.out.println("1. ���ã�� �߰�");
            System.out.println("2. ���ã�� ����");
            System.out.println("3. ���� �޴��� ���ư���");
            System.out.print("�޴� ���� > ");

            int choice = ScanUtil.nextInt();

            switch (choice) {
            case 1:
               view = addBookmark(View.SEARCH);
               flag = false;
               break;
            case 2:
               view = removeBookmark(View.SEARCH);
               flag = false;
               break;
            case 3:
               view = View.SEARCH;// ���� �޴��� ���ư���
               flag = false;
               break;
            default:
               System.out.println("�߸��� �Է��Դϴ�.");
               view = bookmarkHome();
               break;
            }
         }
      } else {
         System.out.println("�α��� �ϼ���.");
         view = View.HOME;
      }
      return view;
   }

   // �������� ���ã�⿡ �߰��ϴ� �޼���
   public int addBookmark(int view) {
      List<Map<String, Object>> myList = bookmarkDao.myBookmark();
      List<Map<String, Object>> stoList = dao.list();
      Map<String, Object> map = null;

      for (int i = 0; i < stoList.size(); i++) {
         Map<String, Object> map1 = stoList.get(i);
         System.out.printf("\t%2d.%s\n", (i + 1), map1.get("STO_NAME"));

         if ((i + 1) % 5 == 0) {
            System.out.println("   ----------------------------- [��] scroll [��]");
         }
      }

      loop1: while (true) {
         System.out.println("\n�� ���� ��ȣ�� �Է����ּ���. ��\n  [0]���� �Է��ϸ� ���� ȭ������ �̵��մϴ�.");
         PrintUtil.bar();
         System.out.print("���Թ�ȣ �Է� >>");
         int stono = ScanUtil.nextInt();
         if (stono == 0) {
            break;
         }
         String Strno = String.valueOf(stono);
         Object no = (Object) String.format("%04d", stono);
         boolean f = false;
         try {
            for (int i = 0; i < myList.size(); i++) {
               map = myList.get(i);
               if (map.containsValue(no)) {
                  f = true;
                  break;
               }
            }
            if (f == true) {
               System.out.println("�̹� ���ã�⿡ �߰��� �����Դϴ�.");
               System.out.println("�ڷΰ����� 1�� �ٽ� ���ã�� �߰��� �Ϸ��� 2���� �Է����ּ���");
               System.out.print("�Է� >");
               int p = ScanUtil.nextInt();
               switch (p) {
               case 1:
                  break loop1;
               case 2:
                  continue;
               }
            } else {
               if (stono > 10000 && stono < 1) {
                  System.out.println("�߸��Է��ϼ̽��ϴ�.");
                  System.out.println("�ٽ� �Է����ּ���.");
                  continue;
               } else if (stono > stoList.size()) {
                  System.out.println("���� ��Ͽ��� �Է��� ���Ը� ã�� �� �����ϴ�.");
                  System.out.println("�ٽ� �Է����ּ���.");
                  continue;
               } else {
                  bookmarkDao.addBookmark(Strno);
                  System.out.println("���ã�� ��Ͽ� �߰� �߽��ϴ�.");
                  break;
               }
            }
         } catch (NullPointerException e) {
            if (stono > 10000 && stono < 1) {
               System.out.println("�߸��Է��ϼ̽��ϴ�.");
               System.out.println("�ٽ� �Է����ּ���.");
               continue;
            } else if (stono > stoList.size()) {
               System.out.println("���ã�� ��Ͽ��� �Է��� ���Ը� ã�� �� �����ϴ�.");
               System.out.println("�ٽ� �Է����ּ���.");
               continue;
            } else {
               bookmarkDao.addBookmark(Strno);
               System.out.println("���ã�� ��Ͽ� �߰� �߽��ϴ�.");
               break;
            }
         }
      }
      return view;
   }

   // ���ã�� ����
   public int removeBookmark(int view) {
      if (Controller.sessionStorage.containsKey("MEM_ID")) {
         try {
            List<Map<String, Object>> myList = bookmarkDao.myBookmark();
            Map<String, Object> map = null;
            Map<String, Object> map1 = null;
            for (int i = 0; i < myList.size(); i++) {
               map = myList.get(i);
               System.out.print("\t�� �� �� ȣ :");
               System.out.println(map.get("STO_NO"));
               System.out.printf("\t��   ��   �� :%s\n", map.get("STO_NAME"));
               System.out.println();
               if ((i + 1) % 5 == 0) {
                  System.out.println("   ----------------------------- [��] scroll [��]");
               }
            }
            boolean f = false;

            while (true) {
               PrintUtil.bar();
               System.out.println("[0]���� �Է��ϸ� ���� ȭ������ �̵��մϴ�.");
               System.out.print("���ã�⿡�� ������ ���Թ�ȣ �Է� >>");
               int stono = ScanUtil.nextInt();
               if (stono == 0) {
                  break;
               }
               String Strno = String.valueOf(stono);
               Object no = (Object) String.format("%04d", stono);

               for (int j = 0; j < myList.size(); j++) {
                  map1 = myList.get(j);
                  if (map1.containsValue(no)) {
                     f = true;
                     break;
                  }
               }
               if (f == true) {
                  bookmarkDao.removeBookmark(Strno);
                  System.out.println("���ã�� ��Ͽ��� �����߽��ϴ�.");
                  break;
               } else {
                  System.out.println("�߸� �Է��ϼ̽��ϴ�.");
                  System.out.println("�ٽ� �Է����ּ���");
               }
            }
         } catch (NullPointerException e) {

         }
      }
      return view;
   }

}