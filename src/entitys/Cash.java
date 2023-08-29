package entitys;

import interfaces.entity.paymentMethod.PaymentMethod;

public class Cash implements PaymentMethod{

    @Override
    public void payPurchase() {
        System.out.println("pago con efectivo");    
    }

}