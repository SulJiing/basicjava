package util;

import java.util.Scanner;

public class ScanUtil {
	static Scanner sc = new Scanner(System.in);
	
	//���� �Է�
	public static String nextLine() {
		return sc.nextLine();
	}
	
	//������ �Է� ���ڿ� ����ó��
	public static int nextInt() {
		while (true) {
			try {
				int result = Integer.parseInt(sc.nextLine());
				return result;
			} catch (NumberFormatException e) {
				System.out.println("�߸� �Է�!!");
				System.out.print("�ٽ� �Է� >>");
			}
		}
	}
	
	public static int nextInt(String text) {
		System.out.println(text);
		return nextInt();
	}
}
