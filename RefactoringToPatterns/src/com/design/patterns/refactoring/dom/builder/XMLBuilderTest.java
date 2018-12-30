/**
 *
 */
package com.design.patterns.refactoring.dom.builder;

/**
 * @author zYx.Tom
 *
 */
public class XMLBuilderTest extends AbstractBuilderTest {
  OutputBuilder createBuilder(String rootName) {
    return new XMLBuilder(rootName);
  }
}
