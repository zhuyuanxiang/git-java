package c08;

import java.util.Dictionary;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import c09.BillingPlan;
import c09.PaymentHistory;

public class Customer {
  private static Dictionary _instance = new Hashtable<>();
  public static Set getInstances() {
    // TODO Auto-generated method stub
    return null;
  }
  public static Customer getNamed(String name) {
    return (Customer) _instance.get(name);
  }

  static void loadCustomers() {
    new Customer("Lemon Car Hire").store();
    new Customer("Associated Coffee Machines").store();
    new Customer("Bilston Gasworks").store();
  }

  private final String _name;

  private Set _orders = new HashSet();

  private Customer(String name) {
    _name = name;
  }

  public boolean containsOrder(Order order) {
    // TODO Auto-generated method stub
    return false;
  }

  public int getDiscount() {
    // TODO Auto-generated method stub
    return 0;
  }

  public PaymentHistory getHistory() {
    return null;
  }

  public String getName() {
    return _name;
  }

  public BillingPlan getPlan() {
    // TODO Auto-generated method stub
    return null;
  }

  private void store() {
    _instance.put(getName(), this);
  }

  void addOrder(Order arg) {
    arg.setCustomer(this);
  }

  Set friendOrders() {
    return _orders;
  }

  double getPriceFor(Order order) {
    assert _orders.contains(order);
    return order.getDiscountedPrice(this);
  }
}
