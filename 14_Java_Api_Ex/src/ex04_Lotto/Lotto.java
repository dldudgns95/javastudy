package ex04_Lotto;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Lotto {
  
  /**
   * 로또 구매<br>
   * 로또 구매를 위해서 사용자로부터 money를 입력 받는 메소드<br>
   * 로또 구매 비용은 최소 1000, 최대 100000이다.<br>
   * @return money 사용자가 입력한 로또 구매 비용에서 1000 미만 단위는 버리고 반환. ex) 5999 입력 시 5000 반환
   * @return 0 로또 구매 실패 시 반환
   */
  public int buyLotto() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Lotto를 얼마나 구입하시겠습니까?(최대 10만원) >>> ");
    int money = sc.nextInt();
    sc.close();
    if(money < 1000 || money > 100000) {
      System.out.println( money + "원 Lotto 구매는 불가능합니다.");
      return 0;
    }
    money -= money % 1000;
    return money;
  }
  
  /**
   * 로또 번호 생성<br>
   * 로또 구매 비용만큼 로또 번호를 생성하는 메소드<br>
   * 5게임씩 끊어서 생성된 로또 번호를 출력한다.<br>
   * @param money 로또 구매 비용
   */
  public void generateLotto(int money) {
    Random random = new Random();
    int count = 0;
    while(count < money / 1000) {
      Set<Integer> lotto = new HashSet<Integer>();
      
      while(lotto.size() < 6) {
        lotto.add(random.nextInt(45) + 1);
      }
      System.out.print(String.format("%02d", count % 5 + 1) + " : ");
      for(int number : lotto) {
        System.out.print(String.format("%4d", number));
      }
      System.out.println();
      count++;
      if(count % 5 == 0 || count == money / 1000) System.out.println("------------------------------");
      
    }
    
  }
  
}
