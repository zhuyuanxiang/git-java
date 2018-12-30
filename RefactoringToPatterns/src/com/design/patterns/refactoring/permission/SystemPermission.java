package com.design.patterns.refactoring.permission;

public class SystemPermission {
  private String state;
  private boolean granted;

  public final static String REQUESTED = "REQUESTED";
  public final static String CLAIMED = "CLAIMED";
  public final static String DENIED = "DENIED";
  public final static String GRANTED = "GRANTED";

  public SystemPermission() {
    state = SystemPermission.REQUESTED;
    granted = false;
  }

  public void claimed() {
    if (state.equals(SystemPermission.REQUESTED)) {
      state = SystemPermission.CLAIMED;
    }
  }

  public void denied() {
    if (state.equals(SystemPermission.CLAIMED)) {
      state = SystemPermission.DENIED;
    }
  }

  public void granted() {
    if (!state.equals(SystemPermission.CLAIMED)) {
      return;
    }
    state = SystemPermission.GRANTED;
    granted = true;
  }

  /**
   * @return the state
   */
  String getState() {
    return state;
  }

  /**
   * @return the granted
   */
  boolean isGranted() {
    return granted;
  }

}
