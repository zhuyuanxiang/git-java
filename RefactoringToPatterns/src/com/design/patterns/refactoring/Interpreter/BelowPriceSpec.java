package com.design.patterns.refactoring.Interpreter;

public class BelowPriceSpec extends Spec {
  private float priceThreshold;

  float getPriceThreshold() {
    return priceThreshold;
  }

  void setPriceThreshold(float priceThreshold) {
    this.priceThreshold = priceThreshold;
  }

  public BelowPriceSpec(float priceThreshold) {
    this.priceThreshold = priceThreshold;
  }

  @Override
  public boolean isSatisfiedBy(Product product) {
    return product.getPrice() < getPriceThreshold();
  }
}
