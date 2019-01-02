package com.design.patterns.refactoring.HTML;

import com.design.patterns.refactoring.HTML.parser.Node;

// import org.htmlparser.Node;
// import org.htmlparser.NodeReader;

public class StringParser {
  private int textBegin;
  private int textEnd;
  private StringBuffer textBuffer;
  private Parser parser;

  public Node find(NodeReader reader, String input, int position, boolean balance_quotes) {
    NodeFactory nodeFactory = new NodeFactory();
    // return parser.getStringNodeParsingOption().createStringNode(textBuffer, textBegin, textEnd);
    // return new StringNode(textBuffer, textBegin, textEnd,
    // reader.getParser().isShouldDecodeNodes());
    return StringNode.createStringNode(textBuffer, textBegin, textEnd,
        reader.getParser().isShouldDecodeNodes());
  }
}
