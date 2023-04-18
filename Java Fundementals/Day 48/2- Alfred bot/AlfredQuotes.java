import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    // Do the guest greeting, input type String, output typr string
    public String guestGreeting(String name) {
        return "Hello, "+ name+" Lovely to see you.";
    }
    // inputs none, output String
    // date anouncment method
    public String dateAnnouncement() {
        Date date = new Date();
      return "It is currently " + date ;
    }
    // inputs String conversation , return type String
    public String respondBeforeAlexis(String conversation) {
    int hasAlexis= conversation.indexOf("Alexis");
    // System.out.println(hasAlexis);
    int hasAlfred =conversation.indexOf("Alfred");
    if (hasAlexis >=0){
      return "Right away, sir. She certainly isn't sophisticated enough for that.";
    }
    else if (hasAlexis<=0 && hasAlfred >0){
      return "At your service. As you wish, naturally.";
    }
    else{
      return "Right. And with that I shall retire.";
    }
    }
    //go back
	// NINJA BONUS
	// See the specs to overload the guestGreeting method 
        // SENSEI BONUS
        // Write your own AlfredQuote method using any of the String methods you have learned!
}

