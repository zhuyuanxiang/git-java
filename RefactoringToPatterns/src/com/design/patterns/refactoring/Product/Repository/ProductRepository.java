package com.design.patterns.refactoring.Product.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductRepository {
  private List<Product> products = new ArrayList<>();

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
    for (Product product : foundProducts)
      if (spec.isSatisfiedBy(product))
        foundProducts.add(product);
    return foundProducts;
  }

}
