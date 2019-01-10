package c08;

import java.util.Dictionary;
import java.util.Hashtable;

public class Customer {
  private final String _name;
  private static Dictionary _instance = new Hashtable<>();

  static void loadCustomers() {
    new Customer("Lemon Car Hire").store();
    new Customer("Associated Coffee Machines").store();
    new Customer("Bilston Gasworks").store();
  }

  private void store() {
    _instance.put(getName(), this);
  }

  public static Customer getNamed(String name) {
    return (Customer) _instance.get(name);
  }

  private Customer(String name) {
    _name = name;
  }

  public String getName() {
    return _name;
  }
}
