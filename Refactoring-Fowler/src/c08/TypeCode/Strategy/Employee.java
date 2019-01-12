package c08.TypeCode.Strategy;

public class Employee {
  private EmployeeType _type;
  int _monthlySalary;
  int _commission;
  int _bonus;

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
    return _type.payAmount(this);
  }
}
