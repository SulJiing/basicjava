package ddit.chap02.sec04;

public class StringExample {

	public static void main(String[] args) {
		// String : java api에서 문자열을 저장 또는 조작할 수 있는 class
		// 문자열은 " "안에 기술된 데이터
		// 문자열에 사용되는 "+"연산자는 문자열 결합을 의미
		// any type+문자열 → 문자열 + 문자열
		// ex) 77+"7"="77"+"7" = "777"
		String str = "7";
		String res = 77 + str;
		// System.out.println(res);

		String str1 = "홍길동";
		String str2 = "홍길동";
		// 주소비교
		if (str1 == str2) { // 참조형 변수들의 동등비교(==)를 쓰면 주소값을 비교함
			System.out.println("같은주소");
		} else {
			System.out.println("다른주소");
		}

		// 내용비교
		if (str1.contentEquals(str2)) {
			System.out.println("같은 이름");
		} else {
			System.out.println("다른 이름");
		}

		String str3 = new String("홍길동");
		String str4 = new String("홍길동");

		if (str3 == str4) {
			System.out.println("같은 주소");
		} else {
			System.out.println("다른 주소");
		}
	}
}
