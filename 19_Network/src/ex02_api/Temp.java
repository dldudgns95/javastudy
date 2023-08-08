package ex02_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Temp {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    String query = null;
    System.out.print("검색어를 입력하세요 >>> ");
    query = sc.nextLine();
    
    try {
      query = URLEncoder.encode(query, "UTF-8");
    } catch(UnsupportedEncodingException e) {
      System.out.println("검색어 인코딩 오류");
    }
    
    String spec = "https://openapi.naver.com/v1/search/blog.json?query=" + query;
    String clientId = "4DEmLZE_bTCwOOIcBI5a";
    String clientSecret = "wrkcYZS46r";
    
    Map<String, String> requestHeaders = new HashMap<String, String>();
    requestHeaders.put("X-Naver-Client-Id", clientId);
    requestHeaders.put("X-Naver-Client-Secret", clientSecret);
    
    String result = get(spec, requestHeaders);
    System.out.println(result);
    
  }
  
  private static String get(String spec, Map<String, String> requestHeaders) {
    
    HttpURLConnection conn = connect(spec);
    String result = null;
    try {
      conn.setRequestMethod("GET");
      
      for(Entry<String, String> entry : requestHeaders.entrySet()) {
        conn.setRequestProperty(entry.getKey(), entry.getValue());
      }
      int responseCode = conn.getResponseCode();
      if(responseCode == HttpURLConnection.HTTP_OK) {
        result = readBody(conn.getInputStream());
      } else {
        result = readBody(conn.getErrorStream());
      }
    } catch(IOException e) {
      System.out.println("요청 또는 응답이 실패");
    } finally {
      conn.disconnect();
    }
    return result;
  }
  
  private static HttpURLConnection connect(String spec) {
    
    URL url = null;
    HttpURLConnection conn = null;
    try {
      url = new URL(spec);
      conn = (HttpURLConnection)url.openConnection();
    } catch(MalformedURLException e) {
      System.out.println("주소가 잘못되었다.");
    } catch(IOException e) {
      System.out.println("접속이 안된다.");
    }
    return conn;
  }
  
  private static String readBody(InputStream in) {
    
    String result = null;
    
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
      
      StringBuilder sb = new StringBuilder();
      String line = null;
      while((line = reader.readLine()) != null) {
        sb.append(line + "\n");
      }
      result = sb.toString();
    } catch(IOException e) {
      System.out.println("응답 실패");
    }
  
    return result;
    
  }
  
}
