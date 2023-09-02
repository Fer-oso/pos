package entitys;

import interfaces.entity.paymentMethod.PaymentMethod;

public class Cash implements PaymentMethod {

    private Double quantity;
   
    public Cash(){}

    public Cash(Double quantity) {
        
        this.quantity = quantity;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }  
}
