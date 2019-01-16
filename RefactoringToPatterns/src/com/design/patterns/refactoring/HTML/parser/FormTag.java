package com.design.patterns.refactoring.HTML.parser;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class FormTag extends CompositeTag {
  private String lineSeparator;
  private String formMethod;
  private String formURL;
  private String formName;

  public FormTag(int tagBegin, int tagEnd, String tagContents, String tagLine) {
    super(tagBegin, tagEnd, tagContents, tagLine);
    // TODO Auto-generated constructor stub
  }

  @Override
  public String toPlainTextString() {
    StringBuffer stringRepresentation = new StringBuffer();;

    for (Tag node : getAllNodesVector())
      stringRepresentation.append(node.toPlainTextString());

    return stringRepresentation.toString();
  }

  private Vector<Node> getAllNodesVector() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected String getHeadTagName() {
    StringBuffer sb = new StringBuffer();
    sb.append("FORM METHOD=\"" + formMethod + "\" ACTION=\"" + formURL + "\"");
    if (formName != null && formName.length() > 0)
      sb.append(" NAME=\"" + formName + "\"");
    return sb.toString();
  }

  @Override
  protected void putChildrenTagsInto(StringBuffer htmlContents) {
    Tag node;
    Enumeration<Node> e = children.elements();
    node = e.nextElement();
    Tag tag = node;
    Hashtable<String, String> table = tag.getParsed();
    String key, value;
    for (Enumeration<String> en = table.keys(); en.hasMoreElements();) {
      key = en.nextElement();
      if (!(key.equals("METHOD") || key.equals("ACTION") || key.equals("NAME")
          || key.equals(Tag.TAGNAME))) {
        value = table.get(key);
        htmlContents.append(" " + key + "=" + "\"" + value + "\"");
      }
    }
  }

  @Override
  protected void putEndTagInto(StringBuffer htmlContents) {
    // Tag node,
    Tag prevNode = null;
    htmlContents.append(">" + lineSeparator);
    for (Tag node : children) {
      if (prevNode != null)
        if (prevNode.elementEnd() > node.elementBegin())
          htmlContents.append(lineSeparator);
      htmlContents.append(node.toHTML());
      prevNode = node;
    }
  }
}
