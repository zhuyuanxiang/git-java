package c06;

public class IntroduceExplainingVariable {
  private double _quantity;
  private double _itemPrice;

  double price() {
    // price is base price - quantity discount + shipping
    return (basePrice() - quantityDiscount()) + shipping(basePrice());
  }

  private double shipping(final double basePrice) {
    return Math.min(basePrice * 0.1, 100.0);
  }

  private double quantityDiscount() {
    return Math.max(0, _quantity - 500) * _itemPrice * 0.05;
  }

  private double basePrice() {
    return _quantity * _itemPrice;
  }
}
