package c09;

public class booleanExpressions {
  void checkSecurity1(String[] people) {
    for (String element : people) {
      if (element.equals("Don")) {
        sendAlert();
        break;
      }
      if (element.equals("John")) {
        sendAlert();
        break;
      }
    }
  }

  void checkSecurity2(String[] people) {
    String found = foundMiscreant(people);
    someLaterCode(found);
  }

  private String foundMiscreant(String[] people) {
    for (String element : people) {
      if (element.equals("Don")) {
        sendAlert();
        return "Don";
      }
      if (element.equals("John")) {
        sendAlert();
        return "John";
      }
    }
    return "";
  }

  private void someLaterCode(String found) {
    // TODO Auto-generated method stub

  }

  private void sendAlert() {
    // TODO Auto-generated method stub

  }

}
