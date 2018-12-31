package com.design.patterns.refactoring.HTML;

import static org.junit.Assert.*;
import org.junit.Test;
import org.w3c.dom.traversal.NodeIterator;
import com.design.patterns.refactoring.HTML.parser.Node;

public class StringNodeTest {

  @Test
  public final void testDecodingAmpersand() {
    String ENCODED_WORKSHOP_TITLE = "The Testing &amp; Refactoring Workshop";
    String DECODED_WORKSHOP_TITLE = "The Testing & Refactoring Workshop";
    StringBuffer decodedContent = new StringBuffer();
    Parser parser = Parser.createParser(ENCODED_WORKSHOP_TITLE);
    parser.setNodeDecoding(true);
    NodeIterator nodes = parser.elements();
    while (nodes.hasMoreNodes()) {
      decodedContent.append(nodes.nextNode().toPlainTextString());
    }
    assertEquals("ampersand in string", DECODED_WORKSHOP_TITLE,
        parseToObtainDecodedResult(ENCODED_WORKSHOP_TITLE));
  }

  private String parseToObtainDecodedResult(String stringToDecode) throws ParserException {
    StringBuffer decodedContent = new StringBuffer();
    createParser(stringToDecode);
    NodeIterator nodes = parser.elements();
    while (nodes.hasMoreNodes()) {
      Node node = nodes.nextNode();
      if (node instanceof StringNode) {
        StringNode stringNode = (StringNode) node;
        decodedContent.append(Translate.decode(stringNode.toPlainTextString()));
      }
      if (node instanceof Tag) {
        decodedContent.append(node.toHTML());
      }
    }
    return decodedContent.toString();
  }

}
