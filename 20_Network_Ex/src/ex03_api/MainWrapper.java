package ex03_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainWrapper {

  public static void main(String[] args) {
    
    // 문제. 공공데이터포털(data.go.kr)에서 "한국전력공사_전기차 충전소 운영정보" API를 신청하고
    // 결과를 "C:/Storage/한국전력공사_전기차_충전소_운영정보.xml"로 저장하시오.
    
    String spec = "http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList";
    String ServiceKey = "JP0WFCabw5jAsEZzdAByydq7VnuWzc7Y+RIKFH4cyfl6mLBB+6ug01YujVQdFGgIykwVRG/52MNwrXCQlWcpPA==";
    String pageNo = "1";
    String numOfRows = "10";
    String addr = "전라남도 나주시 빛가람동 120";
    
    URL url = null;
    HttpURLConnection conn = null;
    BufferedReader reader = null;
    BufferedWriter writer = null;
    
    try {
      
      StringBuilder sb = new StringBuilder();
      sb.append(spec);
      sb.append("?" + "serviceKey=" + URLEncoder.encode(ServiceKey,"UTF-8")); // UnsupportedEncodingException
      sb.append("&" + "pageNo=" + URLEncoder.encode(pageNo, "UTF-8"));
      sb.append("&" + "numOfRows=" + URLEncoder.encode(numOfRows, "UTF-8"));
      sb.append("&" + "addr=" + URLEncoder.encode(addr,"UTF-8"));
      
      url = new URL(sb.toString()); // MalformedURLException
      conn = (HttpURLConnection)url.openConnection();
      
      if(conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
        throw new RuntimeException("HTTP 설정 오류");
      }
      
      reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      
      File dir = new File("C:/storage");
      if(dir.exists() == false) {
        dir.mkdirs();
      }
      File file = new File(dir, "한국전력공사_전기차_충전소_운영정보.xml");
      
      writer = new BufferedWriter(new FileWriter(file));
      
      String line = "";
      
      while((line = reader.readLine()) != null) {
        writer.write(line);
      }
      
      System.out.println(file.getPath() + " 파일 생성 완료");
      
    } catch(UnsupportedEncodingException | MalformedURLException e) {
      System.out.println(e.getMessage());
    } catch(RuntimeException | IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(writer != null) writer.close();
        if(reader != null) reader.close();
        if(conn != null) conn.disconnect();
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
  }

}
