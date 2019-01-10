package c06;

public class SplitTemporaryVariable {
  private double _primaryForce;
  private double _mass;
  private int _delay;
  private double _secondaryForce;

  double getDistanceTravelled(int time) {
    double result;
    result = getBaseDistanceTravelled(primaryAcc(), primaryTime(time));
    if (secondaryTime(time) > 0) {
      result += (primaryVel(primaryAcc()) * secondaryTime(time))
          + getBaseDistanceTravelled(secondaryAcc(), secondaryTime(time));
    }
    return result;
  }

  private double secondaryAcc() {
    return (_primaryForce + _secondaryForce) / _mass;
  }

  private double getBaseDistanceTravelled(double accelerator, int time) {
    return 0.5 * accelerator * time * time;
  }

  private double primaryVel(final double primaryAcc) {
    return primaryAcc * _delay;
  }

  private int secondaryTime(int time) {
    return time - _delay;
  }

  private int primaryTime(int time) {
    return Math.min(time, _delay);
  }

  private double primaryAcc() {
    return _primaryForce / _mass;
  }
}
