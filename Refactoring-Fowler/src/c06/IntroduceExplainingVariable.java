package c06;

public class IntroduceExplainingVariable {
  private double _quantity;
  private double _itemPrice;

  double price() {
    // price is base price - quantity discount + shipping
    final double basePrice = _quantity * _itemPrice;
    final double quantityDiscount = Math.max(0, _quantity - 500) * _itemPrice * 0.05;
    final double shipping = Math.min(basePrice * 0.1, 100.0);
    return (basePrice - quantityDiscount) + shipping;
  }
}
