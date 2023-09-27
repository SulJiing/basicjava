package service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dao.FreeBoardDAO;
import util.ScanUtil;
import util.View;

public class FreeBoardService {
	// 1. 싱글톤 만들기
	private static FreeBoardService instance = null;
	private FreeBoardService() {}
	public static FreeBoardService getInstance() {
		if(instance == null) 
			instance = new FreeBoardService();
		return instance;
	}
	
	// 2. DAO 호출하기 위한 길 만들기
	FreeBoardDAO dao = FreeBoardDAO.getInstance();
	
	// 자유게시판 전체 리스트 조회
	// int의 역할은 페이지번호
	public int list(){
		int result = 0;
		// 전체 리스트 조회하기 위한 조건
		// 전체리스트 조회를 하기위한 쿼리를 생각
		// select * from freeboard
		// 1. 파라미터가 필요합니까? 필요없음
		// 2. 쿼리는 어떻게되지?
		//   - select * from freeboard
		// 3. 결과를 어떻게 받지?
		// Dao에서 넘겨준 결과는 아래 타입으로 받는다.
		//   - List<Map<String, Object>> 
		List<Map<String, Object>> freeBoardList = dao.list();
		
		// 최종 데이터를 출력
		for (int i = 0; i < freeBoardList.size(); i++) {
			Map<String, Object> map = freeBoardList.get(i);
//			System.out.print(map.get("BO_NO") + " " + map.get("BO_TITLE") + " " + map.get("BO_CONTENT"));
			System.out.print(map.get("BO_NO") + " " + map.get("BO_TITLE"));
			System.out.println();
		}
		
		System.out.println();
		System.out.println("다음은 무슨 메뉴를 선택할거예요? >>> ");
		System.out.println("1. 홈으로가기 2. 상세 조회하기");
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		switch (input) {
		case 1:
			System.out.println("홈으로가기 클릭!");
			result = View.HOME;
			break;
		case 2:
			detailList();
			break;
		default:
			break;
		}
		return result; 
	}
	public void detailList() {
		System.out.print("게시글번호 선택 >> ");
		String bo_no = ScanUtil.nextLine();
		Map<String,Object> result = dao.list(bo_no);
		System.out.println("---------------상세보기---------------");
		System.out.println(result.get("BO_NO") + " " + result.get("BO_TITLE")+ " " + result.get("BO_CONTENT"));
		System.out.println("------------------------------------");
	}
}
