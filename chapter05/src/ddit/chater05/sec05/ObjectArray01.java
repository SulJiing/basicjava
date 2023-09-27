package ddit.chater05.sec05;
//08.25
// ���� ��ǥ�� ǥ���ϴ� Ŭ����(point)�� �����ϰ� �̸� �̿��Ͽ� �ﰢ��, �簢��, ���� ������ ����Ͻÿ�.
public class ObjectArray01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Point p1 = new Point(100, 200);
//		Point p2 = new Point(600, 200);
//		Point p3 = new Point(350, 500);
//		Triangle t1 = new Triangle(p1,p2,p3); �ؿ��� ����
		Triangle t1 = new Triangle(new Point(100, 200),new Point(600, 200), new Point(350, 500));
		t1.draw();	
		// Point[] point = {}; �ؿ� �ٲ۰� �����Ϸ���
	}
}
class Point{
	private int x; //������� private�� Ŭ���� �ȿ����� ������ ������
	private int y;
	
	Point(int x, int y){ //(������)
		this.x=x; //this�� ��������� �θ��� �� �޼ҵ� ���� ����
		this.y=y;
	}
	
	@Override //������ / ���� ���⼭ �긦 ���� ����� �ּҰ����� ����
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
		System.out.println("��"+p1+"���� ��"+p2+"�� drawLine()�� �����Ѵ�."); //point[0], point[1]
		System.out.println("��"+p2+"���� ��"+p3+"�� drawLine()�� �����Ѵ�."); //point[1], point[2]
		System.out.println("��"+p3+"���� ��"+p1+"�� drawLine()�� �����Ѵ�."); //point[2], point[0]
	}
}