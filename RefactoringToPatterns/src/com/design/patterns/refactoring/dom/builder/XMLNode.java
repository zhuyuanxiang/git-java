package com.design.patterns.refactoring.dom.builder;

public interface XMLNode {
  public abstract void add(XMLNode childNode);

  public abstract void addAttribute(String attribute, String value);

  public abstract void addValue(String value);
}
