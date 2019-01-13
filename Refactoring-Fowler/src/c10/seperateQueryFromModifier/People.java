package c10.seperateQueryFromModifier;

public class People {
  String foundMiscreant(String[] people) {
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

  private void sendAlert() {
    // TODO Auto-generated method stub

  }

  void checkSEcurity(String people[]) {
    String found = foundMiscreant(people);
    someLaterCode(found);
  }

  private void someLaterCode(String found) {
    // TODO Auto-generated method stub

  }
}
