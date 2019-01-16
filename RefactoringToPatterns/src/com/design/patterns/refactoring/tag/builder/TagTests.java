package com.design.patterns.refactoring.tag.builder;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author zYx.Tom
 *
 */
public class TagTests {
  private static final String SAMPLE_PRICE = "8.95";

  @Test
  public final void testSimpleTagWithOneAttributeAndValue() {
    TagNode priceTag = new TagNode("price");
    priceTag.addAttribute("currency", "USD");
    priceTag.addValue(TagTests.SAMPLE_PRICE);
    String expected = "<price currency='USD'>" + TagTests.SAMPLE_PRICE + "</price>";
    Assert.assertEquals("price XML is not equals", expected, priceTag.toString());
  }

  @Test
  public final void testCompositeTagOneChild() {
    TagNode productTag = new TagNode("product");
    productTag.add(new TagNode("price"));
    String expected = "<product><price></price></product>";
    Assert.assertEquals("price XML", expected, productTag.toString());
  }

  @Test
  public final void testAddingChildrenAndGrandchildren() {
    String expected = "<orders><order><product></product></order></orders>";
    TagNode ordersTag = new TagNode("orders");
    TagNode orderTag = new TagNode("order");
    TagNode productTag = new TagNode("product");
    ordersTag.add(orderTag);
    orderTag.add(productTag);
    Assert.assertEquals("price XML", expected, ordersTag.toString());
  }
}
