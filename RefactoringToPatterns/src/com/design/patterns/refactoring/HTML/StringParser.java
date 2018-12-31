package com.design.patterns.refactoring.HTML;

public class StringParser {
  public Node find(NodeReader reader, String input, int position, boolean balance_quotes) {
    return StringNode.createStringNode(textBuffer, textBegin, textEnd,
        reader.getParser().shouldDecodeNodes());
  }
}
