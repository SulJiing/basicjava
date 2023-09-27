package ddit.chapter07.sec04;
//09.05
public abstract class unit {
	int x;
	int y;
	
	unit(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	abstract void move(int x1, int y1);
	
	void stop() {
		System.out.println("∏ÿ√ﬂ¥Ÿ");
	}
}
