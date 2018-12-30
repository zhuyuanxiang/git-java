package com.design.patterns.refactoring.permission;

public class PermissionState {
  private final String name;

  public PermissionState(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }

  public final static PermissionState REQUESTED = new PermissionState("REQUESTED");
  public final static PermissionState CLAIMED = new PermissionState("CLAIMED");
  public final static PermissionState DENIED = new PermissionState("DENIED");
  public final static PermissionState GRANTED = new PermissionState("GRANTED");
}
