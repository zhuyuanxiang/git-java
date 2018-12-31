package com.design.patterns.refactoring.Observer;

import java.awt.Frame;
import junit.framework.Test;

public class TestRunner extends Frame implements TestListener {
  private TestResult fTestResult;

  @Override
  public void addError(TestResult result, Test test, Throwable t) {
    System.out.println("E");
  }

  @Override
  public void addFailure(TestResult result, Test test, Throwable t) {
    System.out.println("F");
  }

  @Override
  public void endTest(TestResult uiTestResult, Test test) {
    // TODO Auto-generated method stub

  }

  synchronized public void runSuite() {
    fTestResult = createTestResult();
    // testSuite.run(fTestResult);
  }

  @Override
  public void startTest(TestResult textTestResult, Test test) {
    // TODO Auto-generated method stub

  }

  protected TestResult createTestResult() {
    // return new UITestResult(this);
    TestResult testResult = new TestResult();
    testResult.addObserver(this);
    return new TestResult(this);
  }

  protected void doRun(Test suit, boolean wait) {
    TestResult result = createTestResult();
  }
}
