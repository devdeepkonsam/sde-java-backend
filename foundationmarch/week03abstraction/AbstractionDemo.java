public class AbstractionDemo {
    public static void main(String[] args) {
        PaymentMethod cardPayment = new CardPayment();
        PaymentMethod upiPayment = new UpiPayment();

        cardPayment.pay(2500.0);
        upiPayment.pay(499.0);
    }
}