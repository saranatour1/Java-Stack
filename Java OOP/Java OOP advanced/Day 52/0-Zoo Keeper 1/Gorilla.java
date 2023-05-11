public class Gorilla extends Mammal {
  // Create a separate class Gorilla that can throwSomething(), eatBananas(), and
  // climb()
  public void throwSomething() {
    this.energyLevel -= 5;
    System.out.println("The Gorilla Has Thrown something! Energy Level -5 :<(" + this.energyLevel);
    // System.out.println(super.energyLevel);

  }

  public void eatBananas() {
    this.energyLevel += 10;
    System.out
        .println("The Gorilla is eating a banana now! , he is very satisfied!, Energy Level: " + this.energyLevel);
  }

  public void climb() {
    this.energyLevel -= 10;
    System.out.println("The Gorilla is Climbing a tree!, Energy level " + this.energyLevel);
  }
}
