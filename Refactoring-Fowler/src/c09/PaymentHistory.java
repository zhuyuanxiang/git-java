package c09;

public class PaymentHistory {
  int getWeeksDelinquentInLastYear() {
    return 0; // �������Ĭ��ֵ������Ϊ���ֵδ�����ܻ�ı䡣
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
