package com.design.patterns.refactoring.Singleton;

public class Blackjack {
  public void play(){
    deal();writeln(player.getHandAsString());writeln(dealer.getHandAsStringWithFirstCardDown());
    HitStayResponse hitStayResponse;
    do{
      write("H)it or S)tay:");
      hitStayResponse=Console.obtainHitStayResponse(input);
      write(hitStayResponse.toString());
      if(hitStayResponse.shouldHit()){
        dealCardTo(player);writeln(player.getHandAsString());
      }
    }
  }
}
