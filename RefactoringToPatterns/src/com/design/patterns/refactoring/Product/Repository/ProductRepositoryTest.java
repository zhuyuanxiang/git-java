package com.design.patterns.refactoring.Product.Repository;

import java.awt.Color;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductRepositoryTest {
  private ProductRepository repository = new ProductRepository();;
  private Product fireTruck =
      new Product("f1234", "Fire Truck", Color.red, 8.95f, ProductSize.MEDIUM);
  private Product barbieClassic =
      new Product("b7654", "Barbie Classic", Color.yellow, 15.95f, ProductSize.SMALL);
  private Product frisbee = new Product("f4321", "Frisbee", Color.pink, 9.99f, ProductSize.LARGE);
  private Product baseBall =
      new Product("b2343", "Baseball", Color.white, 9.95f, ProductSize.NOT_APPLICABLE);
  private Product toyConvertible = new Product("p1112", "Toy Porsche Convertible", Color.red,
      230.00f, ProductSize.NOT_APPLICABLE);

  @Before
  public void setUp() throws Exception {
    repository.add(fireTruck);
    repository.add(barbieClassic);
    repository.add(frisbee);
    repository.add(baseBall);
    repository.add(toyConvertible);
  }

  @Test
  public final void testFindByColor() {
    List<Product> foundProducts = repository.selectBy(new ColorSpec(Color.red));
    Assert.assertEquals("found 2 red products", 2, foundProducts.size());
    Assert.assertTrue("found fireTruck", foundProducts.contains(fireTruck));
    Assert.assertTrue("found Toy Porsche Convertible", foundProducts.contains(toyConvertible));
  }

  @Test
  public final void testFindByColorSizeAndBelowPrice() {
    CompositeSpec specs = new CompositeSpec();
    specs.add(new ColorSpec(Color.red));
    specs.add(new SizeSpec(ProductSize.SMALL));
    specs.add(new BelowPriceSpec(10.00));
    List<Product> foundProducts = repository.selectBy(specs);
    Assert.assertEquals("small red products below $10.00", 0, foundProducts.size());
  }

}
