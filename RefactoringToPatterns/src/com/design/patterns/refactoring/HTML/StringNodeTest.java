package com.design.patterns.refactoring.HTML;

import static org.junit.Assert.*;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.Translate;
import org.htmlparser.Node;
import org.htmlparser.tags.Tag;
import org.junit.Test;

public class StringNodeTest {
  private String ENCODED_WORKSHOP_TITLE = "The Testing &amp; Refactoring Workshop";
  private String DECODED_WORKSHOP_TITLE = "The Testing & Refactoring Workshop";
  private Parser parser = Parser.createParser(ENCODED_WORKSHOP_TITLE);

  @Test
  public final void testDecodingAmpersand() throws Exception {
    StringBuffer decodedContent = new StringBuffer();
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

  private void createParser(String stringToDecode) {
    // TODO Auto-generated method stub

  }

}
