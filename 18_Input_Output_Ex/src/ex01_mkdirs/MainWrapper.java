package ex01_mkdirs;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Calendar;

public class MainWrapper {

  // Calendar를 이용한 디렉터리 생성
  public static void ex01() {
    
    // 현재 날짜와 시간을 이용하여 디렉터리를 만드시오.
    // C:/2023/08/03/14
    
    Calendar calendar = Calendar.getInstance();
    
    File dir = new File("C:/");
    String year =  ""+calendar.get(Calendar.YEAR);
    String month = String.format("%02d", calendar.get(Calendar.MONTH) + 1);
    String day = String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH));
    String hour = String.format("%02d", calendar.get(Calendar.HOUR_OF_DAY));
    
    File fileYear = new File(dir, year);
    if(!fileYear.exists()) fileYear.mkdirs();
    File fileMonth = new File(fileYear, month);
    if(!fileMonth.exists()) fileMonth.mkdirs();
    File fileDay = new File(fileMonth, day);
    if(!fileDay.exists()) fileDay.mkdirs();
    File fileHour = new File(fileDay, hour);
    if(!fileHour.exists()) fileHour.mkdirs();
    
    System.out.println(fileHour.getPath() + " 디렉터리 생성 완료");
    
  }
  // LocalDateTime을 이용한 디렉터리 생성
  public static void ex02() {
    
    // 현재 날짜와 시간을 이용하여 디렉터리를 만드시오.
    // C:/2023/08/03/14
    
    LocalDateTime localDateTime = LocalDateTime.now();
    int year = localDateTime.getYear();
    int month = localDateTime.getMonthValue();
    int day = localDateTime.getDayOfMonth();
    int hour = localDateTime.getHour();
    
    StringBuilder sb = new StringBuilder();
    sb.append("C:");
    sb.append("/");
    sb.append(year);
    sb.append("/");
    sb.append(String.format("%02d", month));
    sb.append("/");
    sb.append(String.format("%02d", day));
    sb.append("/");
    sb.append(String.format("%02d", hour));
    
    File dir = new File(sb.toString());
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    System.out.println(dir.getPath() + " 디렉터리 생성 완료");
    
  }
  
  public static void main(String[] args) {
    ex02();
  }

}
