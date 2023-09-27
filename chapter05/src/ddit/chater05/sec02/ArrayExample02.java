package ddit.chater05.sec02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 08.24
public class ArrayExample02 {
	int[] lotto = new int[45]; // 45개의 정수 공간이 생성됨
	Random r = new Random(); // 이 자리면 어느 자리에서든 사용할 수 있게됨

	public static void main(String[] args) {
		// 로또번호 생성
		new ArrayExample02().lotto(); // 자기 클래스 객체를 생성하면 스태틱을 안 써도 됨
	}

	public void lotto() {

		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = i + 1; // 첫 째로 시작하는 값이 0이기 때문에 1씩 더해주는 것

		}
		// System.out.println(Arrays.toString(lotto));
		// (테스트) 배열을 출력해주는 클래스 (Arrays=클래스, toString=스테틱)

		// 1000원 어치 로또 구매
		Scanner sc = new Scanner(System.in);
		System.out.print("금액 : ");
		int money = sc.nextInt();

		for (int i = 1; i <= money / 1000; i++) {
			shuffle();
			System.out.print(i+":");
			for (int j = 0; j < 6; j++) { // 6자리를 뽑기 위한 for문
				System.out.printf("%5d", lotto[j]);
			}
			System.out.println();
		}

	}

	public void shuffle() {
		// 배열요소를 섞음
		for (int i = 0; i < 1000000; i++) {
			int rnd = r.nextInt(45); // 45는 포함되지 않음, 0~44까지의 난수 배열요소가 아니라 인덱스 값임
			int temp = lotto[0];
			lotto[0] = lotto[rnd];
			lotto[rnd] = temp; // 순서 바꾸기
		}

	}
}
