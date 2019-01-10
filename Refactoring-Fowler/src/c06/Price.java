package c06;

public class Price {
  private int _quantity;
  private int _itemPrice;

  double getPrice() {
    return basePrice() * discountFactor();
  }

  private double discountFactor() {
    if (basePrice() > 1000) {
      return 0.95;
    } else {
      return 0.98;
    }
  }

  private int basePrice() {
    return _quantity * _itemPrice;
  }
}
