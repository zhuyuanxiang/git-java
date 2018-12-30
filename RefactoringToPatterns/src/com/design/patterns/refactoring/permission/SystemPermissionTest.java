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
  public final void testClaimedByPermissionEnum() {
    final SystemPermission permission = new SystemPermission();
    assertThat(permission.getState(), is(PermissionEnum.REQUESTED));
    permission.claimed();
    assertEquals(PermissionEnum.CLAIMED, permission.getState());
    permission.denied();
    assertEquals(PermissionEnum.DENIED, permission.getState());
  }

  @Test
  public final void testGrantedByPermissionEnum() {
    final SystemPermission permission = new SystemPermission();
    assertThat(permission.getState(), is(PermissionEnum.REQUESTED));
    permission.claimed();
    assertEquals(PermissionEnum.CLAIMED, permission.getState());
    permission.granted();
    assertEquals(PermissionEnum.GRANTED, permission.getState());
  }

}
