package ex02_OutputStream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;

public class MainWrapper {

  /*
   * java.io.OutputStream 클래스
   * 1. 바이트 기반의 출력 스트림이다.
   * 2. 출력 단위
   *    1) int
   *    2) byte[]
   */
  
  // FileOutputStream
  public static void ex01() {
    
    // 디렉터리를 File 객체로 만들기
    File dir = new File("C:/storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    // 파일을 File 객체로 만들기
    File file = new File(dir, "ex01.dat");
    // 파일출력스트림 선언
    FileOutputStream fout = null;
    try {
      // 파일출력스트림 생성 (반드시 예외 처리가 필요한 코드)
      
      // 1. 생성모드 : 언제나 새로 만든다.(덮어쓰기)          new FileOutputStream(file)
      // 2. 추가모드 : 새로 만들거나, 기존 파일에 추가한다.   new FileOutputStream(file, true)
      fout = new FileOutputStream(file);
      // 출력할 데이터(파일로 보낼 데이터)
      int c = 'A';              // int
      String s = "pple";
      byte[] b = s.getBytes();  // byte[] : String을 byte[]로 변환
      // 출력(파일로 데이터 보내기)
      fout.write(c);
      fout.write(b);
      
      System.out.println(file.getPath() + " 파일 크기 : " + file.length() + "바이트");
      
    } catch (IOException e) {
     e.printStackTrace(); 
    } finally {
      try {
        if(fout != null) {
          fout.close();   // 출력 스트림은 반드시 닫아줘야 함 (반드시 예외 처리가 필요한 코드)
        }
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
    
    
  }
  
  public static void ex02() {
    
    // C:\storage\ex02.dat 파일로 "안녕하세요" 보내기, 파일 크기 확인
    
    File dir = new File("C:\\storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "ex02.dat");
    
    FileOutputStream fos = null;
    
    try {
      fos = new FileOutputStream(file);
      String s = "안녕하세요";
      byte[] b = s.getBytes("UTF-8");
      
      fos.write(b);
      
      System.out.println(file.getName() + " 파일 크기 : " + file.length() + "바이트");
      
    } catch(IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(fos != null) {
          fos.close();
        }
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
    
    
  }
  
  public static void ex03() {
    
    /*
     * BufferedOutputStream 클래스
     * 1. 내부 버퍼를 가지고 있는 출력스트림이다.
     * 2. 많은 데이터를 한번에 출력하기 때문에 속도 향상을 위해서 사용한다.
     * 3. 보조스트림이므로 메인스트림과 함께 사용한다.
     */
    
    // 기존에 만들어진 파일이 있다면 기존 파일에 덮어쓴다.
    
    // 2줄로 안녕하세요. 반갑습니다.
    File dir = new File("C:\\storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "ex03.dat");
    // 버퍼출력스트림 선언
    BufferedOutputStream bout = null;
    
    try {
      // 버퍼 출력스트림 생성
      bout = new BufferedOutputStream(new FileOutputStream(file));
      String s1 = "안녕하세요.";
      String s2 = "반갑습니다.";
      int c = '\n';
      
      bout.write(s1.getBytes("UTF-8"));
      bout.write(c);
      bout.write(s2.getBytes(StandardCharsets.UTF_8));    //getBytes("UTF-8")과 동일하다.
      
      System.out.println(file.getName() + " 파일 크기 : " + file.length() + "바이트");
      
    } catch(IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(bout != null) {
          bout.close();
        }
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
    
    
  }

  public static void ex04() {
    
    /*
     * java.io.DataOutputStream 클래스
     * 1. int, double, String 등의 변수를 그대로 출력하는 출력스트림이다.
     * 2. 보조스트림이므로 메인스트림과 함께 사용한다.
     */
    
    File dir = new File("C:\\storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "ex04.dat");
    // 데이터출력스트림 선언
    DataOutputStream dout = null;
    
    try {
      // 버퍼 출력스트림 생성
      dout = new DataOutputStream(new FileOutputStream(file));
      // 출력할 데이터(파일로 보낼 데이터)
      String name = "tom";
      int age = 50;
      double height = 180.5;
      String school = "가산대학교";
      // 출력(파일로 데이터 보내기)
      dout.writeChars(name);      // dout.writeChar('t'), dout.writeChar('o'), dout.writeChar('m')
      dout.writeInt(age);
      dout.writeDouble(height);
      dout.writeUTF(school);
      
      System.out.println(file.getName() + " 파일 크기 : " + file.length() + "바이트");
      
    } catch(IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(dout != null) {
          dout.close();
        }
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
    
    
  }
  
  public static void ex05() {
    
    /*
     * java.io.ObjectOutputStream 클래스
     * 1. 객체를 그대로 출력하는 출력스트림이다.
     * 2. 직렬화(Serializable)된 객체를 보낼 수 있다.
     * 3. 보조스트림이므로 메인스트림과 함께 사용한다.
     */
    
    File dir = new File("C:\\storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "ex05.dat");
    // 객체출력스트림 선언
    ObjectOutputStream oout = null;
    
    try {
      // 객체출력스트림 생성
      oout = new ObjectOutputStream(new FileOutputStream(file));
      // 출력할 데이터(파일로 보낼 데이터)
      String name = "tom";
      int age = 50;
      double height = 180.5;
      String school = "가산대학교";
      Student student = new Student(name, age, height, school);
      // 출력(파일로 데이터 보내기)
      oout.writeObject(student);
      
      System.out.println(file.getName() + " 파일 크기 : " + file.length() + "바이트");
      
    } catch(IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(oout != null) {
          oout.close();
        }
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
    
    
  }
  
  
  public static void main(String[] args) {
    ex05();
  }

}
