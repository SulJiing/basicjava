package util;

public class Util {
	// Intro 화면 출력 딜레이
	public static void wait(int i) {
		long end = System.currentTimeMillis();
		long start = System.currentTimeMillis();
		while ((end - start) < i)
			end = System.currentTimeMillis();
	}
}
