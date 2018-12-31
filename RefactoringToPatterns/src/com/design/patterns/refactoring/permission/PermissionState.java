package com.design.patterns.refactoring.permission;

public abstract class PermissionState {
  private final String name;

  public PermissionState(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }

  public final static PermissionState REQUESTED = PermissionRequested.state();
  public final static PermissionState CLAIMED = new PermissionClaimed();
  public final static PermissionState DENIED = new PermissionDenied();
  public final static PermissionState GRANTED = new PermissionGranted();
  public final static PermissionState UNIX_REQUESTED = new UnixPermissionRequested();
  public final static PermissionState UNIX_CLAIMED = new UnixPermissionClaimed();

  void claimedBy(SystemAdmin admin, SystemPermission permission) {
  }

  void deniedBy(SystemAdmin admin, SystemPermission permission) {
  }

  void grantedBy(SystemAdmin admin, SystemPermission permission) {
  }
}
