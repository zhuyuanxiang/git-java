package com.design.patterns.refactoring.HTML;

public class Parser {
  private boolean shouldDecodeNodes = false;

  public void setNodeDecoding(boolean shouldDecodeNodes) {
    this.shouldDecodeNodes = shouldDecodeNodes;
  }

  public boolean shouldDecodeNodes() {
    return shouldDecodeNodes;
  }
}
