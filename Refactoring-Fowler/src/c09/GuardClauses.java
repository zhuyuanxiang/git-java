package c09;

public class GuardClauses {
  private static final double ADJ_FACTOR = 0;
  private double _capital;
  private double _intRate;
  private double _duration;
  private double _income;

  public double getAdjustedCapital() {
    double result = 0.0;
    if (_capital > 0.0) {
      if ((_intRate > 0.0) && (_duration > 0.0)) {
        result = (_income / _duration) * ADJ_FACTOR;
      }
    }
    return result;
  }

}
