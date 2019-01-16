package com.design.patterns.refactoring.HTML.parser;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

public abstract class CompositeTag extends Tag {
  protected Vector<Node> children;
  protected Hashtable<String, String> parsed;

  public CompositeTag(int tagBegin, int tagEnd, String tagContents, String tagLine) {
    super(tagBegin, tagEnd, tagContents, tagLine);
  }

  public Enumeration<Node> children() {
    return children.elements();
  }

  public void putStartTagInto(StringBuffer htmlContents) {
    htmlContents.append("<" + getHeadTagName() + " ");
    String key, value;
    int i = 0;
    for (Map.Entry<String, String> entry : parsed.entrySet()) {
      key = entry.getKey();
      i++;
      if (key != Tag.TAGNAME) {
        value = entry.getValue();
        htmlContents.append(key + "=\"" + value + "\"");
        if (i < parsed.size() - 1)
          htmlContents.append(" ");
      }
    }
    htmlContents.append(">");
  }

  @Override
  public String toHTML() {
    StringBuffer htmlContents = new StringBuffer();
    putStartTagInto(htmlContents);
    putChildrenTagsInto(htmlContents);
    putEndTagInto(htmlContents);
    return htmlContents.toString();
  }

  private String getParameter(String key) {
    // TODO Auto-generated method stub
    return null;
  }

  protected abstract String getHeadTagName();

  protected abstract void putChildrenTagsInto(StringBuffer htmlContents);

  protected abstract void putEndTagInto(StringBuffer htmlContents);
}
