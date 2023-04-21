
// importing array list

import java.util.ArrayList;

class CoffeeKiosk{
  // the new properties for the coffee kiosk 
  private ArrayList<Item> menu;
  private ArrayList<Order> orders;

  //Counstructor
  public CoffeeKiosk(){
    this.menu = new ArrayList<Item>(); //defaults to null
    this.orders = new ArrayList<Order>(); //defaults to null 
  }

  //Methods 
  //addMenuItem: 
  public void addMenuItem(double price, String name){
    Item newItem = new Item(name, price); //create a new item object with the given name and price.
    newItem.setIndex(menu.indexOf(newItem));   //The new menu item itself will also need to be assigned an index property. 
    menu.add(newItem); //Add the new Item object to the menu items array.
    //The value should be its position, its index, in the menu array.
  }


//   displayMenu
// Now with an array of items you can display the menu without needing separate arrays of names and prices!
// The displayMenu method should display all of the items from the menu array like so:

  public void displayMenu(){
    System.out.println("+-----------------------------------+");
    for(int i=0; i<menu.size();i++){
      System.out.println(i +":"+ menu.get(i).getName() +"--"+ menu.get(i).getPrice());
      
    }
  }

  // newOrder method 

  public void newOrder() {

    // Shows the user a message prompt and then sets their input to a variable, name
      System.out.println("Please enter customer name for new order:");
      String name = System.console().readLine();
  
    // Your code:
    // Create a new order with the given input string
      Order newOrder = new Order(name);

      // System.out.println(name);
      // Show the user the menu, so they can choose items to add.
      displayMenu();
    // Prompts the user to enter an item number
      System.out.println("Please enter a menu item index or q to quit:");
      String itemNumber = System.console().readLine();
      
      // Write a while loop to collect all user's order items
      while(!itemNumber.equals("q")) {
          Item item = menu.get(Integer.parseInt(itemNumber));
          newOrder.addItem(item);
          System.out.println("You have just added: "+item.getName() +" To Your list" );
          System.out.println("If you'd like to continoue your orders, please press a number from the menu , or enter q to end"); 
          displayMenu();
          itemNumber = System.console().readLine(); // Get input for next itemNumber
    
          if (itemNumber.equals("q")) { // Check if user wants to quit
              break; // Exit loop
          }
          // Get the item object from the menu, and add the item to the order
          // Ask them to enter a new item index or q again, and take their input
      }
      
      newOrder.display();
  }



}