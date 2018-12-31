package com.design.patterns.refactoring.Null;

import java.applet.Applet;
import java.awt.Event;

public class NavigationApplet extends Applet {
  private MouseEventHandler mouseEventHandler = new NullMouseEventHandler();

  @Override
  public boolean mouseDown(Event evt, int x, int y) {
    // if (mouseEventHandler != null) {
    return mouseEventHandler.mouseDown(evt, x, y);
    // }
    return true;
  }

  @Override
  public boolean mouseUp(Event evt, int x, int y) {
    if (mouseEventHandler != null) {
      return super.mouseUp(evt, x, y);
    }
    return true;
  }

  @Override
  public boolean mouseMove(Event evt, int x, int y) {
    if (mouseEventHandler != null) {
      return super.mouseMove(evt, x, y);
    }
    return true;
  }

  @Override
  public boolean mouseExit(Event evt, int x, int y) {
    if (mouseEventHandler != null) {
      return super.mouseExit(evt, x, y);
    }
    return true;
  }

}
