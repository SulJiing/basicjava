package util;

public interface View {
	int HOME = 1;
	int MAIN = 11;
	// 멤버 담당 팀원
	int MEMBER = 2;
	int MEMBER_SIGNUP = 21;
	int MEMBER_LOGIN = 22;
	int MEMBER_RESIGN = 23;
	int MEMBER_UPDATE = 24;
	
	// 보드 담당 팀원
	int BOARD = 3;
	int BOARD_LIST = 31;
	int BOARD_DETAIL = 32;
	int BOARD_INSERT = 33;
	int BOARD_UPDATE = 34;
	int BOARD_DELETE = 35;
	
	// 이태영 - 자유게시판
	int FREE = 4;
	int FREE_LIST = 41;
	int FREE_DETAIL = 42;
	int FREE_INSERT = 43;
	int FREE_UPDATE = 44;
	int FREE_DELETE = 45;

	// 테스트 게시판
	int TEST = 5;
	int TEST_LIST = 51;
}
