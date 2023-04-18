public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        // added three more coffee pricess
        double dripCoffee = 4.50;
        double latte = 5.50;
        double cappuccino = 4.00;

        // double total = 0;
        // Customer name variables (add yours below)
        String customer1  = "Cindhuri";
        // added three new customers 
        String customer2  = "Sam"; 
        String custormer3 = "Jimmy";
        String custormer4 = "Noah";

        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        // added three bolean variables that refer to the customers order
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = false;
        


        // user noah ordered a cappitchino , his order becomes true 
        if(!isReadyOrder4){
          isReadyOrder4 =! isReadyOrder4;
          System.out.println("hello! " + custormer4 +" You ordered a Cappetcino " +  isReadyOrder4 );
        }

        // sam ordered two lattes 
        if(!isReadyOrder2){
          isReadyOrder2 =! isReadyOrder2;
          System.out.println("hello! " + customer2 +" You ordered two lattess" +  isReadyOrder2 + "Your total is :" + latte*2 );
        }
        // jimmy and his wrong order 
        if(!isReadyOrder3){
          isReadyOrder3 =! isReadyOrder3;
          System.out.println("hello! " + custormer3 +" You ordered two lattess" +  isReadyOrder3 + "Your total is :" + (dripCoffee-latte) );
        }

        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        // order is ready or not for custormer1 
        System.out.println(generalGreeting + customer1 +  isReadyOrder1 ); // Displays "Welcome to Cafe Java, Cindhuri"
    	  // ** Your customer interaction print statements will go here ** //

    }
}
//go back and fix this code
