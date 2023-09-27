package dao;

import java.util.List;
import java.util.Map;

import controller.Controller;
import util.JDBCUtil;

public class BookmarkDao {
//   private static final int Object = 0;
   private static BookmarkDao instance;
   JDBCUtil jdbc = JDBCUtil.getInstance();

   private BookmarkDao() {
   }

   public static BookmarkDao getInstance() {
      if (instance == null) {
         instance = new BookmarkDao();
      }
      return instance;
   }

   /*
    * public List<Map<String, Object>> myBookmark() {
    * 
    * String id = (String) Controller.sessionStorage.get("MEM_ID"); String sql =
    * "SELECT s.STO_NAME FROM bookmark b JOIN store s ON b.STO_NO = s.STO_NO WHERE b.MEM_ID = '"
    * +id+"'";
    * 
    * return jdbc.selectList(sql); }
    */
   public List<Map<String, Object>> myBookmark() {
      String id = (String) Controller.sessionStorage.get("MEM_ID");
      String sql = "SELECT s.STO_NAME, b.STO_NO FROM BOOKMARK b JOIN STORE s ON b.STO_NO = s.STO_NO WHERE b.MEM_ID = '" + id
            + "'";
      return jdbc.selectList(sql);
   }

   public int addBookmark(String STO_NO) {
      String id = (String) Controller.sessionStorage.get("MEM_ID");
      String sql = "INSERT INTO bookmark(STO_NO, MEM_ID) VALUES (lpad('" + STO_NO + "',4,0), '" + id + "')";
      return jdbc.update(sql);
   }

   public int removeBookmark(String STO_NO) {
      String id = (String) Controller.sessionStorage.get("MEM_ID");    
      String sql = "DELETE FROM bookmark WHERE MEM_ID = '" + id + "' AND STO_NO = lpad('" + STO_NO + "',4,0)";
      return jdbc.update(sql);
   }

}