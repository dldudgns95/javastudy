package ex05_access_modifier;

public class MainWrapper {

  public static void main(String[] args) {
    
    // User 객체(객체명 user) 선언 & 생성
    User user = new User();
    
    // User 객체에 데이터 저장
    user.setId("홍길동");
    user.setAge(50);
    
    //User 객체의 데이터 확인
    System.out.println(user.getId());
    System.out.println(user.getAge() );
    
  }
}
