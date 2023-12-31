package ex01_Person;

import java.util.ArrayList;
import java.util.List;

public class MainWrapper {

  public static void main(String[] args) {
    
    List<Person> family = new ArrayList<Person>();
    
    // 가족 모두 저장하고 for문으로 확인하기
    family.add(new Person("홍길동", 20));
    family.add(new Person("김미영", 40));
    family.add(new Person("김철수", 45));
    
    for(int i = 0, length = family.size(); i < length; i++) {
      System.out.println(family.get(i));
      System.out.println("이름: " + family.get(i).getName());
      System.out.println("나이: " + family.get(i).getAge());
    }
    
  }

}
