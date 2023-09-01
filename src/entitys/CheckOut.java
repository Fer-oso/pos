package entitys;

import interfaces.entity.paymentMethod.PaymentMethod;
import java.util.ArrayList;
import java.util.List;

public class CheckOut {

    private int id;

    private ShoppingCart shoppingCart;

    private final List<PaymentMethod> paymentMethods = new ArrayList<>(2);

    private boolean state;

    private static Integer countId = 0;

    public CheckOut() {

        countId++;

        this.id = countId;
        
        this.paymentMethods.add(new Cash());
        
        this.paymentMethods.add(new CreditCard());

    }

    public CheckOut(ShoppingCart shoppingCart, PaymentMethod paymentMethod, boolean state) {
        
        countId++;
        
        this.id = countId;
        
        this.shoppingCart = shoppingCart;
        
        this.paymentMethods.add(new Cash());
        
        this.paymentMethods.add(new CreditCard());
        
        addPaymentMethod(paymentMethod);
        
        this.state = state;
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

    
    public List<PaymentMethod> getPaymentMethod() {
        return paymentMethods;
    }

    public final void addPaymentMethod(PaymentMethod paymentMethod) {
       
            if (paymentMethods instanceof Cash) {
               
                this.paymentMethods.set(0, paymentMethod);
                
            } else {
            
                this.paymentMethods.set(1, paymentMethod);
                
            }

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
        return "Checking{" + "id=" + id + ", shoppingCart=" + shoppingCart + ", paymentMethod=" + paymentMethods + ", state=" + state + '}';
    }

}
