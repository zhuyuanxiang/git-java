package c01;

class Rental {
  private Movie _movie;
  private int _daysRented;

  public Rental(Movie movie, int daysRented) {
    setMovie(movie);
    setDaysRented(daysRented);
  }

  public Movie getMovie() {
    return _movie;
  }

  int getDaysRented() {
    return _daysRented;
  }

  void setDaysRented(int _daysRented) {
    this._daysRented = _daysRented;
  }

  void setMovie(Movie _movie) {
    this._movie = _movie;
  }
}
