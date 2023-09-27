package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class BookmarkDao {
//   private static final int Object = 0;
   private static BookmarkDao instance;
   private JDBCUtil jdbc = JDBCUtil.getInstance();

   private BookmarkDao() {
   }

   public static BookmarkDao getInstance() {
      if (instance == null) {
         instance = new BookmarkDao();
      }
      return instance;
   }

   // 음식점을 즐겨찾기에 추가하는 메서드
   public int addBookmark(String STO_NO, String MEM_ID) {
      String sql = "INSERT INTO bookmark(STO_NO, MEM_ID) VALUES (?, ?)";
      List<Object> params = new ArrayList<>();
      params.add(STO_NO);
      params.add(MEM_ID);
      return jdbc.update(sql, params);
   }

   // 특정 사용자의 모든 즐겨찾기 목록을 가져오는 메서드
   public List<Map<String, Object>> getAllBookmarks(String MEM_ID) {
      String sql = "SELECT * FROM bookmark WHERE MEM_ID = ?";
      List<Object> params = new ArrayList<>();
      params.add(MEM_ID);
      
      
      //수정해야함return jdbc.selectList(sql, params);
      return null;
   }

   // 특정 사용자의 즐겨찾기에서 특정 음식점을 삭제하는 메서드
   public int removeBookmark(String MEM_ID, String STO_NO) {
      String sql = "DELETE FROM bookmark WHERE MEM_ID = ? AND STO_NO = ?";
      List<Object> params = new ArrayList<>();
      params.add(STO_NO);
      params.add(MEM_ID);
      return jdbc.update(sql, params);
   }
}