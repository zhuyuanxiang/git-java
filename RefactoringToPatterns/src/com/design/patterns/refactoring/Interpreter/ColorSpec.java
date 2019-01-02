package com.design.patterns.refactoring.Interpreter;

import java.awt.Color;

public class ColorSpec extends Spec {
  private Color colorOfProductToFind;

  public ColorSpec(Color color) {
    colorOfProductToFind = color;
  }

  Color getColorOfProductToFind() {
    return colorOfProductToFind;
  }

  void setColorOfProductToFind(Color colorOfProductToFind) {
    this.colorOfProductToFind = colorOfProductToFind;
  }

  @Override
  public boolean isSatisfiedBy(Product product) {
    return product.getColor().equals(getColorOfProductToFind());
  }

}
