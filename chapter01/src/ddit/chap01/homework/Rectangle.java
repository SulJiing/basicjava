package ddit.chap01.homework;
//08.30
public class Rectangle {
	Point p;	//원점의 좌표값
	int width;	// 밑변의 길이
	int height;	// 높이

	Rectangle(Point p, int width, int heigth) {//생성자
		this.p = p;
		this.height = heigth;
		this.width = width;
	}
	
	Point getPoint() { //사각형의 대각선 쪽(오른쪽 상단) 좌표를 알기위함
		int x1 = p.x+width;
		int y1 = p.y+height;
		return new Point(x1, y1);
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}