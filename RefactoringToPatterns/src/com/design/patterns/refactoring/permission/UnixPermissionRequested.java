package com.design.patterns.refactoring.permission;

public class UnixPermissionRequested extends PermissionState {

  public UnixPermissionRequested() {
    super("UNIX_REQUESTED");
  }

  @Override
  void claimedBy(SystemAdmin admin, SystemPermission permission) {
    permission.willBeHandleBy(admin);
    permission.setState(PermissionState.UNIX_CLAIMED);
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
