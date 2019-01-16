package com.design.patterns.refactoring.HTML.parser;

import java.io.Serializable;

public abstract class Node implements Serializable {

  public Node(int tagBegin, int tagEnd, String tagContents, String tagLine) {
  }

  public String toPlainTextString() {
    // TODO Auto-generated method stub
    return null;
  }

}
