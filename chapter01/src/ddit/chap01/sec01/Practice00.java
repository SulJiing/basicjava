package ddit.chap01.sec01;

import java.util.Arrays;

// 1. �������� - �迭���� - ������ ���������� ���� ���� �� ���
// 2. ������ ���� - �迭���� - ������ ���������� ���� ���� �� ���
public class Practice00 {

	public static void main(String[] args) {
		int [] s = {20,50,90,40,30};
		for (int i=0; i<s.length-1; i++) {
			for (int j = i+1; j<s.length; j++) {
				if(s[i]>s[j]) {
					int t = s[i];
					s[i] = s[j];
					s[j]= t; 
				}
			}
		}System.out.println(Arrays.toString(s));
	}

}


// 1. ����
//int[] b = { 10, 9, 80, 34, 52 };
//for (int i = 0; i < b.length - 1; i++) {
//	for (int j = 0; j < b.length - 1 - i; j++) {
//		if (b[j] > b[j + 1]) {
//			int t = b[j];
//			b[j] = b[j + 1];
//			b[j + 1] = t;
//		}
//	}
//}
//System.out.println(Arrays.toString(b));
