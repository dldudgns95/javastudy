package ex05_BankAccount;

public class BankMember {

  private String name;
  private BankAccount acc;
  
  public BankMember(String name, BankAccount acc) {
    this.name = name;
    this.acc = acc;
  }
  
  public BankMember() { }
  
  public void info() {
    System.out.println("고객명: " + name);
    acc.info();
  }
  
  
  public void setName(String name) {
    this.name = name;
  }
  
  public void setAcc(BankAccount acc) {
    this.acc = acc;
  }
  
  public String getName() {
    return name;
  }
  
  public BankAccount getAcc() {
    return acc;
  }
  
  public Bank getBank() {
    return acc.getBank();
  }
  
  public long withdrawal(long money) {
    return acc.withdrawal(money);
  }
  
  public void deposit(long money) {
    acc.deposit(money);
  }
  
  public void transfer(BankMember member, int money) {
    member.deposit(withdrawal(money));
  }
  
}
