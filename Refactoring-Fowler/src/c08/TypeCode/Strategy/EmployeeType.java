package c08.TypeCode.Strategy;

public abstract class EmployeeType {
  static final int ENGINEER = 0;
  static final int SALESMAN = 1;
  static final int MANAGER = 2;

  abstract int getTypeCode();

  static EmployeeType newType(int type) {
    switch (type) {
      case ENGINEER:
        return new Engineer();
      case SALESMAN:
        return new Salesman();
      case MANAGER:
        return new Manager();
      default:
        throw new IllegalArgumentException("Incorrect Employee Code");
    }
  }
}


class Engineer extends EmployeeType {

  @Override
  int getTypeCode() {
    return ENGINEER;
  }

}


class Salesman extends EmployeeType {

  @Override
  int getTypeCode() {
    return SALESMAN;
  }

}


class Manager extends EmployeeType {

  @Override
  int getTypeCode() {
    return MANAGER;
  }

}
