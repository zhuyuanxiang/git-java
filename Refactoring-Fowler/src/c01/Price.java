package c01;

abstract class Price {
  // determine amounts for each line
  protected abstract double getCharge(int daysRented);

  protected int getFrequentRenterPoints(int daysRented) {
    return 1;
  }

  protected abstract int getPriceCode();
}


class ChildrensPrice extends Price {

  @Override
  protected double getCharge(int daysRented) {
    double result = 2;
    if (daysRented > 2) {
      result += (daysRented - 2) * 1.5;
    }
    return result;
  }

  @Override
  protected int getPriceCode() {
    return Movie.CHILDRENS;
  }

}


class NewReleasePrice extends Price {

  @Override
  protected double getCharge(int daysRented) {
    return daysRented * 3;
  }

  @Override
  protected int getFrequentRenterPoints(int daysRented) {
    return (daysRented > 1) ? 2 : 1;
  }

  @Override
  protected int getPriceCode() {
    return Movie.NEW_RELEASE;
  }

}


class RegularPrice extends Price {

  @Override
  protected double getCharge(int daysRented) {
    double result = 1.5;
    if (daysRented > 3) {
      result += (daysRented - 3) * 1.5;
    }
    return result;
  }

  @Override
  protected int getPriceCode() {
    return Movie.REGULAR;
  }
}
