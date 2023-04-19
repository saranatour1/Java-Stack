

import java.util.ArrayList;
public class CafeUtil {
// start of methods
//int getStreakGoal()
//sums together every consecutive integer from 1 to 10 and returns the sum. 
    public int getStreakGoal() {
      // You do not need to code here, this is an example method
      //return the sum from 0 to 10 , output should be 55
      int sum =0;
      for(int i=0; i<= 10 ; i++){
        sum+=i;
      }
      return sum;
    }

    //total price from an array of 'prices'
    public double getOrderTotal(double[] prices){
      double total=0;
      for(int i = 0; i < prices.length; i++){
        total+=prices[i];
      }
      return total;
    }
    //display menu of items 
    public void displayMenu(ArrayList<String> menuItems){
      int i = 0;
      for(String item : menuItems){
        System.out.println( i+ " " + item);
        // other operations using name
        i++;
    }
    // add Customer //type is missing
    }
    //get all Customer names
    public void addCustomer(ArrayList<String> customers) {
      System.out.println("Please enter your name:");
      String userName = System.console().readLine();
      customers.add(userName);
      System.out.println ( "Hello" + userName);
      System.out.println("There are "+ customers.size() +" people in front of you");
    }


}