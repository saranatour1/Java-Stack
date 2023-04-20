
// Item class member variables:
// String name
// double price

  public class Item {
    // return String name, and double price 
      private String name; 
      private double price;
      ///
      public Item(String name, double price) {
          this.name = name;
          this.price = price;
      }
      
      public String getName() {
          return name;
      }
      
      public double getPrice() {
          return price;
      }
  }


