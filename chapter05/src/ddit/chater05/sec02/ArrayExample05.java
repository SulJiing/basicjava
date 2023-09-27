package ddit.chater05.sec02;
//08.24
public class ArrayExample05 {

	public static void main(String[] args) {
		// 최대값, 최솟값 구하기
		int[] num = { 15, 23, 7, 85, 66, 27, 10 };

		int tmin = num[0]; // 임시 최솟값
		int tmax = num[0]; // 임시 최대값

		for (int i = 1; i < num.length - 1; i++) {
			// 최솟값
			if (tmin > num[i]) {
				tmin = num[i];
			}
			// 최대값
			if (tmax < num[i]) {
				tmax = num[i];
			}

		}
		System.out.println("최소값은 =" + tmin);
		System.out.println("최대값은 =" + tmax);
	}

}
