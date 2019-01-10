package c08;

public class Order {
  public Order(String customer) {
    _customer = new Customer(customer);
  }

  public String getCustomer() {
    return _customer.getName();
  }

  public void setCustomer(String arg) {
    _customer = new Customer(arg);
  }

  private Customer _customer;

  public Order getCustomerName() {
    // TODO Auto-generated method stub
    return null;
  }

}
