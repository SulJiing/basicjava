package ddit.chater05.sec03;

import java.util.Random;

//08.25
// 주사위를 50번 던져 나온 눈의 수로 수직으로 되어진 히스토그램을 그리시오.
public class TwoDimArray02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 주사위를 50번 던져 각 눈의 수를 구한다.
		// 2. 최대값을 구해 행의 수로 설정(열은 6으로 고정)
		// 3. 문자배열을 생성(행의수는 위에서 구했고 열의 수는 6임)
		// 4.
		Dice d = new Dice();
		d.setDice();
		char[][] ch = d.convertArray();
		d.showHisto(ch);
	}
}

class Dice {
	int[] dice = new int[6]; // 각 눈의 수를 저장
	Random rnd = new Random();

	public void setDice() {// 주사위를 50번 던져 나온 눈의 수를 구함
		for (int i = 0; i < 50; i++) {
			int r = rnd.nextInt(6)+1; //주사위 한번을 던짐
			dice[r-1]++; // 주사위의 눈이 나온 횟수를 더해주는 것 = 누적 방에다가 저장해주는 것
			// 위와 같은 코드 dice[r-1]=dice[r-1]+1;
		}
	}

	// 행의 수를 구함(최대값) 1차원 배열을 2차원 배열로 바꿈
	public char[][] convertArray() {
		int countOfRow = dice[0]; //임시최대값

		for (int i = 1; i < dice.length; i++) {
			if (countOfRow < dice[i])
				countOfRow = dice[i];
		}

		char[][] histo = new char[countOfRow][6];

		for (int i = 0; i < dice.length; i++) { //dice.length=6
			for (int j = 0; j < dice[i]; j++) { // dice[i] = 첫번째 눈의 값
				histo[j][i] = '*'; //행이 계속 변함
			}
		}return histo;
	}

	// 위 대로만 출력하면 위에서 아래로 내려오는 히스토그램이 그려지기 때문에 또 바꿔야 함
	public void showHisto(char[][] ch) {
		for (int i = ch.length - 1; i >= 0; i--) {
			if((i+1)%5==0 ) {
				System.out.print((i+1)+"\t");
			}else {
				System.out.print("|\t");
			}
			for (int j = 0; j < ch[i].length; j++) {
				System.out.print(ch[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("--------------------------------------------------");
		System.out.print(" \t");
		for (int i = 1; i < 7; i++) {
			System.out.print(i + "\t");

		}
	}
}
