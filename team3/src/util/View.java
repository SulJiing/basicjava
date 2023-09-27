package util;

public interface View {
	// 로그인,회원가입,비회원,회원탈퇴,프로그램종료
	int HOME = 1;
	int EXIT = 11;

	// 회원정보단 >>> MEMBER_DAO
	int USER_LOGIN = 21;
	int USER_SIGNUP = 22;
	int USER_UNKNOWN = 23;
	int USER_UPDATE = 24;

	// 프로그램 홈화면
	int UI_HOME = 3;

	// 검색 메인
	int SEARCH = 4;

	// 검색단 화면 >> STORE_DAO
	int STO_SC = 81;
	int STO_TYPE = 82;
	int STO_RANK = 83;

	// 즐겨찾기 화면(조회)>>BOOKMARK_DAO
	int BOOKMARK = 5;
	int BOOKMARK2 = 51;

	// 리뷰단 화면 >> REVIEW_DAO >> 1.리뷰보기(6) 2.리뷰쓰기(61)
	// 3. 뒤로가기 (4번단으로) 4.홈 5.프로그램종료
	int REVIEW = 6;
	int REVIEW_ADD = 61;

	// 관리단 >> STORE_DAO
	int ADMIN = 7;
	int ADMIN_ADD = 71;
	int ADMIN_MOD = 72;
	int ADMIN_DEL = 73;

}