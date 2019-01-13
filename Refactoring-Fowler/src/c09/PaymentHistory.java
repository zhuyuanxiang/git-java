package c09;

public class PaymentHistory {
  int getWeeksDelinquentInLastYear() {
    return 0; // 不用这个默认值，是因为这个值未来可能会改变。
  }

  public static PaymentHistory newNull() {
    return new NullPaymentHistory();
  }

}


class NullPaymentHistory extends PaymentHistory {
  @Override
  int getWeeksDelinquentInLastYear() {
    return 0;
  }
}
