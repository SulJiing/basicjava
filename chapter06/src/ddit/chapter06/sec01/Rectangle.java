package ddit.chapter06.sec01;
//08.28
public class Rectangle {
	int width = 500; // 직접초기화
	int height = 1000;
	// 초기화 블록
	{ 
		width = 10;
		height = 30;
	}

	// 생성자 메소드 - 다양한 초기화
	Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	// 넓이를 계산한 후 출력하는 메소드
	public void getArea() {
		int area = width*height;
		System.out.println("넓이 : "+area);
	}
}
