package ddit.chater05.sec02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//08.24
public class ArrayExample06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scramble s = new Scramble();
		String choicedWord = s.SelectWord();
		// System.out.println(choicedWord);
		String question = s.Shuffle(choicedWord); // (��)�� ������ �����
		System.out.println("���þ� : " + question);
		System.out.println("--------------------");
		s.inputAnswer(choicedWord);
//		 System.out.println(Arrays.toString(s.word));
	}
}
// ���õ�5���� �ܾ �迭(word)�� �����Ͻÿ�
// "hope", "love", "apple", "pear", "persimmon"
// 1. �� �迭���� ������ �ܾ� ����(selectWord() �żҵ�)
// choicedWord ������ ����
// 2. shuffle �ż��忡�� ���õ� �ܾ��� ���ڵ��� ���´�
// 3. inputAnswer  �ż��忡�� ����ڷκ��� ������ ���� ������ �Է¹޾� ���߸� "�����߽��ϴ�. �õ�Ƚ���� ȸ"
//		Ʋ������ "������ �ƴմϴ�. �ٽ� �õ��ϼ���."�� ��� �� �ٽ� ������ �Է¹޵��� �Ѵ�.
class Scramble {
	String[] word = { "hope", "love", "apple", "pear", "persimmon" };
	Random r = new Random();

	public String SelectWord() {
		int ran = r.nextInt(5);
		// String choicedWord = word[ran];
		return word[ran];

		// System.out.println(choicedWord);
	}

	public String Shuffle(String str) { //str�� choicedword�� ���� ����
		char[] ch = str.toCharArray(); // ���ڿ��� �ڵ����� ���ڹ迭�� ����
//		char[] ch=new char[str.length()];  // ���� ���� ��
//		for (int i =0; i<ch.length; i++) { // ���� ���� ��
//			ch[i] = str.charAt(i); // ���� ���� ��
//		}
		for (int i = 0; i < 100; i++) {
			int rnd = r.nextInt(ch.length);
			char temp = ch[0];
			ch[0] = ch[rnd];
			ch[rnd] = temp;
		} 
		
		return new String(ch); //
	}
	public void inputAnswer(String word) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		while (true) {
			count++;
			System.out.print("���� : ");
			String answer = sc.next();
			if (answer.equals(word)) {
				System.out.println("�����Դϴ�. �õ�Ƚ���� " + count + "ȸ");
				break;
			} else {
				System.out.println("������ �ƴմϴ�. �ٽ� �õ��ϼ���.");
			}
		}
	}
} 