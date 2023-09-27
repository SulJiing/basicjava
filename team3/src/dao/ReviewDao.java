package dao;

import java.util.List;
import java.util.Map;

import controller.Controller;
import util.JDBCUtil;

public class ReviewDao {
   private static ReviewDao instance = null;

   private ReviewDao() {
   }

   public static ReviewDao getInstance() {
      if (instance == null)
         instance = new ReviewDao();
      return instance;
   }

   JDBCUtil jdbc = JDBCUtil.getInstance();

   public List<Map<String, Object>> allReview() {
      String sql = "select a.REVIEW_NO, b.STO_NAME, a.STO_NO, a.MEM_ID, a.RVW_SCORE, a.RVW_REMARK  from review a, store b where a.STO_NO = b.STO_NO order by a.review_no";
      return jdbc.selectList(sql);
   }

   public List<Map<String, Object>> myReview() {

      String id = (String) Controller.sessionStorage.get("MEM_ID");
      String sql = "select a.REVIEW_NO, b.STO_NAME, a.STO_NO, a.MEM_ID, a.RVW_SCORE, a.RVW_REMARK  from review a, store b where a.STO_NO = b.STO_NO and a.MEM_ID = '"
            + id + "'";
      return jdbc.selectList(sql);
   }

   public int writeReview(String no, String score, String remark) {

      String id = (String) Controller.sessionStorage.get("MEM_ID");
      String sql = "insert into review (sto_no, rvw_score, rvw_remark, review_no, mem_id) values(lpad('" + no + "',4,0), '"
            + score + "', '" + remark + "', (select max(review_no) from review)+1, '" + id + "') ";
      return jdbc.update(sql);
   }
   
   public List<Map<String, Object>> stoReview(String no) {
      String sql = "select b.sto_name, a.rvw_score, a.rvw_remark from review a, store b\r\n" + 
            "where a.sto_no = b.sto_no and a.sto_no = lpad('"+no+"',4,0)";
      return jdbc.selectList(sql);
   }
   
   public List<Map<String, Object>> storeNoList(String no) {
      String sql = "select sto_no from store where sto_no = lpad('" + no + "',4,0)";
      return jdbc.selectList(sql);
   }
   
   public int updateStoRank() {
         String sql = "UPDATE STORE s SET s.STO_RANK = (SELECT AVG(r.RVW_SCORE) FROM REVIEW r WHERE r.STO_NO = s.STO_NO)\r\n" + 
               "WHERE s.STO_NO IN (SELECT DISTINCT r.STO_NO FROM REVIEW r WHERE r.RVW_SCORE IS NOT NULL)";
         return jdbc.update(sql);

      }

}