package ddit.chapter06.sec02;
//08.29
public class Tv {
	private String company;
	private int year;
	private double size;
	
	// ����ʵ� �ʱ�ȭ - ������ �޼ҵ带 �����
	Tv(String company,int year, double size){
		this.company=company;
		this.year=year;
		this.size=size;
	}
	Tv(){}	// ����ڰ� ������ �޼ҵ带 �Ѱ��� ������ ������ �ڵ����� 
			// ����������� �Ѱ��� ����� �ڵ����� ��������� �ʱ� 
			// ������ ���� ������־�� ��
	public void printInfor() {
		System.out.println("����ȸ�� : "+this.company);
		System.out.println("����⵵ : "+year);
		System.out.println("ũ�� : "+size+"��ġ");
	
	}
}
