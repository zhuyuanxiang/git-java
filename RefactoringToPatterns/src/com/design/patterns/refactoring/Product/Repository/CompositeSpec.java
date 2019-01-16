package com.design.patterns.refactoring.Product.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompositeSpec extends Spec {
  private List<Spec> specs = new ArrayList<>();

  public CompositeSpec(List<Spec> specs) {
    this.specs = specs;
  }

  public CompositeSpec() {}

  public List<Spec> getSpecs() {
    return Collections.unmodifiableList(specs);
  }

  public void add(Spec spec) {
    specs.add(spec);
  }

  @Override
  public boolean isSatisfiedBy(Product product) {
    boolean satisfiesAllSpecs = true;
    for (Spec productSpec : getSpecs())
      satisfiesAllSpecs &= productSpec.isSatisfiedBy(product);
    return satisfiesAllSpecs;
  }
}
