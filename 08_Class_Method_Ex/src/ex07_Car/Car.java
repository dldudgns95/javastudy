package ex07_Car;

public class Car {
  
  private Driver driver;
  private int speed;
  private int fuel;
  private boolean isEmpty;
  
  public void setDriver(Driver driver) {
    this.driver = driver;
  }
  public void setSpeed(int speed) {
    this.speed = speed;
  }
  public void setFuel(int fuel) {
    this.fuel = fuel;
  }
  public void setEmpty(boolean isEmpty) {
    this.isEmpty = isEmpty;
  }
  
  public Driver getDriver() {
    return driver;
  }
  public int getSpeed() {
    return speed;
  }
  public int getFuel() {
    return fuel;
  }
  public boolean isEmpty() {
    return isEmpty;
  }
  
}
