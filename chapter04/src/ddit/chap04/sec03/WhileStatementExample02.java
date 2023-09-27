package ddit.chap04.sec03;
//08.22
import java.util.Scanner;

public class WhileStatementExample02 {

	public static void main(String[] args) {
		new WhileStatementExample02().init();
		// 자기 자신을 생성시킨 이유는 (정적)static(시점)을 같게 만들어야하기 때문에 객체의 참조변수를 만들지 않고 한번 쓰고 버리는 것

	}

	public void init() {
		String menu = "*** 커피메뉴 ***\n";
		menu += "1. 아메리카노              2000원\n";
		menu += "2. 카페라떼                 3000원\n";
		menu += "3. 카라멜 마끼야또       5000원\n";
		menu += "4. 자바칩 프라프치노    6500원\n";
		menu += "5. 프로그램 종료\n";

		int sum = 0;
		int exit = 0;

		String bill = "*** 영수증 ***\n";
		while (true) {
			System.out.println(menu);
			Scanner sc = new Scanner(System.in);
			System.out.print("커피선택 : ");
			int choice = Integer.parseInt(sc.nextLine()); // 문자열에 들어있는 숫자를 int값으로 변환시켜줄 때 사용

			switch (choice) {
			case 1:
				sum += 2000;
				bill += "아메리카노              2000원\n";
				break;
			case 2:
				sum += 3000;
				bill += "카페라떼                 3000원\n";
				break;
			case 3:
				sum += 5000;
				bill += "카라멜 마끼야또       5000원\n";
				break;
			case 4:
				sum += 6500;
				bill += "자바칩 프라프치노    6500원\n";
				break;
			case 5:
				exit = -1;
				break;
			default:
				System.out.println("메뉴선택이 잘못되었습니다");
			}
			if(exit==-1) {
				System.out.println("프로그램 종료");
				break; //if문을 벗어나는 것이 아니라 반복문을 벗어나는 것
			}
			
		}
		bill+="--------------------\n";
		bill+=" 총 합계                               "+sum+"원";
				System.out.println(bill);
	}
}
