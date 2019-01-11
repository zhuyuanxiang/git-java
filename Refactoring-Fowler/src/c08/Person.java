package c08;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Person {
  private BloodGroup _bloodGroup;

  private Set _courses = new HashSet();

  public Person() {
    this(BloodGroup.O);
  }

  public Person(BloodGroup bloodGroup) {
    _bloodGroup = bloodGroup;
  }

  public void addCourse(Course arg) {
    _courses.add(arg);
  }

  public BloodGroup getBloodGroup() {
    return _bloodGroup;
  }

  public Set getCourses() {
    return Collections.unmodifiableSet(_courses);
  }

  public void initializeCourses(Set arg) {
    assert _courses.isEmpty();
    _courses.addAll(arg);
  }

  public void removeCourse(Course arg) {
    _courses.remove(arg);
  }

  void setBloodGroup(BloodGroup bloodGroup) {
    _bloodGroup = bloodGroup;
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
