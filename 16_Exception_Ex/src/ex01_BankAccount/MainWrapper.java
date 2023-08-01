package ex01_BankAccount;

public class MainWrapper {

  public static void main(String[] args) {
    
    try {
      BankAccount acc1 = new BankAccount(10000, "123456");
      BankAccount acc2 = new BankAccount(20000, "654321");
      acc1.deposit(10000);
      acc2.withdrawal(5000);
      acc1.transfer(acc2, 500);
      System.out.println();
      acc1.inquiry();
      System.out.println();
      acc2.inquiry();
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    }
    
    
  }

}
