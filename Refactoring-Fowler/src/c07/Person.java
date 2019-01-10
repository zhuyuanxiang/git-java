package c07;

public class Person {
  private String _name;
  private TelephoneNumber _officeTelephone = new TelephoneNumber();

  public String getName() {
    return _name;
  }

  public String getTelephoneNumber() {
    return _officeTelephone.getTelephoneNumber();
  }

  TelephoneNumber get_officeTelephone() {
    return _officeTelephone;
  }

}
