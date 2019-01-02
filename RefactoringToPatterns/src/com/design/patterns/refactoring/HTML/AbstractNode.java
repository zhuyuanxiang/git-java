package com.design.patterns.refactoring.HTML;

import com.design.patterns.refactoring.HTML.parser.Node;

public abstract class AbstractNode extends Node {

  public AbstractNode(int tagBegin, int tagEnd, String tagContents, String tagLine) {
    super(tagBegin, tagEnd, tagContents, tagLine);
    // TODO Auto-generated constructor stub
  }

  public AbstractNode(int textBegin, int textEnd) {
    super(textBegin, textEnd);
    // TODO Auto-generated constructor stub
  }

  public String getTest() {
    return null;
  }

  public void setText(String text) {

  }
}
