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
	 * SQL�� MEMBER �� �� �÷� LENGTH�� ��Ȯ�� �� �ʿ� Ȥ�� �ڵ�� ���̸� ��Ȯ�ϰ� �������־����.
	 */
	static public Map<String, Object> loginMap = new HashMap<>();
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

	// MEMBERDAO ����
	MemberDao memberdao = MemberDao.getInstance();

	public int login() {
		// ù �α���ȭ��
		PrintUtil.loginUi();

		// ���̵��Է�
		System.out.print("ID : ");
		String id = ScanUtil.nextLine().trim();
		// ���̵� length ����ó��
		if (id.length() < 4 || id.length() > 10 || id.matches(".*[��-�R]+.*") || id.contains(" ")) {
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
		if (password.length() < 4 || password.length() > 20 || password.matches(".*[��-�R]+.*")
				|| password.contains(" ")) {
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
		if (id.length() < 4 || id.length() > 10 || id.matches(".*[��-�R]+.*") || id.contains(" ")) {
			System.out.println("���̵� ������ Ȯ�����ּ���.");
			return signUp();
		}

		// DB ���̵� �ߺ�Ȯ��
		if (memberdao.getIdlist(id) != null) {
			System.out.println("�ߺ��� ���̵��Դϴ�.");
			return signUp();

		} else {

			// ȭ��� ���̵�ǥ�ø� ���� ���̵� �Է°� ����
			Controller.sessionStorage.put("sign_id", id);
			PrintUtil.signPage1();

			System.out.print("PW �Է�>>  ");
			String password = ScanUtil.nextLine();

			// ��й�ȣ length ����ó��
			if (password.length() < 4 || password.length() > 20 || password.matches(".*[��-�R]+.*")
					|| password.contains(" ")) {
				System.out.println("��й�ȣ ������ Ȯ�����ּ���.");
				return signUp();
			}

			// ȭ��� ��й�ȣ ǥ�ø� ���� ��й�ȣ �Է°� ����
			Controller.sessionStorage.put("sign_pw", password);
			PrintUtil.signPage2();

			System.out.print("NAME �Է�>> ");
			String name = ScanUtil.nextLine();

			// �ѱ� �̸� (3 byte) 7�� �̻� �� ������ mem_name >length(20) �� �ѱ� ������ ����ó��
			if (name.length() > 7) {
				System.out.println("�̸��� 7�ڸ� ���� �� �����ϴ�.");
				return signUp();
			}
			Controller.sessionStorage.put("sign_name", name);
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
				if (pass.length() < 4 || pass.length() > 10 || pass.matches(".*[��-�R]+.*") || pass.contains(" ")) {
					System.out.println("��й�ȣ ������ Ȯ�����ּ���.");
					return infoUpdate();
				}
				sqlStr += " mem_password = '" + pass + "', ";
			} else if (flag.equalsIgnoreCase("n")) {

			} else {
				System.out.println("�߸��� �Է¹���Դϴ�.");
				return View.USER_UPDATE;
			}
			String flag1 = "";
			String name = "";
			// �̸�
			while (true) {
				System.out.print("�̸��� �����ϰڽ��ϴ�?(y/n)\n�Է�>>");
				flag1 = ScanUtil.nextLine();

				// Y/N/ANOTHER ����ó��
				if (flag1.equalsIgnoreCase("y")) {
					while (true) {
						System.out.print("������ �̸� �Է�>>");
						name = ScanUtil.nextLine();

						// �ѱ� �̸� (3 byte) 7�� �̻� �� ������ mem_name >length(20) �� �ѱ� ������ ����ó��
						if (name.length() > 7) {
							System.out.println("�̸��� 7�ڸ� ���� �� �����ϴ�.");
						} else {
							sqlStr += " mem_name = '" + name + "', ";
							break;
						}
					}
					break;
				} else if (flag1.equalsIgnoreCase("n")) {
					break;
				} else {
					System.out.println("�߸��� �Է¹���Դϴ�.");
					break;
				}
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
				Controller.sessionStorage.put("update_name", name);
				Controller.sessionStorage.replace("update_check", 1);
			} else {
				System.out.println("UPDATE ����");
			}

			// ������ ������ Ȯ���ϱ� ���Ͽ� LOGIN�� �ִ� HOME ȭ������
			return View.UI_HOME;
		}
	}
}
