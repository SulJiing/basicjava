package ddit.chap04.sec02;

//08.21
public class ForStatementExample02 {

	public static void main(String[] args) {
		//forMethod01();
		//forMethod02();
		//forMethod03();
		forMethod04();
	}

	public static void forMethod01() {
		/* 			*
		 * 			**
		 * 			***
		 * 			****
		 * 			*****
		 */		
		
		for (int i = 0; i < 5; i++) { // ��(row)�� ���
			for (int j = 0; j <= i; j++) { // �� �ٿ��� ó���ؾ� �� ����
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	public static void forMethod02() {
		/* 				 *
		 * 			    **
		 * 			   ***
		 * 			  ****
		 * 			 *****
		 */	
		for (int i = 0; i < 5; i++) { // ��(row)�� ���
			for (int j = 0; j < 4 - i; j++) { // �������
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) { // �� �ٿ��� ó���ؾ� �� ����
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	public static void forMethod03() {
		/* 			*****	 
		 * 			****
		 * 			***   
		 * 			**  
		 * 			* 
		 */	
		for (int i = 0; i < 5; i++) { // �ټ�
			for (int j = 0; j <= 4 - i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	public static void forMethod04() {
		/* 			*****	    *		*********
		 * 			 ****      ***		 *******
		 * 			  ***     *****		  *****
		 * 			   **    *******	   ***
		 * 			    *   *********		*
		 */	
		for (int i = 0; i < 5; i++) { // �ټ�
			for (int j = 0; j < i; j++) {
				System.out.print(" ");

			}
			for (int j = 0; j <= 4 - i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 9; j >= 2 * i + 1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}

