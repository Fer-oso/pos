package controllers.Shop.checkoutformcontroller;

import entitys.CheckOut;
import entitys.SelectedProduct;
import entitys.ShoppingCart;
import interfaces.entity.paymentMethod.PaymentMethod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import services.CheckOutServiceImp;
import views.Shop.CheckOutFormView;

public class CheckOutFormController implements ActionListener{

    private final CheckOutFormView checkOutFormView;

    private final CheckOutServiceImp checkOutServiceImp;

    private ShoppingCart shoppingCart;

    public CheckOutFormController(CheckOutFormView checkOutFormView, ShoppingCart shoppingCart, CheckOutServiceImp checkOutServiceImp) {

        this.checkOutFormView = checkOutFormView;

        this.checkOutServiceImp = checkOutServiceImp;

        this.shoppingCart = shoppingCart;
        
        checkOutFormView.getTxtCash().setEditable(false);
        
        addActionsListeners();

        listProductsCarshop();

        setLblInfo();
    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == checkOutFormView.getTxtCash()) {
            
            inputCash();
        }
        
        if (e.getSource() == checkOutFormView.getJrbCash()) {
       //    checkOutFormView.getTxtCash().setEditable(true);
          setPaymentsMethods();
        }
        
    }

    private void addActionsListeners(){
        
        checkOutFormView.getTxtCash().addActionListener(this);
        checkOutFormView.getJrbCash().addActionListener(this);
    }

    private DefaultTableModel model = new DefaultTableModel();
    
    private Double inputCash;
    
    CheckOut checkOut;

    private void listProductsCarshop() {
        
        List<SelectedProduct> listProductsShoppingCart = shoppingCart.getProducts();

        model = (DefaultTableModel) checkOutFormView.getjTableCheckOut().getModel();

        for (SelectedProduct psc : listProductsShoppingCart) {

            Object[] objectProduct = {psc.getProductCode(), psc.getProductName(), psc.getProductBrand(),
                psc.getProductQuantity(), psc.getProductPrice(), psc.getFinalPrice()};

            model.addRow(objectProduct);
        }
    }

    private void setLblInfo() {

        checkOutFormView.getLblClientName().setText(shoppingCart.getClient().getName() + " " + shoppingCart.getClient().getLastName());

        checkOutFormView.getLblTotalPrice().setText(String.valueOf(shoppingCart.getFinalPrice()));
    }

    private void inputCash() {
        
        inputCash = Double.valueOf(checkOutFormView.getTxtCash().getText());
    }
    
    private void createCheckOut(){
    
        checkOut = new CheckOut(shoppingCart);
        
        if (true) {
            
        }
    }
    
    
    private void setPaymentsMethods(){
    
//        if (checkOutFormView.getJrbCreditCard().isSelected()) {
//            
//            checkOut.getPaymentMethod().set(0, shoppingCart.getClient().getPaymentMethods().get(1));
//        }
        
        if (checkOutFormView.getJrbCash().isSelected()) {
            
            checkOutFormView.getTxtCash().setEditable(true);
        }else
        {
         checkOutFormView.getTxtCash().setEditable(false);
        }
    
    }
    
}
