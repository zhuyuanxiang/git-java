package com.design.patterns.refactoring.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import junit.framework.Test;
import junit.framework.TestFailure;

public class TestResult {
  protected TestListener fRunner;
  private List<TestListener> observers = new ArrayList<>();
  private Vector<TestFailure> fFailures;
  private Vector<TestFailure> fErrors;
  private int fRunTests;
  private boolean fStop;

  public TestResult(TestListener runner) {
    // this();
    // fRunner = runner;
  }

  public void addObserver(TestListener testListener) {
    observers.add(testListener);
  }

  public TestResult() {
    fFailures = new Vector<>(10);
    fErrors = new Vector<>(10);
    fRunTests = 0;
    fStop = false;
  }

  public synchronized void addError(Test test, Throwable t) {
    fErrors.addElement(new TestFailure(test, t));
    for (TestListener observer : observers) {
      observer.addError(this, test, t);
    }
    // if (fRunner != null) {
    // fRunner.addError(this, test, t);
    // }
  }

  public synchronized void addFailure(Test test, Throwable t) {
    fFailures.addElement(new TestFailure(test, t));
    if (fRunner != null) {
      fRunner.addFailure(this, test, t);
    }
  }

  public synchronized void endTest(Test test) {
    fRunner.endTest(this, test);
  }

  public synchronized void startTest(Test test) {
    fRunTests++;
    fRunner.startTest(this, test);
  }
}
