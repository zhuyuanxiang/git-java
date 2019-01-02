package com.design.patterns.refactoring.HTML;

public class StringNodeParsingOption {
  public boolean decodeStringNodes;

  public void setDecodeStringNodes(boolean decodeStringNodes) {
    this.decodeStringNodes = decodeStringNodes;
  }

  boolean shouldDecodeStringNodes() {
    return decodeStringNodes;
  }

  public Node createStringNode(StringBuffer textBuffer, int textBegin, int textEnd) {
    if (decodeStringNodes) {
      return new DecodingStringNode(new StringNode(textBuffer, textBegin, textEnd));
    }
    return new StringNode(textBuffer, textBegin, textEnd);
  }
}
