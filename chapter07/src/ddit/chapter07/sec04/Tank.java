package ddit.chapter07.sec04;

public class Tank extends unit{
	public Tank(int x, int y) {
		super(x,y);
	}
	
	@Override
	void move(int x1, int y1) {
		 System.out.println("("+x+","+y+")���� ("+(x+x1)+","+(y+y1)+")���� �����Ͽ� �̵�");
	}
	
	 void siegeMode() {
	      System.out.println("�����带 ����ϴ�.");
	   }
}
