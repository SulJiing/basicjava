package ddit.chater05.sec04;

import java.util.Arrays;
//08.05
public class CopyArrayExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// arrayCopy();
		// arrayClone();
		arrayManualCopy();
	}
	// 깊은 복사 방법 3가지
	// System.arraycopy() → 복사해줄 배열과 복사받을 배열이 생성되어 있어야 함
	public static void arrayCopy() {
		int[] arr1 = { 10, 20, 30, 40, 50 };
		int[] arr2 = new int[10];
		System.arraycopy(arr1, 0, arr2, 5, arr1.length);
		System.out.println("원본배열=" + Arrays.toString(arr1) + arr1);
		System.out.println("복사받은배열=" + Arrays.toString(arr2) + arr2);
	}

	// clone() → 복사받을 배열의 생성시에 배열복사
	public static void arrayClone() {
		int[] arr1 = { 10, 20, 30, 40, 50 };
		int[] arr2 = arr1.clone();
		System.out.println("원본배열=" + Arrays.toString(arr1) + arr1);
		System.out.println("복사받은배열=" + Arrays.toString(arr2) + arr2);
	}

	// for문을 이용하여 배열요소를 하나씩 복사
	public static void arrayManualCopy() {
		int[] arr1 = { 10, 20, 30, 40, 50 };
		int[] arr2 = new int[5];

		for (int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		System.out.println("원본배열=" + Arrays.toString(arr1) + arr1);
		System.out.println("복사받은배열=" + Arrays.toString(arr2) + arr2);
	}
}
