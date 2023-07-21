package ex05_BankAccount;

public class BankAccount {

  private Bank bank;
  private String number;
  private int money;
  
  public BankAccount(Bank bank, String number, int money) {
    this.bank = bank;
    this.number = number;
    this.money = money;
  }
  
  public BankAccount() { }
  
  public void info() { // 계좌번호: 012-34-56789, 통장잔액: 50000원
    System.out.println("계좌번호: " + number + ", 통장잔액: " + money + "원");
    System.out.print("개설지점: ");
    bank.info();
  }
  
  
  public void setBank(Bank bank) {
    this.bank = bank;
  }
  
  public void setAccNo(String number) {
    this.number = number;
  }
  
  public void setMoney(int money) {
    this.money = money;
  }
  
  public Bank getBank() {
    return bank;
  }
  
  public String getAccNo() {
    return number;
  }
  
  public int getMoney() {
    return money;
  }
  
  // 출금 : withdrawal
  public long withdrawal(long money) {
    long retVal = 0;
    if(money > 0 && this.money >= money) {
      this.money -= money;
      retVal = money;
    }
    return retVal;
  }
  
  
  // 입금 : deposit
  public void deposit(long money) {
    this.money += money;
  }
  
  public void transfer(BankAccount acc, long money) {
    acc.deposit(withdrawal(money));
  }
  
}
