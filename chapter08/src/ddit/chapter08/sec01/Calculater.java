package ddit.chapter08.sec01;
//09.07.1
public interface Calculater extends Circle{
//	double PI = 3.1415926; // = public static final double PI = 3.1415926;
	
	int add(int num1, int num2);
	int subtract(int num1, int num2);
	long times(int num1, int num2);
	double devide(int num1, int num2);
	// �������̽������� ������ Ÿ�Ծտ� public abstract�� �ִ� ������ ����
}
