package com.design.patterns.refactoring.permission;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

public class SystemPermissionTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public final void testClaimedBy() {
    final SystemPermission permission = new SystemPermission();
    assertThat(permission.getState(), is(PermissionState.REQUESTED));
    permission.claimed();
    assertEquals(PermissionState.CLAIMED, permission.getState());
    permission.denied();
    assertEquals(PermissionState.DENIED, permission.getState());
  }

  @Test
  public final void testGrantedBy() {
    final SystemPermission permission = new SystemPermission();
    assertThat(permission.getState(), is(PermissionState.REQUESTED));
    permission.claimed();
    assertEquals(PermissionState.CLAIMED, permission.getState());
    permission.granted();
    assertEquals(PermissionState.GRANTED, permission.getState());
  }
}
