package ddit.chap02.sec03;

//정수타입: byte(1byte), short(2byte), int(기본형, 4byte), long(8byte)
public class IntegerExample {

	public static void main(String[] args) {
		// byteMethod(); // 호출문
		// shortMethod();
		// intMethod();
		longMethod();
	}

	public static void byteMethod() {
		// byte : 1byte 기억공간
		// 127 ~ -128까지의 정수 저장
		// 위의 값을 벗어나는 값을 갖는 리터럴(실제값/byte b1=128;)은 오류
		// 연산결과가 위 범위값을 벗어나면 순환 적용 - 원처럼
		// (0,1,2,...127,-128,-127,...-1)
		byte b1 = 120; // b1이라는 기억장소가 만들어짐
		System.out.println("b1=" + b1);

		byte b2 = 127;
		b2 = ++b2; // ++=1증가되는 것 / 만약 b2=++b2이면 b2 즉 왼편으로 옮기는 것 = -128 = 순환적용 127 다음은 -128
		// b2++; ++위치에 따라서 증가하고 넘겨주고 넘겨주고 증가하는 것이 다름
		System.out.println("b2=" + b2);
	}

	public static void shortMethod() {
		// short : 2byte 기억공간
		// 32767 ~ -32768까지의 정수 저장
		// 위의 값을 벗어나는 값을 갖는 리터럴은 오류
		// 연산결과가 위 범위값을 벗어나면 순환 적용 - 원처럼
		// (0,1,2,...32767,-32768,-32767,...-1)

		short score = 90;
		System.out.println("score=" + score);

		score = (short) (score + 32767); // 순환적용됨
		System.out.println("score=" + score);
	}

	public static void intMethod() {
		// int : 4byte 기억공간
		// 2147483647 ~ -2147483648까지의 정수 저장 약21억
		// 기본정수형 - int보다 작으면 모두 다 int로 바꿈(L을제외하고)
		// 위의 값을 벗어나는 값을 갖는 리터럴은 오류
		// 연산결과가 위 범위값을 벗어나면 순환 적용 - 원처럼
		// (0,1,2,...2147483647,-2147483648,-2147483647,...-1)

		int num1 = 1000000;
		int num2 = 1000000;
		int res = num1 * num2; // 순환적용
		System.out.println("res=" + res);
	}

	public static void longMethod() {
		// long : 8byte 기억공간
		// 9,223,372,036,854,775,807 ~ -9,223,372,036,854,775,808까지의 정수 저장 약21억
		// 데이터뒤에 'L'('1')을 추가함
		// 위의 값을 벗어나는 값을 갖는 리터럴은 오류
		// 연산결과가 위 범위값을 벗어나면 순환 적용 - 원처럼
		// (0,1,2,...9,223,372,036,854,775,807,-9,223,372,036,854,775,808,...-1)
		int n1 = 1000000;
		int n2 = 1000000;
		long res1 = n1 * n2; // 결과의 기억장소가 다르더라도 연산되어서 저장되어진 타입의 기억장소가 int이기 때문에 int타입의 값이 나옴

		long m1 = 1000000L;
		long m2 = 1000000L;
		long res2 = m1 * m2;

		System.out.println("res1=" + res1);
		System.out.println("res2=" + res2);
	}
}