import java.util.Date;
import java.text.SimpleDateFormat;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return String.format("Hello, %s. Lovely to see you.", name);
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        return String.format("It is currently %s", new Date());
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        if (conversation.indexOf("Alexis") > -1) {
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        else if (conversation.indexOf("Alfred") > -1) {
            return "At your service. As you wish, naturally.";
        }
        else
            return "Right. And with that I shall retire." ;
    }
    
	// NINJA BONUS
	// See the specs to overload the guestGreeting method
    public String guestGreeting(String name, String dayPeriod ) {
        return String.format("Good %s, %s. Lovely to see you.", dayPeriod, name);
    }
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
    public String excitedQuote(String quote) { 
        return quote.toUpperCase();
    }

    //NINJA BONUS SENSEI VERSION
    public String guestGreeting() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("k");
        String date = simpleDateFormat.format(new Date());
        int hour = Integer.parseInt(date);
        if (hour > 6 && hour < 12) {
            return "Good morning.";
        }
        else if (hour > 12 && hour < 20) {
            return "Good afternoon.";
        }
        else if (hour < 6 || hour > 20) {
            return "Good evening.";
        }
        else return "Good night.";
}
}