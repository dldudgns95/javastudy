package ex06_Game;

public class Marine extends GameUnit{
  
  private final int POWER = 5;
  
  // new Marine("마린")
  public Marine(String name) {
    super(name);    // public GameUnit(String name){} 생성자를 호출한다.
  }
  
  public int getPOWER() {
    return POWER;
  }
  
  @Override
  public void attack(GameUnit unit) {   // unit1.attack(unit2)
    if(POWER >= unit.getHp()) {
      unit.setHp(0);
    } else {
      unit.setHp(unit.getHp() - POWER);
    }
  }
  
}
