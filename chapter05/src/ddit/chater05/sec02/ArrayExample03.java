package ddit.chater05.sec02;

import java.util.Arrays;

// 08.24
public class ArrayExample03 {

	public static void main(String[] args) {
		ArrayExample03 ae03 = new ArrayExample03(); // ae03을 가지고 부를 메소드가 하나 이상 존재함을 의미함
		int[] source = { 27, 63, 15, 84, 35 };

		ae03.bubbleSort(source); // 호출문 ()안의 변수를 호출 당하는 문의 변수에 넣어줌
		System.out.println("bubble 정렬 후:" + Arrays.toString(source));// 매개변수명만 바꿔주면 같은 결과가 나옴
		System.out.println("selection 정렬 후 : " + Arrays.toString(ae03.selectionSort()));
	}

	public void bubbleSort(int[] target) { // 호출당하는 문, (매개변수), 이름만 바뀌는 것
		System.out.println("원본:" + Arrays.toString(target));
		boolean f = true; // 개선된 버블정렬(하다가 정렬 다 되면 끝냄)
		// int i =0;
		for (int i = 0; i < target.length - 1; i++) { // 회전수
			f = true;
			for (int j = 0; j < target.length - 1 - i; j++) {
				if (target[j] > target[j + 1]) {
					int t = target[j];
					target[j] = target[j + 1];
					target[j + 1] = t;
					f = false;
				}
			}
			if (f)
				break;
		}
		System.out.println("bubble 정렬 후:" + Arrays.toString(target));
	}

	public int[] selectionSort() {
		int[] source = { 17, 43, 15, 84, 35, 40 };
		System.out.println("\n정렬 전:" + Arrays.toString(source));
		Arrays.sort(source); // 자동정렬
		System.out.println("자동정렬:" + Arrays.toString(source));
		for (int i = 0; i < source.length - 1; i++) {
			for (int j = i + 1; j < source.length; j++) {
				if (source[i] > source[j]) {
					int t = source[i];
					
					source[i] = source[j];
					source[j] = t;

				}
			}
		}
		return source;
	}
}
