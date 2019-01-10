package c06;

public class IntroduceExplainingVariable {
  private int _quantity;
  private int _itemPrice;

  double price() {
    // price is base price - quantity discount + shipping
    return ((_quantity * _itemPrice) -
        (Math.max(0, _quantity - 500) * _itemPrice * 0.05)) +
        Math.min(_quantity * _itemPrice * 0.1, 100.0);
  }
}
