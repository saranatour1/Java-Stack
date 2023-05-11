public class Bat extends Mammal {
  public Bat() {
    this.energyLevel = 300; // changing the default value for the bat o 300
  }
  // Create a Bat class that can fly(), eatHumans(), and attackTown() and has a
  // default energy level of 300.

  public void fly() {
    this.energyLevel -= 50;
    System.out.println("The Bat is Swirming Around! Fshh Fshh Shh" + this.energyLevel);
  }

  public void attackTown() {
    this.energyLevel -= 100;
    System.out.println("Beware! the Bat is attacking the Town! ksh ksh ksh Fire!" + this.energyLevel);
  }

  public void eatHumans() {
    this.energyLevel += 25;
    System.out.println("The Bat is Eating Humans!!" + this.energyLevel);
  }

}
