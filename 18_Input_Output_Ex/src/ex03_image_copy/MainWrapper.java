package ex03_image_copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainWrapper {

  public static void main(String[] args) {
    
    // 문제. %ORA_HOME%/oui/instImages/bg.jpg 이미지 파일을 C:/storage/bg.jpg 이미지로 복사하시오.
    // %ORA_HOME%은 C:/app/사용자/product/18.0.0/dbhomeXE 디렉터리를 의미한다.
    
    File copyFile = new File("C:/app/GDJ69/product4/dbhomeXE/oui/instImages/bg.jpg");
    File file = new File("C:/storage/bg.jpg");
    
    BufferedInputStream bin = null;
    BufferedOutputStream bout = null;
    
    try {
      bin = new BufferedInputStream(new FileInputStream(copyFile));
      bout = new BufferedOutputStream(new FileOutputStream(file));
      
      byte[] b = new byte[1024];
      int readByte = 0;
      
      while((readByte = bin.read(b)) != -1) {
        bout.write(b, 0, readByte);
      }
      System.out.println(file.getPath() + " 파일 생성 완료");
    } catch(IOException e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if(bout != null) bout.close();
        if(bin != null) bin.close();
      } catch(IOException e) {
        System.out.println(e.getMessage());
      }
    }
  }

}
