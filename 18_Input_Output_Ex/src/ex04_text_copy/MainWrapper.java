package ex04_text_copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainWrapper {
  
  public static void ex01() {
    
    // 문제1. 다음과 같이 알파벳 대문자가 입력된 C:/storage/alphabet.txt 파일을 만드시오.
    // ABCDEFGHIJKLMNOPQRSTUVWXYZ
    File dir = new File("C:/storage");
    if(dir.exists() == false) dir.mkdirs();
    File file = new File(dir, "alphabet.txt");
    BufferedWriter bw = null;
    
    try {
      String alphabet = "";
      String alphabet2 = "";
      bw = new BufferedWriter(new FileWriter(file));
      for(char ch = 'A'; ch <= 'Z'; ch++) {
        alphabet += ch;
      }
      for(char ch = 'a'; ch <= 'z'; ch++) {
        alphabet2 += ch;
      }
      bw.write(alphabet);
      bw.newLine();
      bw.write(alphabet2);
      
      
      System.out.println(file.getPath() + " 파일 생성 완료");
      
    } catch(IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(bw != null) bw.close();
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
  }
  
  public static void ex02() {
    
    // 문제2. C:/storage/alphabet.txt 파일을 복사하여 C:/storage/alphabet2.txt 파일을 만드시오.
    File dir = new File("C:/storage");
    if(dir.exists() == false) dir.mkdirs();
    File file1 = new File(dir, "alphabet.txt");
    File file2 = new File(dir, "alphabet2.txt");
    
    BufferedReader br = null;
    BufferedWriter bw = null;
    
    try {
      br = new BufferedReader(new FileReader(file1));
      bw = new BufferedWriter(new FileWriter(file2));
      
      String line = "";
      while((line = br.readLine()) != null) {
        bw.write(line + "\n");
      }
      System.out.println(file1.getPath() + " -> " + file2.getPath() + " 복사 완료");
      
    } catch(IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(bw != null) bw.close();
        if(br != null) br.close();
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
  }
  
  public static void main(String[] args) {
    
    ex01();
    ex02();
    
  }
  
}
