package com.design.patterns.refactoring.permission;

public class PermissionGranted extends PermissionState {

  public PermissionGranted() {
    super("GRANTED");
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
