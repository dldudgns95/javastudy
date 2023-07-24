package ex01_Car;

public class MainWrapper {

  public static void main(String[] args) {
    
    //Ev
    Ev ev = new Ev();
    ev.drive();
    ev.charge();
    
    //EngineCar
    EngineCar enCar = new EngineCar();
    enCar.drive();
    enCar.addFuel();
    
    //HybridCar
    HybridCar hbCar = new HybridCar();
    hbCar.drive();
    hbCar.addFuel();
    hbCar.charge();
    
  }

}
