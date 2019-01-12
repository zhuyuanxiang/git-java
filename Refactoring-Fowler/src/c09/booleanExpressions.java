package c09;

public class booleanExpressions {
  void checkSecurity1(String[] people) {
    boolean found = false;
    for (String element : people) {
      if (!found) {
        if (element.equals("Don")) {
          sendAlert();
          found = true;
        }
        if (element.equals("John")) {
          sendAlert();
          found = true;
        }
      }
    }
  }

  void checkSecurity2(String[] people) {
    String found = "";
    for (String element : people) {
      if (found.equals("")) {
        if (element.equals("Don")) {
          sendAlert();
          found = "Don";
        }
        if (element.equals("John")) {
          sendAlert();
          found = "John";
        }
      }
    }
    someLaterCode(found);
  }

  private void someLaterCode(String found) {
    // TODO Auto-generated method stub

  }

  private void sendAlert() {
    // TODO Auto-generated method stub

  }

}
