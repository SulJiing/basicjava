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

   // �������� ���ã�⿡ �߰��ϴ� �޼���
   public int addBookmark(String STO_NO, String MEM_ID) {
      String sql = "INSERT INTO bookmark(STO_NO, MEM_ID) VALUES (?, ?)";
      List<Object> params = new ArrayList<>();
      params.add(STO_NO);
      params.add(MEM_ID);
      return jdbc.update(sql, params);
   }

   // Ư�� ������� ��� ���ã�� ����� �������� �޼���
   public List<Map<String, Object>> getAllBookmarks(String MEM_ID) {
      String sql = "SELECT * FROM bookmark WHERE MEM_ID = ?";
      List<Object> params = new ArrayList<>();
      params.add(MEM_ID);
      
      
      //�����ؾ���return jdbc.selectList(sql, params);
      return null;
   }

   // Ư�� ������� ���ã�⿡�� Ư�� �������� �����ϴ� �޼���
   public int removeBookmark(String MEM_ID, String STO_NO) {
      String sql = "DELETE FROM bookmark WHERE MEM_ID = ? AND STO_NO = ?";
      List<Object> params = new ArrayList<>();
      params.add(STO_NO);
      params.add(MEM_ID);
      return jdbc.update(sql, params);
   }
}