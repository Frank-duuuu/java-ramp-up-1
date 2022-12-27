/**
 * EECS 285 Project 1 -- Main driver for tweet-sentiment analysis.
 *
 * See https://eecs285.github.io/p1-sentiments/ for the project
 * specification.
 */

package eecs285.p1.jinyangd; // replace with your uniqname

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class TweetSentimentMain {
  /** Uniqname used for package and file paths. */
  public static final String UNIQNAME = "jinyangd";
  // Replace the string above with your uniqname.

  /** Sentiments filename. */
  public static final String SENTIMENT_FILE = "sentiments.csv";

  /** Tweet data filename. */
  public static final String TWEET_FILE = "soup.txt";
  // Change the filename above to run different tests. See the data
  // folder for what tweet files there are.

  /** Lower bound of rectangular approximation of Midwest region. */
  public static final Location MIDWEST_LOWER_BOUND =
    new Location(37, -104.05);

  /** Upper bound of rectangular approximation of Midwest region. */
  public static final Location MIDWEST_UPPER_BOUND =
    new Location(49, -80.517);

  /** Path to data folder. */
  public static final String DATA_PATH =
    "eecs285/proj1/" + UNIQNAME + "/data";

  /**
   * Analyzes sentiment of tweets within and outside of Midwest
   * region.
   *
   * Analyzes TWEET_FILE if args is empty. Otherwise uses args[0] as
   * the tweet filename.
   *
   * @param args  optional argument for specifying tweet file
   */
  public static void main(String[] args) {
    String tweetFile = args.length > 0 ? args[0] : TWEET_FILE;
    TweetAnalyzer analyzer =
      new TweetAnalyzer(getPath(SENTIMENT_FILE), getPath(tweetFile));
    System.out.println("Tweet file: " + tweetFile);
    System.out.println("Location boundary: " + MIDWEST_LOWER_BOUND
                       + " to " + MIDWEST_UPPER_BOUND);
    System.out.println("Sentiment within boundary: ");
    analyzer.averageSentimentWithin(MIDWEST_LOWER_BOUND,
                                    MIDWEST_UPPER_BOUND);
    System.out.println("Sentiment outside boundary: ");
    analyzer.averageSentimentOutside(MIDWEST_LOWER_BOUND,
                                     MIDWEST_UPPER_BOUND);
  }

  /**
   * Constructs full path to the given file.
   *
   * @param filename  name of file
   * @return  full path of file
   */
  static String getPath(String filename) {
    String path = null;
    try {
      path =
        URLDecoder.decode(TweetSentimentMain.class.getClassLoader()
                          .getResource(DATA_PATH + "/" + filename)
                          .getPath(), "UTF-8");
    } catch (UnsupportedEncodingException exc) {
      System.out.println("Error getting path: " + exc);
      System.exit(1);
    }
    return path;
  }
}
