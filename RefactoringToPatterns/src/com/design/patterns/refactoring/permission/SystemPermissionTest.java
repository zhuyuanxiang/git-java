package com.design.patterns.refactoring.permission;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SystemPermissionTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  @Ignore
  public final void testClaimedByPermissionState() {
    final SystemPermission permission = new SystemPermission();
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
