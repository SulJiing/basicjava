package util;

import controller.Controller;

public class PrintUtil {
	// 구분선
	static public void bar() {
		System.out.println("■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□");
	}

	// 프로그램 시작 인트로
	static public void intro() {
		String[] team = { "T_", "T__", "T___", "T___E", "T__E", "T_E", "TE", "TE_", "TE__", "TE__A", "TE_A", "TEA",
				"TEA_", "TEA_M", "TEAM", "TEAM_", "TEAM__", "TEAM___", "TEAM____", "TEAM________1", "TEAM_______1",
				"TEAM______1", "TEAM_____2", "TEAM___2", "TEAM__3", "TEAM_3" };
		String[] name1 = { "ㄱ", "기", "김", "김ㅎ", "김혀", "김현", "김현ㅇ", "김현우", "김현우", "K현우", "KH우", "KHW", "KHW  &" };
		String[] name2 = { "ㅂ", "바", "박", "박ㅈ", "박주", "박줗", "박주ㅎ", "박주호", "P주호", "PJ호", "PJH", "PJH  &" };
		String[] name3 = { "ㅂ", "배", "백", "백ㅇ", "백여", "백영", "백영ㅇ", "백영우", "백영웅", "B영웅", "BY웅", "BYW", "BYW  &" };
		String[] name4 = { "ㅇ", "이", "잇", "이ㅅ", "이사", "이상", "이상ㅊ", "이상처", "이상철", "L상철", "LS철", "LSC" };

		int n1 = 0, n2 = 0, n3 = 0, n4 = 0;
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

	// 메인 로그인 페이지
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

	// UI_HOME
	static public void userHome() {
		String name = "";
		if (Controller.sessionStorage.get("update_check").equals(0)) {
			name = (String) Controller.sessionStorage.get("MEM_NAME");
		} else {
			name = (String) Controller.sessionStorage.get("update_name");
		}
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

	// 로그인 3 page
	static public void loginUi() {
		bar();
		System.out.println("\n");
		System.out.println("\t\t -LOGIN SERVICE-\n");
		System.out.println("          ID : ");
		System.out.println("          PW : \n\n\n\n");
		bar();

	}

	static public void loginUi1() {
		String id = (String) Controller.sessionStorage.get("Ui_id");
		bar();
		System.out.println("\n");
		System.out.println("\t\t -LOGIN SERVICE-\n");
		System.out.println("          ID : " + id);
		System.out.println("          PW : ");
		System.out.println("\n\n\n");
		bar();

	}

	static public void loginUi2() {
		String id = (String) Controller.sessionStorage.get("Ui_id");
		String pw = (String) Controller.sessionStorage.get("Ui_pass");
		PrintUtil.bar();
		System.out.println("\n");
		System.out.println("\t\t -LOGIN SERVICE-\n");
		System.out.println("          ID : " + id);
		System.out.print("          PW : ");
		System.out.print(pw.substring(0, 2));
		System.out.printf("%s", "****");
		System.out.println("\n\n\n");
		bar();
	}

	// 회원가입 page
	static public void signPage() {

		PrintUtil.bar();
		System.out.println("\n");
		System.out.println("\t\t - SIGN IN -\n");
		System.out.println("          ID : ");
		System.out.println("          PW : ");
		System.out.println("        NAME : ");
		System.out.println("\n\n\n");
		PrintUtil.bar();
	}

	static public void signPage1() {
		String id = (String) Controller.sessionStorage.get("sign_id");

		PrintUtil.bar();
		System.out.println("\n");
		System.out.println("\t\t - SIGN IN -\n");
		System.out.println("          ID : " + id);
		System.out.println("          PW : ");
		System.out.println("        NAME : ");
		System.out.println("\n\n\n");
		PrintUtil.bar();
	}

	static public void signPage2() {
		String id = (String) Controller.sessionStorage.get("sign_id");
		String pw = (String) Controller.sessionStorage.get("sign_pw");

		PrintUtil.bar();
		System.out.println("\n");
		System.out.println("\t\t - SIGN IN -\n");
		System.out.println("          ID : " + id);
		System.out.println("          PW : " + pw);
		System.out.println("        NAME : ");
		System.out.println("\n\n\n");
		PrintUtil.bar();
	}

	static public void signPage3() {
		String id = (String) Controller.sessionStorage.get("sign_id");
		String pw = (String) Controller.sessionStorage.get("sign_pw");
		String nm = (String) Controller.sessionStorage.get("sign_name");

		PrintUtil.bar();
		System.out.println("\n");
		System.out.println("\t\t - SIGN IN -\n");
		System.out.println("          ID : " + id);

		System.out.println("          PW : " + pw);
		System.out.println("        NAME : " + nm);
		System.out.println("\n\t\t'" + nm + "'님 가입을 축하드립니다." + "\n\n");
		PrintUtil.bar();
		Util.wait(500);
	}

	/**
	 * System.out.printf()을 이용하면서 한글 공백처리에 대한 불편함을 개선한 메서드
	 * 
	 * @param format      : System.out.printf() 에 입력하는 format과 비슷한 모양. 단, %{int}o 로
	 *                    입력하여 정수, 문자열을 구분하지 않는다. 음수를 입력하면 좌측정렬, 양수를 입력하면 우측정렬이다.
	 * @param spaceString : 빈 공간을 채워넣을 문자열 입력. null을 입력하면 기본값 " "이 들어간다.
	 * @param args        : format에서 %{int}o 부분을 채워줄 값을 순서대로 입력해야한다.
	 */
	public static void printf(String format, String spaceString, Object... args) {
		if (spaceString == null)
			spaceString = " ";
		String str = "";
		int idx = 0;
		for (int i = 0; i < format.length(); i++) {
			char c = format.charAt(i);
			String f = "";
			if (c == '%') {
				c = format.charAt(++i);
				while (c != 'o' && i < format.length() - 1) {
					f += c;
					c = format.charAt(++i);
				}
				str += formater(args[idx++].toString(), Integer.parseInt(f), spaceString);
			} else {
				str += c;
			}
		}
		System.out.println(str);
	}

	private static String formater(String str, int length, String spaceString) {
		String result = "";
		int s = Math.abs(length);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'ㄱ' && str.charAt(i) <= '힇') {
				s -= 2;
			} else {
				s--;
			}
		}
		if (length < 0) {
			result += str;
			result = setSpace(result, s, spaceString);
		} else {
			result = setSpace(result, s, spaceString);
			result += str;
		}
		return result;
	}

	private static String setSpace(String str, int count, String spaceString) {
		for (int i = 0; i < count; i++) {
			str += spaceString;
		}
		return str;
	}

	// 회원정보 수정 참조 페이지
	public static void modiUi() {
		String id = (String) Controller.sessionStorage.get("MEM_ID");
		String pw = (String) Controller.sessionStorage.get("MEM_PASSWORD");
		String nm = (String) Controller.sessionStorage.get("MEM_NAME");

		PrintUtil.bar();
		System.out.println("\n");
		System.out.println("\t\t< " + id + "님의 정보를 변경합니다 >\n");

		System.out.print("\t\tPW : ");
		System.out.print(pw.substring(0, 2));
		System.out.printf("%s", "****\n");
		System.out.print("\t\t이름 : " + nm);
		System.out.println("\n\n\n");
		PrintUtil.bar();

	}

	// 검색단 메뉴
	public static void searchPage() {
		PrintUtil.bar();
		System.out.println("▶ SEARCH DETAIL");
		System.out.printf("%s   %s   %s   %s   %s\n", "1.가게명 검색", "2.분류별 검색", "3.별점 검색", "4.홈으로", "5.프로그램 종료");
		System.out.print("번호 입력 >> ");

	}
}
