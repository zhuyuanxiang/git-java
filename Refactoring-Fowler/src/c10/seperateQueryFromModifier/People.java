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
    // ��������Ҫ���ǵĲ��Ǵ����Ч�ʣ����Ǵ�����׶��ԣ�Ч�ʿ�����δ�����ߵ�ʱ���ٸ���ʵ����Ҫ������
    foundMiscreant(people);
    String found = foundPerson(people);
    someLaterCode(found);
  }

  private void someLaterCode(String found) {
    // TODO Auto-generated method stub

  }
}
