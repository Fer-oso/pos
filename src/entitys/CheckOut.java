package entitys;

import interfaces.entity.checkout.ICheckOut;
import interfaces.entity.paymentMethod.PaymentMethod;
import java.util.ArrayList;
import java.util.List;

public class CheckOut implements ICheckOut<Integer>{

    private Integer id;

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

    public CheckOut(ShoppingCart shoppingCart) {

        countId++;

        this.id = countId;

        this.shoppingCart = shoppingCart;

        this.paymentMethods.add(new Cash());

        this.paymentMethods.add(new CreditCard());
    }

    @Override
    public Integer getId() {
       return id;
    }

    @Override
    public void setId(Integer id) {
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

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public final void addPaymentMethod(PaymentMethod paymentMethod) {

        if (paymentMethods instanceof Cash) {

            this.paymentMethods.set(0, paymentMethod);

        } else {

            this.paymentMethods.set(1, paymentMethod);
        }
    }
    
    @Override
    public String toString() {
        return "Checking{" + "id=" + id + ", shoppingCart=" + shoppingCart + ", paymentMethod=" + paymentMethods + ", state=" + state + '}';
    }
}
