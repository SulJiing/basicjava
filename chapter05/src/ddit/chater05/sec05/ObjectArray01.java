package ddit.chater05.sec05;
//08.25
// 점의 좌표를 표현하는 클래스(point)를 생성하고 이를 이용하여 삼각형, 사각형, 원의 정보를 출력하시오.
public class ObjectArray01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Point p1 = new Point(100, 200);
//		Point p2 = new Point(600, 200);
//		Point p3 = new Point(350, 500);
//		Triangle t1 = new Triangle(p1,p2,p3); 밑에랑 같음
		Triangle t1 = new Triangle(new Point(100, 200),new Point(600, 200), new Point(350, 500));
		t1.draw();	
		// Point[] point = {}; 밑에 바꾼거 적용하려면
	}
}
class Point{
	private int x; //멤버변수 private는 클래스 안에서만 접근이 가능함
	private int y;
	
	Point(int x, int y){ //(생성자)
		this.x=x; //this는 멤버변수를 부르는 것 메소드 밑의 변수
		this.y=y;
	}
	
	@Override //재정의 / 지금 여기서 얘를 빼면 출력이 주소값으로 나옴
	public String toString() {
		return "("+x+", "+y+")";
	}
	
}
class Triangle{
	Point p1;
	Point p2;
	Point p3;
	//Point [] point = new Point[3];
	
	Triangle(Point p1,Point p2,Point p3){ //(Point[] point
		this.p1=p1;							// this.point=point;
		this.p2=p2;
		this.p3=p3;
	}
	
	public void draw() {
		System.out.println("점"+p1+"에서 점"+p2+"를 drawLine()로 연결한다."); //point[0], point[1]
		System.out.println("점"+p2+"에서 점"+p3+"를 drawLine()로 연결한다."); //point[1], point[2]
		System.out.println("점"+p3+"에서 점"+p1+"를 drawLine()로 연결한다."); //point[2], point[0]
	}
}