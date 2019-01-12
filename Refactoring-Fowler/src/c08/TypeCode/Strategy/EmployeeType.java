package c08.TypeCode.Strategy;

public abstract class EmployeeType {
  protected static final int ENGINEER = 0;
  protected static final int SALESMAN = 1;
  protected static final int MANAGER = 2;

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

  abstract int payAmount(Employee employee);
}


class Engineer extends EmployeeType {

  @Override
  int getTypeCode() {
    return ENGINEER;
  }

  @Override
  int payAmount(Employee employee) {
    return employee._monthlySalary;
  }

}


class Salesman extends EmployeeType {

  @Override
  int getTypeCode() {
    return SALESMAN;
  }

  @Override
  int payAmount(Employee employee) {
    return employee._monthlySalary + employee._commission;
  }

}


class Manager extends EmployeeType {

  @Override
  int getTypeCode() {
    return MANAGER;
  }

  @Override
  int payAmount(Employee employee) {
    return employee._monthlySalary + employee._bonus;
  }

}
