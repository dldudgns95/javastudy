package ex03_date_time;

import java.sql.Date;
import java.sql.Timestamp;

public class Ex03_java_sql_Date {

  public static void main(String[] args) {
    
    // java.sql.Date 클래스
    // DB의 DATE 타입을 처리하는 Date 클래스
    Date date1 = new Date(System.currentTimeMillis());
    System.out.println(date1);
    
    // java.sql.Timestamp
    // DB의 TIMESTAMP 타입을 처리하는 Timestamp 클래스
    Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
    System.out.println(timestamp1);
    
  }

}
