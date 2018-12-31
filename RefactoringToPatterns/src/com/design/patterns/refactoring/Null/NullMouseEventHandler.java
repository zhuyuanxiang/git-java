package com.design.patterns.refactoring.Null;

import java.awt.Event;

public class NullMouseEventHandler extends MouseEventHandler {
  public NullMouseEventHandler() {
    super(null);
  }

  public boolean mouseDown(MetaGraphicsContext mgc, Event event, int x, int y) {
    return true;
  }
}
