package c08;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Person {

  // public static final int A = BloodGroup.A.getCode();
  // public static final int AB = BloodGroup.AB.getCode();
  // public static final int B = BloodGroup.B.getCode();
  // public static final int O = BloodGroup.O.getCode();

  private BloodGroup _bloodGroup;

  private Set _courses = new HashSet();

  public Person() {
    // setBloodGroup(O);
    this(BloodGroup.O);
  }

  public Person(BloodGroup bloodGroup) {
    _bloodGroup = bloodGroup;
  }

  // public Person(int bloodGroup) {
  // setBloodGroup(BloodGroup.code(bloodGroup));
  // }

  public void addCourse(Course arg) {
    _courses.add(arg);
  }

  public BloodGroup getBloodGroup() {
    return _bloodGroup;
  }

  // public int getBloodGroupCode() {
  // return _bloodGroup.getCode();
  // }

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

  // public void setBloodGroup(int arg) {
  // _bloodGroup = BloodGroup.code(arg);
  // }

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
