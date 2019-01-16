package c06;

public interface Environmental {
  public long getTime();

  public void playWavFile(String filename);

  public boolean wavWasPlayed();

  public void resetWav();
}


class SystemEnvironment implements Environmental {

  @Override
  public long getTime() {
    return System.currentTimeMillis();
  }

  @Override
  public void playWavFile(String filename) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean wavWasPlayed() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void resetWav() {
    // TODO Auto-generated method stub

  }

}


class MockSystemEnvironment implements Environmental {

  private long current_time;

  @Override
  public long getTime() {
    return current_time;
  }

  public void setTime(long aTime) {
    current_time = aTime;
  }

  @Override
  public void playWavFile(String filename) {
    playedWav = true;
  }

  @Override
  public boolean wavWasPlayed() {
    return playedWav;
  }

  @Override
  public void resetWav() {
    playedWav = false;
  }

  private boolean playedWav = false;
}
