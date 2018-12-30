package com.design.patterns.refactoring.tag.builder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TagNode {
  private StringBuffer attributes;
  private List<TagNode> children;
  private TagNode parent;
  private String name = "";
  private String value = "";

  public TagNode(String name) {
    this.name = name;
    attributes = new StringBuffer("");
  }

  public void add(TagNode childNode) {
    childNode.setParent(this);
    children().add(childNode);
  }

  private void setParent(TagNode parent) {
    this.parent = parent;
  }

  public TagNode getParent() {
    return parent;
  }

  public void addAttribute(String attribute, String value) {
    attributes.append(" " + attribute + "='" + value + "'");
  }

  public void addValue(String value) {
    this.value = value;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    StringBuffer result = new StringBuffer("");
    appendContentsTo(result);
    return result.toString();
  }

  private void writeCloseTagTo(StringBuffer result) {
    result.append("<" + name + attributes + "/>");
  }

  private void writeChildrenTo(StringBuffer result) {
    Iterator<TagNode> it = children().iterator();
    while (it.hasNext()) {
      TagNode node = it.next();
      node.appendContentsTo(result);
    }
  }

  private void writeValueTo(StringBuffer result) {
    if (!value.equals("")) {
      result.append(value);
    }
  }

  private void writeEndTagTo(StringBuffer result) {
    result.append("</" + name + ">");
  }

  private void writeOpenTagTo(StringBuffer result) {
    result.append("<" + name + attributes + ">");
  }

  private List<TagNode> children() {
    if (children == null) {
      children = new ArrayList<>();
    }
    return children;
  }

  public void appendContentsTo(StringBuffer result) {
    Iterator<TagNode> it = children().iterator();
    if (it.hasNext() || value.length() != 0) {
      writeOpenTagTo(result);
      writeChildrenTo(result);
      writeValueTo(result);
      writeEndTagTo(result);
    } else {
      writeCloseTagTo(result);
    }
  }
}
