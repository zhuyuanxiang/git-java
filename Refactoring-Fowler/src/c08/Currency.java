package c08;

import java.util.Dictionary;
import java.util.Hashtable;

public class Currency {
  private String _code; // immutable object
  private static Dictionary _instance = new Hashtable<>();

  static void loadCurrency() {
    new Currency("USD").store();
    new Currency("EUR").store();
    new Currency("JPY").store();
    new Currency("CNY").store();
  }

  public static Currency get(String name) {
    return (Currency) _instance.get(name);
  }

  private void store() {
    _instance.put(getCode(), this);
  }

  public String getCode() {
    return _code;
  }

  Currency(String code) {
    _code = code;
  }

  @Override
  public boolean equals(Object arg) {
    if (!(arg instanceof Currency)) {
      return false;
    }
    Currency other = (Currency) arg;
    return (_code.equals(other._code));
  }

  @Override
  public int hashCode() {
    return _code.hashCode();
  }
}
