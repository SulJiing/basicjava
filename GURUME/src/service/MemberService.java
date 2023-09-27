package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.MemberDao;
import util.PrintUtil;
import util.ScanUtil;
import util.View;

public class MemberService {
	private static MemberService instance = null;

	private MemberService() {
	}

	public static MemberService getInstance() {
		if (instance == null)
			instance = new MemberService();
		return instance;
	}

	MemberDao memberdao = MemberDao.getInstance();

	public int loginHome() {
		System.out.println("========== 로그인 ==========");
		System.out.print("ID : ");
		String ID = ScanUtil.nextLine();
//		System.out.println();
		System.out.print("PASSWORD : ");
		String PASS = ScanUtil.nextLine();
		login(ID, PASS);

		return View.UI_HOME;
	}

	public int login(String id, String password) {
		if ((boolean)Controller.sessionStorage.get("login") !=false) {
			System.out.println("이미 로그인되어있습니다.");
			return View.HOME;
		} else {
			Map<String, Object> row = memberdao.login(id, password);
			if (row == null) {
				System.out.println("존재하지 않는 아이디입니다.");
				System.out.println("=========================");
				return View.HOME;
			} else {
				Controller.sessionStorage.put("login", true);
				System.out.println(row.get("MEM_NAME") + "님 반갑습니다!");
				Controller.sessionStorage.put("MEM_ID", id);
				System.out.println("=========================");
				return View.USER_UNKNOWN;
			}
		}
	}

	public int login() {
//	      if((boolean)Controller.sessionStorage.get("login")) {
//	         System.out.println("이미 로그인되어있습니다.");
//	         return View.HOME;
//	      }
		PrintUtil.bar();
		System.out.println("\n\n          ID : ");
		System.out.println("          PW : \n\n\n\n");
		PrintUtil.bar();
		System.out.print("ID : ");
		String id = ScanUtil.nextLine();

		System.out.print("PW : ");
		String password = ScanUtil.nextLine();

		if ((boolean)Controller.sessionStorage.get("login") !=false) {
			System.out.println("이미 로그인되어있습니다.");
			return View.HOME;
		} else {
			Map<String, Object> row = memberdao.login(id, password);
			if (row == null) {
				System.err.println("아이디가 존재하지 않습니다!");
				return View.HOME;
			} else {
				Controller.sessionStorage.put("login", true);
				Controller.sessionStorage.put("MEM_ID", id);
				Controller.sessionStorage.put("MEM_NAME", row.get("MEM_NAME"));
				System.out.println(row.get("MEM_NAME") + "님 반갑습니다!");
				return View.USER_UNKNOWN;
			}
		}
	}

	public int signUp() {
		System.out.println("========== 회원가입 ==========");
		System.out.print("아이디 :  ");
		String id = ScanUtil.nextLine();
		System.out.print("비밀번호 : ");
		String password = ScanUtil.nextLine();
		System.out.print("이름 : ");
		String name = ScanUtil.nextLine();

		List<Object> param = new ArrayList<>();
		param.add(id);
		param.add(password);
		param.add(name);

		int result = memberdao.signUp(param);
		return View.HOME;
	}

	public int infoUpdate() {
		if (Controller.sessionStorage.containsKey("login") != false){
			System.out.println("로그인을 하세요");
			return View.HOME;
		} else {
//			Map<String, Object> map = (Map<String, Object>)Controller.sessionStorage.get("MEM_ID");
//			String memId = (String)map.get("MEM_ID");
			String memId = (String) Controller.sessionStorage.get("MEM_ID");

			System.out.println("-- 회원정보수정 --");
			String sqlStr = "UPDATE member";
			sqlStr = sqlStr + " SET ";

			System.out.print("암호를 수정하겠습니다?(y/n)");
			String flag = ScanUtil.nextLine();
			if (flag.equalsIgnoreCase("y")) {
				System.out.print("");
				String pass = ScanUtil.nextLine();
				sqlStr += " mem_password = '" + pass + "', ";
			}

			System.out.println("이름을 수정하겠습니다?(y/n)");
			String flag1 = ScanUtil.nextLine();
			if (flag1.equalsIgnoreCase("y")) {
				String name = ScanUtil.nextLine();
				Controller.sessionStorage.put("MEM_NAME", name);
				sqlStr += " mem_name = '" + name + "', ";
			}

			if (flag1.equalsIgnoreCase("n") && flag.equalsIgnoreCase("n")) {
				return View.UI_HOME;
			}

			sqlStr = sqlStr.substring(0, sqlStr.length() - 2);
			sqlStr = sqlStr + " WHERE mem_id = '" + memId + "'";
			System.out.println(sqlStr);

//		int result = memberdao.update(sqlStr, memId);
			int result = memberdao.update(sqlStr);
			if (result > 0) {
				System.out.println("UPDATE 성공");

			} else {
				System.out.println("UPDATE 실패");
			}
		}

		return View.UI_HOME;
	}

}