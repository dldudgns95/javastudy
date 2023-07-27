package ex03_Bus;

import java.util.ArrayList;
import java.util.List;

public class Bus {
  
  
  
  private List<Seat> seat;
  private final int LIMIT = 25;   // 25인승 버스
  
  public Bus() {
    seat = new ArrayList<Seat>();
    for(int i = 0; i < LIMIT; i++) {
      seat.add(new Seat());
    }
  }
  
  public void getOn(int seatNum, Person person) {
    if(seatNum < 1 || seatNum > 25) {
      System.out.println("잘못된 좌석입니다.");
      return;
    } else if(seat.get(seatNum-1).getPerson() != null) {
      System.out.println("이미 앉은 좌석입니다.");
      return;
    }
    seat.get(seatNum-1).setPerson(person);
    System.out.println(seatNum + "번 좌석에 " + person.getName() + "이 착석하셨습니다.");
  }
  
  public void getOff(int seatNum) {
    if(seatNum < 1 || seatNum > 25) {
      System.out.println("잘못된 좌석입니다.");
      return;
    } else if(seat.get(seatNum-1).getPerson() == null) {
      System.out.println("빈 좌석입니다.");
      return;
    }
    
    System.out.println(seatNum + "번 좌석에서 " + seat.get(seatNum-1).getPerson().getName() + "이 내렸습니다.");
    seat.get(seatNum-1).setPerson(null);
  }
  
  
  public void info() {
    for(int i = 0, length = seat.size(); i < length; i++) {
      System.out.print((i+1) + "번 좌석: ");
      if(seat.get(i).getPerson() != null)
        System.out.println(seat.get(i).getPerson().getName() + "이 탑승");
      else
        System.out.println("비어있음");
    }
  }
}
