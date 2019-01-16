/**
 *
 */
package com.design.patterns.refactoring.dom.builder;

import com.design.patterns.refactoring.tag.builder.TagNode;

/**
 * @author zYx.Tom
 */
public class XMLBuilder extends AbstractBuilder {
  private TagNode rootNode;
  private TagNode currentNode;

  public void addChild(String childTagName) {
    addTo(currentNode, childTagName);
  }

  public void addSibling(String siblingTagName) {
    addTo(currentNode.getParent(), siblingTagName);
  }

  public void addTo(TagNode parentNode, String tagName) {
    currentNode = new TagNode(tagName);
    parentNode.add(currentNode);
  }

  public void addAttribute(String attribute, String value) {
    currentNode.addAttribute(attribute, value);
  }

  public void addValue(String value) {
    currentNode.addValue(value);
  }
}
