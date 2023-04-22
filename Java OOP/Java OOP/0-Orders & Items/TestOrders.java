import java.util.ArrayList;
public class TestOrders {
	public static void main(String[] args) {
			// Create Item objects
			//Create 4 item variables of type Item and instantiate each as an Item object. Name them item1, item2 etc.
			Item item1 = new Item("Coffee",4.4); //item1
			Item item2 = new Item("lattee",6); //item2
			Item item3 = new Item("espresso",7); //item3
			Item item4 = new Item("capotchino",10); //item4



			// Create 4 order variables of type Order and instantiate each as an Order object. Name them order1, order2 etc.
			Order order1 = new Order("Cindhuri");
			Order order2 = new Order("Jimmy"); 
			Order order3 = new Order("Noah");
			Order order4 =  new Order("Sam");



		System.out.println(order1); //prints out this : Order@7a81197d
		

		System.out.println(order1.getClass().getName());

		order2.items.add(item1);
		order2.total += item1.price;
		System.out.println(order2.name +"Your total is "+ order2.total) ;

		// added item4 to order3 
		order3.items.add(item4);
		order3.total+=item3.price;
		System.out.println(order3.name +" Your total is "+ order3.total) ;

		// added item4 to order3 
		order4.items.add(item2);
		order4.total+=item2.price;
		System.out.println(order4.name +" Your total is "+ order4.total) ;

		// order1 order's ready 
		order1.ready=true;
		if (order1.ready){
			System.out.println("hey " +order1.name+ " Your order is Ready!");
		}else{
			System.out.println("Sorry, Your order is not ready yet");
		}

		// order4 added two more items
		order4.items.add(item2);
		order4.items.add(item2);
		order4.total+=item2.price;
		System.out.println(order4.name +" Your total is "+ order4.total) ;


		//jimmy's order is ready
		// order2 order's ready 
		order2.ready=true;
		if (order2.ready){
			System.out.println("hey " +order2.name+ " Your order is Ready!");
		}else{
			System.out.println("Sorry, Your order is not ready yet");
		}


	}
}