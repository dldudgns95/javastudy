package ex03_update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import connect.DB_Connect;

public class MainWrapper {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    System.out.print("수정할 USER_NO >>> ");
    int user_no = sc.nextInt();
    System.out.print("수정할 USER_NAME >>> ");
    String user_name = sc.next();
    sc.close();
    
    Connection conn = null;
    PreparedStatement ps = null;
    int result = 0;
    
    try {
      
      conn = DB_Connect.getConnection();
      
      String sql = "";
      sql += "UPDATE USER_T";
      sql += "   SET USER_NAME = ?";
      sql += " WHERE USER_NO = ?";
      
      ps = conn.prepareStatement(sql);
      ps.setString(1, user_name);
      ps.setInt(2, user_no);
      
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
    
    System.out.println(result + "행이 수정되었습니다.");
    
  }

}
