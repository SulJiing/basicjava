package util;

import java.util.Scanner;

public class ScanUtil {
	static Scanner sc = new Scanner(System.in);
	public static String nextLine() {
		return sc.nextLine();
	}
	public static int nextInt() {
		while(true) {
			try {
				int result = Integer.parseInt(sc.nextLine());
				return result;
			}catch (NumberFormatException e) {
				System.out.println("잘못 입력!!");
			}
		}
	}
}

