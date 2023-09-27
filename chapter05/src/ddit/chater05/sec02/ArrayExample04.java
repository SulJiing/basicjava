package ddit.chater05.sec02;

import java.util.Arrays;

//08.24
public class ArrayExample04 {

	public static void main(String[] args) {
		// 주사위를 50번 던져 나온 눈의 수를 조사하여 히스토그램을 작성하시오.
		Dice d = new Dice();
		System.out.println(Arrays.toString(d.dice));
		d.histogram();
	}
	

}
class Dice{
	int [] dice = new int [6];
	
	Dice() {
		for(int i= 0; i<50; i++) {
			int r = (int)(Math.random()*6)+1; // 1에서 6사이의 난수
			dice[r-1]++; //핵심  주사위 눈의 빈도를 증가시킴 012345
		}
	}
	
	public void histogram() {
		for (int i =0; i<dice.length; i++) {
			System.out.print((i+1)+"|");
			for (int j = 0; j<dice[i]; j++) {
				System.out.print("#");
			}
			System.out.println(" "+dice[i]);
		}
	}
}
