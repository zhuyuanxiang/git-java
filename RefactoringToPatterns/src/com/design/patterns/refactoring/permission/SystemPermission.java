package com.design.patterns.refactoring.permission;

public class SystemPermission {
  private boolean granted;
  private PermissionState permission;

  public SystemPermission() {
    setState(PermissionState.REQUESTED);
    granted = false;
  }

  public void claimed() {
    if (getState().equals(PermissionState.REQUESTED)) {
      setState(PermissionState.CLAIMED);
    }
  }

  public void denied() {
    if (getState().equals(PermissionState.CLAIMED)) {
      setState(PermissionState.DENIED);
    }
  }

  public void granted() {
    if (!getState().equals(PermissionState.CLAIMED)) {
      return;
    }
    setState(PermissionState.GRANTED);
    granted = true;
  }

  private void setState(PermissionState permission) {
    this.permission = permission;
  }

  PermissionState getState() {
    return permission;
  }

  boolean isGranted() {
    return granted;
  }

}
