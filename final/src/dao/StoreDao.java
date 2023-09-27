package dao;

/*import java.util.ArrayList;
import java.util.Collections;*/
import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import util.ScanUtil;

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

	/*
	 * // Controller > Service > Dao > Database // Controller < Service < Dao <
	 * Database
	 * 
	 * // Store로 부터 모든 데이터를 끌고온다. // public List<Map<String, Object>> list() { // //
	 * String sql = "SELECT * FROM STORE ORDER BY STO_NO"; // 쿼리를 만들어준다 // // String
	 * sql =
	 * "select a.sto_name , b.type_name, a.sto_rank, a.sto_time, a.sto_distance, a.sto_tel , a.sto_address, a.sto_reservation from store a, type b where a.type_no = b.type_no order by a.sto_distance"
	 * ; // return jdbc.selectList(sql); // }
	 * 
	 * // public List<Map<String, Object>> list() { // String sql =
	 * "select * from store";
	 *///      return jdbc.selectList(sql);
//   }
	// searchHome()
	public List<Map<String, Object>> list() {
		String sql = "select a.sto_no, a.sto_name , b.type_name, a.sto_rank, a.sto_time, a.sto_distance, a.sto_tel , "
				+ "a.sto_address, a.sto_reservation from store a, type b "
				+ "where a.type_no = b.type_no order by a.sto_no";

		return jdbc.selectList(sql);
	}
   /*public List<Map<String, Object>> listMenuForStore(List<Object> storeName) {
	    String sql = "SELECT A.STO_NAME, B.MENU_NAME, B.MENU_PRICE FROM STORE A " +
	                 "INNER JOIN MENUPAN C ON A.STO_NO = C.STO_NO " +
	                 "INNER JOIN MENU B ON B.MENU_NO = C.MENU_NO " +
	                 "WHERE A.STO_NAME = ? " +
	                 "ORDER BY A.STO_NAME";
	    return jdbc.selectList(sql, storeName);
	    }
    */
	// listStoreName()
	public List<Map<String, Object>> list3(String b) {
		while (true) {
			String sql = "SELECT a.*, b.TYPE_NAME FROM store a JOIN type b ON a.TYPE_NO = b.TYPE_NO WHERE a.STO_NAME LIKE ?";

		List<Map<String, Object>> result = jdbc.selectList(sql, "%" + b + "%");

			if (result != null && !result.isEmpty()) {
				return result;
			} else {
				System.out.println("가게를 찾을 수 없습니다.");
				System.out.print("가게명 다시입력>> ");
				b = ScanUtil.nextLine();
			}
		}
	}
	// typeSC()
	public List<Map<String, Object>> list2(String a) {
		String sql = "select a.sto_name from store a, type b " + "where a.type_no = b.type_no and TYPE_NAME = '" + a
				+ "' order by a.sto_name";
		return jdbc.selectList(sql);
	}
	// stoRank()
	public List<Map<String, Object>> listRank(int minRating) {
		String sql = "SELECT STO_NAME, STO_RANK FROM STORE WHERE STO_RANK >= " + minRating + " ORDER BY STO_RANK";
		return jdbc.selectList(sql);
	}
	// listMenuFor(String storeName)
	public List<Map<String, Object>> listMenuForStore(String storeName) {

		String sql = "SELECT B.STO_NAME, C.MENU_PRICE, C.MENU_NAME FROM MENUPAN A INNER JOIN STORE B ON A.STO_NO = B.STO_NO INNER JOIN MENU C ON A.MENU_NO = C.MENU_NO WHERE B.STO_NAME LIKE ?";

		return jdbc.selectList(sql,"%" + storeName + "%");
	}

}