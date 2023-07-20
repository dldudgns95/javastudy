package ex08_static;

public class MainWrapeer {
  
  public static void main(String[] args) {
    
    // 반지름
    double radius = 1.0;
    
    //원 넓이 구하기
    double circleArea = MyMath.getCircleArea(radius);
    System.out.println(circleArea);
    
  }

}
