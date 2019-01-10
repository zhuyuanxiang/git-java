package c06;

public class ReplaceMethod_withMethodObject extends Account {
  int gamma(int inputVal, int quantity, int yearToDate) {
    return (new Gamma(this, inputVal, quantity, yearToDate)).compute();
  }
}
