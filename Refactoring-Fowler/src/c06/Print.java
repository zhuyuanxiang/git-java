package c06;

import java.util.Enumeration;

public class Print {
  private String _name;
  private Order _orders;

  void printOwing(double previousAmout) {
    double outstanding = previousAmout * 1.2;
    printBanner();
    outstanding = getOutstanding(previousAmout);
    printDetails(outstanding);
  }

  private double getOutstanding(double initialValues) {
    double result = initialValues;
    Enumeration e = _orders.elements();
    // calculate outstanding
    while (e.hasMoreElements()) {
      Order each = (Order) e.nextElement();
      result += each.getAmount();
    }
    return result;
  }

  private void printBanner() {
    // print banner
    System.out.println("**************************");
    System.out.println("***** Customer Owes ******");
    System.out.println("**************************");
  }

  private void printDetails(double amount) {
    // print details
    System.out.println("name:" + _name);
    System.out.println("amount" + amount);
  }
