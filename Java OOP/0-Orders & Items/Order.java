import java.util.ArrayList;


public class Order {
    private String name;
    private double total;
    private boolean ready;
    private ArrayList<Item> items;
    
    public Order(String name) {
        this.name = name;
        this.total = 0.0;
        this.ready = false;
        this.items = new ArrayList<Item>();
    }
    //method to create items list,and get the prices as total

    
    public double getTotal(){
      return this.total;
    }

    public ArrayList<Item> getItems() {
      return items;
    }

    // adding items to the array list, updating the price
    public void addItem(Item item){
      items.add(item);
      total+= item.getPrice();
    }

    public boolean isReady(){
      return this.ready= true;
    }

    public String getName(){
      return this.name;
    }

  
    

}