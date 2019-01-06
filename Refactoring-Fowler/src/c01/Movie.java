package c01;

public class Movie {

  public static final int CHILDRENS = 2;
  public static final int NEW_RELEASE = 1;
  public static final int REGULAR = 0;

  private Price _price;
  private String _title;

  public Movie(String title, int priceCode) {
    _title = title;
    setPriceCode(priceCode);
  }

  public Price getPrice() {
    return _price;
  }

  public String getTitle() {
    return _title;
  }

  public void setPrice(Price _price) {
    this._price = _price;
  }

  private void setPriceCode(int arg) {
    switch (arg) {
      case REGULAR:
        setPrice(new RegularPrice());
        break;
      case CHILDRENS:
        setPrice(new ChildrensPrice());
        break;
      case NEW_RELEASE:
        setPrice(new NewReleasePrice());
        break;
      default:
        throw new IllegalArgumentException("Incorrect Price Code");
    }
  }

  int getPriceCode() {
    return getPrice().getPriceCode();
  };
}
