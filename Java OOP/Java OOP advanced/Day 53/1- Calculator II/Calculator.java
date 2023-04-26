import java.util.ArrayList;

class Calculator {
//  array lists now
// as long as the oparation is not '=' don't take the result, all the things are in the operation() method

  private ArrayList < String > everyThing;
  private double result;

  public Calculator() {
      // this.firstNumber = 0.0;
      // this.secondNumber = 0.0;
      // this.operationCode = "";
  this.everyThing = new ArrayList<String>();   //Initaite an empty array
    // this.result = 0.0;
  }


  /*
   * we would have a vals variable operation ()
   * this operation takes all the possible values and adds them to the array list 
   * if the vals is '=' this ends the operation
   * once that happens, it returns the result
   * second try :D:D 
   */


  public void performOperation(String vals) {
    everyThing.add(vals);

    if(vals.equals("=")){
      getResults();
    }

    for(int i =0; i< everyThing.size(); i++){

      if(everyThing.get(i).matches("^[+-]?\\d+(\\.\\d+)?$") ){ //regex for is a number
        double firstNumber = Double.parseDouble(everyThing.get(i));
      }else if(everyThing.get(i).equals("+")   ){

      } 
      
    }


    // double firstNumber = Double.parseDouble(firstNumberStr);
      
    // //get the code operation + or - 
    // System.out.println("Please enter an operation of either + or -:");
    // String operationCode = System.console().readLine();


    }


    // // Get first number from the command line
    // System.out.println("Please enter your first number:");
    // String firstNumberStr = System.console().readLine();
    // double firstNumber = Double.parseDouble(firstNumberStr);

    // //get the code operation + or - 
    // System.out.println("Please enter an operation of either + or -:");
    // String operationCode = System.console().readLine();
    
    // //get the second number 
    // System.out.println("Please enter the second number:");
    // String secondNumberStr = System.console().readLine();
    // double secondNumber = Double.parseDouble(secondNumberStr);

    // //do the operations based on the input
    // if (operationCode.equals("")) {
    //   System.out.println("Please use a correct form of numbers");
    // } else if (operationCode.equals("+")) {
    //   result = firstNumber + secondNumber;
    // } else if (operationCode.equals("-")) {
    //   result = firstNumber - secondNumber;
    // } else {
    //   System.out.println("Please use a correct form of operation");
    // }
  // }

  public double getResults() {
    return result;
  }
}
