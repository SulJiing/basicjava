package ddit.chap04.sec03;
//08.22
import java.util.Scanner;

public class WhileStatementExample02 {

	public static void main(String[] args) {
		new WhileStatementExample02().init();
		// �ڱ� �ڽ��� ������Ų ������ (����)static(����)�� ���� �������ϱ� ������ ��ü�� ���������� ������ �ʰ� �ѹ� ���� ������ ��

	}

	public void init() {
		String menu = "*** Ŀ�Ǹ޴� ***\n";
		menu += "1. �Ƹ޸�ī��              2000��\n";
		menu += "2. ī���                 3000��\n";
		menu += "3. ī��� �����߶�       5000��\n";
		menu += "4. �ڹ�Ĩ ������ġ��    6500��\n";
		menu += "5. ���α׷� ����\n";

		int sum = 0;
		int exit = 0;

		String bill = "*** ������ ***\n";
		while (true) {
			System.out.println(menu);
			Scanner sc = new Scanner(System.in);
			System.out.print("Ŀ�Ǽ��� : ");
			int choice = Integer.parseInt(sc.nextLine()); // ���ڿ��� ����ִ� ���ڸ� int������ ��ȯ������ �� ���

			switch (choice) {
			case 1:
				sum += 2000;
				bill += "�Ƹ޸�ī��              2000��\n";
				break;
			case 2:
				sum += 3000;
				bill += "ī���                 3000��\n";
				break;
			case 3:
				sum += 5000;
				bill += "ī��� �����߶�       5000��\n";
				break;
			case 4:
				sum += 6500;
				bill += "�ڹ�Ĩ ������ġ��    6500��\n";
				break;
			case 5:
				exit = -1;
				break;
			default:
				System.out.println("�޴������� �߸��Ǿ����ϴ�");
			}
			if(exit==-1) {
				System.out.println("���α׷� ����");
				break; //if���� ����� ���� �ƴ϶� �ݺ����� ����� ��
			}
			
		}
		bill+="--------------------\n";
		bill+=" �� �հ�                               "+sum+"��";
				System.out.println(bill);
	}
}
