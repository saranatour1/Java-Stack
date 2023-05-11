public class AlfredTest {
    /*
     * This main method will always be the launch point for a Java application
     * For now, we are using the main to test all our 
     * AlfredQuotes methods.
     */
    public static void main(String[] args) {
      // Make an instance of AlfredQuotes to access all its methods.
      AlfredQuotes alfredBot = new AlfredQuotes();
  
      // Make some test greetings, providing any necessary data
      String testGreeting = alfredBot.basicGreeting();
      String testGuestGreeting = alfredBot.guestGreeting("Beth Kane");
      String testDateAnnouncement = alfredBot.dateAnnouncement();
  
      String alexisTest = alfredBot.respondBeforeAlexis(
        "Alexis! Play some low-fi beats."
      );
      String alfredTest = alfredBot.respondBeforeAlexis(
        "I can't find my yo-yo. Maybe Alfred will know where it is.");
      String notRelevantTest = alfredBot.respondBeforeAlexis(
        "Maybe that's what Batman is about. Not winning. But failing.."
      );
  
      // Print the greetings to test.
      System.out.println(testGreeting);
      // tested on name beth  kane and it gave this output :
      //Hello, Beth Kane Lovely to see you. 
      //which is expected.
      System.out.println(testGuestGreeting);
      // here the date is being declared 
      System.out.println(testDateAnnouncement);
      // System.out.println(alexisTest); //Right away, sir. She certainly isn't sophisticated enough for that.
      // System.out.println(alfredTest); //At your service. As you wish, naturally.
      System.out.println(notRelevantTest); //Right. And with that I shall retire.
    }
  }