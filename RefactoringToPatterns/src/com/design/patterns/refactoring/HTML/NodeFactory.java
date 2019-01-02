package com.design.patterns.refactoring.HTML;

public class NodeFactory {
  public Node createStringNode(StringBuffer textBuffer, int textBegin, int textEnd,
      boolean shouldDecode) {
    if (shouldDecode) {
      return new DecodingNode(new StringNode(textBuffer, textBegin, textEnd));
    }
    return new StringNode(textBuffer, textBegin, textEnd);
  }
}
