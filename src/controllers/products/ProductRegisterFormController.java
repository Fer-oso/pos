package controllers.products;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import entitys.Product;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import services.ProductServiceImp;
import views.Products.ProductRegisterFormView;

public class ProductRegisterFormController extends MouseAdapter implements ActionListener, Serializable {

    private static final long serialVersionUID = 1L;

    private final ProductRegisterFormView productRegisterFormView;

    private final ProductServiceImp productServiceImp;

    private DefaultTableModel model = new DefaultTableModel();
    private ArrayList<Product> listProducts;
    private Product product;

    /*Constructors*/
    public ProductRegisterFormController(ProductRegisterFormView productRegisterFormView, ProductServiceImp productServiceImp) {

        this.productRegisterFormView = productRegisterFormView;

        this.productServiceImp = productServiceImp;
        
        addACtionsListeners();
    }

    /*Actions*/
    private void addACtionsListeners() {

        productRegisterFormView.getJtTableProducts().addMouseListener(this);

        productRegisterFormView.getBtnSave().addActionListener(this);

        productRegisterFormView.getBtnCancel().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == productRegisterFormView.getBtnSave()) {

            if (createNewProduct()) {

                save();
                
                clearForm();

                refreshTable();

                listProducts();

            }
            System.out.println(listProducts);
        }

        if (e.getSource() == productRegisterFormView.getBtnCancel()) {

            clearForm();

            refreshTable();

            listProducts = productServiceImp.findAll();

            listProducts();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e
    ) {

        if (e.getSource() == productRegisterFormView.getJtTableProducts()) {

            getProductSelectedOfTable();

            setFormWithSelectedProduct();
        }
    }

    /*Functions*/
    private boolean createNewProduct() {

        if (productRegisterFormView.getTxtName().getText().equals("") || productRegisterFormView.getTxtPrice().getText().equals("")
                || productRegisterFormView.getTxtStock().getText().equals("") || productRegisterFormView.getTxtBrand().getText().equals("") || productRegisterFormView.getTxtCode().getText().equals("")) {

            JOptionPane.showMessageDialog(null, "All fields required");

            return false;
        }

        String name = productRegisterFormView.getTxtName().getText();

        Double price = Double.valueOf(productRegisterFormView.getTxtPrice().getText());

        Integer stock = Integer.valueOf(productRegisterFormView.getTxtStock().getText());

        boolean availability = productRegisterFormView.getJcbAvailability().isSelected();

        String brand = productRegisterFormView.getTxtBrand().getText();

        String productCode = productRegisterFormView.getTxtCode().getText();

        product = new Product(name, price, availability, stock, brand, productCode);

        System.out.println(product);

        return true;
    }

    private Product save() {

        return productServiceImp.save(product);
    }

    public void listProducts() {
        
        listProducts = productServiceImp.findAll();

        model = (DefaultTableModel) this.productRegisterFormView.getJtTableProducts().getModel();

        for (var pr : listProducts) {

            Object[] productObject = {pr.getId(), pr.getName(), pr.getPrice(), pr.isAvailability(),
                pr.getStock(), pr.getBrand(), pr.getProductCode()};

            model.addRow(productObject);
        }

        this.productRegisterFormView.getJtTableProducts().setModel(model);
    }

    private void getProductSelectedOfTable() {

        int row = this.productRegisterFormView.getJtTableProducts().getSelectedRow();

        product = listProducts.get(row);
    }

    private void setFormWithSelectedProduct() {

        this.productRegisterFormView.getLblId().setText(String.valueOf(product.getId()));

        this.productRegisterFormView.getTxtName().setText(product.getName());

        this.productRegisterFormView.getTxtPrice().setText(String.valueOf(product.getPrice()));

        this.productRegisterFormView.getTxtStock().setText(String.valueOf(product.getStock()));

        checkAvailability();

        this.productRegisterFormView.getTxtBrand().setText(product.getBrand());

        this.productRegisterFormView.getTxtCode().setText(product.getProductCode());
    }

    private void checkAvailability() {

        if (product.isAvailability()) {

            this.productRegisterFormView.getJcbAvailability().setSelected(true);

        } else {

            this.productRegisterFormView.getJcbAvailability().setSelected(false);
        }
    }

    private void clearForm() {

        this.productRegisterFormView.getLblId().setText("");

        this.productRegisterFormView.getTxtName().setText("");

        this.productRegisterFormView.getTxtPrice().setText("");

        this.productRegisterFormView.getTxtStock().setText("");

        this.productRegisterFormView.getJcbAvailability().setSelected(false);

        this.productRegisterFormView.getTxtBrand().setText("");

        this.productRegisterFormView.getTxtCode().setText("");
    }

    public void refreshTable() {

        for (int i = 0; i < model.getRowCount(); i++) {

            model.removeRow(i);

            i = i - 1;
        }
    }

}
