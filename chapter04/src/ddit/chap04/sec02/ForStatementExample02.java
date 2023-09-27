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
		
		for (int i = 0; i < 5; i++) { // 줄(row)을 담당
			for (int j = 0; j <= i; j++) { // 한 줄에서 처리해야 할 내용
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
		for (int i = 0; i < 5; i++) { // 줄(row)을 담당
			for (int j = 0; j < 4 - i; j++) { // 공백출력
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) { // 한 줄에서 처리해야 할 내용
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
		for (int i = 0; i < 5; i++) { // 줄수
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
		for (int i = 0; i < 5; i++) { // 줄수
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

