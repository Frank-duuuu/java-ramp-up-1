/**
 * EECS 285 Project 1 -- Data structure that maps words to sentiments.
 *
 * A Sentiments object maps words to sentiment values in the range
 * [-1.0, 1.0]. A value of 0 indicates that the word has no known
 * sentiment.
 */

package eecs285.p1.jinyangd; // replace with your uniqname

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Sentiments {
  /**
   * Constructs a Sentiments mapping from the given file.
   *
   * @param filename  the path of the file to read sentiments from
   */
  public Sentiments(String filename) {
    sentimentMap = loadSentiments(filename);
  }

  /**
   * Returns the sentiment for a word as a value in the range [-1.0,
   * 1.0].
   *
   * A value of 0 indicates that the word has no known sentiment.
   *
   * @param word  the word for which to retrieve the sentiment
   * @return  the sentiment of the word
   */
  public double getSentiment(String word) {
    Double value = sentimentMap.get(word);
    return value == null ? 0 : value.doubleValue();
  }

  // Helper function to load sentiments from a file.
  private HashMap<String, Double> loadSentiments(String filename) {
    HashMap<String, Double> map = new HashMap<String, Double>();
    try {
      BufferedReader fileData =
        new BufferedReader(new FileReader(filename));
      String line;
      while ((line = fileData.readLine()) != null) {
        String[] columns = line.split(",");
        map.put(columns[0], new Double(columns[1]));
      }
    } catch (IOException exc) {
      System.out.println("Error while loading sentiments: " + exc);
      System.exit(1);
    }
    return map;
  }

  /** Internal data structure that holds word-sentiment mappings. */
  private HashMap<String, Double> sentimentMap;
}
