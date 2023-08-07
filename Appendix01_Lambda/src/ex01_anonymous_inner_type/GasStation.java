package ex01_anonymous_inner_type;

public class GasStation {
  
  private int totalOil;
  private int payPerLiter;
  private int money;
  
  public GasStation() {
    // TODO Auto-generated constructor stub
  }
  
  public void sellOil(String model, int oil) {
    
    // Car car 지역변수(객체) 선언 (sellOil 메소드 호출 시 생성되고, sellOil 메소드 종료 시 소멸된다.)
    Car car;
    
    // Car car 지역변수(객체) 생성
    car = new Car() {
      @Override
      public void addoil() {
        totalOil -= oil;
        money += payPerLiter * oil;
        System.out.println(model + " " + oil + "L 주유 완료");
      }
    };
    
    // Car car 지역변수(객체)의 addOil() 메소드 호출
    car.addoil();
    
  }

  public int getTotalOil() {
    return totalOil;
  }
  public void setTotalOil(int totalOil) {
    this.totalOil = totalOil;
  }
  public int getPayPerLiter() {
    return payPerLiter;
  }
  public void setPayPerLiter(int payPerLiter) {
    this.payPerLiter = payPerLiter;
  }
  public int getMoney() {
    return money;
  }
  public void setMoney(int money) {
    this.money = money;
  }
  
  
  
  
}
