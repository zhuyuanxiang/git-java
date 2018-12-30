package com.design.patterns.refactoring.tag.builder;

public class TagBuilder {
  private static int ATTRIBUTE_CHARS_SIZE = 4;
  private static int TAG_CHARS_SIZE = 5;
  private TagNode currentNode;
  private int outputBufferSize;
  private TagNode rootNode;

  public TagBuilder(String _rootTagName) {
    rootNode = new TagNode(_rootTagName);
    currentNode = rootNode;
    incrementBufferSizeByTagLength(_rootTagName);
  }

  public void addAttribute(String _attribute, String _value) {
    currentNode.addAttribute(_attribute, _value);
    incrementBufferSizeByTagLength(_attribute, _value);
  }

  public void addChild(String _childTagName) {
    addTo(currentNode, _childTagName);
  }

  public void addSibling(String _siblingTagName) {
    addTo(currentNode.getParent(), _siblingTagName);
  }

  public void addTo(TagNode _parentNode, String _childTagName) {
    currentNode = new TagNode(_childTagName);
    _parentNode.add(currentNode);
    incrementBufferSizeByTagLength(_childTagName);
  }

  public void addToParent(String _parentTagName, String _childTagName) {
    TagNode parentNode = findParentBy(_parentTagName);
    if (parentNode == null) {
      throw new RuntimeException("missing parent tag: " + _parentTagName);
    }
    addTo(parentNode, _childTagName);
  }

  public void addValue(String _value) {
    currentNode.addValue(_value);
    incrementBufferSizeByValueLength(_value);
  }

  private void incrementBufferSizeByValueLength(String _value) {
    outputBufferSize += _value.length();
  }

  public int bufferSize() {
    return outputBufferSize;
  }

  public String toXML() {
    StringBuffer xmlResult = new StringBuffer(outputBufferSize);
    rootNode.appendContentsTo(xmlResult);
    return xmlResult.toString();
  }

  private TagNode findParentBy(String _parentTagName) {
    TagNode parentNode = currentNode;
    while (parentNode != null) {
      if (_parentTagName.equals(parentNode.getName())) {
        return parentNode;
      }
      parentNode = parentNode.getParent();
    }
    return null;
  }

  private void incrementBufferSizeByTagLength(String _tagName) {
    int sizeOfOpenAndCloseTags = _tagName.length() * 2;
    outputBufferSize += (sizeOfOpenAndCloseTags + TagBuilder.TAG_CHARS_SIZE);
  }

  private void incrementBufferSizeByTagLength(String _attribute, String _value) {
    outputBufferSize += (_attribute.length() + _value.length() + TagBuilder.ATTRIBUTE_CHARS_SIZE);
  }
}
