package c08;

public class Employee {
  private int _type;
  static final int ENGINEER = 0;
  static final int SALESMAN = 1;
  static final int MANAGER = 2;

  Employee(int type) {
    _type = type;
  }

  void setType(int type) {
    _type = type;
  }

  int getType() {
    return _type;
  }
}
