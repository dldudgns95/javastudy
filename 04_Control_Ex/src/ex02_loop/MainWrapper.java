package ex02_loop;

public class MainWrapper {

  public static void ex01() {
    // 구구단 출력하기
    // 2 x 1 = 2
    // 2 x 2 = 4
    // ...
    // 2 x 9 = 17
    int dan = 4;  // 이 곳에 원하는 구구단을 넣으면 된다.
    
    for(int i = 0; i < 9; i++) {
      System.out.println(dan + " X " + (i+1) + " = " + dan * (i+1));
    }
    
  }
  
  public static void ex02() {
    // 100000 넘을 때까지 60원씩 모금하면서 과정 출력하기
    // 1회 모금액 60원, 현재 모금액 60원
    // 2회 모금액 60원, 현재 모금액 120원
    // 3회 모금액 60원, 현재 모금액 180원
    // ...
    // 1667회 모금액 60원, 현재 모금액 100020원
    int goal = 100000;  // 목표 모금액
    int money = 500;  // 1회당 모금액
    int total = 0;  // 모금액 합계
    int nth = 0;  // 회차
    
    while(true) {
      if(total >= goal) break;
      total += money;
      nth++;
      System.out.println(nth + "회 모금액 " + money + "원, 현재 모금액 " + total + "원");
    }
    
  }
  
  public static void ex03() {
    // 전체 구구단 출력하기 - 1
    // 2 x 1 = 2
    // ...
    // 9 x 9 = 81
    
    for(int i = 2; i <= 9; i++) {
      for(int j = 1; j <= 9; j++) {
        System.out.println(i + " X " + j + " = " + i*j);
      }
    }
    
  }
  
  public static void ex04() {
    // 전체 구구단 출력하기 - 2
    // 2x1=2  3x1=3  4x1=4  ... 9x1=9
    // ...
    // 2x9=18 3x9=27 4x9=36 ... 9x9=81
    
    // 참고할코드
    //System.out.print("2x1=2");  // 2x1=2를 출력한 뒤 줄을 바꾸지 않는다.
    
    for(int i = 1; i <= 9; i++) {
      for(int j = 2; j <= 9; j++) {
        System.out.print(j + "X" + i + "=" + i*j + " ");
        
      }
      System.out.println("");
    }
    
  }
  
  public static void ex05() {
    // 삼각별 출력하기 - 1 (2중 loop)
    //     b=12345 
    // a=1   *
    // a=2   **
    // a=3   ***
    // a=4   ****
    // a=5   *****
    
    // 참고할 코드
    // System.out.print("*");  // *를 출력한 뒤 줄을 바꾸지 않는다.
    // System.out.println();   // 줄 바꾸기
    
    for(int i = 1; i <= 5; i++) {
      for(int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
    
  }
  
  public static void ex06() {
    // 삼각별 출력하기 - 2 (2중 loop)
    //     b=12345
    // a=1   *****
    // a=2   ****
    // a=3   ***
    // a=4   **
    // a=5   *
    
    for(int i = 5; i >= 1; i--) {
      for(int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
    
  }
  
  public static void ex07() {
    // 삼각별 출력하기 - 3 (2중 loop)
    //     b=123456789
    // a=1       *         4 1
    // a=2      ***        3 3
    // a=3     *****       2 5
    // a=4    *******      1 7
    // a=5   *********  
    
    for(int i = 1; i <= 5; i++) {
      for(int j = 1; j <= 5-i ; j++) {  // 빈칸 출력 
        System.out.print(" ");
      }
      for(int j = 1; j <= (i*2)-1 ; j++) {  // * 출력
        System.out.print("*");
      }
      System.out.println();
    }
    
  }
  
  public static void ex08() {
    // 삼각별 출력하기 - 4 (2중 loop)
    //     b=123456789
    // a=1   *********  0 9
    // a=2    *******   1 7
    // a=3     *****    2 5 
    // a=4      ***     3 3
    // a=5       *      4 1
    
    
    for(int i = 1; i <= 5; i++) {
      for(int j = 9; j > 10-i; j--) {  // 빈칸 출력
        System.out.print(" ");
      }
      for(int j = 9; j >= (i*2)-1 ; j--) {  // * 출력
        System.out.print("*");
      }
      System.out.println();
    }
    
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ex08();
  }

}
