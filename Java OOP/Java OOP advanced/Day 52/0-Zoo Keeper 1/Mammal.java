// Parent Class
class Mammal{
  // Every mammal should have an energy level (default 100). 
  public int energyLevel= 100;
  
  public int displayEnergy(){
    System.out.println("The Energy level for this Mammal Species is:"+ this.energyLevel);
    return this.energyLevel;
  }
}

