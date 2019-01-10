package c08;

import java.util.Observable;

public class Interval extends Observable {
  private String _end = "0";
  private String _start = "0";
  private String _length = "0";

  String getEnd() {
    return _end;
  }

  void setEnd(String arg) {
    _end = arg;
    setChanged();
    notifyObservers();
  }

  String getStart() {
    return _start;
  }

  void setStart(String arg) {
    _start = arg;
    setChanged();
    notifyObservers();
  }

  String getLength() {
    return _length;
  }

  void setLength(String arg) {
    _length = arg;
    setChanged();
    notifyObservers();
  }

  void calculateEnd() {
    try {
      int start = Integer.parseInt(_start);
      int length = Integer.parseInt(_length);
      int end = start + length;
      setEnd(String.valueOf(end));
    } catch (NumberFormatException e) {
      throw new RuntimeException("Unexpected Number Format Error");
    }
  }

  void calculateLength() {
    try {
      int start = Integer.parseInt(_start);
      int end = Integer.parseInt(_end);
      int length = end - start;
      setLength(String.valueOf(length));
    } catch (NumberFormatException e) {
      throw new RuntimeException("Unexpected Number Format Error");
    }
  }
}
