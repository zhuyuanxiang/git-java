package c01;

import java.util.Enumeration;
import java.util.Vector;

class Customer {
  private String _name;
  private Vector<Rental> _rentals = new Vector<>();

  public Customer(String name) {
    _name = name;
  }

  public void addRental(Rental arg) {
    _rentals.addElement(arg);
  }

  public String getName() {
    return _name;
  }

  public String htmlStatement() {
    String result = "<H1>Rentals for <EM>" + getName() + "</EM></ H1><P>\n";
    Enumeration<Rental> rentals = _rentals.elements();
    while (rentals.hasMoreElements()) {
      Rental each = rentals.nextElement();
      // show figures for each rental
      result += each.getMovie().getTitle() + ": "
          + String.valueOf(each.getMovie().getPrice().getCharge(each.getDaysRented())) + "<BR>\n";
    }
    // add footer lines
    result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
    result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints())
        + "</EM> frequent renter points<P>";
    return result;
  }

  public String statement() {
    String result = "Rental Record for " + getName() + "\n";
    Enumeration<Rental> rentals = _rentals.elements();
    while (rentals.hasMoreElements()) {
      Rental each = rentals.nextElement();
      // show figures for this rental
      result += "\t" + each.getMovie().getTitle() + "\t"
          + String.valueOf(each.getMovie().getPrice().getCharge(each.getDaysRented())) + "\n";
    }
    // add footer lines
    result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
    result +=
        "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
    return result;

  }

  private double getTotalCharge() {
    double result = 0;
    Enumeration<Rental> rentals = _rentals.elements();
    while (rentals.hasMoreElements()) {
      Rental each = rentals.nextElement();
      result += each.getMovie().getPrice().getCharge(each.getDaysRented());
    }
    return result;
  }

  private int getTotalFrequentRenterPoints() {
    int result = 0;
    Enumeration<Rental> rentals = _rentals.elements();
    while (rentals.hasMoreElements()) {
      Rental each = rentals.nextElement();
      // add frequent renter points
      result += each.getMovie().getPrice().getFrequentRenterPoints(each.getDaysRented());
    }
    return result;
  }

}
