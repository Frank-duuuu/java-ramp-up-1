package eecs285.p1.jinyangd;

public class Location {
  private final double lat;
  private final double lon;

  public Location(double lat, double lon) {
    this.lat = lat;
    this.lon = lon;
  }

  public double getLatitude() {
    return lat;
  }

  public double getLongitude() {
    return lon;
  }

  @Override
  public String toString() {
    return String.format("[%s, %s]", lat, lon);
  }

  public boolean isWithin(Location lowerBound, Location upperBound) {
    if (lat >= lowerBound.getLatitude() && lat <= upperBound.getLatitude() &&
        lon >= lowerBound.getLongitude() && lon <= upperBound.getLongitude()) {
      return true;
    }
    return false;
  }
}
