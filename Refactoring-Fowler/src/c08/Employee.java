package c08;

public abstract class Employee {
  private int _type;
  static final int ENGINEER = 0;
  static final int SALESMAN = 1;
  static final int MANAGER = 2;

  protected Employee(int type) {
    _type = type;
  }

  void setType(int type) {
    _type = type;
  }

  abstract int getType();

  static Employee create(int type) {
    switch (type) {
      case ENGINEER:
        return new Engineer();
      case SALESMAN:
        return new Salesman();
      case MANAGER:
        return new Manager();
      default:
        throw new IllegalArgumentException("Incorrect type code value");
    }
  }
}


class Engineer extends Employee {

  @Override
  int getType() {
    return Employee.ENGINEER;
  }

  Engineer() {
    super(ENGINEER);
  }
}


class Salesman extends Employee {

  @Override
  int getType() {
    return Employee.SALESMAN;
  }

  Salesman() {
    super(SALESMAN);
  }
}


class Manager extends Employee {

  @Override
  int getType() {
    return Employee.MANAGER;
  }

  Manager() {
    super(MANAGER);
  }
}
