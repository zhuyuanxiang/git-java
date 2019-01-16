package com.design.patterns.refactoring.Observer;

import junit.framework.Test;

public interface TestListener {

  void addError(TestResult result, Test test, Throwable t);

  void addFailure(TestResult result, Test test, Throwable t);

  void startTest(TestResult testResult, Test test);

  void endTest(TestResult testResult, Test test);

}
