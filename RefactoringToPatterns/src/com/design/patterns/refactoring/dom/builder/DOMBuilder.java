/**
 *
 */
package com.design.patterns.refactoring.dom.builder;

import org.w3c.dom.Document;

/**
 * @author zYx.Tom
 */
public class DOMBuilder extends AbstractBuilder {
  private Document document;
  private XMLNode rootNode;
  private XMLNode parentNode;
  private XMLNode currentNode;

  protected void init(String rootName) {
    document = new DocumentImpl();
    rootNode = new ElementAdapter(document.createElement(rootName), document);
    document.appendChild(((ElementAdapter) rootNode).getElement());
  }

  public void addAttribute(String name, String value) {
    currentNode.addAttribute(name, value);
  }

  public void addChild(String childTagName) {
    XMLNode childNode = new ElementAdapter(document.createElement(childTagName), document);
    currentNode.add(childNode);
    parentNode = currentNode;
    currentNode = childNode;
    history.push(currentNode);
  }

  public void addBeside(String siblingTagName) {
    if (currentNode == rootNode)
      throw new RuntimeException(CANNOT_ADD_BESIDE_ROOT);
    XMLNode siblingNode = new ElementAdapter(document.createElement(siblingTagName), document);
    parentNode.add(siblingNode);
    currentNode = siblingNode;
    history.pop();
    history.push(currentNode);
  }

  public void addValue(String value) {
    currentNode.addValue(value);
  }
}
