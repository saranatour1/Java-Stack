class Calculator {
  private double firstNumber;
  private String operationCode; // this can be added as enum later
  private double secondNumber;
  private double result;

  public Calculator() {
    this.firstNumber = 0.0;
    this.secondNumber = 0.0;
    this.operationCode = "";
    this.result = 0.0;
  }

  public void setOperandOne(double firstNumber) {
    this.firstNumber = firstNumber;
  }

  public void setOperandTwo(double secondNumber) {
    this.secondNumber = secondNumber;
  }

  public void setOperation(String operationCode) {
    this.operationCode = operationCode;
  }

  public void performOperation() {
    // Get first number from the command line
    System.out.println("Please enter your first number:");
    String firstNumberStr = System.console().readLine();
    double firstNumber = Double.parseDouble(firstNumberStr);

    //get the code operation + or - 
    System.out.println("Please enter an operation of either + or -:");
    String operationCode = System.console().readLine();
    
    //get the second number 
    System.out.println("Please enter the second number:");
    String secondNumberStr = System.console().readLine();
    double secondNumber = Double.parseDouble(secondNumberStr);

    //do the operations based on the input
    if (operationCode.equals("")) {
      System.out.println("Please use a correct form of numbers");
    } else if (operationCode.equals("+")) {
      result = firstNumber + secondNumber;
    } else if (operationCode.equals("-")) {
      result = firstNumber - secondNumber;
    } else {
      System.out.println("Please use a correct form of operation");
    }
  }

  public double getResults() {
    return result;
  }
}
