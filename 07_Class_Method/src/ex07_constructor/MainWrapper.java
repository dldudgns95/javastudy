package ex07_constructor;

public class MainWrapper {
  
  public static void main(String[] args) {
    
    //Computer myCom 객체 선언
    Computer myCom;
    
    //Computer myCom 객체 생성
    myCom = new Computer();   // public Computer(){}생성자가 호출된다.
    
    myCom.setModel("맥북");
    System.out.println("myCom: " + myCom.getModel());
    
    //Computer yourCom 객체 선언
    Computer yourCom;
    
    //Computer yourCom 객체 생성
    yourCom = new Computer("gram"); // public computer(String model){} 생성자가 호출된다.
    
    System.out.println("yourCom: " + yourCom.getModel());
  }

}
