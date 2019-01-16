/**
 *
 */
package com.design.patterns.refactoring.strategy;

import org.junit.Test;
import junit.framework.Assert;

/**
 * @author zYx.Tom
 *
 */
public class CapitalStrategyTest {

  @Test
  public final void test() {
    Date start = november(20, 2003);
    Date maturity = november(20, 2006);
    Loan termLoan = Loan.newTermLoan(LOAN_AMOUNT, start, maturity, HIGH_RISK_RATING);
    termLoan.payment(1000.00, november(20, 2004));
    Assert.assertEquals("duration", 2.0, termLoan.duration, TWO_DIGIT_PRECISION);
    Assert.assertEquals("capital", 210.00, termLoan.duration, TWO_DIGIT_PRECISION);
    Assert.fail("Not yet implemented"); // TODO
  }

}
