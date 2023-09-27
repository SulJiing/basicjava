package ddit.chap04.sec03;
//08.22
//1-2+3...-10=?
public class Homework02 {

	public static void main(String[] args) {
		int sign = -1;
		int sum = 0;
		int cnt = 1;

		while (cnt <= 10) {
			sign = sign * (-1); // -+-+-+-+-+-+- = 숫자의 크기가 아니라 부호를 정해주는 식
			sum += sign * cnt;
			if (sign > 0 && cnt != 1) { // && cnt!=1 1앞에 +기호 없애주는 식
				System.out.print("+" + (sign * cnt));
			} else {
				System.out.print(sign * cnt);
			}
			cnt++;
		}
			System.out.println("="+sum
					);
	}

}
