/**
 *
 */
package com.design.patterns.refactoring.dom.builder;

import org.junit.Test;

/**
 * @author zYx.Tom
 *
 */
public abstract class AbstractBuilderTest {

  protected OutputBuilder builder;

  @Test
  protected abstract OutputBuilder createBuilder(String rootName);

  @Test
  public final void testAddAboveRoot() {
    String invalidResult = "<orders><order></order></orders><customer></customer>";
    builder = createBuilder("orders");
    builder.addChild("order");
    try {
      builder.addAbove("customer");
      fail("expecting java.lang.RuntimeException");
    } catch (RuntimeException ignored) {
    }
  }


}
