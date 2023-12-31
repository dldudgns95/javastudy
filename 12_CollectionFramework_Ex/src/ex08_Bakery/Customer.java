package ex08_Bakery;

import java.util.Map;

public class Customer {
  
  private int count;   // 빵을 몇 개 샀는가?
  private int money;      // 돈을 얼마 가지고 있는가?
  
  public Customer(int money) {
    this.money = money;
  }
  
  public int getCount() {
    return count;
  }
  public void setCount(int count) {
    this.count = count;
  }
  
  public int getMoney() {
    return money;
  }
  public void setMoney(int money) {
    this.money = money;
  }
  
  /**
   * 구매 메소드<br>
   * Bakery에서 빵을 구매하는 메소드이다. <br>
   * 어떤 Bakery에서 살 것인지, 몇 개의 빵을 살 것인지, 얼마를 낼 것인지 전달 받는다. <br>
   * Bakery 클래스의 판매 메소드(sell)을 이용해서 구현한다. 
   * @param bakery 빵을 구매할 Bakery
   * @param count 구매할 빵의 갯수
   * @param money 구매할 때 낸 돈
   */
  public void buy(Bakery bakery, int count,int money) {
    
    if(this.money < money) {
      System.out.println("구매 불가(가진 돈이 낼 돈보다 적음)");
      return;
    }
    
    // bakery에 count에 money를 전달하고 빵과 잔돈을 받는다.
    Map<String, Integer> bc = bakery.sell(count, money);
    
    // 구매 처리
    if(bc != null) {
      this.count += bc.get("bread");    // 빵 3개 받기
      this.money -= money;              // 10000원 내고,
      this.money += bc.get("change");   // 4000원 받기
    }
  }
  
  
}
