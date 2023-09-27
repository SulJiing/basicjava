package ddit.chapter06.sec02;
//08.29
public class Tv {
	private String company;
	private int year;
	private double size;
	
	// 멤버필드 초기화 - 생성자 메소드를 사용한
	Tv(String company,int year, double size){
		this.company=company;
		this.year=year;
		this.size=size;
	}
	Tv(){}	// 사용자가 생성자 메소드를 한개도 만들지 않으면 자동으로 
			// 만들어주지만 한개라도 만들면 자동으로 만들어주지 않기 
			// 때문에 직접 만들어주어야 함
	public void printInfor() {
		System.out.println("제조회사 : "+this.company);
		System.out.println("생산년도 : "+year);
		System.out.println("크기 : "+size+"인치");
	
	}
}
