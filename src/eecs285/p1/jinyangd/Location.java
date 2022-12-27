package eecs285.p1.jinyangd;

public class Location {
  public Location(double lat, double lon) {

  }

  public double getLatitude() {
    return 0.0;
  }

  public double getLongitude() {
    return 0.0;
  }

  @Override
  public String toString() {
    return "";
  }

  public boolean isWithin(Location lowerBound, Location upperBound) {
    return true;
  }
}
