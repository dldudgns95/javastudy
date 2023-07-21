package ex05_BankAccount;

public class Bank {

  private String bankName;
  private String tel;
  
  public Bank(String bankName, String tel) {
    this.bankName = bankName;
    this.tel = tel;
  }
  
  public Bank() { }
  
  public void info() {
    System.out.println(bankName + "(" + tel + ")");
    System.out.println();
  }
  
  
  public void setName(String bankname) {
    this.bankName = bankname;
  }
  
  public void setTel(String tel) {
    this.tel = tel;
  }
  
  public String getName() {
    return bankName;
  }
  
  public String getTel() {
    return tel;
  }
  
}
