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
  
  public void info() { // 계좌번호: 012-34-56789, 통장잔액: 50000원
    System.out.println("계좌번호: " + number + ", 통장잔액: " + money + "원");
    bank.info();
  }
  
}
