package com.design.patterns.refactoring.Observer;

import junit.framework.Test;

public class TextTestResult extends TestResult {
  protected TestListener fRunner;

  TextTestResult(TestListener runner) {
    fRunner = runner;
  }

  @Override
  public synchronized void addFailure(Test test, Throwable t) {
    super.addFailure(test, t);
    fRunner.addFailure(this, test, t);
  }

  @Override
  public synchronized void startTest(Test test) {
    super.startTest(test);
    fRunner.startTest(this, test);
  }

  @Override
  public synchronized void addError(Test test, Throwable t) {
    super.addError(test, t);
    fRunner.addError(this, test, t);
  }
}
