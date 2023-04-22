### orders and items xx barista challenge 

In this aassignment , the memebers of the method are set to private and some methods are added, 

Order properties, Class overloading : 
```java
public class Order {
  // the properties of the order, from name, total, ready, items.
    private String name;
    private double total;
    private boolean ready;
    private ArrayList<Item> items;
    
  //--------------//
  // Order Constructor, where a String name is taken as an argument 
  public Order() {
    // this.name = name;
    this.total = 0.0;
    this.ready = false;
    this.items = new ArrayList<Item>(); //after instantiation this is empty
}
    //overloaded Constructor 
    public Order(String guest) {
        this.name = guest;
        this.total = 0.0;
        this.ready = false;
        this.items = new ArrayList<Item>(); //after instantiation this is empty
    }
}
```

Same for the items Class ,with getters for the name and price:

```java
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
```

in the Order.java file, a few methods are added: 

```java
    public void addItem(Item... items) {
      for (Item item : items) {
          this.items.add(item);
          this.total += item.getPrice();
      }
  }  
    // getStatusMessage 
    public String getStatusMessage(){
      // if (items.size() >0){
      //     ready=true;
      // }
      return ready == true ? "hello " + name + ". Your order is ready." : "Thank you for waiting. Your order will be ready soon.";
    }

    //getOrderTotal
    public double getOrderTotal(){
      return this.total;
    }

    //Change the ready status 
    public boolean isReady() {
      return ready =true;
  }
    // display order details
    public void display(){
      System.out.println("+--------------------+");
      System.out.println("You order details:");
      System.out.println("| " +"Customer name: "+ name + " |");
      for(int i=0; i<items.size() ; i++){
        System.out.println("| "+ items.get(i).getName() +"--" + items.get(i).getPrice() + " $|");
      }
      System.out.println("| " +"total :    --    "+ total + " $|");
      System.out.println("+--------------------+");
    }


```

to test this, in the TestOrders.java :

```java
//Examples, Check the TestOrders for more details 
		//Creating two objects by calling the Order() constructor without args
		Order order1 = new Order();

		// Creating three  orders using the overloaded Constructor
		Order order3 = new Order("Sara");

		//Creating Items to add to the order later on 
		Item item1 = new Item("Caputchino", 12);

		//adding items to orders 
		order1.addItem(item1,item2,item3,item4);

		//Changing the status of the order
		order5.isReady();

		//Status messages 
		System.out.println(order1.getStatusMessage());

		// order total 
		System.out.println(order5.getOrderTotal());

		// display method
		order1.display();

```


### Summery 

For this assignment in particular, the purpose was to know how to use private and public access modifiers, use 'methods' to make things easier. 