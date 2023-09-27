package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class StoreDao {
	private static StoreDao instance = null;

	private StoreDao() {
	}

	// 싱글톤
	public static StoreDao getInstance() {
		if (instance == null) {
			instance = new StoreDao();
		}
		return instance;
	}

	// JdbvUtil 생성
	JDBCUtil jdbc = JDBCUtil.getInstance();

	// Controller > Service > Dao > Database
	// Controller < Service < Dao < Database

	// Store로 부터 모든 데이터를 끌고온다.
//   public List<Map<String, Object>> list() {
//      // String sql = "SELECT * FROM STORE ORDER BY STO_NO"; // 쿼리를 만들어준다
//
//      String sql = "select a.sto_name , b.type_name, a.sto_rank, a.sto_time, a.sto_distance, a.sto_tel , a.sto_address, a.sto_reservation from store a, type b where a.type_no = b.type_no order by a.sto_distance";
//      return jdbc.selectList(sql);
//   }

//   public List<Map<String, Object>> list() {
//	   String sql = "select * from store";
//	   return jdbc.selectList(sql);
//   }

	public List<Map<String, Object>> list() {
		String sql = "select a.sto_name , b.type_name, a.sto_rank, a.sto_time, a.sto_distance, a.sto_tel , "
				+ "a.sto_address, a.sto_reservation from store a, type b "
				+ "where a.type_no = b.type_no order by a.sto_distance";
		return jdbc.selectList(sql);
	}

	public List<Map<String, Object>> list3(String b) {
		String sql = "SELECT a.*, b.TYPE_NAME FROM store a JOIN type b ON a.TYPE_NO = b.TYPE_NO WHERE a.STO_NAME LIKE '%"
				+ b + "%'";
		// String sql = "select * from store where STO_NAME like '%"+b+"%'";
		return jdbc.selectList(sql);
	}

	public List<Map<String, Object>> list2(String a) {
		String sql = "select a.sto_name from store a, type b " + "where a.type_no = b.type_no and TYPE_NAME = '" + a
				+ "' order by a.sto_name";
		return jdbc.selectList(sql);
	}

	public List<Map<String, Object>> listRank(int minRating) {
		String sql = "SELECT STO_NAME FROM STORE WHERE STO_RANK >= '" + minRating + "' ";
		return jdbc.selectList(sql, minRating);
	}
}
