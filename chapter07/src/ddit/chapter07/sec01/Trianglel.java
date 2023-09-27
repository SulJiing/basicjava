package ddit.chapter07.sec01;
//09.01
public class Trianglel extends Shape{
	int width;
	int height;
		
	Trianglel(String kind, int width, int height){
		super(kind);
		this.width=width;
		this.height=height;
	}
		
	@Override
	public void getArea() {
		System.out.println(kind+"≥–¿Ã : "+(width*height)/2);
	}
}
