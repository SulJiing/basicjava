package ddit.chapter03.sec01;
// ���� ������  08.17
import java.util.Scanner;

public class ArithmeticOperatorExample03 {

	public static void main(String[] args) {
		// Ű����� �����ϳ��� �Է¹޾� �� ���̿� �ش��ϴ� ���ɴ븦 ���ϰ� ���ɴ밡 
		// ~ 20�� : û�⼼�� / 30~50�� : ��⼼�� / 60�� ���� : ��⼼��
		// ex) 17 => 10��, 81 => 80��, 11 => 10�� ...
		Scanner sc = new Scanner(System.in);
		System.out.print("�����Է� : ");
		int age = sc.nextInt();
		int ageGroup = age/10;
		
		String g = (ageGroup<3) ? "û�⼼��" : (ageGroup<6 && ageGroup>=3) ? "��⼼��" : "��⼼��";
			// �̹� 3�̻��̱� ������ �Ѿ�� ������ ���� 3���� Ŀ�� �Ѵٴ� ������ ��� ��
		System.out.println("���� : " + age + " => " + g);
}

}
