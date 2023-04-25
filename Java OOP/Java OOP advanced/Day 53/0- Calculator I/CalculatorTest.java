public class CalculatorTest {
  public static void main(String[] args) {
    
  Calculator appTest = new Calculator();

  appTest.performOperation();
  System.out.println(appTest.getResults());
  }
}

/*
Calculator I
setOperandOne(10.5)
setOperation("+")
setOperandTwo(5.2)
performOperation()
getResults()


*/ 

/*
Calculator II 
 * performOperation(10.5)
performOperation("+")
performOperation(5.2)
performOperation("*")
performOperation(10)
performOperation("=")
getResults()
 * 
 */