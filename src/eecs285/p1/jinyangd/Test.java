/**
 * EECS 285 Project 1 -- Basic tests for Tweet and Location classes.
 */

package eecs285.p1.jinyangd; // replace with your uniqname

import java.util.ArrayList;

public class Test {
  public static void main(String[] args) {
    Location location1 = new Location(42.28, -83.75);
    printLocationInfo(location1);
    Location location2 = new Location(37.87, -122.27);
    printLocationInfo(location2);
    
    Tweet tweet1 = new Tweet("i love my job. #winning",
                             location1.getLatitude(),
                             location1.getLongitude());
    printTweetInfo(tweet1);
    Tweet tweet2 = new Tweet("i hate my job",
                             location2.getLatitude(),
                             location2.getLongitude());
    printTweetInfo(tweet2);
    Tweet tweet3 = new Tweet("michigan wolverines",
                             location1.getLatitude(),
                             location1.getLongitude());
    printTweetInfo(tweet3);
  }

  private static void printTweetInfo(Tweet tweet) {
    System.out.println(tweet);
    System.out.println("  Text: " + tweet.getText());
    System.out.println("  Location: " + tweet.getLocation());
    System.out.println("  Words:");
    ArrayList<String> words = tweet.getWords();
    for (int i = 0; i < words.size(); i++) {
      System.out.println("    " + words.get(i));
    }
  }

  private static void printLocationInfo(Location location) {
    System.out.println(location);
    System.out.println("  Latitude: " + location.getLatitude());
    System.out.println("  Longitude: " + location.getLongitude());
    System.out.println("  In Midwest? "
                       + location.isWithin(TweetSentimentMain
                                           .MIDWEST_LOWER_BOUND,
                                           TweetSentimentMain
                                           .MIDWEST_UPPER_BOUND));
  }
}
