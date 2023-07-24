package ex01_is_a;

public class MainWrapper {

  public static void main(String[] args) {
    
    // Student 객체 선언 & 생성
    Student stu = new Student();
    
    // Student 객체 메소드 확인
    stu.eat();      // 슈퍼 클래스로부터 상속 받은 메소드
    stu.sleep();    // 슈퍼 클래스로부터 상속 받은 메소드
    stu.study();    // 내 꺼
    
  }

}
