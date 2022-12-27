/**
 * EECS 285 Project 1 -- Class that reads tweet data from a file.
 *
 * Reads tweets from a file and provides access to individual tweets.
 */

package eecs285.p1.jinyangd.<uniqname>; // replace with your uniqname

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TweetReader {
  /**
   * Constructs a TweetReader over the given file.
   *
   * @param filename  the path of the file from which to read tweets
   */
  public TweetReader(String filename) {
    tweets = loadTweets(filename);
  }

  /**
   * Returns the number of tweets read.
   *
   * @return  the number of tweets in this reader
   */
  public int size() {
    return tweets.size();
  }

  /**
   * Retrieves the tweet at the given index.
   *
   * @param index  the tweet index
   * @return  the tweet at the given index
   */
  public Tweet get(int index) {
    return tweets.get(index);
  }

  // Helper function to load tweets from a file.
  private ArrayList<Tweet> loadTweets(String filename) {
    ArrayList<Tweet> tweetsList = new ArrayList<Tweet>();
    try {
      BufferedReader fileData =
        new BufferedReader(new FileReader(filename));
      String line;
      while ((line = fileData.readLine()) != null) {
        String[] fields = line.trim().split("\t");
        if (fields.length >= 4) {
          tweetsList.add(readTweet(fields));
        }
      }
    } catch (IOException exc) {
      System.out.println("Error while loading tweets: " + exc);
      System.exit(1);
    }
    return tweetsList;
  }

  // Helper function to convert string data to a tweet.
  private Tweet readTweet(String[] fields) {
    Matcher matcher = LOCATION_PATTERN.matcher(fields[0]);
    if (!matcher.find()) {
      System.out.println("Error reading tweet location: " + fields[0]);
      System.exit(1);
    }
    return new Tweet(fields[3].toLowerCase(),
                     Double.parseDouble(matcher.group(1)),
                     Double.parseDouble(matcher.group(2)));
  }

  /** Regular expression for geographic locations. */
  private static final Pattern LOCATION_PATTERN =
    Pattern.compile("\\[([0-9\\-\\.]+), ([0-9\\-\\.]+)\\]");

  /** Internal data structure that holds the tweets read. */
  private ArrayList<Tweet> tweets;
}
