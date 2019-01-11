package c08;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Person {

  public static final int A = 1;
  public static final int AB = 3;
  public static final int B = 2;
  public static final int O = 0;

  private int _bloodGroup;

  private Set _courses = new HashSet();

  public Person(int bloodGroup) {
    _bloodGroup = bloodGroup;
  }

  public void addCourse(Course arg) {
    _courses.add(arg);
  }

  public int getBloodGroup() {
    return _bloodGroup;
  }

  public Set getCourses() {
    return Collections.unmodifiableSet(_courses);
  }

  public void initializeCourses(Set arg) {
    assert _courses.isEmpty();
    _courses.addAll(arg);
    // Iterator iter = arg.iterator();
    // while (iter.hasNext()) {
    // addCourse((Course) iter.next());
    // }
  }

  public void removeCourse(Course arg) {
    _courses.remove(arg);
  }

  public void setBloodGroup(int arg) {
    _bloodGroup = arg;
  }

  private void setCourses(Set arg) {
    // 不再允许直接设置集合类型
    _courses = arg;
  }

  int countAdvancedCourses() {
    Iterator iter = getCourses().iterator();
    int count = 0;
    while (iter.hasNext()) {
      Course each = (Course) iter.next();
      if (each.isAdvanced()) {
        count++;
      }
    }
    return count;
  }
}
