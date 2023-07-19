package ex04_field;

/**
 * 사칙연산 결과를 저장할 수 있는 계산기
 * 
 * @author 이영훈
 * @since 2023.07.19
 * @version 1.0.0
 */
public class AccCalculator {
  
  /*
   * 필드(field)
   * 1. 객체가 가질 수 있는 값을 저장할 변수
   * 2. 클래스에서 선언한다.
   * 3. 필드는 자동으로 초기화된다.(0, 0.0, false, null(참조타입))
   * 4. 정보 은닉을 위해서 private 처리한다.
   */
  
  /**
   * 이 필드는 AccCalculator의 사칙연산 결과를<br>저장할 수 있는 필드이다.
   */
  private double value;
  
  /**
   * 전달된 실수를 필드 value에 더하는 메소드
   * 
   * @param a
   */
  public void addition(double a) {
    value += a;
  }
  /**
   * 파라미터 a를 필드 value에서 빼는 메소드
   * 
   * @param a
   */
  public void subtraction(double a) {
    value -= a;
  }
  /**
   * 파라미터 a를 필드 value에 곱하는 메소드
   * 
   * @param a
   */
  public void multiplication(double a) {
    value *= a;
  }
  /**
   * 필드 value에 파라미터 a를 나누는 메소드
   * 
   * @param a
   */
  public void division(double a) {
    value /= a;
  }
  
  public void showValue() {
    System.out.println(value);
  }
  
}
