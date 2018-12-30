package com.design.patterns.refactoring.permission;

public class SystemPermission {
  private final SystemProfile profile;
  private final SystemUser requestor;
  private SystemAdmin admin;
  private final boolean isGranted;
  private String state;
  private boolean isUnixPermissionGranted;

  public final static String REQUESTED = "REQUESTED";
  public final static String CLAIMED = "CLAIMED";
  public final static String UNIX_REQUESTED = "UNIX_REQUESTED";
  public final static String UNIX_CLAIMED = "UNIX_CLAIMED";
  public final static String DENIED = "DENIED";
  public final static String GRANTED = "GRANTED";

  public SystemPermission(SystemUser requestor, SystemProfile profile) {
    this.requestor = requestor;
    this.profile = profile;
    state = SystemPermission.REQUESTED;
    isGranted = false;
    notifyAdminOfPermissionRequest();
  }

  public void claimedBy(SystemAdmin admin) {
    if (!state.equals(SystemPermission.REQUESTED) && !state.equals(UNIX_REQUESTED)) {
      return;
    }
    willBeHandleBy(admin);
    if (state.equals(SystemPermission.REQUESTED)) {
      state = SystemPermission.CLAIMED;
    } else if (state.equals(SystemPermission.UNIX_REQUESTED)) {
      state = SystemPermission.UNIX_CLAIMED;
    }
  }

  public void deniedBy(SystemAdmin admin) {
    if (!state.equals(SystemPermission.CLAIMED) && !state.equals(SystemPermission.UNIX_CLAIMED)) {
      return;
    }
    if (!this.admin.equals(admin)) {
      return;
    }
    isGranted = false;
    isUnixPermissionGranted = false;
    state = SystemPermission.DENIED;
    notifyUserOfPermissionRequestResult();
  }

  public void grantedBy(SystemAdmin admin) {
    if (!state.equals(SystemPermission.CLAIMED) && !state.equals(SystemPermission.CLAIMED)) {
      return;
    }
    if (!this.admin.equals(admin)) {
      return;
    }

    if (profile.isUnixPermissionRequired() && state.equals(UNIX_CLAIMED)) {
      isUnixPermissionRequired = true;
    } else if (profile.isUnixPermissionRequired && !isUnixPermissionGranted()) {
      state = SystemPermission.UNIX_REQUESTED;
      notifyUnixAdminsOfPermissionRequest();
      return;
    }
    state = SystemPermission.GRANTED;
    isGranted = true;
    notifyUserOfPermissionRequestResult();

  }

  /**
   * @return the state
   */
  String getState() {
    return state;
  }

  /**
   * @return the granted
   */
  boolean isGranted() {
    return granted;
  }

}
