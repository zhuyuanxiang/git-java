package com.design.patterns.refactoring.HTML.parser;

import java.util.Enumeration;

public class LinkTag extends CompositeTag {
  public LinkTag(int tagBegin, int tagEnd, String tagContents, String tagLine) {
    super(tagBegin, tagEnd, tagContents, tagLine);
    // TODO Auto-generated constructor stub
  }

  @Override
  public String toPlainTextString() {
    StringBuffer sb = new StringBuffer();
    Tag node;

    for (Enumeration<Node> e = linkData(); e.hasMoreElements();) {
      node = e.nextElement();
      sb.append(node.toPlainTextString());
    }

    return sb.toString();
  }

  private Enumeration<Node> linkData() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected String getHeadTagName() {
    return "A ";
  }

  @Override
  protected void putChildrenTagsInto(StringBuffer htmlContents) {
    Tag node;
    for (Enumeration<Node> e = children(); e.hasMoreElements();) {
      node = e.nextElement();
      htmlContents.append(node.toHTML());
    }
  }

  @Override
  protected void putEndTagInto(StringBuffer htmlContents) {
    htmlContents.append("</A>");
  }
}
