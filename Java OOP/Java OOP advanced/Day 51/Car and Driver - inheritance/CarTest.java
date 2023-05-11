
public class CarTest {
  public static void main(String[] args) {
    Driver driver = new Driver("John");

    driver.displayGasLevel();

    driver.drive();
    driver.drive();
    driver.drive();
    driver.drive();
    driver.drive();
    driver.drive();
    driver.drive();
    driver.drive();
    driver.drive();
    driver.drive();

    driver.gameOver();

    driver.displayGasLevel();
  }
}
