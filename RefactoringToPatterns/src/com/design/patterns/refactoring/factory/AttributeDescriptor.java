/**
 *
 */
package com.design.patterns.refactoring.factory;

/**
 * @author zYx.Tom
 *
 */
public abstract class AttributeDescriptor {
  protected AttributeDescriptor() {}
}


class BooleanDescriptor extends AttributeDescriptor {
  public BooleanDescriptor() {
    super();
  }
}


class DefaultDescriptor extends AttributeDescriptor {
  public DefaultDescriptor() {
    super();
  }
}


class ReferenceDescriptor extends AttributeDescriptor {
  public ReferenceDescriptor() {
    super();
  }
}
