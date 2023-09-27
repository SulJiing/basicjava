package kr.or.ddit.study.lotto;

import java.util.Arrays;

public class Lotto {
	
	public static void main(String[] args) {
		Lotto l = new Lotto();
		int bundle [][][] = l.buyLottoBundle(7);
		l.printLotto(bundle);
	}
	
	
	public void printLotto(int[][][] buyLottoBundle) {
		for(int paper[][] : buyLottoBundle) {
			System.out.println("-----------------------------------------------------");
			for(int line[] : paper) {
				System.out.print("[");
				for(int number : line) {
					System.out.print(number +"\t");
				}
				System.out.print("]");
				System.out.println();
			}
			System.out.println("-----------------------------------------------------");
			System.out.println();
		}
	}
	
	public int[] generateLotto() {
		int lotto[] = new int[6];
		for(int i=0; i<6;i++) {
			int ran = (int)(Math.random()*45)+1;
			lotto[i] = ran;
			for(int j=0; j<i; j++) {
				if(lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}
		Arrays.sort(lotto);
		return lotto;
	}
	
	public int[][] buyLottoPaper(){
		
		return buyLottoPaper(5);
	}
	
	public int[][] buyLottoPaper(int num){
		
		int[][] lottoBundle = new int[num][6];
		for(int i=0; i<lottoBundle.length; i++) {
			
			lottoBundle[i] = generateLotto();
		}
		return lottoBundle;
	}
	
	public int[][][] buyLottoBundle(int num){
		int paper = num/5;
		if(num%5 !=0) paper++;  
		
		int[][][] lottoBundle = new int[paper][5][6];
		for(int i=0; i<paper; i++) {
			lottoBundle[i] = buyLottoPaper();
		}
		if(num%5 !=0) {
			lottoBundle[paper-1] = buyLottoPaper(num%5);
		}
		return lottoBundle;
	}
	
}
