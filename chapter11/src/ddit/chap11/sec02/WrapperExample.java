package ddit.chap11.sec02;

import java.util.ArrayList;
import java.util.Scanner;
//09.08.05
public class WrapperExample {

	public static void main(String[] args) {
		// �⺻Ÿ�� => Wrapper
		// 1) ������ �޼���
		Long l1 = new Long(25l);
		Long l2 = 25l;	//����ڽ�
		
		long res = 100+l2; //�����ڽ�
		System.out.println("res = "+res);
		
		// 2) valueOf()
		Long l3 = Long.valueOf("25");
		
		long ll3 = l3.longValue();
		long ll4 = Long.parseLong(String.valueOf(ll3));
		
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		
		ArrayList<Long> list = new ArrayList<Long>();
		
		list.add(l1);
		list.add(l3);
		
		System.out.println(list.toString());
		
	}

}
