package ddit.chap04.sec01;

//08.18
import java.util.Random;
import java.util.Scanner;

public class RockScissorsPaper {

	public static void main(String[] args) {
// ��ǻ�Ϳ� ����ڰ� ���� ���� �� ������ �Ѵ�  �̸� ���α׷��Ͻÿ�  (���� =>1, ���� =>2, ��=> 3)
		Scanner sc = new Scanner(System.in);
		System.out.print("���� =>1, ���� =>2, ��=> 3 : ");
		Random r = new Random();
		int user = sc.nextInt();
		int com = r.nextInt(3) + 1;
		System.out.println(com);
		int score = user - com;

		if (user <= 0 || user >= 4) {
			System.out.println("�߸��� ���� �Է��߽��ϴ�.");
		} else if (score == 1 || score == -2) {
			System.out.println("�¸��߽��ϴ�!!");
		} else if (score == 0) {
			System.out.println("���º��Դϴ�!");
		} else if (score == -1 || score == 2) {
			System.out.println("�ѿ�...�й��߽��ϴ� �Ф�");
		}
	}

}
