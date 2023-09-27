package ddit.chapter07.sec04;

public class Tank extends unit{
	public Tank(int x, int y) {
		super(x,y);
	}
	
	@Override
	void move(int x1, int y1) {
		 System.out.println("("+x+","+y+")에서 ("+(x+x1)+","+(y+y1)+")으로 운전하여 이동");
	}
	
	 void siegeMode() {
	      System.out.println("시즈모드를 사용하다.");
	   }
}
