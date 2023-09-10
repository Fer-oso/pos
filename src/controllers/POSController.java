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
import views.Products.ProductFindByNameView;
import views.Products.ProductFindByPcView;
import views.Products.ProductRegisterFormView;
import views.Shop.ShopFormView;
import views.clients.ClientFindByNameFormView;
import views.clients.ClientFindBySsnView;
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

    public POSController(POS pos) {
        this.pos = pos;
        initActions();
    }

    private void initActions() {

        /*Shopping Views*/
        this.pos.jMenuItemShopForm.addActionListener(this);

        /*Product Views*/
        this.pos.jMenuItemProductRegister.addActionListener(this);
        this.pos.jMenuItemProductByName.addActionListener(this);
        this.pos.jMenuItemProductByPC.addActionListener(this);

        /*Client Views*/
        this.pos.jMenuItemClientRegister.addActionListener(this);
        this.pos.jMenuItemClientByName.addActionListener(this);
        this.pos.jMenuItemClientBySsn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == pos.jMenuItemShopForm) {
            pos.jDesktopPane1.add(shopForm).setVisible(true);
        }

        if (e.getSource() == pos.jMenuItemProductByName) {
            pos.jDesktopPane1.add(new ProductFindByNameView(productServiceImp)).setVisible(true);
        }

        if (e.getSource() == pos.jMenuItemProductByPC) {
            pos.jDesktopPane1.add(new ProductFindByPcView(productServiceImp)).setVisible(true);
        }

        if (e.getSource() == pos.jMenuItemProductRegister) {
            pos.jDesktopPane1.add(new ProductRegisterFormView(productServiceImp)).setVisible(true);
        }

        if (e.getSource() == pos.jMenuItemClientRegister) {
            pos.jDesktopPane1.add(new ClientRegisterFormView(clientServiceImp)).setVisible(true);
        }

        if (e.getSource() == pos.jMenuItemClientByName) {
            pos.jDesktopPane1.add(new ClientFindByNameFormView(clientServiceImp)).setVisible(true);
        }

        if (e.getSource() == pos.jMenuItemClientBySsn) {
            pos.jDesktopPane1.add(new ClientFindBySsnView(clientServiceImp)).setVisible(true);
        }
    }

}
