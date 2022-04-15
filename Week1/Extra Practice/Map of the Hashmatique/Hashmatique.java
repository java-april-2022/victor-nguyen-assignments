import java.util.HashMap;

public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("What is love?", "Baby don't hurt me");
        map.put("Livin' on a Prayer", "We're halfway there");
        map.put("Don't Stop Believin'", "Hold on to the feelin'");
        map.put("Bohemian Rhapsody", "Galileo Galileo");

        String val = map.get("What is love?");

        for (String key : map.keySet()) {
            System.out.println(String.format("Track: %s: Lyrics: %s", key, map.get(key)));
        }


    }
}