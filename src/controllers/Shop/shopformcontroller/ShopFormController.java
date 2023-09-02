package controllers.Shop.shopformcontroller;

import entitys.Client;
import entitys.Product;
import entitys.SelectedProduct;
import entitys.ShoppingCart;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.ClientServiceImp;
import services.ProductServiceImp;
import services.ShoppingCartServiceImp;

import views.Shop.ShopFormView;
import views.Shop.ShoppingCartFormView;

public class ShopFormController extends MouseAdapter implements ActionListener {

    /*Services*/
    private final ProductServiceImp productServiceImp;

    private final ClientServiceImp clientServiceImp;

    private final ShoppingCartServiceImp shoppingCartServiceImp;

    /*Views*/
    private final ShopFormView shopForm;
    
    /*Global variables*/
    
    private DefaultTableModel model = new DefaultTableModel();
    
    private final List<SelectedProduct> listSelectedProducts = new ArrayList<>();

    private Product product;

    private Client client;

    private SelectedProduct selectedProduct;

    private int productQuantityToSell;

    private int row;

    private Integer id;

    private Integer ssn;

    private Double total;

    //Constructors
    public ShopFormController(ShopFormView shopForm, ProductServiceImp productServiceImp, ClientServiceImp clientServiceImp, ShoppingCartServiceImp shoppingCartServiceImp) {

        this.shopForm = shopForm;

        this.productServiceImp = productServiceImp;

        this.clientServiceImp = clientServiceImp;

        this.shoppingCartServiceImp = shoppingCartServiceImp;

        addACtionsListeners();
    }

    /*Actions Events*/
    private void addACtionsListeners() {

        shopForm.getTxtProductCode().addActionListener(this);

        shopForm.getTxtProductQuantityToSell().addActionListener(this);

        shopForm.getBtnRemove().addActionListener(this);

        shopForm.getTxtClientSsn().addActionListener(this);

        shopForm.getBtnAddToShoppingCart().addActionListener(this);

        shopForm.getjTableProducts().addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == shopForm.getTxtProductCode()) {

            findProduct();
        }

        if (e.getSource() == shopForm.getTxtProductQuantityToSell()) {

            checkQuantityLessStock();

            refreshTable(model);

            listProductsCarshop();
        }

        if (e.getSource() == shopForm.getBtnRemove()) {

            removeProductToList(id);

            refreshTable(model);

            listProductsCarshop();
        }

        if (e.getSource() == shopForm.getTxtClientSsn()) {

            findClient();
        }

        if (e.getSource() == shopForm.getBtnAddToShoppingCart()) {

            addToShoppingCart();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == shopForm.getjTableProducts()) {

            getProductSelectedOfTable();
        }
    }

    /*Function o business logic*/
    private void findProduct() {

        if (!"".equals(shopForm.getTxtProductCode().getText())) {

            String productCode = shopForm.getTxtProductCode().getText();

            product = productServiceImp.findByPc(productCode).get();

            System.out.println(product);

            if (product.getName() != null) {

                shopForm.getTxtProductName().setText("" + product.getName());

                shopForm.getTxtProductBrand().setText("" + product.getBrand());

                shopForm.getTxtProductPrice().setText("" + product.getPrice());

                shopForm.getTxtProductStock().setText("" + product.getStock());

                shopForm.getTxtProductQuantityToSell().requestFocus();

            } else {

                shopForm.getTxtProductName().setText("");

                shopForm.getTxtProductBrand().setText("");

                shopForm.getTxtProductPrice().setText("");

                shopForm.getTxtProductStock().setText("");

                shopForm.getTxtProductCode().requestFocus();

                shopForm.getTxtProductQuantityToSell().setText("");
            }

        } else {

            JOptionPane.showMessageDialog(null, "Insert product code");

            shopForm.getTxtProductCode().requestFocus();

            shopForm.getTxtProductQuantityToSell().setText("");
        }
    }

    private void checkQuantityLessStock() {

        int actualStock;

        if (!"".equals(shopForm.getTxtProductQuantityToSell().getText())) {

            int productStock = Integer.parseInt(shopForm.getTxtProductStock().getText());

            productQuantityToSell = Integer.parseInt(shopForm.getTxtProductQuantityToSell().getText());

            if (productStock >= productQuantityToSell) { // si el producto se puede vender

                selectedProduct = createSelectedProduct(); // crea un producto seleccionado

                shopForm.getTxtProductQuantityToSell().setText("");

                addProductToList(selectedProduct); // añade a la lista el producto seleccionado

                actualStock = (productStock - productQuantityToSell);

                shopForm.getTxtProductStock().setText("" + actualStock);

            } else {

                JOptionPane.showMessageDialog(null, "Stock no disponible");
            }
            
        } else {

            JOptionPane.showMessageDialog(null, "Insert quantity ");

            shopForm.getTxtProductQuantityToSell().requestFocus();

            shopForm.getTxtProductQuantityToSell().setText("");
        }
    }

    private SelectedProduct createSelectedProduct() {

        id = product.getId();

        String productCode = product.getProductCode();

        String productName = product.getName();

        String productBrand = product.getBrand();

        double productPrice = product.getPrice();

        double finalPrice = productQuantityToSell * productPrice;

        return new SelectedProduct(id, productCode, productName, productBrand, productPrice, productQuantityToSell, finalPrice);
    }

    private void addProductToList(SelectedProduct selectedProduct) {

        boolean existDuplicate = false; //Flag to check duplicate existence

        if (listSelectedProducts.isEmpty()) { // if the list is empty 

            listSelectedProducts.add(selectedProduct); //add directly the product

            System.out.println("producto añadido por que estaba vacia" + listSelectedProducts);

        } else {

            for (SelectedProduct p : listSelectedProducts) {

                if (p.getProductCode().equals(selectedProduct.getProductCode())) {

                    JOptionPane.showMessageDialog(null, "producto ya esta en la lista");

                    p.setProductQuantity(p.getProductQuantity() + productQuantityToSell);

                    p.setFinalPrice(p.getProductQuantity() * selectedProduct.getProductPrice());

                    existDuplicate = true; // change the value to true  if the product exist

                    break;
                }
            }

            if (!existDuplicate) {

                listSelectedProducts.add(selectedProduct);
            }
        }
    }

    private void listProductsCarshop() {

        model = (DefaultTableModel) shopForm.getjTableProducts().getModel();

        for (SelectedProduct sp : listSelectedProducts) {

            Object[] objectProduct = {sp.getProductCode(), sp.getProductName(), sp.getProductBrand(),
                sp.getProductQuantity(), sp.getProductPrice(), sp.getFinalPrice()};

            model.addRow(objectProduct);
        }

        shopForm.getjTableProducts().setModel(model);

        calculateFinalPrice();
    }

    private void calculateFinalPrice() {

        total = 0.0;

        double finalPrice;

        for (var sp : listSelectedProducts) {

            finalPrice = sp.getFinalPrice() * 1.21;

            total += finalPrice;

            shopForm.getLblTotal().setText("" + total);

            System.out.println(finalPrice);

            System.out.println(total);
        }
    }

    private void getProductSelectedOfTable() {

        row = shopForm.getjTableProducts().getSelectedRow();

        selectedProduct = listSelectedProducts.get(row);

        id = selectedProduct.getId();

        System.out.println(id);
    }

    private void refreshTable(DefaultTableModel modelo) {

        for (int i = 0; i < modelo.getRowCount(); i++) {

            modelo.removeRow(i);

            i = i - 1;
        }
    }

    private void removeProductToList(Integer id) {

        Iterator<SelectedProduct> iteratorList = listSelectedProducts.iterator();

        while (iteratorList.hasNext()) {

            selectedProduct = iteratorList.next();

            if (selectedProduct.getId().equals(id)) {

                System.out.println("" + selectedProduct);

                iteratorList.remove();

                break;
            }
        }

        System.out.println(listSelectedProducts);
    }

    private void findClient() {

        if (!"".equals(shopForm.getTxtClientSsn().getText())) {

            ssn = Integer.valueOf(shopForm.getTxtClientSsn().getText());

            client = clientServiceImp.findBySsn(ssn).get();

            if (client.getName() != null) {

                shopForm.getTxtClientName().setText("" + client.getName());

            } else {

                JOptionPane.showMessageDialog(null, "Client not found");

                shopForm.getTxtClientSsn().setText("");
            }

        } else {

            JOptionPane.showMessageDialog(null, "Ssn required");
        }
    }

    private void addToShoppingCart() {

        if (client == null) {

            JOptionPane.showMessageDialog(null, "client required");

            return;
        }

        ShoppingCart shoppingCart = new ShoppingCart(client, listSelectedProducts, total);

        ShoppingCartFormView shoppingCartForm = new ShoppingCartFormView(shoppingCart, shoppingCartServiceImp);

        shoppingCartForm.setVisible(true);
    }
}