package c08.TypeCode.Strategy;

public class Employee {
  private EmployeeType _type;
  private int _monthlySalary;
  private int _commission;
  private int _bonus;

  Employee(int type) {
    setType(type);
  }

  void setType(int type) {
    _type = EmployeeType.newType(type);
  }

  int getType() {
    return _type.getTypeCode();
  }

  int payAmount() {
    switch (getType()) {
      case EmployeeType.ENGINEER:
        return _monthlySalary;
      case EmployeeType.SALESMAN:
        return _monthlySalary + _commission;
      case EmployeeType.MANAGER:
        return _monthlySalary + _bonus;
      default:
        throw new RuntimeException("Incorrect Employee");
    }
  }
}
