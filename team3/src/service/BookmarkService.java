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
         System.out.println("로그인을 먼저 수행해야합니다.");
         view = View.HOME;
      } else {
         PrintUtil.bar();
         System.out.println("\n\t\t▼ BOOKMARK MENU ▼\n");
         System.out.println("1.내 즐겨찾기 목록   2.즐겨찾기 추가   3.즐겨찾기 삭제   4.홈으로\n\n");
         PrintUtil.bar();
         boolean flag = true;
         while (flag) {
            System.out.print("입력 >>");
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
               System.out.println("잘못 입력하셨습니다");
               System.out.println("다시 입력해주세요.");
            }
         }
      }
      return view;
   }

   public int myBookmarkList() {
      int view = 0;
      PrintUtil.bar();
      System.out.println("\n\t▼ MY BOOKMARK ▼\n");
      if (Controller.sessionStorage.containsKey("MEM_ID")) {
         try {
            List<Map<String, Object>> myList = bookmarkDao.myBookmark();
            for (int i = 0; i < myList.size(); i++) {
               Map<String, Object> map = myList.get(i);
               System.out.print("\t가 게 번 호 :");
               System.out.println(map.get("STO_NO"));
               System.out.printf("\t가   게   명 :%s\n", map.get("STO_NAME"));
               System.out.println();
               if ((i + 1) % 5 == 0) {
                  System.out.println("   ----------------------------- [▲] scroll [▼]");
               }
            }
            PrintUtil.bar();
            System.out.println("엔터키를 입력하시면 뒤로 돌아갑니다.");
            ScanUtil.nextLine();
         } catch (NullPointerException e) {
            System.out.println("\"추가된 즐겨찾기가 없습니다.\"");
         } finally {
            view = myBookmark();
         }
      } else {
         System.out.println("로그인을 하세요");
         view = View.HOME;
      }
      return view;
   }

   public int bookmarkHome() {
      int view = 0;
      if (Controller.sessionStorage.containsKey("MEM_ID")) {
         boolean flag = true;
         while (flag) {
            System.out.println("==== 즐겨찾기 ====");
            System.out.println("1. 즐겨찾기 추가");
            System.out.println("2. 즐겨찾기 삭제");
            System.out.println("3. 이전 메뉴로 돌아가기");
            System.out.print("메뉴 선택 > ");

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
               view = View.SEARCH;// 이전 메뉴로 돌아가기
               flag = false;
               break;
            default:
               System.out.println("잘못된 입력입니다.");
               view = bookmarkHome();
               break;
            }
         }
      } else {
         System.out.println("로그인 하세요.");
         view = View.HOME;
      }
      return view;
   }

   // 음식점을 즐겨찾기에 추가하는 메서드
   public int addBookmark(int view) {
      List<Map<String, Object>> myList = bookmarkDao.myBookmark();
      List<Map<String, Object>> stoList = dao.list();
      Map<String, Object> map = null;

      for (int i = 0; i < stoList.size(); i++) {
         Map<String, Object> map1 = stoList.get(i);
         System.out.printf("\t%2d.%s\n", (i + 1), map1.get("STO_NAME"));

         if ((i + 1) % 5 == 0) {
            System.out.println("   ----------------------------- [▲] scroll [▼]");
         }
      }

      loop1: while (true) {
         System.out.println("\n▼ 매장 번호를 입력해주세요. ▼\n  [0]번을 입력하면 이전 화면으로 이동합니다.");
         PrintUtil.bar();
         System.out.print("가게번호 입력 >>");
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
               System.out.println("이미 즐겨찾기에 추가된 가게입니다.");
               System.out.println("뒤로가려면 1번 다시 즐겨찾기 추가를 하려면 2번을 입력해주세요");
               System.out.print("입력 >");
               int p = ScanUtil.nextInt();
               switch (p) {
               case 1:
                  break loop1;
               case 2:
                  continue;
               }
            } else {
               if (stono > 10000 && stono < 1) {
                  System.out.println("잘못입력하셨습니다.");
                  System.out.println("다시 입력해주세요.");
                  continue;
               } else if (stono > stoList.size()) {
                  System.out.println("가게 목록에서 입력한 가게를 찾을 수 없습니다.");
                  System.out.println("다시 입력해주세요.");
                  continue;
               } else {
                  bookmarkDao.addBookmark(Strno);
                  System.out.println("즐겨찾기 목록에 추가 했습니다.");
                  break;
               }
            }
         } catch (NullPointerException e) {
            if (stono > 10000 && stono < 1) {
               System.out.println("잘못입력하셨습니다.");
               System.out.println("다시 입력해주세요.");
               continue;
            } else if (stono > stoList.size()) {
               System.out.println("즐겨찾기 목록에서 입력한 가게를 찾을 수 없습니다.");
               System.out.println("다시 입력해주세요.");
               continue;
            } else {
               bookmarkDao.addBookmark(Strno);
               System.out.println("즐겨찾기 목록에 추가 했습니다.");
               break;
            }
         }
      }
      return view;
   }

   // 즐겨찾기 삭제
   public int removeBookmark(int view) {
      if (Controller.sessionStorage.containsKey("MEM_ID")) {
         try {
            List<Map<String, Object>> myList = bookmarkDao.myBookmark();
            Map<String, Object> map = null;
            Map<String, Object> map1 = null;
            for (int i = 0; i < myList.size(); i++) {
               map = myList.get(i);
               System.out.print("\t가 게 번 호 :");
               System.out.println(map.get("STO_NO"));
               System.out.printf("\t가   게   명 :%s\n", map.get("STO_NAME"));
               System.out.println();
               if ((i + 1) % 5 == 0) {
                  System.out.println("   ----------------------------- [▲] scroll [▼]");
               }
            }
            boolean f = false;

            while (true) {
               PrintUtil.bar();
               System.out.println("[0]번을 입력하면 이전 화면으로 이동합니다.");
               System.out.print("즐겨찾기에서 삭제할 가게번호 입력 >>");
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
                  System.out.println("즐겨찾기 목록에서 삭제했습니다.");
                  break;
               } else {
                  System.out.println("잘못 입력하셨습니다.");
                  System.out.println("다시 입력해주세요");
               }
            }
         } catch (NullPointerException e) {

         }
      }
      return view;
   }

}