package com.design.patterns.refactoring.Interpreter;

import java.awt.Color;

public class NotSpec extends Spec {
  private Spec specToNegate;

  public NotSpec(Spec specToNegate) {
    this.specToNegate = specToNegate;
  }

  Spec getSpecToNegate() {
    return specToNegate;
  }

  void setSpecToNegate(Spec specToNegate) {
    this.specToNegate = specToNegate;
  }

  @Override
  public boolean isSatisfiedBy(Product product) {
    return !specToNegate.isSatisfiedBy(product);
  }
}
