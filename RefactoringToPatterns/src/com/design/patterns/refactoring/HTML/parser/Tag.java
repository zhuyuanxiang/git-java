package com.design.patterns.refactoring.HTML.parser;

import java.util.Hashtable;

public abstract class Tag {
  public static final String TAGNAME = null;

  public Tag(int tagBegin, int tagEnd, String tagContents, String tagLine) {
    // TODO super(tagBegin, tagEnd, tagContents, tagLine);
  }

  public Hashtable<String, String> getParsed() {
    // TODO Auto-generated method stub
    return null;
  }

  public int elementBegin() {
    // TODO Auto-generated method stub
    return 0;
  }

  public int elementEnd() {
    // TODO Auto-generated method stub
    return 0;
  }

  public abstract String toPlainTextString();

  public abstract String toHTML();
}
