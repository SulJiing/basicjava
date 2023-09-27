package ddit.chap02.sec03;

//����Ÿ��: byte(1byte), short(2byte), int(�⺻��, 4byte), long(8byte)
public class IntegerExample {

	public static void main(String[] args) {
		// byteMethod(); // ȣ�⹮
		// shortMethod();
		// intMethod();
		longMethod();
	}

	public static void byteMethod() {
		// byte : 1byte ������
		// 127 ~ -128������ ���� ����
		// ���� ���� ����� ���� ���� ���ͷ�(������/byte b1=128;)�� ����
		// �������� �� �������� ����� ��ȯ ���� - ��ó��
		// (0,1,2,...127,-128,-127,...-1)
		byte b1 = 120; // b1�̶�� �����Ұ� �������
		System.out.println("b1=" + b1);

		byte b2 = 127;
		b2 = ++b2; // ++=1�����Ǵ� �� / ���� b2=++b2�̸� b2 �� �������� �ű�� �� = -128 = ��ȯ���� 127 ������ -128
		// b2++; ++��ġ�� ���� �����ϰ� �Ѱ��ְ� �Ѱ��ְ� �����ϴ� ���� �ٸ�
		System.out.println("b2=" + b2);
	}

	public static void shortMethod() {
		// short : 2byte ������
		// 32767 ~ -32768������ ���� ����
		// ���� ���� ����� ���� ���� ���ͷ��� ����
		// �������� �� �������� ����� ��ȯ ���� - ��ó��
		// (0,1,2,...32767,-32768,-32767,...-1)

		short score = 90;
		System.out.println("score=" + score);

		score = (short) (score + 32767); // ��ȯ�����
		System.out.println("score=" + score);
	}

	public static void intMethod() {
		// int : 4byte ������
		// 2147483647 ~ -2147483648������ ���� ���� ��21��
		// �⺻������ - int���� ������ ��� �� int�� �ٲ�(L�������ϰ�)
		// ���� ���� ����� ���� ���� ���ͷ��� ����
		// �������� �� �������� ����� ��ȯ ���� - ��ó��
		// (0,1,2,...2147483647,-2147483648,-2147483647,...-1)

		int num1 = 1000000;
		int num2 = 1000000;
		int res = num1 * num2; // ��ȯ����
		System.out.println("res=" + res);
	}

	public static void longMethod() {
		// long : 8byte ������
		// 9,223,372,036,854,775,807 ~ -9,223,372,036,854,775,808������ ���� ���� ��21��
		// �����͵ڿ� 'L'('1')�� �߰���
		// ���� ���� ����� ���� ���� ���ͷ��� ����
		// �������� �� �������� ����� ��ȯ ���� - ��ó��
		// (0,1,2,...9,223,372,036,854,775,807,-9,223,372,036,854,775,808,...-1)
		int n1 = 1000000;
		int n2 = 1000000;
		long res1 = n1 * n2; // ����� �����Ұ� �ٸ����� ����Ǿ ����Ǿ��� Ÿ���� �����Ұ� int�̱� ������ intŸ���� ���� ����

		long m1 = 1000000L;
		long m2 = 1000000L;
		long res2 = m1 * m2;

		System.out.println("res1=" + res1);
		System.out.println("res2=" + res2);
	}
}