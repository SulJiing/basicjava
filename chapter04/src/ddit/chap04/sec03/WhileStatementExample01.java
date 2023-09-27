package ddit.chap04.sec03;

// 08.21
public class WhileStatementExample01 {

	public static void main(String[] args) {
		// whileMethod01();
		 whileMethod02();
		//whileMethod03();
	}

	public static void whileMethod01() {
		// 10번찍어 안 넘어가는 나무 없다
		int numOfChop = 1;// 도끼질 횟수

		while (numOfChop < 10) {
			System.out.println("나무를 " + numOfChop + "번 찍었습니다");
			System.out.println("아직 안넘어 갔습니다..\n\n");
			numOfChop++;
		}
		System.out.println("나무를 " + numOfChop + "번 찍었습니다");
		System.out.println("드디어 나무가 넘어갔습니다...");
	}

	public static void whileMethod02() {
		// 1-50사이에 있는 피보나치 수열을 출력하시오
		int ppn = 1; // 전전수
		int pn = 1; // 전수
		int cn = 0; // 현재수
		System.out.printf("%2d, %2d, ", ppn, pn);
		while (cn < 50) {
			cn = ppn + pn;
			if (cn < 50) {
				System.out.printf("%2d, ", cn);
			} else {
				break;
			}
			ppn = pn;
			pn = cn;
		}
	}

	public static void whileMethod03() {
		// 오늘은 100월, 내일부터 오늘의 2배씩 저축할 때 최초로 100만원을 넘는 날과 그때까지 저축한 액수를 구하시오.
		int sum = 0;
		int money = 100;
		int days = 0;
		while (true) {
			// 저축
			sum += money;

			days++;

			if (sum >= 1000000)
				break;
			money = money * 2;

			// 저축할 액수 구하기
		}
		// 날 수 출력 days
		System.out.println(days);
		// 저축금액 출력
		System.out.println(sum);
		System.out.println(money);
	}

}
