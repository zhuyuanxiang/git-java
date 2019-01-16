/**
 *
 */
package com.design.patterns.refactoring.dom.builder;

/**
 * @author zYx.Tom
 */
public class DOMBuilderTest {
    private OutputBuilder createBuilder(String rootName){
      return new DOMBuilder(rootName);
    }
  }
}
