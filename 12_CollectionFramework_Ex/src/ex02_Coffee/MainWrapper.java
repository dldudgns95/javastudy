package ex02_Coffee;

public class MainWrapper {

  public static void main(String[] args) {
    
    Cup cup1 = new Cup();
    cup1.setCoffee(new Americano("아메리카노"));
    
    Cup cup2 = new Cup();
    cup2.setCoffee(new CafeLatte("카페라떼"));
    
    Person p = new Person();
    p.addCupToTray(cup2);
    p.addCupToTray(cup1);
    
    p.trayInfo();
    
    
  }

}
