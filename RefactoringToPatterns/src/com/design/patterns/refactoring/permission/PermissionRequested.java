package com.design.patterns.refactoring.permission;

public class PermissionRequested extends PermissionState {

  public PermissionRequested() {
    super("REQUESTED");
  }

  @Override
  void claimedBy(SystemAdmin admin, SystemPermission permission) {
    permission.willBeHandleBy(admin);
    permission.setState(PermissionState.CLAIMED);
  }

  @Override
  void deniedBy(SystemAdmin admin, SystemPermission permission) {
    // TODO Auto-generated method stub

  }

  @Override
  void grantedBy(SystemAdmin admin, SystemPermission permission) {
    // TODO Auto-generated method stub

  }
}
