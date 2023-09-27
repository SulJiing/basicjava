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

   // 싱글톤
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
         System.out.println("가게명 : " + map.get("STO_NAME"));
         System.out.println();
      }

      System.out.println();
      System.out.println("다음은 무슨 메뉴를 선택할거예요? >>> ");
      System.out.println("1. 가게 세부정보(가게명 입력) 2. 분류별 가게 보기  3. 별점별 가게 보기");
      System.out.println("   4. 홈으로 가기        5. 프로그램 종료");
      System.out.print("번호 입력 : ");

      int input = sc.nextInt();
      switch (input) {
      case 1:
         System.out.println("가게 세부정보(가게명 입력) 클릭!");
         result = View.STO_SC;
         break;
      case 2:
         System.out.println("분류별 가게 보기!");
         result = View.STO_TYPE;
         break;
      case 3:
         System.out.println("별점별 가게 보기 클릭!");
         result = View.STO_RANK;
         break;
      case 4:
         System.out.println("홈으로가기 클릭!");
         result = View.SEARCH;
         break;
      case 5:
         System.out.println("=========================");
         System.out.println("프로그램을 종료합니다.");
         System.exit(0);
         break;
      default:
         break;
      }
      return result;
   }

   public int listStoreName() {
      int result = 0;

      // 가게명 입력
      System.out.println();
      System.out.print("가게명을 입력해주세요 : ");
      String input = ScanUtil.nextLine();

      // 가게명 검색
      List<Map<String, Object>> storeList = dao.list3(input);
      boolean found = false;

      // 검색 결과 출력
      for (int i = 0; i < storeList.size(); i++) {
         Map<String, Object> map = storeList.get(i);

         if (map.containsKey("STO_NAME")) {
            System.out.println("==========  가게정보  =========");
            System.out.println("가게명   : " + map.get("STO_NAME"));
            System.out.println("분류      : " + map.get("TYPE_NAME"));
            System.out.println("별점      : " + map.get("STO_RANK"));
            System.out.println("영업시간: " + map.get("STO_TIME"));
            System.out.println("거리      : " + map.get("STO_DISTANCE"));
            System.out.println("전화번호: " + map.get("STO_TEL"));
            System.out.println("주소      : " + map.get("STO_ADDRESS"));
            System.out.println("예약가능여부: " + map.get("STO_RESERVATION"));
            System.out.println();
            found = true;
         }
      }
      // 검색된 가게가 없을 경우
      if (!found) {
         System.out.println("가게를 찾을 수 없습니다.");
         System.out.println("1. 홈으로 가기  2. 프로그램 종료 3. 다시검색");
         System.out.print("번호 입력 : ");
         int input3 = sc.nextInt();
         switch (input3) {
         case 1:
            System.out.println("뒤로가기 클릭!");
            result = View.SEARCH;
            break;
         case 2:
            System.out.println("=========================");
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
            break;
         case 3:
            listStoreName();
            break;
         default:
            break;
         }
      } else {
         System.out.print("정확한 가게명을 입력해주세요: ");
         String selectedStoreName = ScanUtil.nextLine();
         result = stoNameView();
         // 여기서 선택한 가게명을 사용하여 리뷰 작성 등의 작업을 수행할 수 있습니다.
         // selectedStoreName 변수에 선택한 가게명이 저장됩니다.
         // 예를 들어, selectedStoreName을 이용하여 리뷰 작성 기능을 구현할 수 있습니다.

         // 리뷰 작성 메뉴로 이동하는 코드를 추가하세요.
      }

      return result;
   }

   public int stoSc() {
      int result = listStoreName();
      return result;
   }

   public int stoNameView() {
      int result = 0;
      System.out.println("다음은 무슨 메뉴를 선택할거예요? >>> ");
      System.out.println("1. 리뷰보기 2. 리뷰쓰기  3. 즐겨찾기");
      System.out.println("4. 홈으로 가기    5. 프로그램 종료");
      System.out.print("번호 입력 : ");
      int input2 = sc.nextInt();
      switch (input2) {
      case 1:
         System.out.println("리뷰보기!");
         result = View.STO_SC;
         break;
      case 2:
         System.out.println("리뷰쓰기!");
         result = View.STO_SC;
         break;
      case 3:
         System.out.println("즐겨찾기");
         result = View.STO_SC;
         break;
      case 4:
         System.out.println("홈으로가기 클릭!");
         result = View.SEARCH;
         break;
      case 5:
         System.out.println("=========================");
         System.out.println("프로그램을 종료합니다.");
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

      System.out.println("1.한식  2.일식   3.중식   4.양식  5.분식  6.기타");
      int choice = ScanUtil.nextInt();
      switch (choice) {
      case 1:
         List<Map<String, Object>> storeList = dao.list2("한식");
         for (int i = 0; i < storeList.size(); i++) {
            Map<String, Object> map = storeList.get(i);
            System.out.println("가게명 : " + map.get("STO_NAME"));
            System.out.println();
         }
         result = listStoreName();
         break;
      case 2:
         List<Map<String, Object>> storeList1 = dao.list2("일식");
         for (int i = 0; i < storeList1.size(); i++) {
            Map<String, Object> map = storeList1.get(i);
            System.out.println("가게명 : " + map.get("STO_NAME"));
            System.out.println();
         }
         result = listStoreName();
         break;
      case 3:
         List<Map<String, Object>> storeList2 = dao.list2("중식");
         for (int i = 0; i < storeList2.size(); i++) {
            Map<String, Object> map = storeList2.get(i);
            System.out.println("가게명 : " + map.get("STO_NAME"));
            System.out.println();
         }
         result = listStoreName();
         break;
      case 4:
         List<Map<String, Object>> storeList3 = dao.list2("양식");
         for (int i = 0; i < storeList3.size(); i++) {
            Map<String, Object> map = storeList3.get(i);
            System.out.println("가게명 : " + map.get("STO_NAME"));
            System.out.println();
         }
         result = listStoreName();
         break;
      case 5:
         List<Map<String, Object>> storeList4 = dao.list2("분식");
         for (int i = 0; i < storeList4.size(); i++) {
            Map<String, Object> map = storeList4.get(i);
            System.out.println("가게명 : " + map.get("STO_NAME"));
            System.out.println();
         }
         result = listStoreName();
         break;
      case 6:
         List<Map<String, Object>> storeList5 = dao.list2("기타");
         for (int i = 0; i < storeList5.size(); i++) {
            Map<String, Object> map = storeList5.get(i);
            System.out.println("가게명 : " + map.get("STO_NAME"));
            System.out.println();
         }
         result = listStoreName();
         break;
      default:
         System.out.println("잘못된 입력입니다.");
         return View.STO_TYPE;
      }
      return result;
   }

   public int stoRank() {
      StoreDao dao = StoreDao.getInstance();

      // 사용자로부터 별점 이상을 입력받음
      System.out.print("최소 별점을 입력하세요: ");
      int minRating = ScanUtil.nextInt();

      List<Map<String, Object>> storeList = dao.listRank(minRating);

      if (storeList == null || storeList.isEmpty()) {
         System.out.println("별점 " + minRating + " 이상의 가게가 없습니다.");
         stoRank();
      } else {
         System.out.println("별점 " + minRating + " 이상의 가게 목록:");
         for (Map<String, Object> map : storeList) {
            System.out.println("가게명: " + map.get("STO_NAME"));
            listStoreName();
         }
      }

      // 가게 목록의 크기를 반환
      return (storeList != null) ? storeList.size() : 0;
   }
}