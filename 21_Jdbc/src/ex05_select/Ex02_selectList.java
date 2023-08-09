package ex05_select;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.DB_Connect;
import dto.UserDto;

public class Ex02_selectList {
  
  // select 결과 행이 여러 개인 경우

  public static void main(String[] args) {
  
    // Connection 객체 선언
    Connection conn = null;
    
    // PreparedStatement 객체 선언 (쿼리문 실행)
    PreparedStatement ps = null;
    
    // ResultSet 객체 선언
    ResultSet rs = null;
    
    try {
      
      // Connection 객체 생성 (DB_Connect 클래스의 getConnection 메소드로부터 받아오기)
      conn = DB_Connect.getConnection();
      
      // 쿼리문
      String sql = "";
      sql += "SELECT USER_NO, USER_ID, USER_NAME, JOINED_AT";
      sql += "  FROM USER_T";
      sql += " ORDER BY USER_NO";
      
      // PreparedStatement 객체 생성
      ps = conn.prepareStatement(sql);
      
      // 쿼리문 실행
      rs = ps.executeQuery();
      
      // 검색 결과를 저장할 List<UserDto> 생성
      List<UserDto> users = new ArrayList<UserDto>();
      
      // 검색 결과가 여러 개인 경우 while문을 이용해서 검색 결과가 있는지 여러 번 체크한다.
      while(rs.next()) {
        
        // 검색 결과 행(Row)1ro -> UserDto 객체 생성
        UserDto user = new UserDto();
        user.setUser_no(rs.getInt(1));
        user.setUser_id(rs.getString(2));
        user.setUser_name(rs.getString(3));
        user.setJoined_at(rs.getDate(4));
        
        //UserDto 객체 -> List<UserDto> 추가
        users.add(user);
      }
      
      // 결과 확인
      for(UserDto user : users) {
        System.out.println(user);
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(rs != null) rs.close();
        if(ps != null) ps.close();
        if(conn != null) conn.close();
      } catch(SQLException e) {
        e.printStackTrace();
      }
    }
    
  }

}
