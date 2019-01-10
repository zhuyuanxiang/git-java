package c07;

public class AccountType {

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

}
