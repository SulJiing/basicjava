package ddit.chap01.homework;
//08.30
public class Rectangle {
	Point p;	//������ ��ǥ��
	int width;	// �غ��� ����
	int height;	// ����

	Rectangle(Point p, int width, int heigth) {//������
		this.p = p;
		this.height = heigth;
		this.width = width;
	}
	
	Point getPoint() { //�簢���� �밢�� ��(������ ���) ��ǥ�� �˱�����
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