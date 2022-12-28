package eecs285.p1.jinyangd;

import java.util.ArrayList;

public class Tweet {
  private String content;
  private Location loc;
  public Tweet(String content, double lat, double lon) {
    this.content = content;
    this.loc = new Location(lat, lon);
  }

  public String getText() {
    return content;
  }

  public Location getLocation() {
    return loc;
  }

  @Override
  public String toString() {
    return String.format("%s %s", loc.toString(), content);
  }

  private static boolean isWord(char ch) {
    return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
  }

  public ArrayList<String> getWords() {
    ArrayList<String> res = new ArrayList<>();
    StringBuilder cur = new StringBuilder();
    for (int i = 0; i < content.length(); i++) {
      if (isWord(content.charAt(i))) {
        cur.append(content.charAt(i));
      }
      else if (cur.length() != 0) {
        res.add(String.valueOf(cur));
        cur = new StringBuilder();
      }
    }
    if (cur.length() != 0) {
      res.add(String.valueOf(cur));
    }
    return res;
  }
}
