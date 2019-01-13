package c09;

public class Customer {
  private String _name;
  private PaymentHistory _paymentHistory;
  private BillingPlan _billingPlan;

  public String getName() {
    return _name;
  }

  public void setName(String name) {
    _name = name;
  }

  public BillingPlan getPlan() {
    return _billingPlan;
  }

  public void setPan(BillingPlan plan) {
    _billingPlan = plan;
  }

  public PaymentHistory getHistory() {
    return _paymentHistory;
  }

  public void setHistory(PaymentHistory history) {
    _paymentHistory = history;
  }

  public boolean isNull() {
    return false;
  }

  protected Customer() {
  }

  static Customer newNull() {
    return new NullCustomer();
  }
}


class NullCustomer extends Customer {
  // ������������õķ���������Null Object��������������ֱ���ں����з��أ����������ȷ
  // NullCustomer() {
  // setName("occupant");
  // setHistory(new PaymentHistory());
  // }

  @Override
  public boolean isNull() {
    return true;
  }

  @Override
  public BillingPlan getPlan() {
    return BillingPlan.basic();
  }

  @Override
  public String getName() {
    return "occupant";
  }

  @Override
  public PaymentHistory getHistory() {
    return PaymentHistory.newNull();
  }
}
