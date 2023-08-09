package connect;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB_Connect {
  
  public static Connection getConnection() {    // static이면 새로운 객체를 만들지 않고도 쓸 수 있다.
    
    Connection conn = null;
    try (BufferedReader reader = new BufferedReader(new FileReader("src/db.properties"))){
      Class.forName("oracle.jdbc.OracleDriver");
      
      Properties p = new Properties();
      p.load(reader);
      
      conn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("password"));
      
    } catch(FileNotFoundException e) {
      System.out.println("파일을 찾을 수 없습니다.");
    } catch(ClassNotFoundException e) {
      System.out.println("OracleDriver 파일 찾기 실패");
    } catch(IOException e) {
      System.out.println("reader 로드 실패");
    } catch(SQLException e) {
      System.out.println("conn 연결 실패");
    }
    
    return conn;
  }
  
}
