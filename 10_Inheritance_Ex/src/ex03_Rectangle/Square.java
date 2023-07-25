package ex03_Rectangle;

// 정사각형은 사각형이다.

public class Square extends Rectangle{
  
  public Square() {
    
  }
  
  public Square(int value) {
    
    super(value, value);    // new Rectangle(6, 6)
    
    /*
    super.setWidth(value);
    super.setHeight(value);
    */
  }
  
  
}
