// displaying your account number, checking and savings amount, total amount
// . Of course, there are also methods to invoke, such as depositing a check, checking your balance, withdrawing money.

// (double) checking balance, (double) savings balance.

public class BankAccount{
  private double cheakingBalnace;
  private double savingsBalance;
  public static int member; //class?
  public static double member1; //claass?
  private double total;
  // Create a class member (static) that has the number of accounts created thus far.
  //Create a class member (static) that tracks the total amount of money stored in every account created.
 //creating a Constructor
  public BankAccount(){
    this.cheakingBalnace=0;
    this.savingsBalance=0;
    member+=1;
    member1 =this.cheakingBalnace + this.savingsBalance;
  }

  // Create a getter method for the user's checking account balance.

  public void getCheckingBalance(){
    System.out.println(cheakingBalnace);
  }

  // Create a getter method for the user's saving account balance.
  public void getSavingsAccount(){
    System.out.println(savingsBalance);
  }

  public void chooseAccount(){
    System.out.println("Choose Your bank account type :");
    System.out.println("1: Savings Account ");
    System.out.println("other: Checking Account");
  }

  // Create a method that will allow a user to deposit money into either the checking or saving, be sure to add to total amount stored.
  //implement a checking for account type function? 
  public double depositMoney(double money, int accountType) {
    if (accountType == 1) {
        cheakingBalnace += money;
    } else{
        savingsBalance += money;
    }
    total = cheakingBalnace + savingsBalance;
    return total;
    }

    // Create a method to withdraw money from one balance. Do not allow them to withdraw money if there are insufficient funds.

    public void withdraw(double money, int accountType){

      if (cheakingBalnace + savingsBalance < money || cheakingBalnace <0 || savingsBalance<0){
        System.out.println("Sorry,  insufficient funds! ");
      }else{
        if (accountType == 1) {
          cheakingBalnace -= money;
      } else{
          savingsBalance -= money;
      }
      total = cheakingBalnace + savingsBalance;
      }
    }

    // Create a method to see the total money from the checking and saving.

    public double balance(){
      return cheakingBalnace + savingsBalance ;
    }
    // Users should not be able to set any of the attributes from the class. ?? maybe this means they should be private?  under testing


}