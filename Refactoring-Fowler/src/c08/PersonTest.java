package c08;

import static org.junit.Assert.*;
import org.junit.Test;

public class PersonTest {

  @Test
  public final void test() {
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
    // kent.getCourses().add(refact);// �����Ѿ���Ϊ�����޸ĵģ����е�����ᱨ��
    // kent.getCourses().add(new Course("Brutal Sarcasm", false));
    assert 4 == kent.getCourses().size();
    kent.removeCourse(refact);
    // kent.getCourses().remove(refact); // �����Ѿ���Ϊ�����޸ĵģ����е�����ᱨ��
    assert 3 == kent.getCourses().size();
  }

}
