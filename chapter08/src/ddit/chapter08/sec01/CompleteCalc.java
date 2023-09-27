package ddit.chapter08.sec01;
//09.07.1
public class CompleteCalc extends Calc implements Circle{
	int radius;
	
	public CompleteCalc(int radius) {
		this.radius=radius;
	}
	
	@Override
	public long times(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1*num2;
	}

	@Override
	public double devide(int num1, int num2) {
		// TODO Auto-generated method stub
		return (double)num1/num2;
	}
	
	public double getArea() {
		return radius*radius*PI;
	}
	
}
