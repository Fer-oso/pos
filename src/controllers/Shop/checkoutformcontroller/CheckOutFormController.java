package controllers.Shop.checkoutformcontroller;

import entitys.Cash;
import entitys.CheckOut;
import entitys.CreditCard;
import entitys.SelectedProduct;
import entitys.ShoppingCart;
import interfaces.entity.paymentMethod.PaymentMethod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import services.CheckOutServiceImp;
import views.Shop.CheckOutFormView;

public class CheckOutFormController implements ActionListener {

    private final CheckOutFormView checkOutFormView;

    private final CheckOutServiceImp checkOutServiceImp;

    private final ShoppingCart shoppingCart;

    private DefaultTableModel model = new DefaultTableModel();

    private Double inputCash;

    List<PaymentMethod> paymentMethodsList = new ArrayList<>();

    Cash cash;

    CreditCard creditCard;

    CheckOut checkOut;

    Double creditCardPriceByFee;

    public CheckOutFormController(CheckOutFormView checkOutFormView, ShoppingCart shoppingCart, CheckOutServiceImp checkOutServiceImp) {

        this.checkOutFormView = checkOutFormView;

        this.checkOutServiceImp = checkOutServiceImp;

        this.shoppingCart = shoppingCart;

        checkOutFormView.getTxtCash().setEditable(false);

        addActionsListeners();

        listProductsCarshop();

        setLblInfo();
    }

    private void addActionsListeners() {

        checkOutFormView.getJrbCash().addActionListener(this);

        checkOutFormView.getJrbCreditCard().addActionListener(this);

        checkOutFormView.getTxtCash().addActionListener(this);

        checkOutFormView.getJcbCuotes().addActionListener(this);

        checkOutFormView.getTxtCreditCardQuantity().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == checkOutFormView.getTxtCash()) {

            inputCash();
        }

        if (e.getSource() == checkOutFormView.getJrbCash()) {

            jrbCashButtonActions();
        }

        if (e.getSource() == checkOutFormView.getJrbCreditCard()) {

            jrbCreditCardButtonActions();
        }

        if (e.getSource() == checkOutFormView.getJcbCuotes()) {

            selectedFees();
        }

        if (e.getSource() == checkOutFormView.getTxtCreditCardQuantity()) {

            inputCreditCardQuantity();
            selectedFees();
        }
    }

    private void jrbCreditCardButtonActions() {

        if (checkOutFormView.getJrbCreditCard().isSelected()) {

            checkOutFormView.getJcbCuotes().setEnabled(true);

            checkOutFormView.getTxtFinalPriceCc().setVisible(true);

//            creditCardPriceByFee = shoppingCart.getFinalPrice() * 1.06;
//
//            checkOutFormView.getTxtFinalPriceCc().setText(String.format("%.2f", creditCardPriceByFee));
        } else {

            checkOutFormView.getTxtFinalPriceCc().setVisible(false);

            checkOutFormView.getJcbCuotes().setSelectedIndex(0);
        }
    }

    private void jrbCashButtonActions() {

        if (checkOutFormView.getJrbCash().isSelected()) {

            checkOutFormView.getTxtCash().setEditable(true);

        } else {

            checkOutFormView.getTxtCash().setEditable(false);
        }
    }

    private void setLblInfo() {

        checkOutFormView.getLblClientName().setText(shoppingCart.getClient().getName() + " " + shoppingCart.getClient().getLastName());

        checkOutFormView.getLblTotalPrice().setText(String.valueOf(shoppingCart.getFinalPrice()));
    }

    private void inputCash() {

        inputCash = Double.valueOf(checkOutFormView.getTxtCash().getText());
    }

    private void inputCreditCardQuantity() {

        creditCardPriceByFee = Double.valueOf(checkOutFormView.getTxtCreditCardQuantity().getText());
    }

    private void listProductsCarshop() {

        List<SelectedProduct> listProductsShoppingCart = shoppingCart.getProducts();

        model = (DefaultTableModel) checkOutFormView.getjTableCheckOut().getModel();

        for (SelectedProduct psc : listProductsShoppingCart) {

            Object[] objectProduct = {psc.getProductCode(), psc.getProductName(), psc.getProductBrand(),
                psc.getProductQuantity(), psc.getProductPrice(), psc.getFinalPrice()};

            model.addRow(objectProduct);
        }
    }

    private void selectedFees() {

        Double creditCardQuantity = 0.0;

        if (checkOutFormView.getJcbCuotes().getSelectedIndex() == 0 && checkOutFormView.getTxtCreditCardQuantity().getText().equals("")) {

            creditCardPriceByFee = shoppingCart.getFinalPrice() * 1.06;

          //  checkOutFormView.getTxtFinalPriceCc().setText(String.format("%.2f", creditCardPriceByFee));

        } else {
            
            if (!checkOutFormView.getTxtCreditCardQuantity().getText().equals("")) {
                
                
            creditCardQuantity = Double.valueOf(checkOutFormView.getTxtCreditCardQuantity().getText());

            creditCardPriceByFee = creditCardQuantity * 1.06;
                
            }


         //   checkOutFormView.getTxtFinalPriceCc().setText(String.format("%.2f", creditCardPriceByFee));

        }

        if (checkOutFormView.getJcbCuotes().getSelectedIndex() == 1 && checkOutFormView.getTxtCreditCardQuantity().getText().equals("")) {

            creditCardPriceByFee = shoppingCart.getFinalPrice() * 1.11;

        //    checkOutFormView.getTxtFinalPriceCc().setText(String.format("%.2f", creditCardPriceByFee));

        } else {

            if (!checkOutFormView.getTxtCreditCardQuantity().getText().equals("")) {

                creditCardQuantity = Double.valueOf(checkOutFormView.getTxtCreditCardQuantity().getText());

                creditCardPriceByFee = creditCardQuantity * 1.11;

      //          checkOutFormView.getTxtFinalPriceCc().setText(String.format("%.2f", creditCardPriceByFee));
            }
        }

        if (checkOutFormView.getJcbCuotes().getSelectedIndex() == 2 && checkOutFormView.getTxtCreditCardQuantity().getText().equals("")) {

            creditCardPriceByFee = shoppingCart.getFinalPrice() * 1.18;

        //    checkOutFormView.getTxtFinalPriceCc().setText(String.format("%.2f", creditCardPriceByFee));

        } else {

            if (!checkOutFormView.getTxtCreditCardQuantity().getText().equals("")) {

                creditCardQuantity = Double.valueOf(checkOutFormView.getTxtCreditCardQuantity().getText());

                creditCardPriceByFee = creditCardQuantity * 1.18;

        //        checkOutFormView.getTxtFinalPriceCc().setText(String.format("%.2f", creditCardPriceByFee));
            }
        }

        if (checkOutFormView.getJcbCuotes().getSelectedIndex() == 3 && checkOutFormView.getTxtCreditCardQuantity().getText().equals("")) {

            creditCardPriceByFee = shoppingCart.getFinalPrice() * 1.24;

        //    checkOutFormView.getTxtFinalPriceCc().setText(String.format("%.2f", creditCardPriceByFee));

        } else {

            if (!checkOutFormView.getTxtCreditCardQuantity().getText().equals("")) {

                creditCardQuantity = Double.valueOf(checkOutFormView.getTxtCreditCardQuantity().getText());

                creditCardPriceByFee = creditCardQuantity * 1.24;

         //       checkOutFormView.getTxtFinalPriceCc().setText(String.format("%.2f", creditCardPriceByFee));
            }
        }
        
        checkOutFormView.getTxtFinalPriceCc().setText(String.format("%.2f", creditCardPriceByFee));
    }
    
}
