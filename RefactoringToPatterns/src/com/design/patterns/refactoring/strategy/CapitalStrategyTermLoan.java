/**
 *
 */
package com.design.patterns.refactoring.strategy;

import java.util.Iterator;

/**
 * @author zYx.Tom
 *
 */
public class CapitalStrategyTermLoan extends CapitalStrategy {
  double riskAmountFor(Loan loan) {
    return loan.getCommitment();
  }

  @Override
  public double duration(Loan loan) {
    return weightedAverageDuration(loan);
  }

  private double weightedAverageDuration(Loan loan) {
    double duration = 0.0;
    double weightedAverage = 0.0;
    double sumOfPayments = 0.0;
    Iterator<Payment> loanPayments = loan.getPayments().iterator();
    while (loanPayments.hasNext()) {
      Payment payment = loanPayments.next();
      sumOfPayments += payment.amount();
      weightedAverage += yearsTo(payment.date(), loan) * payment.amount();
    }
    if (loan.getCommitment() != 0.0)
      duration = weightedAverage / sumOfPayments;
    return duration;
  }
}
