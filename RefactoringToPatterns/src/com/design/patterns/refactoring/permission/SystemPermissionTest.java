package com.design.patterns.refactoring.permission;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SystemPermissionTest {
  private SystemPermission permission;
  private SystemAdmin admin;
  private SystemUser user;
  private SystemProfile profile;

  @Before
  public void setUp() throws Exception {
    permission = new SystemPermission(user, profile);
  }

  @Test
  public final void testGrantedBy() {
    permission.granted(admin);
    assertEquals("requested", permission.REQUESTED, permission.getState());
    assertEquals("not granted", false, permission.isGranted());
    permission.claimed(admin);
    permission.granted(admin);
    assertEquals("granted", permission.GRANTED, permission.getState());
    assertEquals("granted", true, permission.isGranted());
  }

  @Test
  @Ignore
  public final void testClaimedByPermissionState() {
    assertThat(permission.getState(), is(PermissionState.REQUESTED));
    permission.claimed(admin);
    assertEquals(PermissionState.CLAIMED, permission.getState());
    permission.denied(admin);
    assertEquals(PermissionState.DENIED, permission.getState());
  }

  @Test
  @Ignore
  public final void testGrantedByPermissionState() {
    final SystemPermission permission = new SystemPermission(user, profile);
    assertThat(permission.getState(), is(PermissionState.REQUESTED));
    permission.claimed(admin);
    assertEquals(PermissionState.CLAIMED, permission.getState());
    permission.granted(admin);
    assertEquals(PermissionState.GRANTED, permission.getState());
  }

  @Test
  public final void testClaimedBySystemPermission() {
    final SystemPermission permission = new SystemPermission(user, profile);
    assertThat(permission.getState(), is(SystemPermission.REQUESTED));
    permission.claimed(admin);
    assertEquals(SystemPermission.CLAIMED, permission.getState());
    permission.denied(admin);
    assertEquals(SystemPermission.DENIED, permission.getState());
  }

  @Test
  public final void testGrantedBySystemPermission() {
    final SystemPermission permission = new SystemPermission(user, profile);
    assertThat(permission.getState(), is(SystemPermission.REQUESTED));
    permission.claimed(admin);
    assertEquals(SystemPermission.CLAIMED, permission.getState());
    permission.granted(admin);
    assertEquals(SystemPermission.GRANTED, permission.getState());
  }
}
