package ddit.chater05.sec03;

import java.util.Random;

//08.25
// �ֻ����� 50�� ���� ���� ���� ���� �������� �Ǿ��� ������׷��� �׸��ÿ�.
public class TwoDimArray02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. �ֻ����� 50�� ���� �� ���� ���� ���Ѵ�.
		// 2. �ִ밪�� ���� ���� ���� ����(���� 6���� ����)
		// 3. ���ڹ迭�� ����(���Ǽ��� ������ ���߰� ���� ���� 6��)
		// 4.
		Dice d = new Dice();
		d.setDice();
		char[][] ch = d.convertArray();
		d.showHisto(ch);
	}
}

class Dice {
	int[] dice = new int[6]; // �� ���� ���� ����
	Random rnd = new Random();

	public void setDice() {// �ֻ����� 50�� ���� ���� ���� ���� ����
		for (int i = 0; i < 50; i++) {
			int r = rnd.nextInt(6)+1; //�ֻ��� �ѹ��� ����
			dice[r-1]++; // �ֻ����� ���� ���� Ƚ���� �����ִ� �� = ���� �濡�ٰ� �������ִ� ��
			// ���� ���� �ڵ� dice[r-1]=dice[r-1]+1;
		}
	}

	// ���� ���� ����(�ִ밪) 1���� �迭�� 2���� �迭�� �ٲ�
	public char[][] convertArray() {
		int countOfRow = dice[0]; //�ӽ��ִ밪

		for (int i = 1; i < dice.length; i++) {
			if (countOfRow < dice[i])
				countOfRow = dice[i];
		}

		char[][] histo = new char[countOfRow][6];

		for (int i = 0; i < dice.length; i++) { //dice.length=6
			for (int j = 0; j < dice[i]; j++) { // dice[i] = ù��° ���� ��
				histo[j][i] = '*'; //���� ��� ����
			}
		}return histo;
	}

	// �� ��θ� ����ϸ� ������ �Ʒ��� �������� ������׷��� �׷����� ������ �� �ٲ�� ��
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
