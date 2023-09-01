package controllers.Shop;

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

import views.Shop.ShopForm;
import views.Shop.ShoppingCartForm;

 public class ShopFormController extends MouseAdapter implements ActionListener {

    /*Services*/
    private final ProductServiceImp productServiceImp;

    private final ClientServiceImp clientServiceImp;

    private final ShoppingCartServiceImp shoppingCartServiceImp;

    /*Views*/
    private final ShopForm shopForm;

    private ShoppingCartForm shoppingCartForm;

    private DefaultTableModel model = new DefaultTableModel();

    /*Global variables*/
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
    public ShopFormController(ShopForm shopForm, ProductServiceImp productServiceImp, ClientServiceImp clientServiceImp, ShoppingCartServiceImp shoppingCartServiceImp) {

        this.shopForm = shopForm;

        this.productServiceImp = productServiceImp;

        this.clientServiceImp = clientServiceImp;

        this.shoppingCartServiceImp = shoppingCartServiceImp;
        
        initEvents();

    }

    /*Actions Events*/
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.shopForm.getTxtProductCode()) {

            findProduct();
        }

        if (e.getSource() == this.shopForm.getTxtProductQuantityToSell()) {

            checkQuantityLessStock();

            refreshTable(model);

            listProductsCarshop();

        }

        if (e.getSource() == this.shopForm.getBtnRemove()) {

            removeProductToList(id);

            refreshTable(model);

            listProductsCarshop();
        }

        if (e.getSource() == this.shopForm.getTxtClientSsn()) {

            findClient();
        }

        if (e.getSource() == this.shopForm.getBtnAddToShoppingCart()) {

            addToShoppingCart();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == shopForm.getjTableProducts()) {

            getProductSelectedOfTable();

        }
    }
    
    private void initEvents(){
        
        this.shopForm.getTxtProductCode().addActionListener(this);

        this.shopForm.getTxtProductQuantityToSell().addActionListener(this);

        this.shopForm.getBtnRemove().addActionListener(this);

        this.shopForm.getTxtClientSsn().addActionListener(this);

        this.shopForm.getBtnAddToShoppingCart().addActionListener(this);

        this.shopForm.getjTableProducts().addMouseListener(this);
    
    }

    /*Function o business logic*/
    private void findProduct() {

        if (!"".equals(this.shopForm.getTxtProductCode().getText())) {

            String productCode = this.shopForm.getTxtProductCode().getText();

            product = productServiceImp.findByPc(productCode).get();

            System.out.println(product);

            if (product.getName() != null) {

                this.shopForm.getTxtProductName().setText("" + product.getName());

                this.shopForm.getTxtProductBrand().setText("" + product.getBrand());

                this.shopForm.getTxtProductPrice().setText("" + product.getPrice());

                this.shopForm.getTxtProductStock().setText("" + product.getStock());

                this.shopForm.getTxtProductQuantityToSell().requestFocus();

            } else {

                this.shopForm.getTxtProductName().setText("");

                this.shopForm.getTxtProductBrand().setText("");

                this.shopForm.getTxtProductPrice().setText("");

                this.shopForm.getTxtProductStock().setText("");

                this.shopForm.getTxtProductCode().requestFocus();

                this.shopForm.getTxtProductQuantityToSell().setText("");

            }

        } else {

            JOptionPane.showMessageDialog(null, "Insert product code");

            this.shopForm.getTxtProductCode().requestFocus();

            this.shopForm.getTxtProductQuantityToSell().setText("");
        }
    }

    private void checkQuantityLessStock() {

        int actualStock;

        if (!"".equals(this.shopForm.getTxtProductQuantityToSell().getText())) {

            int productStock = Integer.parseInt(this.shopForm.getTxtProductStock().getText());

            productQuantityToSell = Integer.parseInt(this.shopForm.getTxtProductQuantityToSell().getText());

            if (productStock >= productQuantityToSell) { // si el producto se puede vender

                selectedProduct = createSelectedProduct(); // crea un producto seleccionado

                this.shopForm.getTxtProductQuantityToSell().setText("");

                addProductToList(selectedProduct); // añade a la lista el producto seleccionado

                actualStock = (productStock - productQuantityToSell);

                this.shopForm.getTxtProductStock().setText("" + actualStock);

            } else {

                JOptionPane.showMessageDialog(null, "Stock no disponible");

            }

        } else {

            JOptionPane.showMessageDialog(null, "Insert quantity ");

            this.shopForm.getTxtProductQuantityToSell().requestFocus();

            this.shopForm.getTxtProductQuantityToSell().setText("");

        }
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

    private SelectedProduct createSelectedProduct() {

        id = product.getId();

        String productCode = product.getProductCode();

        String productName = product.getName();

        String productBrand = product.getBrand();

        double productPrice = product.getPrice();

        double finalPrice = productQuantityToSell * productPrice;

        return new SelectedProduct(id, productCode, productName, productBrand, productPrice, productQuantityToSell, finalPrice);

    }

    private void listProductsCarshop() {

        model = (DefaultTableModel) this.shopForm.getjTableProducts().getModel();

        //MODELO TABLA
        Object[] objectProduct = new Object[6];

        for (int i = 0; i < listSelectedProducts.size(); i++) {

            objectProduct[0] = listSelectedProducts.get(i).getProductCode();

            objectProduct[1] = listSelectedProducts.get(i).getProductName();

            objectProduct[2] = listSelectedProducts.get(i).getProductBrand();

            objectProduct[3] = listSelectedProducts.get(i).getProductQuantity();

            objectProduct[4] = listSelectedProducts.get(i).getProductPrice();

            objectProduct[5] = listSelectedProducts.get(i).getFinalPrice();

            model.addRow(objectProduct);
        }

        this.shopForm.getjTableProducts().setModel(model);

        calculateFinalPrice();

    }

    private void calculateFinalPrice() {

        total = 0.0;

        double finalPrice;

        for (SelectedProduct selectedProduct : listSelectedProducts) {

            finalPrice = selectedProduct.getFinalPrice() *1.21;

            total += finalPrice;

            this.shopForm.getLblTotal().setText("" + total);

            System.out.println(finalPrice);

            System.out.println(total);
        }

    }

    private void getProductSelectedOfTable() {

        row = this.shopForm.getjTableProducts().getSelectedRow();

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

            this.selectedProduct = iteratorList.next();

            if (this.selectedProduct.getId().equals(id)) {

                System.out.println("" + this.selectedProduct);

                iteratorList.remove();

                break;
            }
        }

        System.out.println(listSelectedProducts);
    }

    private void findClient() {

        if (!"".equals(this.shopForm.getTxtClientSsn().getText())) {

            ssn = Integer.valueOf(this.shopForm.getTxtClientSsn().getText());

            client = clientServiceImp.findBySsn(ssn).get();

            if (client.getName() != null) {

                this.shopForm.getTxtClientName().setText("" + client.getName());

            } else {

                JOptionPane.showMessageDialog(null, "Client not found");

                this.shopForm.getTxtClientSsn().setText("");
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

        this.shoppingCartForm = new ShoppingCartForm(shoppingCart, shoppingCartServiceImp);

        shoppingCartForm.setVisible(true);

    }

}
