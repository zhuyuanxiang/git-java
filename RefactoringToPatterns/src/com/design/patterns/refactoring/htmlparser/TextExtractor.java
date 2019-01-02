package com.design.patterns.refactoring.htmlparser;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.Translate;
import com.design.patterns.refactoring.HTML.StringNode;
import com.design.patterns.refactoring.HTML.parser.LinkTag;
import com.design.patterns.refactoring.HTML.parser.Tag;

public class TextExtractor {
  private boolean isPreTag = false;
  private boolean isScriptTag = false;
  private StringBuffer results;

  public String extracctText() throws ParserException {
    Node node;
    Parser parser;
    results = new StringBuffer();
    parser.flushScanners();
    parser.registerScanners();

    for (NodeIterator e = parser.elements(); e.hasMoreNodes();) {
      node = e.nextNode();
      if (node instanceof StringNode) {
        ((StringNode) node).accept(this);
      } else if (node instanceof LinkTag) {
        accpet((LinkTag) node);
      } else if (node instanceof EndTag) {
        accept((EndTag) node);
      } else if (node instanceof Tag) {
        accept((Tag) node);
      }

    }
    return (results.toString());

  }

  private void accept(Tag tag) {
    visitTag(tag);
  }

  private void visitTag(Tag tag) {
    String tagName = tag.getTagName();
    if (tagName.equalsIgnoreCase("PRE")) {
      isPreTag = true;
    } else if (tagName.equalsIgnoreCase("SCRIPT")) {
      isScriptTag = true;
    }
  }

  private void accept(EndTag endTag) {
    visitEndTag(endTag);
  }

  private void visitEndTag(EndTag endTag) {
    String tagName = endTag.getTagName();
    if (tagName.equalsIgnoreCase("PRE")) {
      isPreTag = false;
    } else if (tagName.equalsIgnoreCase("SCRIPT")) {
      isScriptTag = false;
    }
  }

  private void accpet(LinkTag link) {
    visitLink(link);
  }

  private void visitLink(LinkTag link) {
    if (isPreTag) {
      results.append(link.getLinkText());
    } else {
      collapse(results, Translate.decode(link.getLinkText()));
    }
    if (getLinks()) {
      results.append("<" + link.getLink() + ">");
    }
  }

  public void visitStringNode(StringNode stringNode) {
    if (!isScriptTag) {
      if (isPreTag) {
        results.append(stringNode.getText());
      }
    } else {
      String text = Translate.decode(stringNode.getText());
      if (getReplaceNonBreakingSpace()) {
        text = text.replace('\u00a0', ' ');
      }
      if (getCollapse()) {
        collapse(results, text);
      } else {
        results.append(text);
      }
    }
  }
}
