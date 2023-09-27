package ddit.chapter07.sec04;
//09.05
public abstract class GraphicalObject {
	int x,y;
	
	void moveTo(int newX, int newY) {
		System.out.println("newX, newY로 이동하다");
	}
	
	abstract void draw();
	abstract void resize();
}

class Circle extends GraphicalObject{
	@Override
	void draw() {
		System.out.println("원을 그리다");
	}
	@Override
	void resize(){
		
	}
}

class Line extends GraphicalObject{

	@Override
	void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void resize() {
		// TODO Auto-generated method stub
		
	}
	
}

