public class BatTest {
  public static void main(String[] args) {
    Bat batman= new Bat();
    // batman.displayEnergy(); // 300 !
    batman.attackTown(); //200 
    batman.attackTown(); // 100 
    batman.attackTown(); // 0

    batman.eatHumans(); // 25 
    batman.eatHumans();  // 50 

    batman.fly(); // -50
    batman.fly(); // -50 


    System.out.println("The Energy level for this Mammal Species is:"+ batman.displayEnergy());
  }
}
