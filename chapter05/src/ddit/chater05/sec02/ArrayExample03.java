package ddit.chater05.sec02;

import java.util.Arrays;

// 08.24
public class ArrayExample03 {

	public static void main(String[] args) {
		ArrayExample03 ae03 = new ArrayExample03(); // ae03�� ������ �θ� �޼ҵ尡 �ϳ� �̻� �������� �ǹ���
		int[] source = { 27, 63, 15, 84, 35 };

		ae03.bubbleSort(source); // ȣ�⹮ ()���� ������ ȣ�� ���ϴ� ���� ������ �־���
		System.out.println("bubble ���� ��:" + Arrays.toString(source));// �Ű������� �ٲ��ָ� ���� ����� ����
		System.out.println("selection ���� �� : " + Arrays.toString(ae03.selectionSort()));
	}

	public void bubbleSort(int[] target) { // ȣ����ϴ� ��, (�Ű�����), �̸��� �ٲ�� ��
		System.out.println("����:" + Arrays.toString(target));
		boolean f = true; // ������ ��������(�ϴٰ� ���� �� �Ǹ� ����)
		// int i =0;
		for (int i = 0; i < target.length - 1; i++) { // ȸ����
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
		System.out.println("bubble ���� ��:" + Arrays.toString(target));
	}

	public int[] selectionSort() {
		int[] source = { 17, 43, 15, 84, 35, 40 };
		System.out.println("\n���� ��:" + Arrays.toString(source));
		Arrays.sort(source); // �ڵ�����
		System.out.println("�ڵ�����:" + Arrays.toString(source));
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
