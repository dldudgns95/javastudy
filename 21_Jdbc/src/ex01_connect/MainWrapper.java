package ex01_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainWrapper {

  // C:\app\GDJ69\product4\dbhomeXE\jdbc\lib\ojdbc8.jar 파일 buildpath하기
  
  // 1. oracle.jdbc.OracleDriver 클래스 Load
  public static void ex01() {
    try {
      Class.forName("oracle.jdbc.OracleDriver");
    } catch (ClassNotFoundException e) {
      System.out.println("OracleDriver 클래스가 없다.");
    }
  }
  // 2. java.sql.Connection 객체 생성 (DB 접속 생성)
  public static void ex02() {
    
    // 접속 정보
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user = "GD";
    String password = "1111";
    
    // Connection 객체 선언
    Connection conn = null;
    
    // Connection 객체 생성
    try {
      conn = DriverManager.getConnection(url, user, password);
      System.out.println("DB 접속 성공");
    } catch(SQLException e) {
      System.out.println("DB 접속 실패");
    } finally {
      // Connection 객체 닫기
      try {
        if(conn != null) conn.close();
      } catch(SQLException e) {
        System.out.println("DB 접속 닫기 실패");
      }
    }
  }
  
  // 3. 접속 정보를 별도의 파일(프로퍼티 파일)에 저장 (.gitignore 대비)
  
  public static void main(String[] args) {
    ex01();
    ex02();
    
    
  }

}
