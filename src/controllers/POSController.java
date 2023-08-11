package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import persistence.ClientRepository;
import persistence.ProductRepository;
import services.ClientServiceImp;
import services.ProductServiceImp;
import views.POS;
import views.Products.ProductFindByName;
import views.Products.ProductFindByPc;
import views.Products.ProductRegisterForm;
import views.Shop.ShopForm;
import views.clients.ClientFindBySsn;
import views.clients.ClientFindByName;
import views.clients.ClientRegisterForm;

public class POSController implements ActionListener {

    POS pos;
    ProductRepository productRepository = new ProductRepository();
    ProductServiceImp productServiceImp = new ProductServiceImp(productRepository);
    
    ClientRepository clientRepository = new ClientRepository();
    ClientServiceImp clientServiceImp = new ClientServiceImp(clientRepository);

    
    
    public POSController(POS pos) {
        this.pos = pos;
        
        this.pos.jMenuItemShopForm.addActionListener(this);
        
        /*Product Views*/
        this.pos.jMenuItemProductRegister.addActionListener(this);
        this.pos.jMenuItemProductByName.addActionListener(this);
        this.pos.jMenuItemProductByPC.addActionListener(this);

        /*Client Views*/
        this.pos.jMenuItemClientRegister.addActionListener(this);
        this.pos.jMenuItemClientByName.addActionListener(this);
        this.pos.jMenuItemClientByCI.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == pos.jMenuItemShopForm) {
            pos.jDesktopPane1.add(new ShopForm(productServiceImp)).setVisible(true);
        }
        
        if (e.getSource() == pos.jMenuItemProductByName) {
            pos.jDesktopPane1.add(new ProductFindByName(productServiceImp)).setVisible(true);
        }

        if (e.getSource() == pos.jMenuItemProductByPC) {
            pos.jDesktopPane1.add(new ProductFindByPc(productServiceImp)).setVisible(true);
        }

        if (e.getSource() == pos.jMenuItemProductRegister) {
            pos.jDesktopPane1.add(new ProductRegisterForm(productServiceImp)).setVisible(true);
        }

        if (e.getSource() == pos.jMenuItemClientRegister) {
            pos.jDesktopPane1.add(new ClientRegisterForm(clientServiceImp)).setVisible(true);
        }

        if (e.getSource() == pos.jMenuItemClientByName) {
            pos.jDesktopPane1.add(new ClientFindByName(clientServiceImp)).setVisible(true);
        }

        if (e.getSource() == pos.jMenuItemClientByCI) {
            pos.jDesktopPane1.add(new ClientFindBySsn(clientServiceImp)).setVisible(true);
        }
    }

}
