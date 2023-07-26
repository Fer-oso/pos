package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import persistence.ProductRepository;
import services.ProductServiceImp;
import views.POS;
import views.Product.ProductFindByName;
import views.Product.ProductFindByPC;
import views.Product.ProductRegisterForm;

public class POSController implements ActionListener {

    POS pos;
    ProductRepository productRepository = new ProductRepository();
    ProductServiceImp productService = new ProductServiceImp(productRepository);

    public POSController(POS pos) {
        this.pos = pos;
        this.pos.jMenuItemProductByName.addActionListener(this);
        this.pos.jMenuItemProductByPC.addActionListener(this);
        this.pos.jMenuItemProductRegister.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pos.jMenuItemProductByName) {
            pos.jDesktopPane1.add(new ProductFindByName(productService)).setVisible(true);
        }

        if (e.getSource() == pos.jMenuItemProductByPC) {
            pos.jDesktopPane1.add(new ProductFindByPC(productService)).setVisible(true);
        }

        if (e.getSource() == pos.jMenuItemProductRegister) {
            pos.jDesktopPane1.add(new ProductRegisterForm(productService)).setVisible(true);
        }
    }


    
}
