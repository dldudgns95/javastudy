package ex04_delete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import connect.DB_Connect;

public class MainWrapper {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    System.out.print("삭제할 USER_NO >>> ");
    int user_no = sc.nextInt();
    sc.close();
    
    Connection conn = null;
    PreparedStatement ps = null;
    
    int result = 0;
    
    try {
      
      conn = DB_Connect.getConnection();
      
      String sql = "";
      sql += "DELETE FROM USER_T";
      sql += " WHERE USER_NO = ?";
      
      ps = conn.prepareStatement(sql);
      ps.setInt(1, user_no);
      
      result = ps.executeUpdate();
      
      
      
      
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(ps != null) ps.close();
        if(conn != null) conn.close();
      } catch(SQLException e) {
        e.printStackTrace();
      }
    }
    
    System.out.println(result + "행이 삭제되었습니다.");
    
  }

}
