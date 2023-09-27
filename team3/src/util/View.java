package util;

public interface View {
	// �α���,ȸ������,��ȸ��,ȸ��Ż��,���α׷�����
	int HOME = 1;
	int EXIT = 11;

	// ȸ�������� >>> MEMBER_DAO
	int USER_LOGIN = 21;
	int USER_SIGNUP = 22;
	int USER_UNKNOWN = 23;
	int USER_UPDATE = 24;

	// ���α׷� Ȩȭ��
	int UI_HOME = 3;

	// �˻� ����
	int SEARCH = 4;

	// �˻��� ȭ�� >> STORE_DAO
	int STO_SC = 81;
	int STO_TYPE = 82;
	int STO_RANK = 83;

	// ���ã�� ȭ��(��ȸ)>>BOOKMARK_DAO
	int BOOKMARK = 5;
	int BOOKMARK2 = 51;

	// ����� ȭ�� >> REVIEW_DAO >> 1.���亸��(6) 2.���侲��(61)
	// 3. �ڷΰ��� (4��������) 4.Ȩ 5.���α׷�����
	int REVIEW = 6;
	int REVIEW_ADD = 61;

	// ������ >> STORE_DAO
	int ADMIN = 7;
	int ADMIN_ADD = 71;
	int ADMIN_MOD = 72;
	int ADMIN_DEL = 73;

}