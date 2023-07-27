package ex10_Cart;

public class Cart {
  
  /* Product 배열 길이 */   private final int CART_LENGTH = 10;
  /* Product 배열 */        private Product[] products;
  /* 담긴 Product 갯수 */   private int prodCount;
  
  // new Cart()
  public Cart() {
    products = new Product[CART_LENGTH];
  }
  
  public Product[] getProducts() {
    return products;
  }
  public void setProducts(Product[] products) {
    this.products = products;
  }
  public int getProdCount() {
    return prodCount;
  }
  public void setProdCount(int prodCount) {
    this.prodCount = prodCount;
  }
  
  // 물건 넣기
  // addProduct(new Product("제품번호", "제품명", 제품가격))
  public void addProduct(Product product) {
    // 물건을 못 넣는 경우
    if(prodCount == CART_LENGTH ) {
      System.out.println("Cart is Full");
      return;
    }
    // 물건 넣기
    products[prodCount++] = product;
  }
  
  // 물건 바꾸기
  // changeProduct(1, new Product("제품번호", "제품명", 제품가격))
  public void changeProduct(int changeNo, Product product) {
    if(changeNo < 0 || changeNo >= prodCount) {
      System.out.println("There is no product!");
      return;
    }
    
    // 물건 바꾸기
    products[changeNo] = product;
  }
  
  // 물건 빼기
  // deleteProduct(0)
  public void deleteProduct(int deleteNo) {
    // 물건을 못 빼는 경우
    if(deleteNo == prodCount) {
      System.out.println("Cart is empty!");
      return;
    }
    if(deleteNo < 0 || deleteNo >= prodCount) {
      System.out.println("There is no product!");
      return;
    }
    System.arraycopy(products, deleteNo+1, products, deleteNo, prodCount - deleteNo - 1);
    products[--prodCount] = null;
    
  }
  
  
}
