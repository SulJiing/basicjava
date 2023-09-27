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
		String question = s.Shuffle(choicedWord); // (얘)를 가지고 섞어라
		System.out.println("제시어 : " + question);
		System.out.println("--------------------");
		s.inputAnswer(choicedWord);
//		 System.out.println(Arrays.toString(s.word));
	}
}
// 제시된5개의 단어를 배열(word)에 저장하시오
// "hope", "love", "apple", "pear", "persimmon"
// 1. 위 배열에서 임의의 단어 선택(selectWord() 매소드)
// choicedWord 변수에 저장
// 2. shuffle 매서드에서 선택된 단어의 문자들을 섞는다
// 3. inputAnswer  매서드에서 사용자로부터 정답을 맞출 때까지 입력받아 맞추면 "성공했습니다. 시도횟수는 회"
//		틀렸으면 "정답이 아닙니다. 다시 시도하세요."를 출력 후 다시 정답을 입력받도록 한다.
class Scramble {
	String[] word = { "hope", "love", "apple", "pear", "persimmon" };
	Random r = new Random();

	public String SelectWord() {
		int ran = r.nextInt(5);
		// String choicedWord = word[ran];
		return word[ran];

		// System.out.println(choicedWord);
	}

	public String Shuffle(String str) { //str은 choicedword와 같은 것임
		char[] ch = str.toCharArray(); // 문자열을 자동으로 문자배열로 만듦
//		char[] ch=new char[str.length()];  // 위랑 같은 것
//		for (int i =0; i<ch.length; i++) { // 위랑 같은 것
//			ch[i] = str.charAt(i); // 위랑 같은 것
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
			System.out.print("정답 : ");
			String answer = sc.next();
			if (answer.equals(word)) {
				System.out.println("정답입니다. 시도횟수는 " + count + "회");
				break;
			} else {
				System.out.println("정답이 아닙니다. 다시 시도하세요.");
			}
		}
	}
} 