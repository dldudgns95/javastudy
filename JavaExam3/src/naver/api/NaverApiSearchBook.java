package naver.api;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class NaverApiSearchBook {
  
  private void generateImage(String spec) {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedInputStream bin = null;
    BufferedOutputStream bout = null;
    
    try {
      
      url = new URL(spec);
      con = (HttpURLConnection)url.openConnection();
      bin = new BufferedInputStream(con.getInputStream());
      File dir = new File("C:/download");
      if(dir.exists() == false) {
        dir.mkdirs();
      }
      File file =new File(dir, spec.substring(spec.lastIndexOf("/")));
      bout = new BufferedOutputStream(new FileOutputStream(file));
      
      byte[] b = new byte[1024];
      int readByte = 0;
      
      while((readByte = bin.read(b)) != -1) {
        bout.write(b, 0, readByte);
      }
      
      System.out.println(file.getPath() + " 파일 다운로드 완료");
      // 파라미터 String spec에는 다운로드 받을 이미지 파일의 URL이 전달된다.
      // 해당 URL의 이미지 파일을 다운로드 받는다.
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(bout != null) bout.close();
        if(bin != null) bin.close();
        if(con != null) con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
  }
  
  public void getSearchList() {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedReader reader = null;
    
    String clientId = "4DEmLZE_bTCwOOIcBI5a";
    String clientSecret = "wrkcYZS46r";
    
    try {
      
      String spec = "https://openapi.naver.com/v1/search/book.json";
      Scanner sc = new Scanner(System.in);
      System.out.print("검색어를 입력하세요 >>> ");
      String search = sc.nextLine();
      sc.close();
      spec += "?query=" + URLEncoder.encode(search, "UTF-8"); 
      
      url = new URL(spec);
      con = (HttpURLConnection)url.openConnection();
      con.setRequestMethod("GET");
      con.setRequestProperty("X-Naver-Client-Id", clientId);
      con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
      
      int responseCode = con.getResponseCode();
      if(responseCode != HttpURLConnection.HTTP_OK) {
        throw new RuntimeException(responseCode + " 발생");
      }
      
      reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
      String line = "";
      StringBuilder sb = new StringBuilder();
      while((line = reader.readLine()) != null) {
        sb.append(line);
      }
      JSONObject obj = new JSONObject(sb.toString());
      JSONArray array = (JSONArray)obj.get("items");
      if(array.isEmpty()) {
        System.out.println("검색값이 존재하지 않습니다. array.length:" + array.length());  // 검색값 없으면 값 안넘기고 종료
        
        return;
      }

      for(int i = 0, length = array.length(); i < length; i++) {
        obj = array.getJSONObject(i);
        String image = obj.getString("image");
        generateImage(image);
      }
      
      // 책 검색 OpenAPI를 사용해서 응답 결과 중 이미지(image) 결과만 추출하여
      // generateImage 메소드에 전달한다.
      // 10번의 generateImage 메소드 호출이 필요하다.
      
      
    } catch (Exception e) {
      // 예외 발생 시 로그파일을 만든다.
      BufferedWriter bw = null;
      Date date = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss, ");
      String result = sdf.format(date) + e.getMessage();
      try {
        File dir = new File("C:/download/log");
        if(dir.exists() == false) {
          dir.mkdirs();
        }
        File file =new File(dir, "log.txt");
        bw = new BufferedWriter(new FileWriter(file, true));
        bw.write(result + "\n");
        
        System.out.println(file.getPath() + " 파일에 로그가 작성되었습니다.");
      } catch(IOException e2) {
        e2.printStackTrace();
      } finally {
        try {
          if(bw != null) bw.close();
        } catch (IOException e2) {
          e.printStackTrace();
        }
      }
      
    } finally {
      try {
        if(reader != null) reader.close();
        if(con != null) con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
  }
  
}