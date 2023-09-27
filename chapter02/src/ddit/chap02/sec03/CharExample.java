package ddit.chap02.sec03;

//문자(char) : 2byte(부호없는 정수형, 0~65535)
//			  ' '로 묶여 표현
public class CharExample {

	public static void main(String[] args) {
		char ch1 = 'a'; // 한글자만 저장이 가능 (char ch1='abcd';)X
		char ch2 = '대';

		ch1++; // 영어는 다음 걸로 됨, 하나가 더해짐
		System.out.println("ch1=" + ch1);
		System.out.println("ch1=" + (ch1 + 1)); // ASCii코드값
		System.out.println("ch2=" + ch2);
		System.out.println("ch2=" + (ch2 + 0));

		byte b1 = 10;
		short s1 = 0;
		// s1=s1+ch1; : char이 음수가 없어서 변환이 안됨
		// ch1=b1+'a' : char이 음수가 없어서 변환이 안됨 -byte 값을 못 내보냄
	}

}
