package com.design.patterns.refactoring.Interpreter;

import java.awt.Color;

public class AndSpec extends Spec {
  private Spec augend, addend;

  public AndSpec(Spec augend, Spec addend) {
    this.augend = augend;
    this.addend = addend;
  }

  Spec getAugend() {
    return augend;
  }

  void setAugend(Spec augend) {
    this.augend = augend;
  }

  Spec getAddend() {
    return addend;
  }

  void setAddend(Spec addend) {
    this.addend = addend;
  }

  @Override
  public boolean isSatisfiedBy(Product product) {
    return augend.isSatisfiedBy(product) && addend.isSatisfiedBy(product);
  }
}
