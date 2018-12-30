package com.design.patterns.refactoring.permission;

public class UnixPermissionClaimed extends PermissionState {

  public UnixPermissionClaimed() {
    super("UNIX_CLAIMED");
  }

  @Override
  void grantedBy(SystemAdmin admin, SystemPermission permission) {
    if (!permission.getAdmin().equals(admin)) {
      return;
    }

    if (permission.getProfile().isUnixPermissionRequired()) {
      permission.setUnixPermissionGranted(true);
    } else if (permission.getProfile().isUnixPermissionRequired()
        && !permission.isUnixPermissionGranted()) {
      permission.setState(PermissionState.UNIX_REQUESTED);
      permission.notifyUnixAdminsOfPermissionRequest();
      return;
    }
    permission.setState(PermissionState.GRANTED);
    permission.setGranted(true);
    permission.notifyUserOfPermissionRequestResult();
  }

  @Override
  void deniedBy(SystemAdmin admin, SystemPermission permission) {
    if (!permission.getAdmin().equals(admin)) {
      return;
    }
    permission.setGranted(false);
    permission.setUnixPermissionGranted(false);
    permission.setState(PermissionState.DENIED);
    permission.notifyUserOfPermissionRequestResult();
  }

  @Override
  void claimedBy(SystemAdmin admin, SystemPermission permission) {
    // TODO Auto-generated method stub

  }
}
