package com.design.patterns.refactoring.Singleton;

public class Console {
  static private HitStayResponse hitStayResponse = new HitStayResponse();

  private Console() {
    super();
  }

  public static HitStayResponse obtainHitStayResponse(BufferedReader input) {
    hitStayResponse.readFrom(input);
    return hitStayResponse;
  }

  public static void setPlayerResponse(HitStayResponse newHitStayResponse) {
    hitStayResponse = newHitStayResponse;
  }
}
