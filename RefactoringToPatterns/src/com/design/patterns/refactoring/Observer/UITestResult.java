package com.design.patterns.refactoring.Observer;

import junit.framework.Test;

public class UITestResult extends TestResult {
  protected TestListener fRunner;

  UITestResult(TestListener runner) {
    fRunner = runner;
  }

  @Override
  public synchronized void addFailure(Test test, Throwable t) {
    super.addFailure(test, t);
    fRunner.addFailure(this, test, t);
  }

  @Override
  public synchronized void endTest(Test test) {
    super.endTest(test);
    fRunner.endTest(this, test);
  }
}
