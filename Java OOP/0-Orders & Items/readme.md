
### Tasks for Orders & Items

* Create the Item class with the member variables listed above.
_______________________________________________________
in the Item.java file :

```java
  public class Item {
    // create a class, when instantiated name and price properties are created for that object 
      public String name; 
      public double price;
    // --- 
          // a constructor class to assign the objects with their properties 
      public Item(String name, double price) {
          this.name = name;
          this.price = price;
      }
      //--------//
  }

```
______________________


*  <s>Create the Order class with the member variables listed above.</s>  

in the Order.java file: 
```java
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

```

* Create the testing file TestOrders and complete the rest of the tasks inside the testing file.
in the Test order file: 
```java
public class TestOrders {
	public static void main(String[] args) {

	}
}
```
* Create 4 item variables of type Item and instantiate each as an Item object. Name them item1, item2 etc.

While in the Test file: 
```java
  Item item1 = new Item("mocha",4.4); //item1
  Item item2 = new Item("lattee",6); //item2
  Item item3 = new Item("Coffee",7); //item3
  Item item4 = new Item("capuccino",10); //item4
```
*  <s> Set the price and the name for each -- "mocha", "latte", "drip coffee" and "capuccino" (price is up to you!) </s>

* Create 4 order variables of type Order and instantiate each as an Order object. Name them order1, order2 etc.

* Set each order's name -- "Cindhuri", "Jimmy", "Noah", "Sam".

  ```java
  Order order1 = new Order("Cindhuri");
  Order order2 = new Order("Jimmy"); 
  Order order3 = new Order("Noah");
  Order order4 =  new Order("Sam");
  ```
* Print the order1 variable to the console to see what happens.
  Prints out the object Class and the address part in the memory : Order@7a81197d
  * Predict what will happen if you print order1.total 
  it returns an error. 

* Add item1 to order2's item list and increment the order's total.
```java
order2.items.add(item1);
order2.total += item1.price;
System.out.println(order2.name +"Your total is "+ order2.total) ;
```
* order3 ordered a cappucino. Add the cappuccino to their order list and to their tab.
```java
  // added item4 to order3 
  order3.items.add(item4);
  order3.total+=item3.price;
  System.out.println(order3.name +"Your total is "+ order3.total) ;

```

* order4 added a latte. Update accordingly.
```java
  // added item4 to order3 
  order4.items.add(item2);
  order4.total+=item2.price;
  System.out.println(order4.name +" Your total is "+ order4.total) ;
```
* Cindhuri’s order is now ready. Update her status.
```java
  // order1 order's ready 
  order1.ready=true;
  if (order1.ready){
    System.out.println("hey" +order1.name+ "Your order is Ready!");
  }else{
    System.out.println("Sorry, Your order is not ready yet");
  }
```
* Sam ordered more drinks - 2 lattes. Update their order as well.

```java
  order4.items.add(item2);
  order4.items.add(item2);
  order4.total+=item2.price;
  System.out.println(order4.name +" Your total is "+ order4.total) ;
```
* Jimmy’s order is now ready. Update his status.

```java
		order2.ready=true;
		if (order2.ready){
			System.out.println("hey " +order2.name+ " Your order is Ready!");
		}else{
			System.out.println("Sorry, Your order is not ready yet");
		}
```