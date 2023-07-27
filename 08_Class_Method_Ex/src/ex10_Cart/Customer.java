package ex10_Cart;

import java.text.DecimalFormat;

public class Customer {

  /* Cart */       private Cart cart;     
  /* 돈 */         private int money;
  /* 포인트 */     private int point;
  
  //new Customer(100_000, 1_000)
  public Customer(int money, int point) {
    super();
    this.money = money;
    this.point = point;
  }
  
  public Cart getCart() {
    return cart;
  }
  public void setCart(Cart cart) {
    this.cart = cart;
  }
  public int getMoney() {
    return money;
  }
  public void setMoney(int money) {
    this.money = money;
  }
  public int getPoint() {
    return point;
  }
  public void setPoint(int point) {
    this.point = point;
  }
  
  // 카트에 물건 넣기
  public void addProductToCart(Product product) {
    cart.addProduct(product);
  }
  
  // 카트에 물건 바꾸기
  public void changeProductFromCart(int changeNo, Product product) {
    cart.changeProduct(changeNo, product);
  }
  
  // 카트에 물건 빼기
  public void deleteProductFromCart(int deleteNo) {
    cart.deleteProduct(deleteNo);
  }
  
  // 카트에 들어있는 물건 구매
  public String buy() {
    
    String receipt = "------ 영수증 ------\n";
    int totalPrice = 0;
    
    for(int i = 0, length = cart.getProdCount(); i < length; i++) {
      
      // cart에서 뺀 물건 1개
      Product product = cart.getProducts()[i];
      // 구매액 누적
      totalPrice += product.getProdPrice();
      
      // 구매가 불가능한 경우
      if(money < totalPrice) {
        System.out.println("돈이 부족합니다.");
        return "";
      }
      
      // 영수증 만들기
      receipt += String.format("%-10s", product.getProdName());
      receipt += String.format("%7s", new DecimalFormat("#,##0").format(product.getProdPrice()));
      receipt += "\n";
    }
    
    // 비용 지불
    money -= totalPrice;
    // 발생 포인트 누적
    point += totalPrice * 0.1;
    
    //영수증 만들기
    receipt += "--------------------\n";
    receipt += "구매총액" + String.format("%12s", new DecimalFormat("#,##0").format(totalPrice)) + "\n"; 
    receipt += "발생포인트" + String.format("%10s", new DecimalFormat("#,##0").format(totalPrice * 0.1)) + "\n";
    receipt += "보유포인트" + String.format("%10s", new DecimalFormat("#,##0").format(point)) + "\n";
    
    // 영수증 반환
    return receipt;
  }

  @Override
  public String toString() {
    return "Customer [money=" + money + ", point=" + point + "]";
  }
  
  
  
}
