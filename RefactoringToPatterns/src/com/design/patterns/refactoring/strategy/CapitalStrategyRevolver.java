package com.design.patterns.refactoring.strategy;

public class CapitalStrategyRevolver extends CapitalStrategy {
  @Override
  public double capital(Loan loan) {
    return super.capital(loan) + unusedCapital(loan);
  }

  private double unusedCapital(Loan loan) {
    return loan.unusedRiskAmount() * loan.duration() * unusedRiskFactorFor(loan);
  }

  @Override
  public double riskAmountFor(Loan loan) {
    return loan.outstandingRiskAmount();
  }

}
