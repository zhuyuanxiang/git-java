package c08.Subclass;

public class Person {
  static Person createFemale() {
    return new Person(false, 'F');
  }

  static Person createMale() {
    return new Person(true, 'M');
  }

  private final char _code;
  private final boolean _isMale;

  protected Person(boolean isMale, char code) {
    _isMale = isMale;
    _code = code;
  }

  char getCode() {
    return _code;
  }

  boolean isMale() {
    return _isMale;
  }
}
