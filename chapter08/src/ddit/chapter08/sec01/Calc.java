package ddit.chapter08.sec01;
//09.07.1
public abstract class Calc implements Calculater { 
	//�߻�Ŭ������ �Ǿ�� �ϴ� ������ ������ Ÿ����� ����̵� �޼��带 ���������� �ʰ� �״�� ��ӹ޾ұ� ����
	public int add(int num1, int num2) {
		return num1+num2;
	}
	public int subtract(int num1, int num2) {
		return num1-num2;
	}
}
