package ddit.chap04.sec03;
//08.22
//1-2+3...-10=?
public class Homework02 {

	public static void main(String[] args) {
		int sign = -1;
		int sum = 0;
		int cnt = 1;

		while (cnt <= 10) {
			sign = sign * (-1); // -+-+-+-+-+-+- = ������ ũ�Ⱑ �ƴ϶� ��ȣ�� �����ִ� ��
			sum += sign * cnt;
			if (sign > 0 && cnt != 1) { // && cnt!=1 1�տ� +��ȣ �����ִ� ��
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
