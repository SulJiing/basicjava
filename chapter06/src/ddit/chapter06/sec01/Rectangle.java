package ddit.chapter06.sec01;
//08.28
public class Rectangle {
	int width = 500; // �����ʱ�ȭ
	int height = 1000;
	// �ʱ�ȭ ���
	{ 
		width = 10;
		height = 30;
	}

	// ������ �޼ҵ� - �پ��� �ʱ�ȭ
	Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	// ���̸� ����� �� ����ϴ� �޼ҵ�
	public void getArea() {
		int area = width*height;
		System.out.println("���� : "+area);
	}
}
