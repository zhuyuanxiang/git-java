package com.design.patterns.refactoring.HTML;

import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserUtils;
import org.htmlparser.util.Translate;
import org.htmlparser.visitors.NodeVisitor;
import com.design.patterns.refactoring.HTML.parser.Node;
import com.design.patterns.refactoring.htmlparser.TextExtractor;

public class StringNode extends AbstractNode {

  // protected boolean shouldDecode = false;
  private boolean shouldRemoveEscapeCharacters = false;
  protected StringBuffer textBuffer;

  public StringNode(StringBuffer textBuffer, int textBegin, int textEnd) {
    super(textBegin, textEnd);
    this.textBuffer = textBuffer;
  }

  // private StringNode(StringBuffer textBuffer, int textBegin, int textEnd,
  // boolean shouldDecode) {
  // this(textBuffer, textBegin, textEnd);
  // setShouldDecode(shouldDecode);
  // }

  public StringNode(StringBuffer textBuffer, int textBegin, int textEnd, boolean shouldDecode,
      boolean shouldRemoveEscapeCharacters) {
    this(textBuffer, textBegin, textEnd);
    // setShouldDecode(shouldDecode);
    this.shouldRemoveEscapeCharacters = shouldRemoveEscapeCharacters;
  }

  public void accept(NodeVisitor visitor) {
    // TODO Auto-generated method stub

  }

  public void accept(TextExtractor textExtractor) {
    textExtractor.visitStringNode(this);
  }

  public void collectInto(NodeList collectionList, String filter) {
    // TODO Auto-generated method stub

  }

  public String toHtml() {
    // TODO Auto-generated method stub
    return null;
  }

  public String toPlainTextString() {
    return textBuffer.toString();
    // String result = textBuffer.toString();
    // if (shouldDecode()) {
    // result = Translate.decode(result);
    // }
    // if (shouldRemoveEscapeCharacters) {
    // result = ParserUtils.removeEscapeCharacters(result);
    // }
    // return result;
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return null;
  }

  // public boolean shouldDecode() {
  // return false;
  // }

  // public void setShouldDecode(boolean shouldDecode) {
  // this.shouldDecode = shouldDecode;
  // }

  public static Node createStringNode(StringBuffer textBuffer, int textBegin, int textEnd,
      boolean shouldDecode) {
    return new StringNode(textBuffer, textBegin, textEnd);
  }
}
