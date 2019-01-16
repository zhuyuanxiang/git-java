package com.design.patterns.refactoring.Singleton;

import static org.junit.Assert.*;
import org.junit.Test;

public class ScenarioTest {

  @Test
  public final void testDealerStandsWhenPlayerBusts() {
    Console.setPlayerResponse(new TestAlwaysHitResponse());
    int[] deck = {
        10, 8, 7, 2, 6
    };
    Blackjack blackjack = new Blackjack(deck);
    blackjack.play();
    assertTrue("dealer wins", blackjack.didDealerWin());
    assertTrue("player loses", !blackjack.didPlayerWin());
    assertTrue("dealer total", 11, blackjack.getDealerTotal());
    assertTrue("player total", 23, blackjack.getPlayerTotal());
  }

}
