package ex01_BankAccount;

public class MainWrapper {

  public static void main(String[] args) {
    
    // BankAccount my 객체 선언 & 생성
    BankAccount my = new BankAccount();
    
    // my 객체에 계좌번호 등록하기
    my.setAccNo("110-123-456789");
    
    // my 객체에 입금하기
    my.deposit(50000);
    
    // my 객체 출금하기
    my.withdrawal(1);
    
    // my 객체 조회하기
    my.inquiry();
    
    // BankAccount you 객체 선언 & 생성
    BankAccount you = new BankAccount();
    
    //you 객체 계좌번호 등록하기
    you.setAccNo("110-987-654321");
    
    //내가 너에게 30000원을 이체하겠다.
    my.transfer(you, 30000);
    
    // my 객체 조회하기
    my.inquiry();   // 통장잔액: 19999원
    you.inquiry();  // 통장잔액: 30000원
  }

}
