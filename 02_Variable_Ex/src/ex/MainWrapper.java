package ex;

public class MainWrapper {
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    // 초 -> 분/초
    int second = 321;
    int m = second / 60;  // 1
    int s = second % 60;  // 30
    System.out.println(second + "초는 "+ m + "분 " + s +"초");
    
    // x와 y값을 교환
    int x = 10;
    int y = 20;
    int temp;
    System.out.println("x = " + x + ", y = " + y);
    
    temp = x;
    x = y;
    y = temp;
    System.out.println("x = " + x + ", y = " + y);

    
    // 5% 이자는 얼마?(소수 이하는 버림)
    long balance = 123456L;  // 통장잔액
    double pct = 0.05;       // 5%
    
    balance *= (1 + pct);
    System.out.println(balance);
    // long result = (long)((double)balance * pct + balance);
    // System.out.println(balance + "의 이자는 " + result);

    
    // 90점대 점수이면 true, 아니면 false
    int score1 = 99;
    boolean result1 = (score1 >= 90 && score1 < 100);     // true
    int score2 = 75;
    boolean result2 = (score2 / 10 == 9) ? true : false;  // false
    System.out.println(score1 + "점은 " + result1);
    System.out.println(score2 + "점은 " + result2);


    // n의 "짝수", "홀수" 여부 출력
    int n = 3;
    String res1 = (n % 2 == 0) ? "짝수" : "홀수";  // "홀수"
    System.out.println(n + "은 " + res1);

    // num의 "짝수", "홀수", "3의배수" 여부 출력
    int num = 0;
    String res2 = (num != 0) && (num % 3 == 0) ? "3의배수" : ((num % 2 == 0) ? "짝수" : "홀수" ) ;  // "3의배수"
    System.out.println(num + "은 " + res2 + "입니다");

  }

}
