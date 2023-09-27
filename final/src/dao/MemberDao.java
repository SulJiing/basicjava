package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class MemberDao {
   private static MemberDao instance = null;
   private MemberDao() {}
   public static MemberDao getInstance() {
   if(instance == null) instance = new MemberDao();
   return instance;
   }
   
   JDBCUtil jdbc = JDBCUtil.getInstance();
   
//   public Map<String, Object> login(String id, Object pass){
////      return jdbc.selectOne("SELECT * FROM MEMBER WHERE MEM_ID = "+id+" AND MEM_PASSWORD = "+password);
//      String sql = "SELECT * FROM MEMBER WHERE MEM_ID = ? AND MEM_PASSWORD = ?";
//      List<Object> param = new ArrayList<Object>();
//      param.add(id);
//      param.add(pass);
//      
//      return jdbc.selectOne(sql, param);
//   }
   
   
   //로그인 
   public Map<String, Object> login(String id, String password){
         return jdbc.selectOne("SELECT * FROM MEMBER WHERE MEM_ID = '"+id+"'AND MEM_PASSWORD = '"+password+"'");
      }

   
   //회원가입
   public int signUp(List<Object> param) {
         return jdbc.update("INSERT INTO MEMBER (MEM_ID, MEM_PASSWORD, MEM_NAME) VALUES (?, ?, ?)", param);
      }
   
//   public int update(String sql, String memID) { 
//      List<Object> param = new ArrayList<Object>();
//      param.add(memID);
//      return jdbc.update(sql, param);
//   }
   
   //회원정보수정
   public int update(String sql) {
      return jdbc.update(sql);
   }
   //회원들의 아이디 정보 가져오기
   public List<Map<String, Object>> getIdlist(String id) {
      String sql = "select mem_id from member where mem_id = '"+id+"'";
      return jdbc.selectList(sql);
   }

}