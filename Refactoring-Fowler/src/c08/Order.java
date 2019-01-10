package c08;

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

}
