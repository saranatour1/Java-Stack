import java.util.ArrayList;
public class TestOrders {
	public static void main(String[] args) {
		//Creating two objects by calling the Order() constructor without args
		CoffeeKiosk appTest = new CoffeeKiosk();

		appTest.addMenuItem(17, "Capotchino");
		appTest.addMenuItem(15, "Soda");
		appTest.addMenuItem(12, "Croissant");
		appTest.addMenuItem(8, "Muffin");
		appTest.addMenuItem(20, "Steak Sandwich");
		appTest.addMenuItem(5, "Fries");
		appTest.addMenuItem(7, "Onion Rings");
		appTest.newOrder();

		}
	}
