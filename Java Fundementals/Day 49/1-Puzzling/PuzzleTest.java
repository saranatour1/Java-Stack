import java.util.ArrayList;
import java.util.Arrays;
public class PuzzleTest {

  public static void main(String[] args) {
    PuzzleJava appTest = new PuzzleJava();

    // return an array of size 10 values 
    System.out.println("\n----- Get 10 Rolls from 1 to 20 -----");
    for (int i = 0; i < 10; i++) {
      int[] arr = appTest.getTenRolls();
      int random = arr[i];
      System.out.println("10 Rolls array = " + random); //for now 
    }

    // return  a random letter from a-z 
    System.out.println("\n----- Your random letter is:  -----");
    System.out.println("letter is  = " + appTest.getRandomLetter());

    // return  a password of 8 charecters 
    System.out.println("\n----- Your password is :  -----");
    System.out.println("Your password is= " + appTest.generatePassword());

    // return password array
    System.out.println("\n----- Your password array is :  -----");
    String[] arr = appTest.getNewPasswordSet(8);
    for (int i = 0; i < arr.length; i++) {
      System.out.println("Your password is= " + arr[i]);
    }

  }
}