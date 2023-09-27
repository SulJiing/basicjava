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
	 * SQL¿¡ MEMBER ÀÇ °¢ ÄÃ·³ LENGTH¿¡ Á¤È®ÇÑ °ª ÇÊ¿ä È¤Àº ÄÚµå·Î ±æÀÌ¸¦ Á¤È®ÇÏ°Ô ³ª´©¾îÁÖ¾î¾ßÇÔ.
	 */
	static public Map<String, Object> loginMap = new HashMap<>();
	static public Map<String, Object> singMap = new HashMap<>();

	private static MemberService instance = null;

	private MemberService() {
	}

	// ½Ì±ÛÅæ
	public static MemberService getInstance() {
		if (instance == null)
			instance = new MemberService();
		return instance;
	}

	// MEMBERDAO »ı¼º
	MemberDao memberdao = MemberDao.getInstance();

	public int login() {
		// Ã¹ ·Î±×ÀÎÈ­¸é
		PrintUtil.loginUi();

		// ¾ÆÀÌµğÀÔ·Â
		System.out.print("ID : ");
		String id = ScanUtil.nextLine().trim();
		// ¾ÆÀÌµğ length ¿¹¿ÜÃ³¸®
		if (id.length() < 4 || id.length() > 10 || id.matches(".*[°¡-ÆR]+.*") || id.contains(" ")) {
			System.out.println("¾ÆÀÌµğ¸¦ È®ÀÎÇØÁÖ¼¼¿ä.");
			return login();
		}
		// ¾ÆÀÌµğ ÀÔ·Â ¼º°ø
		Controller.sessionStorage.put("Ui_id", id);
		PrintUtil.loginUi1();

		// ¾ÆÀÌµğÀÔ·Â
		System.out.print("PW : ");
		String password = ScanUtil.nextLine();

		// ºñ¹Ğ¹øÈ£ length ¿¹¿ÜÃ³¸®
		if (password.length() < 4 || password.length() > 20 || password.matches(".*[°¡-ÆR]+.*")
				|| password.contains(" ")) {
			System.out.println("ºñ¹Ğ¹øÈ£¸¦ È®ÀÎÇØÁÖ¼¼¿ä.");
			return login();
		}

		// ºñ¹Ğ¹øÈ£ ÀÔ·Â ¼º°ø
		Controller.sessionStorage.put("Ui_pass", password);
		PrintUtil.loginUi2();

		// MEMBERDAO LOGIN METHOD >> ¾ÆÀÌµğ ¹× ºñ¹Ğ¹øÈ£ È®ÀÎ with SQL_DB
		Map<String, Object> row = memberdao.login(id, password);
		if (row == null) {
			System.err.println("¾ÆÀÌµğ°¡ Á¸ÀçÇÏÁö ¾Ê½À´Ï´Ù!");
			return View.HOME;
		} else {
			// ·Î±×ÀÎ¿¡ µû¶ó ´ÙÀ½ ±â´ÉÀÇ »ç¿ë °¡´É ¿©ºÎ¸¦ Á¤ÇÒ ¼ö ÀÖ°Ô sessionStorage List¿¡ Á¤º¸ ÀúÀå
			Controller.sessionStorage.put("login", true);
			Controller.sessionStorage.put("MEM_ID", id);
			Controller.sessionStorage.put("MEM_PASSWORD", password);
			Controller.sessionStorage.put("MEM_NAME", row.get("MEM_NAME"));
			return View.UI_HOME;
		}
	}

	public int signUp() {
		// È¸¿ø°¡ÀÔ ÆäÀÌÁö
		PrintUtil.signPage();

		// ¾ÆÀÌµğÀÔ·Â
		System.out.print("ID ÀÔ·Â>>  ");
		String id = ScanUtil.nextLine();

		// ¾ÆÀÌµğ length ¿¹¿ÜÃ³¸®
		if (id.length() < 4 || id.length() > 10 || id.matches(".*[°¡-ÆR]+.*") || id.contains(" ")) {
			System.out.println("¾ÆÀÌµğ Çü½ÄÀ» È®ÀÎÇØÁÖ¼¼¿ä.");
			return signUp();
		}

		// DB ¾ÆÀÌµğ Áßº¹È®ÀÎ
		if (memberdao.getIdlist(id) != null) {
			System.out.println("Áßº¹µÈ ¾ÆÀÌµğÀÔ´Ï´Ù.");
			return signUp();

		} else {

			// È­¸é´Ü ¾ÆÀÌµğÇ¥½Ã¸¦ À§ÇÑ ¾ÆÀÌµğ ÀÔ·Â°ª ÀúÀå
			Controller.sessionStorage.put("sign_id", id);
			PrintUtil.signPage1();

			System.out.print("PW ÀÔ·Â>>  ");
			String password = ScanUtil.nextLine();

			// ºñ¹Ğ¹øÈ£ length ¿¹¿ÜÃ³¸®
			if (password.length() < 4 || password.length() > 20 || password.matches(".*[°¡-ÆR]+.*")
					|| password.contains(" ")) {
				System.out.println("ºñ¹Ğ¹øÈ£ Çü½ÄÀ» È®ÀÎÇØÁÖ¼¼¿ä.");
				return signUp();
			}

			// È­¸é´Ü ºñ¹Ğ¹øÈ£ Ç¥½Ã¸¦ À§ÇÑ ºñ¹Ğ¹øÈ£ ÀÔ·Â°ª ÀúÀå
			Controller.sessionStorage.put("sign_pw", password);
			PrintUtil.signPage2();

			System.out.print("NAME ÀÔ·Â>> ");
			String name = ScanUtil.nextLine();

			// ÇÑ±Û ÀÌ¸§ (3 byte) 7ÀÚ ÀÌ»ó ½Ã ¼³Á¤°ª mem_name >length(20) À» ³Ñ±â ¶§¹®¿¡ ¿¹¿ÜÃ³¸®
			if (name.length() > 7) {
				System.out.println("ÀÌ¸§Àº 7ÀÚ¸¦ ³ÑÀ» ¼ö ¾ø½À´Ï´Ù.");
				return signUp();
			}
			Controller.sessionStorage.put("sign_name", name);
			PrintUtil.signPage3();

			// memberdao.signUp ¿¡ ³Ñ°ÜÁÙ ÆÄ¶ó¹ÌÅÍ ¸®½ºÆ®
			List<Object> param = new ArrayList<>();
			param.add(id);
			param.add(password);
			param.add(name);
			int result = memberdao.signUp(param);
			System.out.println(result);

			// È¸¿ø °¡ÀÔ ¿Ï·á ÈÄ HOME º¹±Í
			return View.HOME;
		}
	}

	public int infoUpdate() {
		// ºñÈ¸¿øÀº ¸Ş´º»ç¿ë ¿¹¿ÜÃ³¸®
		if (Controller.sessionStorage.get("login") == (Object) false) {
			System.out.println("·Î±×ÀÎÀ» ¸ÕÀú ¼öÇàÇØ¾ßÇÕ´Ï´Ù.");
			return View.HOME;
		} else {
			// ºñ±³¸¦ À§ÇØ ÀÌ¹Ì login()À» ÅëÇØ ÀúÀåµÈ Controller.sessionStorage.get("MEM_ID") °ª °¡Áö°í¿À±â
			String memId = (String) Controller.sessionStorage.get("MEM_ID");

			// È¸¿øÁ¤º¸ ¼öÁ¤À» À§ÇÑ È­¸é´Ü Ãâ·Â
			PrintUtil.modiUi();

			// È¸¿øÁ¤º¸ ¼öÁ¤À» À§ÇÑ 'Äõ¸®¹®' À» ¸¸µå´Â ÄÚµå
			String sqlStr = "UPDATE member";
			sqlStr = sqlStr + " SET ";

			// ºñ¹Ğ¹øÈ£
			System.out.print("ºñ¹Ğ¹øÈ£¸¦ ¼öÁ¤ÇÏ°Ú½À´Ï´Ù?(y/n)\nÀÔ·Â>>");
			String flag = ScanUtil.nextLine();

			// Y/N/ANOTHER ¿¹¿ÜÃ³¸®
			if (flag.equalsIgnoreCase("y")) {
				System.out.print("º¯°æÇÒ ¾ÏÈ£ ÀÔ·Â>>");
				String pass = ScanUtil.nextLine();
				if (pass.length() < 4 || pass.length() > 10 || pass.matches(".*[°¡-ÆR]+.*") || pass.contains(" ")) {
					System.out.println("ºñ¹Ğ¹øÈ£ Çü½ÄÀ» È®ÀÎÇØÁÖ¼¼¿ä.");
					return infoUpdate();
				}
				sqlStr += " mem_password = '" + pass + "', ";
			} else if (flag.equalsIgnoreCase("n")) {

			} else {
				System.out.println("Àß¸øµÈ ÀÔ·Â¹æ½ÄÀÔ´Ï´Ù.");
				return View.USER_UPDATE;
			}
			String flag1 = "";
			String name = "";
			// ÀÌ¸§
			while (true) {
				System.out.print("ÀÌ¸§À» ¼öÁ¤ÇÏ°Ú½À´Ï´Ù?(y/n)\nÀÔ·Â>>");
				flag1 = ScanUtil.nextLine();

				// Y/N/ANOTHER ¿¹¿ÜÃ³¸®
				if (flag1.equalsIgnoreCase("y")) {
					while (true) {
						System.out.print("º¯°æÇÒ ÀÌ¸§ ÀÔ·Â>>");
						name = ScanUtil.nextLine();

						// ÇÑ±Û ÀÌ¸§ (3 byte) 7ÀÚ ÀÌ»ó ½Ã ¼³Á¤°ª mem_name >length(20) À» ³Ñ±â ¶§¹®¿¡ ¿¹¿ÜÃ³¸®
						if (name.length() > 7) {
							System.out.println("ÀÌ¸§Àº 7ÀÚ¸¦ ³ÑÀ» ¼ö ¾ø½À´Ï´Ù.");
						} else {
							sqlStr += " mem_name = '" + name + "', ";
							break;
						}
					}
					break;
				} else if (flag1.equalsIgnoreCase("n")) {
					break;
				} else {
					System.out.println("Àß¸øµÈ ÀÔ·Â¹æ½ÄÀÔ´Ï´Ù.");
					break;
				}
			}
			// ºñ¹Ğ¹øÈ£ ¼±ÅÃ N / ÀÌ¸§ ¼±ÅÃ N
			if (flag1.equalsIgnoreCase("n") && flag.equalsIgnoreCase("n")) {
				return View.HOME;
			}

			// ÃÖÁ¾ 'Äõ¸®¹®'À» ÅëÇØ È¸¿ø Á¤º¸ ¼öÁ¤ UPDATE [sqlStr.substring(0, sqlStr.length() - 2) ¸¦ ÅëÇØ
			// Äõ¸®¹® ¸¶Áö¸· ", " »èÁ¦]
			sqlStr = sqlStr.substring(0, sqlStr.length() - 2);
			sqlStr = sqlStr + " WHERE mem_id = '" + memId + "'";
			// System.out.println(sqlStr);

			int result = memberdao.update(sqlStr);
			if (result > 0) {
				System.out.println("UPDATE ¼º°ø");
				Controller.sessionStorage.put("update_name", name);
				Controller.sessionStorage.replace("update_check", 1);
			} else {
				System.out.println("UPDATE ½ÇÆĞ");
			}

			// ¼öÁ¤µÈ Á¤º¸¸¦ È®ÀÎÇÏ±â À§ÇÏ¿© LOGINÀÌ ÀÖ´Â HOME È­¸éÀ¸·Î
			return View.UI_HOME;
		}
	}
}
