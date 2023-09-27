package ddit.chap04.sec01;

//08.18
import java.util.Scanner;

public class SwitchExample01 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		SwitchExample01 se = new SwitchExample01();
		// se.switMethod01();
		se.switMethod02();
	}

	// 회원등급을 입력받아 그 값이
	// 1등급이면 "VIP회원입니다"를
	// 2-3등급이면 "우수회원입니다"를
	// 4-6등급이면 "일반회원입니다"를
	// 7-9등급이면 "신규회원등급입니다"를
	// 다른 값이면 "잘못된 등급입니다."를 출력하시오
	void switMethod01() {
		System.out.print("회원등급(1~9) : ");
		int grade = sc.nextInt();
		String message = "";
		switch (grade) {
		case 1:
			message = "VIP 회원입니다.";
			break;
		case 2:
		case 3:
			message = "우수 회원입니다.";
			break;
		case 4:
		case 5:
		case 6:
			message = "일반 회원입니다.";
			break;
		case 7:
		case 8:
		case 9:
			message = "신규 회원입니다.";
			break;
		default:
			message = "잘못된 등급입니다.";
		}
		System.out.println(message);
	}

	void switMethod02() {
		// 영문으로 된 국가명을 입력받아
		// "kor" 또는 "korea"이면 "대한민국입니다."
		// "jp" 또는 "japan" 이면 "일본입니다."
		// "china"이면 "중국입니다."
		System.out.print("영문으로된 국가명을 입력하십시오 : ");
		String message = "";
		String country = sc.nextLine();
		switch (country) {
		case "kor":
		case "korea":
			message = "대한민국입니다.";
			break;
		case "jp":
		case "japan":
			message = "일본입니다.";
			break;
		case "china":
			message = "중국입니다.";
			break;
		}
		System.out.println(message);
	}
}
