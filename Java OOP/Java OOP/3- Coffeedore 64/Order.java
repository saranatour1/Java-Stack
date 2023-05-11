
// importing the 'ArrayList' from the java.util library
import java.io.PushbackInputStream;
import java.util.ArrayList;

public class Order {
  // the properties of the order, from name, total, ready, items.
  private String name;
  private double total;
  private boolean ready;
  private ArrayList<Item> items;

  // --------------//
  // Order Constructor, where a String name is taken as an argument
  public Order() {
    // this.name = name;
    this.total = 0.0;
    this.ready = false;
    this.items = new ArrayList<Item>(); // after instantiation this is empty
  }

  // overloaded Constructor
  public Order(String guest) {
    this.name = guest;
    this.total = 0.0;
    this.ready = false;
    this.items = new ArrayList<Item>(); // after instantiation this is empty
  }
  // -----------//

  // add items class, here we take the item, add it
  // to the array of items, and increase the total
  public void addItem(Item... items) {
    for (Item item : items) {
      this.items.add(item);
      this.total += item.getPrice();
    }
  }

  // getStatusMessage
  public String getStatusMessage() {
    // if (items.size() >0){
    // ready=true;
    // }
    return ready == true ? "hello " + name + ". Your order is ready."
        : "Thank you for waiting. Your order will be ready soon.";
  }

  // getOrderTotal
  public double getOrderTotal() {
    return this.total;
  }

  // Change the ready status
  public boolean isReady() {
    return ready = true;
  }

  // display order details
  public void display() {
    System.out.println("+--------------------+");
    System.out.println("You order details:");
    System.out.println("| " + "Customer name: " + name + " |");
    for (int i = 0; i < items.size(); i++) {
      System.out.println("| " + items.get(i).getName() + "--" + items.get(i).getPrice() + " $|");
    }
    System.out.println("| " + "total :    --    " + total + " $|");
    System.out.println("+--------------------+");
  }

}