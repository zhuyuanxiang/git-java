package com.design.patterns.refactoring.strategy;

public class CapitalStrategyAdvisedLine extends CapitalStrategy {
  @Override
  public double capital(Loan loan) {
    return riskAmountFor(loan) * loan.duration() * riskFactorFor(loan);
  }

  private double riskAmountFor(Loan loan) {
    return loan.getCommitment() * loan.getUnusedPercentage();
  }
}
