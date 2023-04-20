
// importing the 'ArrayList' from the java.util library
import java.util.ArrayList;


public class Order {
  // the properties of the order, from name, total, ready, items.
    public String name;
    public double total;
    public boolean ready;
    public ArrayList<Item> items;
    
  //--------------//
  // Order Constructor, where a String name is taken as an argument 
    public Order(String name) {
        this.name = name;
        this.total = 0.0;
        this.ready = false;
        this.items = new ArrayList<Item>();
    }
    //-----------//  
    
    

}