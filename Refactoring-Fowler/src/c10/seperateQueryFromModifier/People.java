package c10.seperateQueryFromModifier;

public class People {
  void foundMiscreant(String[] people) {
    if (!foundPerson(people).equals("")) {
      sendAlert();
    }
  }

  String foundPerson(String[] people) {
    for (String element : people) {
      if (element.equals("Don")) {
        return "Don";
      }
      if (element.equals("John")) {
        return "John";
      }
    }
    return "";
  }

  private void sendAlert() {
    // TODO Auto-generated method stub

  }

  void checkSEcurity(String people[]) {
    // 编码中主要考虑的不是代码的效率，而是代码的易读性，效率可以在未来上线的时候再根据实际需要调整。
    foundMiscreant(people);
    String found = foundPerson(people);
    someLaterCode(found);
  }

  private void someLaterCode(String found) {
    // TODO Auto-generated method stub

  }
}
