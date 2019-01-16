/**
 *
 */
package com.design.patterns.refactoring.strategy;

import java.util.Date;
import java.util.List;

/**
 * @author zYx.Tom
 */
public class Loan {
  private double commitment;
  private Date expiry;
  private Date maturity;
  private double outstanding;
  private double unusedPercentage;
  private CapitalStrategy capitalStrategy;

  private Loan(double commitment, double outstanding, Date start, Date expiry, Date maturity,
      int riskRating, CapitalStrategy capitalStrategy) {
    this.commitment = commitment;
    this.expiry = expiry;
    this.maturity = maturity;
    this.outstanding = outstanding;
    this.capitalStrategy = capitalStrategy;
  }

  public static Loan newTermLoan(double commitment, Date start, Date maturity, int riskRating) {
    return new Loan(commitment, commitment, start, null, maturity, riskRating,
        new CapitalStrategyTermLoan());
  }

  public static Loan newRevolver(double commitment, Date start, Date expiry, int riskRating) {
    return new Loan(commitment, 0, start, expiry, null, riskRating, new CapitalStrategyRevolver());
  }

  public static Loan newAdvisedLine(double commitment, Date start, Date expiry, int riskRating) {
    if (riskRating > 3) {
      return null;
    }
    Loan advisedLine =
        new Loan(commitment, 0, start, expiry, null, riskRating, new CapitalStrategyAdvisedLine());
    advisedLine.setUnusedPercentage(0.1);
    return advisedLine;
  }

  public void setUnusedPercentage(double d) {
    // TODO Auto-generated method stub

  }

  public double duration() {
    return capitalStrategy.duration(this);
  }

  public double capital() {
    return capitalStrategy.capital(this);
  }

  double outstandingRiskAmount() {
    return outstanding;
  }

  double unusedRiskAmount() {
    return commitment - outstanding;
  }

  double getCommitment() {
    return commitment;
  }

  Date getExpiry() {
    return expiry;
  }

  Date getMaturity() {
    return maturity;
  }

  double getUnusedPercentage() {
    return unusedPercentage;
  }

  public List getPayments() {
    return null;
  }
}
