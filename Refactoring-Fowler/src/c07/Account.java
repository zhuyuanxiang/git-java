package c07;

public class Account {
  int _daysOverdrawn;
  private AccountType _type;

  double bankCharge() {
    double result = 4.5;
    if (_daysOverdrawn > 0) {
      result += overdraftCharge();
    }
    return result;
  }

  /**
   * @deprecated Use {@link c07.AccountType#overdraftCharge(c07.Account)} instead
   */
  @Deprecated
  double overdraftCharge() {
    return _type.overdraftCharge(this);
  }

  /**
   * @deprecated Use {@link c07.AccountType#interestForAmount_days(c07.Account,double,int)} instead
   */
  @Deprecated
  double interestForAmount_days(double amount, int days) {
    return _type.interestForAmount_days(amount, days);
  }

  double get_interestRate() {
    return _type.get_interestRate();
  }

  void set_interestRate(double _interestRate) {
    _type.set_interestRate(_interestRate);
  }
}
