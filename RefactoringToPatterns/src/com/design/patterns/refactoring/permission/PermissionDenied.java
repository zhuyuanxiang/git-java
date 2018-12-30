package com.design.patterns.refactoring.permission;

public class PermissionDenied extends PermissionState {

  public PermissionDenied() {
    super("DENIED");
  }

  @Override
  void claimedBy(SystemAdmin admin, SystemPermission permission) {
    // TODO Auto-generated method stub

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
