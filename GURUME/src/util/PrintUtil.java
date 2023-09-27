package util;

import controller.Controller;

public class PrintUtil {

   static public void bar() {
      System.out.println("■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□");
   }

   static public void intro() {
      String[] team = { "T_", "T__", "T___", "T___E", "T__E", "T_E", "TE", "TE_", "TE__", "TE__A", "TE_A", "TEA",
            "TEA_", "TEA_M", "TEAM", "TEAM_", "TEAM__", "TEAM___", "TEAM____", "TEAM________1", "TEAM_______1",
            "TEAM______1", "TEAM_____2", "TEAM___2", "TEAM__3", "TEAM_3" };
      String[] name1 = { "ㄱ", "기", "김", "김ㅎ", "김혀", "김현", "김현ㅇ", "김현우", "김현우", "K현우", "KH우", "KHW", "KHW  &" };
      String[] name2 = { "ㅂ", "바", "박", "박ㅈ", "박주", "박줗", "박주ㅎ", "박주호", "P주호", "PJ호", "PJH", "PJH  &" };
      String[] name3 = { "ㅂ", "배", "백", "백ㅇ", "백여", "백영", "백영ㅇ", "백영우", "백영웅", "B영웅", "BY웅", "BYW", "BYW  &" };
      String[] name4 = { "ㅇ", "이", "잇", "이ㅅ", "이사", "이상", "이상ㅊ", "이상처", "이상철", "L상철", "LS철", "LSC" };

      int t1 = 0, n1 = 0, n2 = 0, n3 = 0, n4 = 0;
      String pressEnter = "";
      for (int i = 0; i < team.length + name1.length + name2.length + name3.length + name4.length; i++) {
         String team_1 = "", name_1 = "", name_2 = "", name_3 = "", name_4 = "";

         int j = i;
         if (j > team.length - 1)
            j = team.length - 1;
         team_1 = team[j];
         if (i >= team.length) {
            if (n1 > name1.length - 1)
               n1 = name1.length - 1;
            name_1 = name1[n1++];
         }
         if (i >= team.length + name1.length) {
            if (n2 > name2.length - 1)
               n2 = name2.length - 1;
            name_2 = name2[n2++];
         }
         if (i >= team.length + name1.length + name2.length) {
            if (n3 > name3.length - 1)
               n3 = name3.length - 1;
            name_3 = name3[n3++];
         }
         if (i >= team.length + name1.length + name2.length + name3.length) {
            if (n4 > name4.length - 1)
               n4 = name4.length - 1;
            name_4 = name4[n4++];
         }

         if (i == team.length + name1.length + name2.length + name3.length + name4.length - 1) {
            Util.wait(100);
            pressEnter = "계속하려면 엔터키를 입력....";
         }

         Util.wait(150);
         System.out.println("\n\n■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□\n");
         System.out.println();
         System.out.println("        " + "WE");
         System.out.println("        " + "ARE");
         System.out.println("        " + team_1 + "  ◀▤■■■■■▣ ");
         System.out.println("        " + "MADE BY" + " " + name_1 + "\t" + name_2 + "\t" + name_3 + "\t" + name_4);
         System.out.println("");
         System.out.println("                                         ");
         System.out.println("                       @ version_1  @ update_230915");
         System.out.println("■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□\n" + pressEnter);
      }
      ScanUtil.nextLine();
   }

   static public void title1() {
      System.out.println();
      System.out.println(" O \tDDIT 맛집 리스트__");
      System.out.println("<|v\t\tDDIT 맛집 리스트__");
      System.out.println("/>  \t\t\tDDIT 맛집 리스트__\n\n\n");

      System.out.printf("%5s%5s%10s%5s%10s%5s%10s", " 1.로그인", "|", "2.회원가입", "|", "3.비회원로그인", "|", "4.프로그램 종료");
      System.out.println("\n\n                       @ version_1  @ update_230915");
      bar();
      System.out.print("번호 입력 >> ");
   }

   static public void userHome() {
      String name = (String) Controller.sessionStorage.get("MEM_NAME");

      bar();
      System.out.println();
      if (name == null) {
         System.out.println("\t\t비회원 로그인입니다\n");
      } else {
         System.out.println("\t\t" + name + "님 반갑습니다!");
      }

      System.out.println("\t1.검색");
      System.out.println("\t2.즐겨찾기");
      System.out.println("\t3.리뷰 ");
      System.out.println("\t4.회원정보수정  ");
      System.out.println("\t5.프로그램 종료  ");
      System.out.println("\n\n                       @ version_1  @ update_230915");
      bar();
      System.out.print("번호 입력 >> ");
   }

   static public void loginUi() {

   }


//	public void printlist(List<Map<String, Object>> name) {
//		for (int i = 0; i < name.size(); i++) {
//			Map<String, Object> map = name.get(i);
//			System.out.println(map.get("STO_NAME")+"\t"+ map.get("RVW_SCORE")+"\t"+map.get("RVW_RAMARK"));
//			System.out.println();
//		}
//	}
	
	
	
}
