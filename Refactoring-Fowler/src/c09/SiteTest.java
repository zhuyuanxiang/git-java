package c09;

import static org.junit.Assert.*;
import org.junit.Test;

public class SiteTest {

  @Test
  public final void test() {
    Site site = new Site();
    Customer customer = site.getCustomer();

    BillingPlan plan = customer.getPlan();

    String customerName = customer.getName();

    int weeksDelinquent = customer.getHistory().getWeeksDelinquentInLastYear();
  }

}
