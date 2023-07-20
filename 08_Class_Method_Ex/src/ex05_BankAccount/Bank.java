package ex05_BankAccount;

public class Bank {

  private String bankName;
  private String tel;
  
  public Bank(String bankName, String tel) {
    this.bankName = bankName;
    this.tel = tel;
  }
  
  public void info() {
    System.out.println(bankName + "(" + tel + ")");
    System.out.println();
  }
  
}
