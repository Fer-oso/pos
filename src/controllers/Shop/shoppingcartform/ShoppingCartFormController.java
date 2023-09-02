package controllers.Shop.shoppingcartform;

import entitys.ShoppingCart;
import entitys.SelectedProduct;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import services.ShoppingCartServiceImp;

import views.Shop.ShoppingCartFormView;

public class ShoppingCartFormController extends MouseAdapter implements ActionListener {

    /*Views*/
    private final ShoppingCartFormView shoppingCartForm;

    /*Entitys*/
    private final ShoppingCart shoppingCart;

    /*Services*/
    ShoppingCartServiceImp shoppingCartServiceImp;

    /*Global variables*/
    private final List<SelectedProduct> listShoppingCartProducts;

    private DefaultTableModel model = new DefaultTableModel();

    /*Constructors*/
    public ShoppingCartFormController(ShoppingCartFormView shoppingCartForm, ShoppingCart shoppingCart, ShoppingCartServiceImp shoppingCartServiceImp) {

        this.shoppingCartForm = shoppingCartForm;

        this.shoppingCart = shoppingCart;

        this.shoppingCartServiceImp = shoppingCartServiceImp;
        
        addActionsListeners();

        listShoppingCartProducts = shoppingCart.getProducts();

        listProductsCarshop();
    }

    /*Actions Events*/
    private void addActionsListeners() {

        shoppingCartForm.getBtnGenerateOrder().addActionListener(this);

        shoppingCartForm.getBtnCancel().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == shoppingCartForm.getBtnCancel()) {

            shoppingCartForm.setVisible(false);

            shoppingCartForm.setDefaultCloseOperation(2);
        }

        if (e.getSource() == shoppingCartForm.getBtnGenerateOrder()) {

            shoppingCartServiceImp.save(shoppingCart);

            shoppingCartServiceImp.show(shoppingCart);
        }
    }

    /*Functions*/
    private void listProductsCarshop() {

        model = (DefaultTableModel) shoppingCartForm.getjTableProducts().getModel();

        //MODELO TABLA
       for (SelectedProduct sp : listShoppingCartProducts) {

            Object[] objectProduct = {sp.getProductCode(), sp.getProductName(), sp.getProductBrand(),
                sp.getProductQuantity(), sp.getProductPrice(), sp.getFinalPrice()};

            model.addRow(objectProduct);
        }

        shoppingCartForm.getjTableProducts().setModel(model);

        shoppingCartForm.getLblTotal().setText("" + shoppingCart.getFinalPrice());

        shoppingCartForm.getTxtClientName().setText("" + shoppingCart.getClient().getName());

        shoppingCartForm.getTxtClientSsn().setText("" + shoppingCart.getClient().getSsn());
    }
}
