package c02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Timer;
import org.junit.Test;

public class LargestTest {
  @Test
  public final void testEmpty() {
    try {
      Largest.largest(new int[] {});
      fail("Should have thrown an exception");
    } catch (RuntimeException e) {
      assertTrue(true);
    }
  }

  @Test
  public final void testOne() {
    assertEquals(1, Largest.largest(new int[] {
        1
    }));
  }

  @Test
  public final void testSimple() {
    assertEquals(9, Largest.largest(new int[] {
        7, 8, 9
    }));
  }

  @Test
  public final void testNegative() {
    assertEquals(-7, Largest.largest(new int[] {
        -7, -8, -9
    }));
  }

  @Test

  public final void testDups() {
    assertEquals(9, Largest.largest(new int[] {
        7, 9, 8, 9
    }));
  }

  @Test
  public void testFromFile() throws Exception {
    String line;
    BufferedReader rdr = new BufferedReader(
        new FileReader(
            "testdata.txt"));
    while ((line = rdr.readLine()) != null) {
      if (line.startsWith("#")) { // Ignore comments
        continue;
      }
      StringTokenizer st = new StringTokenizer(line);
      if (!st.hasMoreTokens()) {
        continue; // Blank line
      }
      // Get the expected value
      String val = st.nextToken();
      int expected = Integer.valueOf(val).intValue();
      // And the arguments to Largest
      ArrayList argument_list = new ArrayList();
      while (st.hasMoreTokens()) {
        argument_list.add(Integer.valueOf(
            st.nextToken()));
      }
      // Transfer object list into native array
      int[] arguments = new int[argument_list.size()];
      for (int i = 0; i < argument_list.size(); i++) {
        arguments[i] = ((Integer) argument_list.get(i)).intValue();
      }
      // And run the assert
      assertEquals(expected,
          Largest.largest(arguments));
    }
  }

  @Test
  public void testSquareRootUsingInverse() {
    double x = Math.sqrt(4.0);
    assertEquals(2.0, x, 0.0001);
    assertEquals(4.0, x * x, 0.0001);
  }

  @Test
  public void testURLFilter() {
    Timer timer = new Timer();
    String naughty_url = "http://www.xxxxxxxxxxx.com";
    // First, check a bad URL against a small list
    URLFilter filter = new URLFilter(small_list);
    timer.start();
    filter.check(naughty_url);
    timer.end();
    assertTrue(timer.elapsedTime() < 1.0);
    // Next, check a bad URL against a big list
    URLFilter f = new URLFilter(big_list);
    timer.start();
    filter.check(naughty_url);
    timer.end();
    assertTrue(timer.elapsedTime() < 2.0);
    // Finally, check a bad URL against a huge list
    URLFilter f = new URLFilter(huge_list);
    timer.start();
    filter.check(naughty_url);
    timer.end();
    assertTrue(timer.elapsedTime() < 3.0);
  }
}
