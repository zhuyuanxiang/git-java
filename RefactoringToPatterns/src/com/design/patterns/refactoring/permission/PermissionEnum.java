package com.design.patterns.refactoring.permission;

public enum PermissionEnum {
  REQUESTED("REQUESTED"), CLAIMED("CLAIMED"), DENIED("DENIED"), GRANTED("GRANTED");
  private final String name;

  private PermissionEnum(String name) {
    this.name = name;
  }

}
