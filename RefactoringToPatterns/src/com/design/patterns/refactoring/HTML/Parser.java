package com.design.patterns.refactoring.HTML;

import org.htmlparser.Node;
import org.htmlparser.NodeReader;
import org.htmlparser.tags.EndTag;
import org.htmlparser.tags.MetaTag;
import org.htmlparser.util.IteratorImpl;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.ParserException;
import org.htmlparser.util.ParserFeedback;

public class Parser {
  private StringNodeParsingOption stringNodeParsingOption = new StringNodeParsingOption();
  protected transient NodeReader reader;
  protected String resourceLocn;
  protected ParserFeedback feedback;
  private boolean shouldDecodeNodes = false;

  boolean isShouldDecodeNodes() {
    return shouldDecodeNodes;
  }

  void setShouldDecodeNodes(boolean shouldDecodeNodes) {
    this.shouldDecodeNodes = shouldDecodeNodes;
  }

  StringNodeParsingOption getStringNodeParsingOption() {
    return stringNodeParsingOption;
  }

  void setStringNodeParsingOption(StringNodeParsingOption option) {
    stringNodeParsingOption = option;
  }

  public void flushScanners() {
    // TODO Auto-generated method stub

  }

  public void registerScanners() {
    // TODO Auto-generated method stub

  }

  public NodeIterator elements() throws ParserException {
    boolean remove_scanner;
    Node node;
    MetaTag meta;
    String httpEquiv;
    String charset;
    boolean restart;
    EndTag end;
    IteratorImpl ret;

    remove_scanner = false;
    restart = false;
    ret = new IteratorImpl(reader, resourceLocn, feedback);
    ret = createIteratorImpl(remove_scanner, ret);

    return (ret);
  }

  private IteratorImpl createIteratorImpl(boolean remove_scanner, IteratorImpl ret) {
    // TODO Auto-generated method stub
    return null;
  }

  public static Parser createParser(String eNCODED_WORKSHOP_TITLE) {
    // TODO Auto-generated method stub
    return null;
  }

  public void setNodeDecoding(boolean b) {
    // TODO Auto-generated method stub

  }

}
