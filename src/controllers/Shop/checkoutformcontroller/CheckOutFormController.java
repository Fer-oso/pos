package controllers.Shop.checkoutformcontroller;

import entitys.ShoppingCart;
import services.CheckOutServiceImp;
import views.Shop.CheckOutFormView;

public class CheckOutFormController {
    
    CheckOutFormView checkOutFormView;
    
    CheckOutServiceImp checkOutServiceImp;
    
    ShoppingCart shoppingCart;

    public CheckOutFormController(CheckOutFormView checkOutFormView, CheckOutServiceImp checkOutServiceImp) {
        
        this.checkOutFormView = checkOutFormView;
        
        this.checkOutServiceImp = checkOutServiceImp;
        
    }
    
    
    
}
