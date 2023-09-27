package ddit.chater05.sec03;
//08.24
public class TwoDimArray01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tarryMethod01();
	}

	public static void tarryMethod01() {
//		5명의 이름(홍길동, 정몽주, 강감찬, 김유신, 이순신)과 -name
//		3과목의 성적을 배열처리하고자 한다. -score
//		 이름		국어		산수		사회
//		홍길동	80		75		80
//		정몽주	90		85		90
//		강감찬	90		90		80
//		김유신	80		70		70
//		이순신	70		95		70
//		배열을 생성하시오.
		String[] name = { "홍길동", "정몽주", "강감찬", "김유신", "이순신" }; // 1차원배열
		int[][] score = { { 80, 75, 80, 0, 0, 1 }, 
						  { 90, 85, 90, 0, 0, 1 }, 
				          { 90, 90, 80, 0, 0, 1 },
				          { 80, 70, 70, 0, 0, 1 }, 
				          { 70, 95, 70, 0, 0, 1 } }; //2차원배열
		//총점및평균
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < 3; j++) {
				score[i][3] = score[i][3] + score[i][j]; // 총점
			}
			score[i][4] = score[i][3] / 3; // 평균
		}
		//등수구하기
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score.length; j++) {
				if (score[i][3] < score[j][3]) { //총점<다음사람의 점수
					score[i][5]++;
				}
			}
		}
		//등수 오름차순
		for (int i = 0; i < score.length -1; i++) {
        for (int j = i + 1; j < score.length; j++) {
            if (score[i][5] > score[j][5]) { // 등수 오름차순 정렬
                int[] temp = score[i];
                score[i] = score[j];
                score[j] = temp;
                String stp = name[i];
                name[i] = name[j]; 
                name[j]= stp; 
                	
            }
        }
    }
		// 출력
		for (int i = 0; i < score.length; i++) {
			System.out.print(name[i] + "   ");
			for (int j = 0; j < score[i].length; j++) {
				System.out.printf("%-5d", score[i][j]); // i랑 j는 행열을 뜻 함
			}
			System.out.println();
		}

	}

}
