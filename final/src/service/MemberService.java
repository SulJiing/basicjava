package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import controller.Controller;
import dao.MemberDao;
import util.PrintUtil;
import util.ScanUtil;
import util.View;

public class MemberService {
   /*
    * 앞으로 구성해야 할 것 1. 아이디와 비밀번호에 (영문과 숫자 특수 기호) 이외 (띄어쓰기 및 한글)이 들어가면 걸러주는 코드 필요 2.
    * SQL에 MEMBER 의 각 컬럼 LENGTH에 정확한 값 필요 혹은 코드로 길이를 정확하게 나누어주어야함. 3.
    */

   static public Map<String, Object> loginMap = new HashMap<>();
   // SIGN UP 화면단 표시를 위한 LIST
   static public Map<String, Object> singMap = new HashMap<>();
   private static MemberService instance = null;

   private MemberService() {
   }

   // 싱글톤
   public static MemberService getInstance() {
      if (instance == null)
         instance = new MemberService();
      return instance;
   }

   MemberDao memberdao = MemberDao.getInstance();

   public int login() {
      // 첫 로그인화면
      PrintUtil.loginUi();

      // 아이디입력
      System.out.print("ID : ");
      String id = ScanUtil.nextLine().trim();
      // 아이디 length 예외처리
      if (id.length() < 4 || id.length() >= 7 || id.matches(".*[가-힣]+.*") || id.contains(" ")){
         System.out.println("아이디를 확인해주세요.");
         return login();
      }
      // 아이디 입력 성공
      Controller.sessionStorage.put("Ui_id", id);
      PrintUtil.loginUi1();

      // 아이디입력
      System.out.print("PW : ");
      String password = ScanUtil.nextLine();

      // 비밀번호 length 예외처리
      if (password.length() < 4 || password.length() >= 7 || password.matches(".*[가-힣]+.*") || password.contains(" ")) {
         System.out.println("비밀번호를 확인해주세요.");
         return login();
      }

      // 비밀번호 입력 성공
      Controller.sessionStorage.put("Ui_pass", password);
      PrintUtil.loginUi2();

      // MEMBERDAO LOGIN METHOD >> 아이디 및 비밀번호 확인 with SQL_DB
      Map<String, Object> row = memberdao.login(id, password);
      if (row == null) {
         System.err.println("아이디가 존재하지 않습니다!");
         return View.HOME;
      } else {
         // 로그인에 따라 다음 기능의 사용 가능 여부를 정할 수 있게 sessionStorage List에 정보 저장
         Controller.sessionStorage.put("login", true);
         Controller.sessionStorage.put("MEM_ID", id);
         Controller.sessionStorage.put("MEM_PASSWORD", password);
         Controller.sessionStorage.put("MEM_NAME", row.get("MEM_NAME"));
         return View.UI_HOME;
      }
   }

   public int signUp() {
      // 회원가입 페이지
      PrintUtil.signPage();

      // 아이디입력
      System.out.print("ID 입력>>  ");
      String id = ScanUtil.nextLine();

      // 아이디 length 예외처리
      if (id.length() < 4 || id.length() >= 7|| id.matches(".*[가-힣]+.*") || id.contains(" ")) {
         System.out.println("아이디 형식을 확인해주세요.");
         return signUp();
      }

      // DB 아이디 중복확인
      if (memberdao.getIdlist(id) != null) {
         System.out.println("중복된 아이디입니다.");
         return signUp();

      } else {

         // 화면단 아이디표시를 위한 아이디 입력값 저장
         singMap.put("MEM_ID", id);
         PrintUtil.signPage1();

         System.out.print("PW 입력>>  ");
         String password = ScanUtil.nextLine();

         // 비밀번호 length 예외처리
         if (password.length() < 4 || password.length() >= 7|| password.matches(".*[가-힣]+.*") || password.contains(" ")) {
            System.out.println("비밀번호 형식을 확인해주세요.");
            return signUp();
         }

         // 화면단 비밀번호 표시를 위한 비밀번호 입력값 저장
         singMap.put("MEM_PASSWORD", password);
         PrintUtil.signPage2();

         System.out.print("NAME 입력>> ");
         String name = ScanUtil.nextLine();

         // 한글 이름 (3 byte) 7자 이상 시 설정값 mem_name >length(20) 을 넘기 때문에 예외처리
         if (name.length() > 7) {
            System.out.println("이름은 7자를 넘을 수 없습니다.");
            return signUp();
         }
         singMap.put("MEM_NAME", name);
         PrintUtil.signPage3();

         // memberdao.signUp 에 넘겨줄 파라미터 리스트
         List<Object> param = new ArrayList<>();
         param.add(id);
         param.add(password);
         param.add(name);
         int result = memberdao.signUp(param);
         System.out.println(result);

         // 회원 가입 완료 후 HOME 복귀
         return View.HOME;
      }
   }

   public int infoUpdate() {
      // 비회원은 메뉴사용 예외처리
      if (Controller.sessionStorage.get("login") == (Object) false) {
         System.out.println("로그인을 먼저 수행해야합니다.");
         return View.HOME;
      } else {
         // 비교를 위해 이미 login()을 통해 저장된 Controller.sessionStorage.get("MEM_ID") 값 가지고오기
         String memId = (String) Controller.sessionStorage.get("MEM_ID");

         // 회원정보 수정을 위한 화면단 출력
         PrintUtil.modiUi();

         // 회원정보 수정을 위한 '쿼리문' 을 만드는 코드
         String sqlStr = "UPDATE member";
         sqlStr = sqlStr + " SET ";

         // 비밀번호
         System.out.print("비밀번호를 수정하겠습니다?(y/n)\n입력>>");
         String flag = ScanUtil.nextLine();

         // Y/N/ANOTHER 예외처리
         if (flag.equalsIgnoreCase("y")) {
            System.out.print("변경할 암호 입력>>");
            String pass = ScanUtil.nextLine();
            if (pass.length() < 4 || pass.length() >= 7|| pass.matches(".*[가-힣]+.*") || pass.contains(" ")) {
               System.out.println("비밀번호 형식을 확인해주세요.");
               return infoUpdate();
            }
            sqlStr += " mem_password = '" + pass + "', ";
         } else if (flag.equalsIgnoreCase("n")) {

         } else {
            System.out.println("잘못된 입력방식입니다.");
            return View.USER_UPDATE;
         }

         // 이름
         System.out.print("이름을 수정하겠습니다?(y/n)\n입력>>");
         String flag1 = ScanUtil.nextLine();

         // Y/N/ANOTHER 예외처리
         if (flag1.equalsIgnoreCase("y")) {
            System.out.print("변경할 이름 입력>>");
            String name = ScanUtil.nextLine();

            // 한글 이름 (3 byte) 7자 이상 시 설정값 mem_name >length(20) 을 넘기 때문에 예외처리
            if (name.length() > 7) {
               System.out.println("이름은 7자를 넘을 수 없습니다.");
               return infoUpdate();
            }

            sqlStr += " mem_name = '" + name + "', ";

         } else if (flag1.equalsIgnoreCase("n")) {
         } else {
            System.out.println("잘못된 입력방식입니다.");
            return View.USER_UPDATE;
         }

         // 비밀번호 선택 N / 이름 선택 N
         if (flag1.equalsIgnoreCase("n") && flag.equalsIgnoreCase("n")) {
            return View.HOME;
         }

         // 최종 '쿼리문'을 통해 회원 정보 수정 UPDATE [sqlStr.substring(0, sqlStr.length() - 2) 를 통해
         // 쿼리문 마지막 ", " 삭제]
         sqlStr = sqlStr.substring(0, sqlStr.length() - 2);
         sqlStr = sqlStr + " WHERE mem_id = '" + memId + "'";
         // System.out.println(sqlStr);

         int result = memberdao.update(sqlStr);
         if (result > 0) {
            System.out.println("UPDATE 성공");
         } else {
            System.out.println("UPDATE 실패");
         }

         // 수정된 정보를 확인하기 위하여 LOGIN이 있는 HOME 화면으로
         return View.HOME;

      }
   }
}