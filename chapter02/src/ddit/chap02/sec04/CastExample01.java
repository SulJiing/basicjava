package ddit.chap02.sec04;

import java.util.Scanner;

// ���� 3������ ������ ����� ���Ͻÿ�.(Ű����� �Է�) ��, ����� �Ҽ�2��° �ڸ����� �ݿø��Ͻÿ�
// ���� : 97, 80, 90
// Ű���� �Է�
// 1.Scanner class import - ���ص� �Ǵ� �� - 2�� �����ϰ� �ڵ��ϼ�������� �ᵵ ��
//  �� import java.util.Scanner; ���ڹ������ؿ� ��ƿ�����ؿ� ��ĳ�ʶ�� Ŭ������ ���ڴ�. �� ����(class �ۿ� ���)
// 2. Scanner class ��ü�� ����
//  �� Scanner sc(��������)=new Scanner(System.in);
// 3. �޼��� ��� - �Է¹޴� ��ġ
//  �� System.out.print("�޼���");
// 4. Scanner Ŭ���� ��ü(sc)�� �̿��Ͽ� �ڷ� �Է� 
//   �� (����) sc.nextInt() - ������ ���ö� ������ ���� 120 130�� ������
//   ��       Integer.parseInt(sc.nextLine()) - ���͸� ġ�� �������� ��� �����͸� ���ڿ��� ����
//   �� (���ڿ�) sc.next() 
//   ��        sc.nextLine()
// 		�� ���� ������ : next�� ���Ⱑ ������ �ڿ� ���ڰ� �ִ��� ������� ����
public class CastExample01 {

	public static void main(String[] args) {
		int sum=0; //�� =0=�ʱ�ȭ
		int score=0; //��������
		Scanner sc = new Scanner(System.in);
		System.out.print("�������� : "); //�� �ȹٲ�
		score=sc.nextInt();
		sum=sum+score; //0+�Է¹��������Ͱ� sum�� ��
		
		System.out.print("�������� : "); //�� �ȹٲ�
		score=sc.nextInt();
		sum=sum+score; //score ������ �׻� �ֽ��� ���� ������
		
		System.out.print("�������� : "); //�� �ȹٲ�
		score=sc.nextInt();
	sum=sum+score;
		
//		System.out.print("next : ");
//		String str = sc.nextLine();
//		System.err.println(str + str);
//
//		System.out.print("next line : ");
//		String str1 = sc.nextLine();
//		System.err.println(str);
//		System.err.println(str1);

		double avg= (double) sum/3;
		avg=(int)(avg*10+0.5)/10.; // ��°�ڸ����� �ݿø��̱� ������ 10�� ���ϰ� 0.5�� ���� �� �׸��� 10�� ���߱� ������ 10�� �ٽ� ������ ��
		// (int)�� ���� ������ �� ������ �Ҽ��� ���� �ڸ��� ����� ����
		//int�� �����̱� ������ �Ҽ��� �ڸ��� 0���� ���� �׷��� 10�ڿ� .�� ��ų� �տ� (double)�� ������ ��
		
		System.out.println("���� ="+sum);
		
		
		System.out.println("��� ="+avg);
	}

}
