package com.design.patterns.refactoring.Interpreter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductRepository {
  private List<Product> products = new ArrayList<>();

  List<Product> getProducts() {
    return products;
  }

  void setProducts(List<Product> products) {
    this.products = products;
  }

  public Iterator<Product> iterator() {
    return products.iterator();
  }

  public void add(Product product) {
    products.add(product);
  }

  public List<Product> selectBy(List<Spec> specs) {
    return selectBy(new CompositeSpec(specs));
  }

  public List<Product> selectBy(Spec spec) {
    List<Product> foundProducts = new ArrayList<>();
    for (Product product : foundProducts) {
      if (spec.isSatisfiedBy(product)) {
        foundProducts.add(product);
      }
    }
    return foundProducts;
  }

}
