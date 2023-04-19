import java.util.Random;

public class PuzzleJava {
  /*
   * Write a method that will generate and return an array with 10 random numbers between 1 and 20 inclusive.
   */

  public int[] getTenRolls() {
    int[] arr = new int[10];
    Random randMachine = new Random();
    for (int i = 0; i < arr.length; i++) {
      int result = randMachine.nextInt(21);
      arr[i] = result;
    }
    return arr;
  }

  // getRandomLetter
  public Character getRandomLetter() {
    // array to get all the alphates 
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray(); //it takes 26 letters by default 
    Random randMachine = new Random();
    int result = randMachine.nextInt(26);
    return alphabet[result];
  }

  // generatePassword
  // Write a method that uses the previous method to create a random string of eight characters and return that string.
  public String generatePassword() {
    // array to get all the alphates 
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray(); //it takes 26 letters by default 
    Random randMachine = new Random();

    String password = "";
    for (int i = 0; i < 8; i++) {
      int result = randMachine.nextInt(26);
      password += alphabet[result];
    }
    return password;
  }

  // getNewPasswordSet
  /*
   * Write a method that takes an int length as an argument and creates an array of random eight-character words.
   *  The array should be the length passed in as an int. Return the array of passwords.
   * 
   * 
   */

  //return array of passeords

  //generate an aray of passwords, where each element is supposed to have 8 charecters of passwords in it 
  public String[] getNewPasswordSet(int length) {
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    Random randMachine = new Random();
    String[] passwords = new String[length];

    for (int j = 0; j < length; j++) {
      String password = "";
      for (int i = 0; i < 8; i++) {
        int result = randMachine.nextInt(26);
        password += alphabet[result];
      }
      passwords[j] = password;
    }

    return passwords;
  }

}