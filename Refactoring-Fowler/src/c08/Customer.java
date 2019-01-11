package c08;

import java.util.Dictionary;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class Customer {
  private final String _name;
  private Set _orders = new HashSet();
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

  Set friendOrders() {
    return _orders;
  }

  void addOrder(Order arg) {
    arg.setCustomer(this);
  }

  public int getDiscount() {
    // TODO Auto-generated method stub
    return 0;
  }

  double getPriceFor(Order order) {
    assert _orders.contains(order);
    return order.getDiscountedPrice(this);
  }

  public static Set getInstances() {
    // TODO Auto-generated method stub
    return null;
  }

  public boolean containsOrder(Order order) {
    // TODO Auto-generated method stub
    return false;
  }
}
