package util;

import controller.Controller;

public class PrintUtil {

   static public void bar() {
      System.out.println("�����������������������������������������������������");
   }

   static public void intro() {
      String[] team = { "T_", "T__", "T___", "T___E", "T__E", "T_E", "TE", "TE_", "TE__", "TE__A", "TE_A", "TEA",
            "TEA_", "TEA_M", "TEAM", "TEAM_", "TEAM__", "TEAM___", "TEAM____", "TEAM________1", "TEAM_______1",
            "TEAM______1", "TEAM_____2", "TEAM___2", "TEAM__3", "TEAM_3" };
      String[] name1 = { "��", "��", "��", "�褾", "����", "����", "������", "������", "������", "K����", "KH��", "KHW", "KHW  &" };
      String[] name2 = { "��", "��", "��", "�ڤ�", "����", "�ڢG", "���֤�", "����ȣ", "P��ȣ", "PJȣ", "PJH", "PJH  &" };
      String[] name3 = { "��", "��", "��", "�餷", "�鿩", "�鿵", "�鿵��", "�鿵��", "�鿵��", "B����", "BY��", "BYW", "BYW  &" };
      String[] name4 = { "��", "��", "��", "�̤�", "�̻�", "�̻�", "�̻�", "�̻�ó", "�̻�ö", "L��ö", "LSö", "LSC" };

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

   static public void userHome() {
      String name = (String) Controller.sessionStorage.get("MEM_NAME");

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
