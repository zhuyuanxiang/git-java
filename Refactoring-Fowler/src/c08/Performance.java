package c08;

public class Performance {
  private String _name;
  private int _wins;

  public String getName() {
    return _name;
  }

  public void setName(String arg) {
    _name = arg;
  }

  public void setWins(String arg) {
    _wins = Integer.parseInt(arg);
  }

  public int getWins() {
    return _wins;
  }

}
