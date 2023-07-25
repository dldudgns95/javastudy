package ex06_Game;

public class Firebat extends GameUnit{
  
  private final int POWER = 10;
  
  // new Firebat("파이어뱃")
  public Firebat(String name) {
    super(name);  // public GameUnit(String name){} 생성자를 호출한다.
  }

  public int getPOWER() {
    return POWER;
  }
  
  @Override
  public void attack(GameUnit unit) {   // unit2.attack(unit1)
    if(POWER >= unit.getHp()) {
      unit.setHp(0);
    } else {
      unit.setHp(unit.getHp() - POWER);
    }
  }
  
}
