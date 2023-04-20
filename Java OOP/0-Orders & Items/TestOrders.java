public class TestOrders {
	public static void main(String[] args) {
			// Create Item objects
			//Create 4 item variables of type Item and instantiate each as an Item object. Name them item1, item2 etc.
			Item item1 = new Item("Coffee",4.4); //item1
			Item item2 = new Item("lattee",6); //item2
			Item item3 = new Item("espresso",7); //item3
			Item item4 = new Item("capotchino",10); //item4

			System.out.println(item1.getName());
			System.out.println(item1.getPrice());


			// Create 4 order variables of type Order and instantiate each as an Order object. Name them order1, order2 etc.
			Order order1 = new Order("Cindhuri");
			Order order2 = new Order("Jimmy"); 
			Order order3 = new Order("Noah");
			Order order4 =  new Order("Sam");

			order2.addItem(item1);
			order3.addItem(item4); 
			order4.addItem(item2); 
			order4.addItem(item2); 


			System.out.println("Hello! "+order1.getName()+ " Your order is now ready "  +order1.isReady()); 
			System.out.println("Hello! "+order2.getName()+ " Your order is now ready "  +order2.isReady()); 


			System.out.println("Hello, "+order1.getName() +" Your order total is " + order4.getTotal());
			System.out.println(order3.getItems());
			System.out.println(order2.getTotal()); //Order@5ca881b5
			System.out.println(order1.getTotal()); //to print the total, we had to create an instance to get the total



	}
}