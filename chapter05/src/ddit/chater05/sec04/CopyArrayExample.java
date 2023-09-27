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
	// ���� ���� ��� 3����
	// System.arraycopy() �� �������� �迭�� ������� �迭�� �����Ǿ� �־�� ��
	public static void arrayCopy() {
		int[] arr1 = { 10, 20, 30, 40, 50 };
		int[] arr2 = new int[10];
		System.arraycopy(arr1, 0, arr2, 5, arr1.length);
		System.out.println("�����迭=" + Arrays.toString(arr1) + arr1);
		System.out.println("��������迭=" + Arrays.toString(arr2) + arr2);
	}

	// clone() �� ������� �迭�� �����ÿ� �迭����
	public static void arrayClone() {
		int[] arr1 = { 10, 20, 30, 40, 50 };
		int[] arr2 = arr1.clone();
		System.out.println("�����迭=" + Arrays.toString(arr1) + arr1);
		System.out.println("��������迭=" + Arrays.toString(arr2) + arr2);
	}

	// for���� �̿��Ͽ� �迭��Ҹ� �ϳ��� ����
	public static void arrayManualCopy() {
		int[] arr1 = { 10, 20, 30, 40, 50 };
		int[] arr2 = new int[5];

		for (int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		System.out.println("�����迭=" + Arrays.toString(arr1) + arr1);
		System.out.println("��������迭=" + Arrays.toString(arr2) + arr2);
	}
}
