package ddit.chap02.sec03;

//�Ǽ���(�Ҽ����� �ִ� ��) : float(4byte), double(8byte:�⺻��)
public class FloatExample {

	public static void main(String[] args) {
		floatMethod();
		doubleMethod();
	}

	public static void floatMethod() {
		// float: 4byte(1 bit : ��ȣ, 8bit(����) : ����, 23bit : ����(�Ҽ��� ������ ��)
		// 1.4e(x10)-45(��=����) ~ 3.4e(x10)+38(��=����) : longŸ�Ժ��� ū ũ���� ������ ����
		// ������ ���� �ݵ�� 'f'('F')�� ����Ͽ� float type���� �����Ϸ����� �˷��� ��.
		float pi = 3.1415926f;
		int radius = 15;// ������ = 15

		System.out.println("���� ���� =" + (radius * radius * pi));
		System.out.println("���ѷ� =" + (2 * radius * pi)); // 2�� int ���̴��� float�� ū���̱⶧���� ����
		// �Ҽ��� ��°�ڸ����� �ݿø��ϴ� ���=x10
	}

	public static void doubleMethod() {
		// double: 8byte(1 bit : ��ȣ, 11bit(����) : ����, 52bit : ����(�Ҽ��� ������ ��)
		// 4.9e(x10)-324(��=����) ~ 1.8e(x10)+308(��=����) :���� ū ũ���� ������ ����
		// ������ ���� 'd'('D')�� ����ϰų� ������ �� ����

		double d1 = 0.1D;
		double d2 = 0.1F; // floatŸ���� double�� ��ȯ�ؼ� double�� ������ �� / ���� ���� �ٸ� - ��ȯ������ ����

		System.out.println("d1=" + d1);
		System.out.println("d2=" + d2);
	}

}
