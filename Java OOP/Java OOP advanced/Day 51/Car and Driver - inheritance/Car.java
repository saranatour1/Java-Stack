// Your first task is to create a car class that has a gas attribute. Each car should start with a gas level of 10. 
// Next, create a method that displays the amount of gas remaining in the car.

public class Car {
  private int gas;

  public Car() {
    this.gas = 10;
  }

  // get the gas level
  public int getGas() {
    return gas;
  }

  // getter method for displaying gas
  public void displayGasLevel() {
    System.out.println("HI, Your car has this amount of gas now " + gas);
  }

  public void decreaseGas(int amount) {
    this.gas -= amount;
    System.out.println("You have decreased your gas level by " + amount + " and you have " + gas + " left");
  }

  public void increaseGas(int amount) {
    this.gas += amount;
    System.out.println("You have increased your gas level by " + amount + " and you have " + gas + " left");
  }

}
