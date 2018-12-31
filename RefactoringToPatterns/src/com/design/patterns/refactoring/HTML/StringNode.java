package com.design.patterns.refactoring.HTML;

public class StringNode extends Node {
  public static Node createStringNode(StringBuffer textBuffer, int textBegin, int textEnd,
      boolean shouldDecode) {
    if (shouldDecode) {
      return new DecodingNode(new StringNode(textBuffer, textBegin, textEnd));
    }
    return new StringNode(textBuffer, textBegin, textEnd);
  }

  private boolean shouldRemoveEscapeCharacters = false;

  public StringNode(StringBuffer textBuffer, int textBegin, int textEnd) {
    // TODO Auto-generated constructor stub
  }

  public StringNode(StringBuffer textBuffer, int textBegin, int textEnd, boolean shouldDecode,
      boolean shouldRemoveEscapeCharacters) {
    this(textBuffer, textBegin, textEnd);
    this.shouldRemoveEscapeCharacters = shouldRemoveEscapeCharacters;
  }

  public String toPlainTextString() {
    String result = textBuffer.toString();

    if (shouldRemoveEscapeCharacters) {
      result = ParserUtils.removeEscapeCharacters(result);
    }
    return result;
  }
}
