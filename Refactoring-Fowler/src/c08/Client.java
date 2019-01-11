package c08;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Client {
  static int numberOfOrdersFor(Collection orders, String customer) {
    int result = 0;
    Iterator iter = orders.iterator();
    while (iter.hasNext()) {
      Order each = (Order) iter.next();
      if (each.getCustomerName().equals(customer)) {
        result++;
      }
    }
    return result;
  }

  static void readArray() {
    Performance row = new Performance();
    row.setName("Liverpool");
    row.setWins("15");

    String name = row.getName();
    int wins = row.getWins();

  }

  void addCourses() {
    Person kent = new Person();
    kent.addCourse(new Course("Smalltalk Programming", false));
    kent.addCourse(new Course("Appreciating Single Malts", true));
    // Set s = new HashSet();
    // s.add(new Course("Smalltalk Programming", false));
    // s.add(new Course("Appreciating Single Malts", true));
    // kent.initializeCourses(s);
    assert 2 == kent.getCourses().size();
    Course refact = new Course("Refactoring", true);
    kent.addCourse(refact);
    kent.addCourse(new Course("Brutal Sarcasm", false));
    // kent.getCourses().add(refact);
    // kent.getCourses().add(new Course("Brutal Sarcasm", false));
    assert 4 == kent.getCourses().size();
    kent.removeCourse(refact);
    kent.getCourses().remove(refact); // 集合已经成为不可修改的，可能运行到这里会报错。
    assert 3 == kent.getCourses().size();
  }

  /**
   * @deprecated Use {@link c08.Person#countAdvancedCourses()} instead
   */
  int countAdvancedCourses(Person person) {
    return person.countAdvancedCourses();
  }
}
