// Parent Class

//this class is never instantated, it is being inherited to other animals.
abstract class Mammal {
  // Every mammal should have an energy level (default 100).
  public int energyLevel = 100;

  public int displayEnergy() {

    return this.energyLevel;
  }
}
