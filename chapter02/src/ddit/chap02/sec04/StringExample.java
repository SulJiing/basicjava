package ddit.chap02.sec04;

public class StringExample {

	public static void main(String[] args) {
		// String : java api���� ���ڿ��� ���� �Ǵ� ������ �� �ִ� class
		// ���ڿ��� " "�ȿ� ����� ������
		// ���ڿ��� ���Ǵ� "+"�����ڴ� ���ڿ� ������ �ǹ�
		// any type+���ڿ� �� ���ڿ� + ���ڿ�
		// ex) 77+"7"="77"+"7" = "777"
		String str = "7";
		String res = 77 + str;
		// System.out.println(res);

		String str1 = "ȫ�浿";
		String str2 = "ȫ�浿";
		// �ּҺ�
		if (str1 == str2) { // ������ �������� �����(==)�� ���� �ּҰ��� ����
			System.out.println("�����ּ�");
		} else {
			System.out.println("�ٸ��ּ�");
		}

		// �����
		if (str1.contentEquals(str2)) {
			System.out.println("���� �̸�");
		} else {
			System.out.println("�ٸ� �̸�");
		}

		String str3 = new String("ȫ�浿");
		String str4 = new String("ȫ�浿");

		if (str3 == str4) {
			System.out.println("���� �ּ�");
		} else {
			System.out.println("�ٸ� �ּ�");
		}
	}
}
