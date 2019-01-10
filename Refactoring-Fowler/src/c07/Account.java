package c07;

public class Account {
  private int _daysOverdrawn;
  private AccountType _type;

  double bankCharge() {
    double result = 4.5;
    if (_daysOverdrawn > 0) {
      result += overdraftCharge();
    }
    return result;
  }

  double overdraftCharge() {
    if (_type.isPremium()) {
      double result = 10;
      if (_daysOverdrawn > 7) {
        result += (_daysOverdrawn - 7) * 0.85;
      }
      return result;
    } else {
      return _daysOverdrawn * 1.75;
    }
  }

}
