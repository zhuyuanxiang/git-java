package c08;

import java.util.HashSet;
import java.util.Set;

public class Order {
  private Customer _customer;

  public Order(String name) {
    _customer = Customer.getNamed(name);
  }

  public String getCustomerName() {
    return _customer.getName();
  }

  public void setCustomer(String name) {
    _customer = Customer.getNamed(name);
  }

  void setCustomer(Customer arg) {
    if (_customer != null) {
      _customer.friendOrders().remove(this);
    }
    _customer = arg;
    if (_customer != null) {
      _customer.friendOrders().add(this);
    }
  }

}
