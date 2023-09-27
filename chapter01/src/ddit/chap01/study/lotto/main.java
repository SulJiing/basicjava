package ddit.chap01.study.lotto;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Person person = new Person();
		person.name="¹é¿µ¿õ";
		person.buyLotto(7000);
		person.lottoPrint();
	}
	
}
