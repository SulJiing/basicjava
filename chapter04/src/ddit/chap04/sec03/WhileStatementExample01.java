package ddit.chap04.sec03;

// 08.21
public class WhileStatementExample01 {

	public static void main(String[] args) {
		// whileMethod01();
		 whileMethod02();
		//whileMethod03();
	}

	public static void whileMethod01() {
		// 10����� �� �Ѿ�� ���� ����
		int numOfChop = 1;// ������ Ƚ��

		while (numOfChop < 10) {
			System.out.println("������ " + numOfChop + "�� ������ϴ�");
			System.out.println("���� �ȳѾ� �����ϴ�..\n\n");
			numOfChop++;
		}
		System.out.println("������ " + numOfChop + "�� ������ϴ�");
		System.out.println("���� ������ �Ѿ���ϴ�...");
	}

	public static void whileMethod02() {
		// 1-50���̿� �ִ� �Ǻ���ġ ������ ����Ͻÿ�
		int ppn = 1; // ������
		int pn = 1; // ����
		int cn = 0; // �����
		System.out.printf("%2d, %2d, ", ppn, pn);
		while (cn < 50) {
			cn = ppn + pn;
			if (cn < 50) {
				System.out.printf("%2d, ", cn);
			} else {
				break;
			}
			ppn = pn;
			pn = cn;
		}
	}

	public static void whileMethod03() {
		// ������ 100��, ���Ϻ��� ������ 2�辿 ������ �� ���ʷ� 100������ �Ѵ� ���� �׶����� ������ �׼��� ���Ͻÿ�.
		int sum = 0;
		int money = 100;
		int days = 0;
		while (true) {
			// ����
			sum += money;

			days++;

			if (sum >= 1000000)
				break;
			money = money * 2;

			// ������ �׼� ���ϱ�
		}
		// �� �� ��� days
		System.out.println(days);
		// ����ݾ� ���
		System.out.println(sum);
		System.out.println(money);
	}

}
