package com.design.patterns.refactoring.permission;

public class SystemPermission {
  private boolean granted;

  private PermissionEnum permission;

  public SystemPermission() {
    setState(PermissionEnum.REQUESTED);
    granted = false;
  }

  public void claimed() {
    if (getState() == PermissionEnum.REQUESTED) {
      setState(PermissionEnum.CLAIMED);
    }
  }

  public void denied() {
    if (getState() == PermissionEnum.CLAIMED) {
      setState(PermissionEnum.DENIED);
    }
  }

  public void granted() {
    if (getState() == (PermissionEnum.CLAIMED)) {
      setState(PermissionEnum.GRANTED);
      granted = true;
    }
  }

  private void setState(PermissionEnum permission) {
    this.permission = permission;
  }

  PermissionEnum getState() {
    return permission;
  }

  boolean isGranted() {
    return granted;
  }

}
