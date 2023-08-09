package ex02_insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import connect.DB_Connect;
import dto.UserDto;

public class MainWrapper {
  
  // 참조 : https://recollectionis.tistory.com/161
  // SQL 실행하기 전 'Data Source Explorer' - 'Database Connections' 연결 확인
  
  public static void main(String[] args) {
    
    // User 정보 입력
    Scanner sc = new Scanner(System.in);
    System.out.print("USER_ID >>> ");
    String user_id = sc.next();
    sc.nextLine();
    System.out.print("USER_NAME >>> ");
    String user_name = sc.nextLine();
    sc.close();
    // UserDto 생성
    UserDto user = new UserDto();
    user.setUser_id(user_id);
    user.setUser_name(user_name);
    
    // Connection 객체 선언 (DB 접속)
    Connection conn = null;
    
    // PreparedStatement 객체 선언 (쿼리문 실행)
    PreparedStatement ps = null;
    
    try {
      
      // Connection 객체 생성 (DB_Connect 클래스의 getConnection 메소드로부터 받아오기)
      conn = DB_Connect.getConnection();
      
      // 쿼리문
      String sql = "";
      sql += "INSERT INTO USER_T (USER_NO, USER_ID, USER_NAME, JOINED_AT) ";
      sql += "VALUES (USER_SEQ.NEXTVAL, ?, ?, SYSDATE)";
      
      // PreparedStatement 객체 생성
      ps = conn.prepareStatement(sql);
      
      // 쿼리문에 변수 넣기
      ps.setString(1, user.getUser_id());   // 1번째 물음표 <- user객체의 user_id
      ps.setString(2, user.getUser_name()); // 2번째 물음표 <- user객체의 user_name
      
      //쿼리문 실행 : insert된 행의 개수가 반환된다.
      int insertResult = ps.executeUpdate();
      
      // 결과 확인
      System.out.println(insertResult + "개의 행이 삽입되었습니다.");
      
      // 커밋은 안 한다.
      // con.setAutoCommit(true); <- 기본값으로 사용되고 있다.
      
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(ps != null)ps.close();
        if(conn != null) conn.close();
      } catch(SQLException e) {
        e.printStackTrace();
      }
    }
    
  }

}
