package c08;

import java.util.Iterator;

public class Order {
  private static final int BASE_DISCOUNT = 1;
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

  double getDiscountedPrice(Customer customer) {
    return getGrossPrice() * (BASE_DISCOUNT - customer.getDiscount());
  }

  private int getGrossPrice() {
    // TODO Auto-generated method stub
    return 0;
  }

  Customer getCustomer() {
    Iterator iter = Customer.getInstances().iterator();
    while (iter.hasNext()) {
      Customer each = (Customer) iter.next();
      if (each.containsOrder(this)) {
        return each;
      }
    }
    return null;
  }
}
