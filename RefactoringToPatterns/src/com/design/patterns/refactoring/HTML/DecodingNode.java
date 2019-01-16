package com.design.patterns.refactoring.HTML;

import org.htmlparser.util.NodeList;
import org.htmlparser.util.Translate;
import org.htmlparser.visitors.NodeVisitor;
import com.design.patterns.refactoring.HTML.parser.Node;

public class DecodingNode extends StringNode {

  private Node delegate;

  // public DecodingNode(Node newDelegate) {
  // delegate = newDelegate;
  // }

  public DecodingNode(StringBuffer textBuffer, int textBegin, int textEnd) {
    super(textBuffer, textBegin, textEnd);
    delegate = new StringNode(textBuffer, textBegin, textEnd);
  }

  // @Override
  // public boolean shouldDecode() {
  // return true;
  // }

  // @Override
  // public void accept(NodeVisitor visitor) {
  // delegate.accpet(visitor);
  // }
  //
  // public void collectInto(NodeList collectionList, Class nodeType) {
  // delegate.collectInto(collectionList, nodeType);
  // }
  //
  // @Override
  @Override
  public String toPlainTextString() {
    return Translate.decode(delegate.toPlainTextString());
  }
}
