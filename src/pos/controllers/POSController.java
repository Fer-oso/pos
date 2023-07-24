package pos.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pos.dao.ProductDAO;
import pos.services.ProductService;
import pos.views.POS;
import pos.views.Product.ProductFindByName;
import pos.views.Product.ProductFindByPC;
import pos.views.Product.ProductRegisterForm;

public class POSController implements ActionListener {

    POS pos;
    ProductDAO productDAO = new ProductDAO();
    ProductService productService = new ProductService(productDAO);

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
