package ddit.chap02.sec03;

//����(char) : 2byte(��ȣ���� ������, 0~65535)
//			  ' '�� ���� ǥ��
public class CharExample {

	public static void main(String[] args) {
		char ch1 = 'a'; // �ѱ��ڸ� ������ ���� (char ch1='abcd';)X
		char ch2 = '��';

		ch1++; // ����� ���� �ɷ� ��, �ϳ��� ������
		System.out.println("ch1=" + ch1);
		System.out.println("ch1=" + (ch1 + 1)); // ASCii�ڵ尪
		System.out.println("ch2=" + ch2);
		System.out.println("ch2=" + (ch2 + 0));

		byte b1 = 10;
		short s1 = 0;
		// s1=s1+ch1; : char�� ������ ��� ��ȯ�� �ȵ�
		// ch1=b1+'a' : char�� ������ ��� ��ȯ�� �ȵ� -byte ���� �� ������
	}

}
