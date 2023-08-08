package ex02_api;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class NaverCaptcha {
  
  private static final String CLIENT_ID = "4DEmLZE_bTCwOOIcBI5a";
  private static final String CLIENT_SECRET = "wrkcYZS46r";
  
  private static String getKey() {
    
    URL url = null;
    HttpURLConnection conn = null;
    BufferedReader reader = null;
    String result = null;
    
    try {
      String spec = "https://openapi.naver.com/v1/captcha/nkey?code=0";
      url = new URL(spec);
      conn = (HttpURLConnection) url.openConnection();
      
      conn.setRequestMethod("GET");
      conn.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
      conn.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
      
      int responseCode = conn.getResponseCode();
      if(responseCode != HttpURLConnection.HTTP_OK) {
        throw new RuntimeException(responseCode + " 발생");
      }
      
      reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      StringBuilder sb = new StringBuilder();
      String line = null;
      
      while((line = reader.readLine()) != null) {
        sb.append(line);
      }
      
      System.out.println(sb.toString());
      JSONObject obj = new JSONObject(sb.toString());
      result = obj.getString("key");
    } catch(Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if(reader != null) reader.close();
        if(conn != null) conn.disconnect();
      } catch(IOException e) {
        e.printStackTrace();
      }
    } 
    
    return result;
    
  }
  
  private static JSONObject getImage() {
    
    URL url = null;
    HttpURLConnection conn = null;
    BufferedInputStream bin = null;
    BufferedOutputStream bout = null;
    JSONObject obj = new JSONObject();
    String key = null;
    
    try {
      key = getKey();
      obj.put("key", key);
      String spec = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
      
      url = new URL(spec);
      conn = (HttpURLConnection) url.openConnection();
      
      conn.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
      conn.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
      
      int responseCode = conn.getResponseCode();
      if(responseCode != HttpURLConnection.HTTP_OK) {
        throw new RuntimeException(responseCode + " 발생");
      }
      
      bin = new BufferedInputStream(conn.getInputStream());
      
      File dir = new File("C:/storage");
      if(dir.exists() == false) {
        dir.mkdirs();
      }
      File file = new File(dir, System.currentTimeMillis() + ".jpg");
      obj.put("file", file.getPath());
      
      bout = new BufferedOutputStream(new FileOutputStream(file));
      
      byte[] b = new byte[1024];
      int readByte = 0;
      
      while((readByte = bin.read(b)) != -1) {
          bout.write(b, 0, readByte);
      }
      System.out.println(file.getPath() + " 파일 생성 완료");
    } catch(Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if(bout != null) bout.close();
        if(bin != null) bin.close();
        if(conn != null) conn.disconnect();
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
    return obj;
  }
  
  private static void validInput() {
    
    JSONObject getObj = getImage();
    URL url = null;
    HttpURLConnection conn = null;
    BufferedReader reader = null;
    
    try {
      Scanner sc = new Scanner(System.in);
      System.out.print("캡차 값을 입력하시오 >>> ");
      String value = sc.next();
      
      String spec = "https://openapi.naver.com/v1/captcha/nkey?code=1&key=" + getObj.getString("key") + "&value=" + value;
      
      url = new URL(spec);
      conn = (HttpURLConnection)url.openConnection();
      
      conn.setRequestMethod("GET");
      conn.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
      conn.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
      
      int responseCode = conn.getResponseCode();
      if(responseCode != HttpURLConnection.HTTP_OK) {
        throw new RuntimeException(responseCode + " 발생");
      }
      
      reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      
      StringBuilder sb = new StringBuilder();
      String line = null;
      
      while((line = reader.readLine()) != null) {
        sb.append(line);
      }
      
      JSONObject obj = new JSONObject(sb.toString());
      System.out.println("응답시간: " + obj.getDouble("responseTime"));
      if(obj.getBoolean("result")) {
        System.out.println("맞습니다.");
      } else {
        System.out.println("틀립니다.");
      }
      File file = new File(getObj.getString("file"));
      file.delete();
      System.out.println(file.getPath() + " 파일 삭제 완료");
      
    } catch(Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if(reader != null) reader.close();
        if(conn != null) conn.disconnect();
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
    
  }
  
  public static void main(String[] args) {
    validInput();
    
  }

}
