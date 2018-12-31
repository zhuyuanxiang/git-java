package com.design.patterns.refactoring.permission;

public class PermissionRequested extends PermissionState {
  private static PermissionState state = new PermissionRequested();

  private PermissionRequested() {
    super("REQUESTED");
  }

  @Override
  void claimedBy(SystemAdmin admin, SystemPermission permission) {
    permission.willBeHandleBy(admin);
    permission.setState(PermissionState.CLAIMED);
  }

  public static PermissionState state() {
    return state;
  }
}
