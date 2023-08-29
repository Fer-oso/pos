package entitys;

import interfaces.entity.paymentMethod.PaymentMethod;

public class CreditCard implements PaymentMethod{

    @Override
    public void payPurchase() {
        System.out.println("pago con tarjeta");
    }

}