package util;

import java.util.Scanner;

public class ScanUtil {
	static Scanner sc = new Scanner(System.in);
	
	//정보 입력
	public static String nextLine() {
		return sc.nextLine();
	}
	
	//정수값 입력 숫자외 예외처리
	public static int nextInt() {
		while (true) {
			try {
				int result = Integer.parseInt(sc.nextLine());
				return result;
			} catch (NumberFormatException e) {
				System.out.println("잘못 입력!!");
				System.out.print("다시 입력 >>");
			}
		}
	}
	
	public static int nextInt(String text) {
		System.out.println(text);
		return nextInt();
	}
}
