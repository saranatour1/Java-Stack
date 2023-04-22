
// Item class member variables:
// String name
// double price

  public class Item {
    // create a class, when instantiated name and price properties are created for that object 
      private String name; 
      private double price;
      private int index; 
      //---------//
      // Add a constructor to your Item class that takes a String name and double price
      public Item(String name, double price) {
          this.name= name;
          this.price = price;
          // adding an index varoable 
          this.index+=1; //not sure 
      }
      //--------//
      // GETTERS & SETTERS  - for name and price
      // we only need getters here! 
      public String getName(){
        return name;
      }
      //adding setter 
      public void addName(String name){
        this.name=name;
      }
      public double getPrice(){
        return price;
      }
      //adding setter 
      public void addPrice(double price){
        this.price=price;
      }
      //added an index getter maybe this should become a variable that is being ++ by the instantiation of a new object?
      public int getIndex(){
        return index;
      }
      // adding a setter 
      public void addIndex(){
        this.index+=1; //not sure
      }
      public void setIndex(int index) {
        this.index = index;
    }
    
  
    }


