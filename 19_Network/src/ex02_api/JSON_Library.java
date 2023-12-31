package ex02_api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSON_Library {

  /*
   * JSON 공식 홈페이지
   * 1. 링크 : https://www.json.org/
   * 2. Java 라이브러리 다운로드
   *    JSON-Java 라이브러리
   */
  
  /*
   * JSON
   * 1. JavaScript Object Notation
   * 2. 자바스크립트 객체 표기법
   * 3. 객체는 중괄호 {}로 묶어서 표기한다.
   * 4. 배열은 대괄호 []로 묶어서 표기한다.
   * 5. 속성(Property)과 값(Value)을 콜론(:)으로 구분하여 작성한다.
   */
  
  /*
   * JSON-Java 라이브러리에서 제공하는 클래스
   * 1. JSONObject 클래스 : 객체 처리용
   * 2. JSONArray  클래스 : 배열 처리용
   */
  
  // JSON 객체 만들기
  public static void ex01() {
    
    // JSON 객체 만들기
    
    JSONObject obj = new JSONObject();
    obj.put("name", "tom");
    obj.put("age", 50);
    obj.put("height", 180.5);
    
    System.out.println(obj.toString());
    
  }
  // JSON 배열 만들기
  public static void ex02() {
    
    // JSON 배열 만들기 (JSON 객체를 2개 저장한 배열)
    JSONObject obj1 = new JSONObject();
    obj1.put("name","tom");
    obj1.put("age", 50);
    obj1.put("height", 180.5);
    
    JSONObject obj2 = new JSONObject();
    obj2.put("name","jessica");
    obj2.put("age", 60);
    obj2.put("height", 170.5);
    
    // 배열
    JSONArray array = new JSONArray();
    array.put(obj1);
    array.put(obj2);
    
    // 배열 확인
    System.out.println(array.toString());
    
    
  }
  // String 형식의 JSON 객체 분석하기
  public static void ex03() {
    
    // String 형식의 JSON 객체 분석하기
    String str = "{\"name\":\"tom\",\"age\":50,\"height\":180.5}";
    
    // String -> JSONObject 객체로 변환
    JSONObject obj = new JSONObject(str);
    
    // 원하는 Key(Property)를 가져오기
    String name = obj.getString("name");      // String name = (String)obj.get("name");
    int age = obj.getInt("age");              // int age = (int)obj.get("age");
    double height = obj.getDouble("height");  // double height = (double)obj.get("height");
    
    // 결과 확인
    System.out.println(name);
    System.out.println(age);
    System.out.println(height);
    
  }
  // String 형식의 JSON 배열 분석하기
  public static void ex04() {
    
    // String 형식의 JSON 배열 분석하기
    String str = "[{\"name\":\"tom\",\"age\":50,\"height\":180.5},{\"name\":\"jessica\",\"age\":60,\"height\":170.5}]";

    // String -> JSONArray 변환
    JSONArray array = new JSONArray(str);
    
    // 일반 for문
    for(int i = 0, length = array.length(); i < length; i++) {
      JSONObject obj = array.getJSONObject(i);
      String name = obj.getString("name");
      int age = obj.getInt("age");
      double height = obj.getDouble("height");
      System.out.println((i+1) + ", " + name + ", " + age + ", " + height);
    }
    
    //향상for문
    for(Object obj : array) {   // JSON 배열을 쓰기 위해서는 Object 타입으로 선언 후 JSONObject로 캐스팅해줘야 한다.
      JSONObject person = (JSONObject)obj;
      String name= person.getString("name");
      int age = person.getInt("age");
      double height = person.getDouble("height");
      System.out.println(name + ", " + age + ", " + height);
    }
    
  }
  // Map -> JSONObject 변환하기
  public static void ex05() {
    
    // Map -> JSONObject 변환하기
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("name", "tom");
    map.put("age", 50);
    map.put("height", 180.5);
    
    // JSONObject 
    JSONObject obj = new JSONObject(map);
    
    // Key(Property)에 해당하는 Value 확인
    String name = obj.getString("name");
    int age = obj.getInt("age");
    double height = obj.getDouble("height");
    
    System.out.println(name);
    System.out.println(age);
    System.out.println(height);
  }
  // List -> JSONArray 변환
  public static void ex06() {
    
    // List -> JSONArray 변환
    
    // Map 2개 (사람 2명)
    Map<String, Object> map1 = new HashMap<String, Object>();
    map1.put("name", "tom");
    map1.put("age", 50);
    map1.put("height", 180.5);
    
    Map<String, Object> map2 = new HashMap<String, Object>();
    map2.put("name", "jessica");
    map2.put("age", 40);
    map2.put("height", 170.5);
    
    // List (Map 2개 저장)
    List<Map<String, Object>> list = Arrays.asList(map1, map2);

    
    // JSONArray
    JSONArray array = new JSONArray(list);
    
    for(Object obj : array) {
      JSONObject person = (JSONObject)obj;
      String name = person.getString("name");
      int age = person.getInt("age");
      double height = person.getDouble("height");
      System.out.println(name + ", " + age + ", " + height);
    }
    
    System.out.println(array.toString());
  }

  public static void main(String[] args) {
    ex04();
  }

}
