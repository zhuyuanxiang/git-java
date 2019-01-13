package c09;

import static org.junit.Assert.*;
import org.junit.Test;

public class SiteTest {

  @Test
  public final void test() {
    Site site = new Site();
    Customer customer = site.getCustomer();

    BillingPlan plan;
    if (customer == null) {
      plan = BillingPlan.basic();
    } else {
      plan = customer.getPlan();
    }

    String customerName;
    if (customer == null) {
      customerName = "occupant";
    } else {
      customerName = customer.getName();
    }

    int weeksDelinquent;
    if (customer == null) {
      weeksDelinquent = 0;
    } else {
      weeksDelinquent = customer.getHistory().getWeeksDelinquentInLastYear();
    }
  }

}
