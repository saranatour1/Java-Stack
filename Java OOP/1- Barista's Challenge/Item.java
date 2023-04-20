
// Item class member variables:
// String name
// double price

  public class Item {
    // create a class, when instantiated name and price properties are created for that object 
      private String name; 
      private double price;
      //---------//
      // Add a constructor to your Item class that takes a String name and double price
      public Item(String name, double price) {
          this.name = name;
          this.price = price;
      }
      //--------//
      // GETTERS & SETTERS  - for name and price
      // we only need getters here! 
      public String getName(){
        return name;
      }
      public double getPrice(){
        return price;
      }
  }


