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
    * ������ �����ؾ� �� �� 1. ���̵�� ��й�ȣ�� (������ ���� Ư�� ��ȣ) �̿� (���� �� �ѱ�)�� ���� �ɷ��ִ� �ڵ� �ʿ� 2.
    * SQL�� MEMBER �� �� �÷� LENGTH�� ��Ȯ�� �� �ʿ� Ȥ�� �ڵ�� ���̸� ��Ȯ�ϰ� �������־����. 3.
    */

   static public Map<String, Object> loginMap = new HashMap<>();
   // SIGN UP ȭ��� ǥ�ø� ���� LIST
   static public Map<String, Object> singMap = new HashMap<>();
   private static MemberService instance = null;

   private MemberService() {
   }

   // �̱���
   public static MemberService getInstance() {
      if (instance == null)
         instance = new MemberService();
      return instance;
   }

   MemberDao memberdao = MemberDao.getInstance();

   public int login() {
      // ù �α���ȭ��
      PrintUtil.loginUi();

      // ���̵��Է�
      System.out.print("ID : ");
      String id = ScanUtil.nextLine().trim();
      // ���̵� length ����ó��
      if (id.length() < 4 || id.length() >= 7 || id.matches(".*[��-�R]+.*") || id.contains(" ")){
         System.out.println("���̵� Ȯ�����ּ���.");
         return login();
      }
      // ���̵� �Է� ����
      Controller.sessionStorage.put("Ui_id", id);
      PrintUtil.loginUi1();

      // ���̵��Է�
      System.out.print("PW : ");
      String password = ScanUtil.nextLine();

      // ��й�ȣ length ����ó��
      if (password.length() < 4 || password.length() >= 7 || password.matches(".*[��-�R]+.*") || password.contains(" ")) {
         System.out.println("��й�ȣ�� Ȯ�����ּ���.");
         return login();
      }

      // ��й�ȣ �Է� ����
      Controller.sessionStorage.put("Ui_pass", password);
      PrintUtil.loginUi2();

      // MEMBERDAO LOGIN METHOD >> ���̵� �� ��й�ȣ Ȯ�� with SQL_DB
      Map<String, Object> row = memberdao.login(id, password);
      if (row == null) {
         System.err.println("���̵� �������� �ʽ��ϴ�!");
         return View.HOME;
      } else {
         // �α��ο� ���� ���� ����� ��� ���� ���θ� ���� �� �ְ� sessionStorage List�� ���� ����
         Controller.sessionStorage.put("login", true);
         Controller.sessionStorage.put("MEM_ID", id);
         Controller.sessionStorage.put("MEM_PASSWORD", password);
         Controller.sessionStorage.put("MEM_NAME", row.get("MEM_NAME"));
         return View.UI_HOME;
      }
   }

   public int signUp() {
      // ȸ������ ������
      PrintUtil.signPage();

      // ���̵��Է�
      System.out.print("ID �Է�>>  ");
      String id = ScanUtil.nextLine();

      // ���̵� length ����ó��
      if (id.length() < 4 || id.length() >= 7|| id.matches(".*[��-�R]+.*") || id.contains(" ")) {
         System.out.println("���̵� ������ Ȯ�����ּ���.");
         return signUp();
      }

      // DB ���̵� �ߺ�Ȯ��
      if (memberdao.getIdlist(id) != null) {
         System.out.println("�ߺ��� ���̵��Դϴ�.");
         return signUp();

      } else {

         // ȭ��� ���̵�ǥ�ø� ���� ���̵� �Է°� ����
         singMap.put("MEM_ID", id);
         PrintUtil.signPage1();

         System.out.print("PW �Է�>>  ");
         String password = ScanUtil.nextLine();

         // ��й�ȣ length ����ó��
         if (password.length() < 4 || password.length() >= 7|| password.matches(".*[��-�R]+.*") || password.contains(" ")) {
            System.out.println("��й�ȣ ������ Ȯ�����ּ���.");
            return signUp();
         }

         // ȭ��� ��й�ȣ ǥ�ø� ���� ��й�ȣ �Է°� ����
         singMap.put("MEM_PASSWORD", password);
         PrintUtil.signPage2();

         System.out.print("NAME �Է�>> ");
         String name = ScanUtil.nextLine();

         // �ѱ� �̸� (3 byte) 7�� �̻� �� ������ mem_name >length(20) �� �ѱ� ������ ����ó��
         if (name.length() > 7) {
            System.out.println("�̸��� 7�ڸ� ���� �� �����ϴ�.");
            return signUp();
         }
         singMap.put("MEM_NAME", name);
         PrintUtil.signPage3();

         // memberdao.signUp �� �Ѱ��� �Ķ���� ����Ʈ
         List<Object> param = new ArrayList<>();
         param.add(id);
         param.add(password);
         param.add(name);
         int result = memberdao.signUp(param);
         System.out.println(result);

         // ȸ�� ���� �Ϸ� �� HOME ����
         return View.HOME;
      }
   }

   public int infoUpdate() {
      // ��ȸ���� �޴���� ����ó��
      if (Controller.sessionStorage.get("login") == (Object) false) {
         System.out.println("�α����� ���� �����ؾ��մϴ�.");
         return View.HOME;
      } else {
         // �񱳸� ���� �̹� login()�� ���� ����� Controller.sessionStorage.get("MEM_ID") �� ���������
         String memId = (String) Controller.sessionStorage.get("MEM_ID");

         // ȸ������ ������ ���� ȭ��� ���
         PrintUtil.modiUi();

         // ȸ������ ������ ���� '������' �� ����� �ڵ�
         String sqlStr = "UPDATE member";
         sqlStr = sqlStr + " SET ";

         // ��й�ȣ
         System.out.print("��й�ȣ�� �����ϰڽ��ϴ�?(y/n)\n�Է�>>");
         String flag = ScanUtil.nextLine();

         // Y/N/ANOTHER ����ó��
         if (flag.equalsIgnoreCase("y")) {
            System.out.print("������ ��ȣ �Է�>>");
            String pass = ScanUtil.nextLine();
            if (pass.length() < 4 || pass.length() >= 7|| pass.matches(".*[��-�R]+.*") || pass.contains(" ")) {
               System.out.println("��й�ȣ ������ Ȯ�����ּ���.");
               return infoUpdate();
            }
            sqlStr += " mem_password = '" + pass + "', ";
         } else if (flag.equalsIgnoreCase("n")) {

         } else {
            System.out.println("�߸��� �Է¹���Դϴ�.");
            return View.USER_UPDATE;
         }

         // �̸�
         System.out.print("�̸��� �����ϰڽ��ϴ�?(y/n)\n�Է�>>");
         String flag1 = ScanUtil.nextLine();

         // Y/N/ANOTHER ����ó��
         if (flag1.equalsIgnoreCase("y")) {
            System.out.print("������ �̸� �Է�>>");
            String name = ScanUtil.nextLine();

            // �ѱ� �̸� (3 byte) 7�� �̻� �� ������ mem_name >length(20) �� �ѱ� ������ ����ó��
            if (name.length() > 7) {
               System.out.println("�̸��� 7�ڸ� ���� �� �����ϴ�.");
               return infoUpdate();
            }

            sqlStr += " mem_name = '" + name + "', ";

         } else if (flag1.equalsIgnoreCase("n")) {
         } else {
            System.out.println("�߸��� �Է¹���Դϴ�.");
            return View.USER_UPDATE;
         }

         // ��й�ȣ ���� N / �̸� ���� N
         if (flag1.equalsIgnoreCase("n") && flag.equalsIgnoreCase("n")) {
            return View.HOME;
         }

         // ���� '������'�� ���� ȸ�� ���� ���� UPDATE [sqlStr.substring(0, sqlStr.length() - 2) �� ����
         // ������ ������ ", " ����]
         sqlStr = sqlStr.substring(0, sqlStr.length() - 2);
         sqlStr = sqlStr + " WHERE mem_id = '" + memId + "'";
         // System.out.println(sqlStr);

         int result = memberdao.update(sqlStr);
         if (result > 0) {
            System.out.println("UPDATE ����");
         } else {
            System.out.println("UPDATE ����");
         }

         // ������ ������ Ȯ���ϱ� ���Ͽ� LOGIN�� �ִ� HOME ȭ������
         return View.HOME;

      }
   }
}