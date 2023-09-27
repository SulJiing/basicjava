package ddit.chapter10.sec02;
//09.08.01
// ����� ���� ���� Ŭ����
// - Exception class�� ���
// - throw ������� ���ܸ� �����߻�
public class UserExceptionExample {

	public static void main(String[] args) {
		try {
			System.out.println("���� �߻�");
			throw new MyException("����� ���� ����");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

class MyException extends Exception{
	
	public MyException(String errMsg) {
		super(errMsg);
	}	
}