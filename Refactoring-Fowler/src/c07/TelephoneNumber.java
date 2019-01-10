package c07;

public class TelephoneNumber {
  private String _areaCode;
  private String _number;

  String get_AreaCode() {
    return _areaCode;
  }

  void set_AreaCode(String _officeAreaCode) {
    this._areaCode = _officeAreaCode;
  }

  String get_Number() {
    return _number;
  }

  void set_Number(String _officeNumber) {
    this._number = _officeNumber;
  }

  public String getTelephoneNumber() {
    return ("(" +get_AreaCode()+ ") " + get_Number());
  }
}
