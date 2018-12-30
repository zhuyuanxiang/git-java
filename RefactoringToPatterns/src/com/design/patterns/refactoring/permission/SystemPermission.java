package com.design.patterns.refactoring.permission;

public class SystemPermission {
  public final static String CLAIMED = "CLAIMED";
  public final static String DENIED = "DENIED";
  public final static String GRANTED = "GRANTED";
  public final static String REQUESTED = "REQUESTED";
  public final static String UNIX_CLAIMED = "UNIX_CLAIMED";
  public final static String UNIX_REQUESTED = "UNIX_REQUESTED";
  private SystemAdmin admin;

  private boolean isGranted;
  private boolean isUnixPermissionGranted;
  private PermissionState permissionState;
  private final SystemProfile profile;
  private final SystemUser requestor;

  public SystemPermission(SystemUser requestor, SystemProfile profile) {
    this.requestor = requestor;
    this.profile = profile;
    setState(PermissionState.REQUESTED);
    isGranted = false;
    notifyAdminOfPermissionRequest();
  }

  private void notifyAdminOfPermissionRequest() {
    // TODO Auto-generated method stub

  }

  public void claimed(SystemAdmin admin) {
    getState().claimedBy(admin, this);
  }

  public void denied(SystemAdmin admin) {
    getState().deniedBy(admin, this);
  }

  public PermissionState getState() {
    return permissionState;
  }

  public void granted(SystemAdmin admin) {
    getState().grantedBy(admin, this);
  }

  public void notifyUserOfPermissionRequestResult() {
    // TODO Auto-generated method stub

  }

  SystemAdmin getAdmin() {
    return admin;
  }

  SystemProfile getProfile() {
    return profile;
  }

  boolean isGranted() {
    return isGranted;
  }

  boolean isUnixPermissionGranted() {
    return isUnixPermissionGranted;
  }

  void setAdmin(SystemAdmin admin) {
    this.admin = admin;
  }

  void setGranted(boolean isGranted) {
    this.isGranted = isGranted;
  }

  void setState(PermissionState permissionState) {
    this.permissionState = permissionState;
  }

  void setUnixPermissionGranted(boolean isUnixPermissionGranted) {
    this.isUnixPermissionGranted = isUnixPermissionGranted;
  }

  public void notifyUnixAdminsOfPermissionRequest() {
    // TODO Auto-generated method stub

  }

  public void willBeHandleBy(SystemAdmin admin2) {
    // TODO Auto-generated method stub

  }

}
