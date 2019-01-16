package com.design.patterns.refactoring.dom.builder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ElementAdapter implements XMLNode {
  Element element;
  Document document;

  public ElementAdapter(Element element, Document document) {
    this.element = element;
    this.document = document;
  }

  /**
   * @return the element
   */
  Element getElement() {
    return element;
  }

  @Override
  public void addAttribute(String name, String value) {
    getElement().setAttribute(name, value);
  }

  @Override
  public void add(XMLNode childNode) {
    ElementAdapter childElement = (ElementAdapter) childNode;
    getElement().appendChild(childElement.getElement());
  }

  @Override
  public void addValue(String value) {
    getElement().appendChild(document.createTextNode(value));
  }
}
