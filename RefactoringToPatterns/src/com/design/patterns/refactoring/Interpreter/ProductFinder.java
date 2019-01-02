package com.design.patterns.refactoring.Interpreter;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class ProductFinder {
  private ProductRepository repository;

  public ProductFinder(ProductRepository repository) {
    this.repository = repository;
  }

  public List<Product> byColor(Color colorOfProductToFind) {
    ColorSpec spec = new ColorSpec(colorOfProductToFind);
    return selectBy(spec);
  }

  public List<Product> byPrice(float priceLimit) {
    Spec spec = null;
    return selectBy(spec);
  }

  // P145 后面的代码
  public List<Product> byColorAndBelowPrice(Color color, float price) {
    AndSpec spec = new AndSpec(new ColorSpec(color), new BelowPriceSpec(price));
    return selectBy(spec);
  }

  // public List<Product> byPrice(float priceLimit) {
  // List<Product> foundProducts = new ArrayList<>();
  // for (Product product : repository.getProducts()) {
  // if (product.getPrice() == priceLimit) {
  // foundProducts.add(product);
  // }
  // }
  // return foundProducts;
  // }
  public List<Product> belowPriceAvoidingAColor(float price, Color color) {
    AndSpec spec = new AndSpec(new BelowPriceSpec(price), new NotSpec(new ColorSpec(color)));
    return selectBy(spec);
  }

  List<Product> selectBy(ProductSpecification spec) {
    List<Product> foundProducts = new ArrayList<>();
    for (Product product : repository.getProducts()) {
      if (spec.isSatisfiedBy(product)) {
        foundProducts.add(product);
      }
    }
    // Iterator<Product> products=repository.iterator();
    // while (products.hasNext()) {
    // Product product = products.next();
    // if (product.getPrice()==priceLimit)) {
    // foundProducts.add(product);
    // }
    // }
    return foundProducts;
  }
}
