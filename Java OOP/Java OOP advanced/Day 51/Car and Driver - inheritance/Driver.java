public class Driver extends Car {
  private String name;

  public Driver(String name) {
    this.name = name;
  }

  // Driving should decrease gas by 1
  public void drive() {
    decreaseGas(1);
  }

  // Using boosters should decrease gas by 3
  public void boosters() {
    decreaseGas(3);
  }

  // Refueling should increase gas by 2
  public void refuel() {
    increaseGas(2);
  }

  public void gameOver() {
    int x = getGas();
    if (x == 0) {
      System.out.println("Game over X_X");
    }
  }

}
