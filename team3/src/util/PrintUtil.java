package util;

import controller.Controller;

public class PrintUtil {
	// ���м�
	static public void bar() {
		System.out.println("�����������������������������������������������������");
	}

	// ���α׷� ���� ��Ʈ��
	static public void intro() {
		String[] team = { "T_", "T__", "T___", "T___E", "T__E", "T_E", "TE", "TE_", "TE__", "TE__A", "TE_A", "TEA",
				"TEA_", "TEA_M", "TEAM", "TEAM_", "TEAM__", "TEAM___", "TEAM____", "TEAM________1", "TEAM_______1",
				"TEAM______1", "TEAM_____2", "TEAM___2", "TEAM__3", "TEAM_3" };
		String[] name1 = { "��", "��", "��", "�褾", "����", "����", "������", "������", "������", "K����", "KH��", "KHW", "KHW  &" };
		String[] name2 = { "��", "��", "��", "�ڤ�", "����", "�ڢG", "���֤�", "����ȣ", "P��ȣ", "PJȣ", "PJH", "PJH  &" };
		String[] name3 = { "��", "��", "��", "�餷", "�鿩", "�鿵", "�鿵��", "�鿵��", "�鿵��", "B����", "BY��", "BYW", "BYW  &" };
		String[] name4 = { "��", "��", "��", "�̤�", "�̻�", "�̻�", "�̻�", "�̻�ó", "�̻�ö", "L��ö", "LSö", "LSC" };

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
				pressEnter = "����Ϸ��� ����Ű�� �Է�....";
			}

			Util.wait(150);
			System.out.println("\n\n�����������������������������������������������������\n");
			System.out.println();
			System.out.println("        " + "WE");
			System.out.println("        " + "ARE");
			System.out.println("        " + team_1 + "  ���ǡ������ ");
			System.out.println("        " + "MADE BY" + " " + name_1 + "\t" + name_2 + "\t" + name_3 + "\t" + name_4);
			System.out.println("");
			System.out.println("                                         ");
			System.out.println("                       @ version_1  @ update_230915");
			System.out.println("�����������������������������������������������������\n" + pressEnter);
		}
		ScanUtil.nextLine();
	}

	// ���� �α��� ������
	static public void title1() {
		System.out.println();

		System.out.println(" O \tDDIT ���� ����Ʈ__");
		System.out.println("<|v\t\tDDIT ���� ����Ʈ__");
		System.out.println("/>  \t\t\tDDIT ���� ����Ʈ__\n\n\n");

		System.out.printf("%5s%5s%10s%5s%10s%5s%10s", " 1.�α���", "|", "2.ȸ������", "|", "3.��ȸ���α���", "|", "4.���α׷� ����");
		System.out.println("\n\n                       @ version_1  @ update_230915");
		bar();
		System.out.print("��ȣ �Է� >> ");
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
			System.out.println("\t\t��ȸ�� �α����Դϴ�\n");
		} else {
			System.out.println("\t\t" + name + "�� �ݰ����ϴ�!");
		}

		System.out.println("\t1.�˻�");
		System.out.println("\t2.���ã��");
		System.out.println("\t3.���� ");
		System.out.println("\t4.ȸ����������  ");
		System.out.println("\t5.���α׷� ����  ");
		System.out.println("\n\n                       @ version_1  @ update_230915");
		bar();
		System.out.print("��ȣ �Է� >> ");
	}

	// �α��� 3 page
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

	// ȸ������ page
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
		System.out.println("\n\t\t'" + nm + "'�� ������ ���ϵ帳�ϴ�." + "\n\n");
		PrintUtil.bar();
		Util.wait(500);
	}

	/**
	 * System.out.printf()�� �̿��ϸ鼭 �ѱ� ����ó���� ���� �������� ������ �޼���
	 * 
	 * @param format      : System.out.printf() �� �Է��ϴ� format�� ����� ���. ��, %{int}o ��
	 *                    �Է��Ͽ� ����, ���ڿ��� �������� �ʴ´�. ������ �Է��ϸ� ��������, ����� �Է��ϸ� ���������̴�.
	 * @param spaceString : �� ������ ä������ ���ڿ� �Է�. null�� �Է��ϸ� �⺻�� " "�� ����.
	 * @param args        : format���� %{int}o �κ��� ä���� ���� ������� �Է��ؾ��Ѵ�.
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
			if (str.charAt(i) >= '��' && str.charAt(i) <= 'Ş') {
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

	// ȸ������ ���� ���� ������
	public static void modiUi() {
		String id = (String) Controller.sessionStorage.get("MEM_ID");
		String pw = (String) Controller.sessionStorage.get("MEM_PASSWORD");
		String nm = (String) Controller.sessionStorage.get("MEM_NAME");

		PrintUtil.bar();
		System.out.println("\n");
		System.out.println("\t\t< " + id + "���� ������ �����մϴ� >\n");

		System.out.print("\t\tPW : ");
		System.out.print(pw.substring(0, 2));
		System.out.printf("%s", "****\n");
		System.out.print("\t\t�̸� : " + nm);
		System.out.println("\n\n\n");
		PrintUtil.bar();

	}

	// �˻��� �޴�
	public static void searchPage() {
		PrintUtil.bar();
		System.out.println("�� SEARCH DETAIL");
		System.out.printf("%s   %s   %s   %s   %s\n", "1.���Ը� �˻�", "2.�з��� �˻�", "3.���� �˻�", "4.Ȩ����", "5.���α׷� ����");
		System.out.print("��ȣ �Է� >> ");

	}
}
