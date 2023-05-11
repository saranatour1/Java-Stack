import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class TrackTest {

  public static void main(String[] args) {
    TrackList appTest = new TrackList();
    HashMap<String, String> trackList = appTest.getTrackList();
    // Value of one of the songs
    String name = trackList.get("Fairytale Of New York");
    System.out.println(name);

    Set<String> keys = trackList.keySet();
    for (String key : keys) {
      System.out.println("OUR track! " + key + '\n');
      System.out.println("OUR Lyrics! " + trackList.get(key) + '\n');
      System.out.println("_________________________________________________________________");
    }

  }
}