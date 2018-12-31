package com.design.patterns.refactoring.HTML;

public class DecodingNode extends StringNode {

  public DecodingNode(StringBuffer textBuffer, int textBegin, int textEnd) {
    delegate = new StringNode(textBuffer, textBegin, textEnd);
  }

  public DecodingNode(Node newDelegate) {
    delegate = newDelegate;
  }

  @Override
  public String toPlainTextString() {
    return Translate.decode(delegate.toPlainTextString());
  }

  private Node delegate;

  public void accept(NodeVisitor visitor) {
    delegate.accpet(visitor);
  }

  public void collectInto(NodeList collectionList, Class nodeType) {
    delegate.collectInto(collectionList, nodeType);
  }
}
