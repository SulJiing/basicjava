package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.MemberDAO;
import util.ScanUtil;
import util.View;

public class MemberService {
	private static MemberService instance = null;
	private MemberService() {}
	public static MemberService getInstance() {
		if(instance == null) instance = new MemberService();
		return instance;
	}
	
	MemberDAO memberdao = MemberDAO.getInstance();
	
	public int login() {
		if((boolean) Controller.sessionStorage.get("login")) {
			System.out.println("이미 로그인되어있습니다.");
			return View.HOME;
		}
		System.out.println("-- 로그인 --");
		System.out.print("아이디 >> ");
		String id = ScanUtil.nextLine();
		System.out.print("비밀번호 >> ");
		String pass = ScanUtil.nextLine();
		Map<String, Object> row = memberdao.login(id, pass);
		if(row == null) {
			System.out.println("아이디가 없습니다.");
			return View.HOME;
		}else {
			Controller.sessionStorage.put("login", true);
			System.out.println(row.get("MEM_NAME") + "님 환영합니다!");
			return View.BOARD_LIST;
		}
	}
	public int signUp() {
		System.out.println("-- 회원가입 --");
		System.out.print("아이디 >> ");
		String id = ScanUtil.nextLine();
		System.out.print("비밀번호 >> ");
		String pass = ScanUtil.nextLine();
		
		List<Object> param = new ArrayList<>();
		param.add(id);
		param.add(pass);
		
		int result = memberdao.signUp(param);
		System.out.println("처리건수 : "+result);
		return View.HOME;
	}
	public int inforUpdate() {
		if(Controller.sessionStorage.get("login")==(Object)false) {
			System.out.println("로그인을 먼저 수행해야 합니다.");
			return View.HOME;
		}
			Map<String, Object> map = (Map<String, Object>) Controller.sessionStorage.get("loginInfo");
			String memId = (String)map.get("MEM_ID");
		
		System.out.println("-- 회원정보 수정 --");
		String sqlStr = "UPDATE member ";
		sqlStr = sqlStr+"SET ";
		
		System.out.print("암호를 수정하시겠습니까?(Y/N)");
		String flag1 = ScanUtil.nextLine();
		if(flag1.equalsIgnoreCase("Y")) { //equalsIgnoreCase 대소문자 구분 x
			System.out.print("신규 암호 : ");
			String pass = ScanUtil.nextLine();
			sqlStr = sqlStr+"mem_pass = '"+pass+"', ";
		}
		System.out.print("이름을 수정하시겠습니까?(Y/N)");
		String flag2 = ScanUtil.nextLine();
		if(flag2.equalsIgnoreCase("Y")) {
			System.out.print("이름 : ");
			String name = ScanUtil.nextLine();
			sqlStr = sqlStr+"mem_name = '"+name+"', ";
		}
		System.out.print("주소를 수정하시겠습니까?(Y/N)");
		String flag3 = ScanUtil.nextLine();
		if(flag3.equalsIgnoreCase("Y")) {
			System.out.print("기본 주소 : ");
			String add1 = ScanUtil.nextLine();
			sqlStr = sqlStr+"mem_add1 = '"+add1+"', ";
			System.out.print("상세 주소 : ");
			String add2 = ScanUtil.nextLine();
			sqlStr = sqlStr+"mem_add2 = '"+add2+"', ";
		}
		System.out.print("전화번호를 수정하시겠습니까?(Y/N)");
		String flag4 = ScanUtil.nextLine();
		if(flag4.equalsIgnoreCase("Y")) {
			System.out.print("변경 전화번호 : ");
			String hp = ScanUtil.nextLine();
			sqlStr = sqlStr+"mem_hp = '"+hp+"', ";
		}
		sqlStr = sqlStr.substring(0,sqlStr.length()-2);
		sqlStr=sqlStr+"where mem_id = ?";
		System.out.println(sqlStr);
		
		int result = memberdao.update(sqlStr, memId);
		if(result>0) {
			System.out.println("update가 성공적으로 수행되었습니다.");
		}
		
		return View.HOME;
	}
}
