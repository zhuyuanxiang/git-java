/**
 *
 */
package com.design.patterns.refactoring.strategy;

import java.util.Date;

/**
 * @author zYx.Tom
 *
 */
public abstract class CapitalStrategy {
  private static final int DAYS_PER_YEAR = 365;
  private static final int MILLIS_PER_DAY = 86400000;

  public double duration(Loan loan) {
    return yearsTo(loan.getExpiry(), loan);
  }

  protected double unusedRiskFactorFor(Loan loan) {
    return UnusedRiskFactors.getFactors().forRating(riskRating);
  }

  protected double riskFactorFor(Loan loan) {
    return RiskFactor.getFactors().forRating(riskRating);
  }

  private double yearsTo(Date endDate, Loan loan) {
    Date beginDate = loan.getToday() == null ? start : today;
    return (endDate.getTime() - beginDate.getTime()) / CapitalStrategy.MILLIS_PER_DAY
        / CapitalStrategy.DAYS_PER_YEAR;
  }

  public double capital(Loan loan) {
    return riskAmountFor(loan) * duration(loan) * riskFactorFor(loan);
  }

  public abstract double riskAmountFor(Loan loan);

}
