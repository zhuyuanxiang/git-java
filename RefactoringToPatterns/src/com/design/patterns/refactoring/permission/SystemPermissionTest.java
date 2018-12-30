package com.design.patterns.refactoring.permission;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SystemPermissionTest {
  private SystemPermission permission;

  @Before
  public void setUp() throws Exception {
    permission = new SystemPermission(user, profile);
  }

  @Test
  public final void testGrantedBy() {
    permission.grantedBy(admin);
    assertEquals("requested", permission.REQUESTED, permission.getState());
    assertEquals("not granted", false, permission.isGranted());
    permission.claimedBy(admin);
    permission.grantedBy(admin);
    assertEquals("granted", permission.GRANTED, permission.getState());
    assertEquals("granted", true, permission.isGranted());
  }

  @Test
  @Ignore
  public final void testClaimedByPermissionState() {
    assertThat(permission.getState(), is(PermissionState.REQUESTED));
    permission.claimed();
    assertEquals(PermissionState.CLAIMED, permission.getState());
    permission.denied();
    assertEquals(PermissionState.DENIED, permission.getState());
  }

  @Test
  @Ignore
  public final void testGrantedByPermissionState() {
    final SystemPermission permission = new SystemPermission();
    assertThat(permission.getState(), is(PermissionState.REQUESTED));
    permission.claimed();
    assertEquals(PermissionState.CLAIMED, permission.getState());
    permission.granted();
    assertEquals(PermissionState.GRANTED, permission.getState());
  }

  @Test
  public final void testClaimedBySystemPermission() {
    final SystemPermission permission = new SystemPermission();
    assertThat(permission.getState(), is(SystemPermission.REQUESTED));
    permission.claimed();
    assertEquals(SystemPermission.CLAIMED, permission.getState());
    permission.denied();
    assertEquals(SystemPermission.DENIED, permission.getState());
  }

  @Test
  public final void testGrantedBySystemPermission() {
    final SystemPermission permission = new SystemPermission();
    assertThat(permission.getState(), is(SystemPermission.REQUESTED));
    permission.claimed();
    assertEquals(SystemPermission.CLAIMED, permission.getState());
    permission.granted();
    assertEquals(SystemPermission.GRANTED, permission.getState());
  }
}
