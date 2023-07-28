package ex06_BinaryNumber;

import java.util.ArrayList;
import java.util.List;

public class BinaryNumber {
  
  @SuppressWarnings("unused")
  private int number;             // 10진수
  private List<Integer> binary;   // 2진수
  
  // new BinaryNumber(32)
  public BinaryNumber(int number) {
    this.number = number;
    binary = new ArrayList<Integer>();
    if(number == 0) binary.add(0);
    while(number != 0) {
      binary.add(0, number % 2);
      number /= 2;
    }
    
  }
  
  @Override
  public String toString() {
    String value = "";
    for(int i = 0, length = binary.size(); i < length; i++) {
      value += binary.get(i);
    }
    return value;
  }
  
  
}
