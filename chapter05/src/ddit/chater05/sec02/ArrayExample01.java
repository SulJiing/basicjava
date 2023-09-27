package ddit.chater05.sec02;

//08.22
public class ArrayExample01 {

	public static void main(String[] args) {
		arrayMehod01();

	}

	public static void arrayMehod01() {
		// 정수형 배열 10 생성

		int[] num = null; // num은 일반형이 아닌 참조형이라서 주소값을 초기화할때는 null로 초기화해야함
		num = new int[10];

		int[] num1 = new int[10]; // 이게 위에 2줄 합친 거랑 같음
		for (int i = 0; i < num1.length; i++) {
			System.out.println("num1[" + i + "]=" + num1[i]);
		}

		// 3개의 요소를 갖는 실수형 배열을 생성하고 10.5, 30.0, 0.34로 초기화
		double[] dvalue = new double[] { 10.5, 30.0, 0.34 };

		double[] val = { 10.5, 30.0, 0.34 };

		double[] val1 = new double[3];
		val1[0] = 10.5;
		val1[1] = 30.0;
		val1[2] = 0.34;
		
		// 26개 요소를 갖는 문자배열에 알파벳 'A'~'Z'까지 저장하고 출력하시오
		char [] alpha = new char[26];
			for (int i = 0; i<alpha.length; i++) {
					alpha[i] = (char)('A'+i);
					System.out.printf("%c",alpha[i]);
				}

	}
	
}