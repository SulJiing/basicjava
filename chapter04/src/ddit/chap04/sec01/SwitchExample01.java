package ddit.chap04.sec01;

//08.18
import java.util.Scanner;

public class SwitchExample01 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		SwitchExample01 se = new SwitchExample01();
		// se.switMethod01();
		se.switMethod02();
	}

	// ȸ������� �Է¹޾� �� ����
	// 1����̸� "VIPȸ���Դϴ�"��
	// 2-3����̸� "���ȸ���Դϴ�"��
	// 4-6����̸� "�Ϲ�ȸ���Դϴ�"��
	// 7-9����̸� "�ű�ȸ������Դϴ�"��
	// �ٸ� ���̸� "�߸��� ����Դϴ�."�� ����Ͻÿ�
	void switMethod01() {
		System.out.print("ȸ�����(1~9) : ");
		int grade = sc.nextInt();
		String message = "";
		switch (grade) {
		case 1:
			message = "VIP ȸ���Դϴ�.";
			break;
		case 2:
		case 3:
			message = "��� ȸ���Դϴ�.";
			break;
		case 4:
		case 5:
		case 6:
			message = "�Ϲ� ȸ���Դϴ�.";
			break;
		case 7:
		case 8:
		case 9:
			message = "�ű� ȸ���Դϴ�.";
			break;
		default:
			message = "�߸��� ����Դϴ�.";
		}
		System.out.println(message);
	}

	void switMethod02() {
		// �������� �� �������� �Է¹޾�
		// "kor" �Ǵ� "korea"�̸� "���ѹα��Դϴ�."
		// "jp" �Ǵ� "japan" �̸� "�Ϻ��Դϴ�."
		// "china"�̸� "�߱��Դϴ�."
		System.out.print("�������ε� �������� �Է��Ͻʽÿ� : ");
		String message = "";
		String country = sc.nextLine();
		switch (country) {
		case "kor":
		case "korea":
			message = "���ѹα��Դϴ�.";
			break;
		case "jp":
		case "japan":
			message = "�Ϻ��Դϴ�.";
			break;
		case "china":
			message = "�߱��Դϴ�.";
			break;
		}
		System.out.println(message);
	}
}
