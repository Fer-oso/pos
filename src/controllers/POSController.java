package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import persistence.ClientRepository;
import persistence.ProductRepository;
import persistence.ShoppingCartRepository;
import services.ClientServiceImp;
import services.ProductServiceImp;
import services.ShoppingCartServiceImp;
import views.POS;
import views.Products.ProductFindByPcFormView;
import views.Products.ProductRegisterFormView;
import views.Shop.ShopFormView;
import views.clients.ClientFindByNameFormView;
import views.clients.ClientRegisterFormView;

public class POSController implements ActionListener {

    POS pos;

    ProductRepository productRepository = new ProductRepository();
    ProductServiceImp productServiceImp = new ProductServiceImp(productRepository);

    ClientRepository clientRepository = new ClientRepository();
    ClientServiceImp clientServiceImp = new ClientServiceImp(clientRepository);

    ShoppingCartRepository shoppingCartRepository = new ShoppingCartRepository();
    ShoppingCartServiceImp shoppingCartServiceImp = new ShoppingCartServiceImp(shoppingCartRepository);

    ShopFormView shopForm = new ShopFormView(productServiceImp, clientServiceImp, shoppingCartServiceImp);

    ProductFindByPcFormView productFindByPcFormView = new ProductFindByPcFormView(productServiceImp);
  
    ProductRegisterFormView productRegisterFormView = new ProductRegisterFormView(productServiceImp);
    
    ClientRegisterFormView clientRegisterFormView = new ClientRegisterFormView(clientServiceImp);
    
    ClientFindByNameFormView clientFindByNameFormView = new ClientFindByNameFormView(clientServiceImp);

    public POSController(POS pos) {
       
        this.pos = pos;

        initActions(); 
    }

    private void initActions() {

        /*Shopping Views*/
        this.pos.jMenuItemShopForm.addActionListener(this);

        /*Product Views*/
        this.pos.jMenuItemProductRegister.addActionListener(this);
        this.pos.jMenuItemProductByPC.addActionListener(this);

        /*Client Views*/
        this.pos.jMenuItemClientRegister.addActionListener(this);
        this.pos.jMenuItemClientByName.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == pos.jMenuItemShopForm) {
            
            pos.jTabbedPane1.removeAll();
            
            pos.jTabbedPane1.addTab("shopform", shopForm);     
        }

        if (e.getSource() == pos.jMenuItemProductByPC) {
    
            pos.jTabbedPane1.removeAll();
            
            pos.jTabbedPane1.addTab("findbypc", productFindByPcFormView);   
        }

        if (e.getSource() == pos.jMenuItemProductRegister) {
            
            pos.jTabbedPane1.removeAll();
            
            pos.jTabbedPane1.addTab("register product", productRegisterFormView); 
        }

        if (e.getSource() == pos.jMenuItemClientRegister) {
            
            pos.jTabbedPane1.removeAll();
            
            pos.jTabbedPane1.addTab("register client", clientRegisterFormView);  
        }

        if (e.getSource() == pos.jMenuItemClientByName) {
            
            pos.jTabbedPane1.removeAll();
            
            pos.jTabbedPane1.addTab("findbyname", clientFindByNameFormView); 
        }
    }
}
