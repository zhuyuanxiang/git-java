package c07;

public class AccountType {

  double _interestRate;

  double get_interestRate() {
    return _interestRate;
  }

  void set_interestRate(double _interestRate) {
    this._interestRate = _interestRate;
  }

  public boolean isPremium() {
    // TODO Auto-generated method stub
    return false;
  }

  double overdraftCharge(Account account) {
    if (isPremium()) {
      double result = 10;
      if (account._daysOverdrawn > 7) {
        result += (account._daysOverdrawn - 7) * 0.85;
      }
      return result;
    } else {
      return account._daysOverdrawn * 1.75;
    }
  }

  double interestForAmount_days(double amount, int days) {
    return (get_interestRate() * amount * days) / 365;
  }

}
