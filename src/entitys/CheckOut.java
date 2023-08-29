package entitys;

import interfaces.entity.paymentMethod.PaymentMethod;

public class CheckOut {

    private int id;
    
    private ShoppingCart shoppingCart;
    
    private PaymentMethod paymentMethod;
    
    private boolean state;
    
    private static Integer countId = 0;

    public CheckOut() {

        countId++;

        this.id = countId;

    }

    public CheckOut(ShoppingCart shoppingCart, PaymentMethod paymentMethod) {

        countId++;

        this.id = countId;
        
        this.shoppingCart = shoppingCart;
        
        this.paymentMethod = paymentMethod;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public static Integer getCountId() {
        return countId;
    }

    public static void setCountId(Integer countId) {
        CheckOut.countId = countId;
    }

    @Override
    public String toString() {
        return "Checking{" + "id=" + id + ", shoppingCart=" + shoppingCart + ", paymentMethod=" + paymentMethod + ", state=" + state + '}';
    }

   
}
