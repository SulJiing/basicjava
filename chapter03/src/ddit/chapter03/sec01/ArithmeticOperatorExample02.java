package ddit.chapter03.sec01;
/*    �Է�          ���
 * A    B   AND   OR   EX-or /0=false,1=ture
 * 0	0	 0	  0      0
 * 0	1	 0	  1		 1
 * 1	0    0    1      1
 * 1	1    1    1      0
 */
public class ArithmeticOperatorExample02 {
	//�������� : !(not), &&(and), ||(or)
	public static void main(String[] args) {
		logicaloperator();
		bitwise();
		

	}
	public static void logicaloperator() {
		char ch='0'; //���� 0�� ASCii�ڵ�� �ٲ� ��, ���� 0�� 48
		int num = 100;
		System.out.println("1=>"+(int)'1');
		System.out.println("a=>"+(int)'a');
		boolean flag = ch>'a' && num!=50;
		System.out.println("and=>"+flag);
		
		System.out.println("or=>"+(ch>'a' || num!=50));
	}
	public static void bitwise() {
		// ��Ʈ�� (&,|,^ ) - ������:���� ��ġ�� ��Ʈ���� and, or, ex-or ����
		// 						����� �����ڷ�� ��ȯ
		
		int val1=27; //11011
		int val2=19; //10011
		
		System.out.println("��Ʈ�� and : "+(val1 & val2));
		System.out.println("��Ʈ�� or : "+(val1 | val2));
		System.out.println("��Ʈ�� ex-or : "+(val1 ^ val2));
	
	}
}
