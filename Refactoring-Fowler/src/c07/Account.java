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

}
