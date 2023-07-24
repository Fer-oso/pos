package pos.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import pos.models.Product;
import pos.services.ProductService;
import pos.views.Product.ProductRegisterForm;

public class ProductRegisterFormController extends MouseAdapter implements ActionListener {

    ProductRegisterForm productRegisterForm;
    ProductService productService;

    private DefaultTableModel model = new DefaultTableModel();
    List<Product> listProducts = new ArrayList<>();
    Product product;

    public ProductRegisterFormController(ProductRegisterForm productRegisterForm, ProductService productService) {
        this.productRegisterForm = productRegisterForm;
        this.productService = productService;
        listProducts(findAll());
        this.productRegisterForm.getJtTableProducts().addMouseListener(this);
        this.productRegisterForm.getBtnSave().addActionListener(this);
        this.productRegisterForm.getBtnCancel().addActionListener(this);
    }

    private Product save() {
        return productService.save(getDataOfForm());
    }

    private List<Product> findAll() {
        return productService.findAll();
    }

    private void listProducts(List<Product> listProducts) {
        this.listProducts = listProducts;
        model = (DefaultTableModel) this.productRegisterForm.getJtTableProducts().getModel();
        Object[] product = new Object[7];

        for (int i = 0; i < listProducts.size(); i++) {
            product[0] = listProducts.get(i).getId();
            product[1] = listProducts.get(i).getName();
            product[2] = listProducts.get(i).getPrice();
            product[3] = listProducts.get(i).getStock();
            product[4] = listProducts.get(i).isAvailability();
            product[5] = listProducts.get(i).getBrand();
            product[6] = listProducts.get(i).getProductCode();

            model.addRow(product);
        }
        this.productRegisterForm.getJtTableProducts().setModel(model);

    }

    private Product getProductSelectedOfTable() {
        int row = this.productRegisterForm.getJtTableProducts().getSelectedRow();
        product = listProducts.get(row);
        return product;

    }

    private void setFormWithSelectedProduct(Product product) {
        this.productRegisterForm.getLblId().setText(String.valueOf(product.getId()));
        this.productRegisterForm.getTxtName().setText(product.getName());
        this.productRegisterForm.getTxtPrice().setText(String.valueOf(product.getPrice()));
        this.productRegisterForm.getTxtStock().setText(String.valueOf(product.getStock()));
        checkAvailability();
        this.productRegisterForm.getTxtBrand().setText(product.getBrand());
        this.productRegisterForm.getTxtCode().setText(product.getProductCode());
    }

    private Product getDataOfForm(){

        String name = productRegisterForm.getTxtName().getText();
        double price = Double.parseDouble(productRegisterForm.getTxtPrice().getText());
        int stock = Integer.parseInt(productRegisterForm.getTxtStock().getText());
        boolean availability = productRegisterForm.getJcbAvailability().isSelected();
        String brand = productRegisterForm.getTxtBrand().getText();
        String productCode = productRegisterForm.getTxtCode().getText();
        //int id = Integer.parseInt(productRegisterForm.getLblId().getText());

        return  new Product(name, price, availability, stock, brand, productCode);
    }

    private void checkAvailability() {
        if (getProductSelectedOfTable().isAvailability()) {

            this.productRegisterForm.getJcbAvailability().setSelected(true);
        } else {
            this.productRegisterForm.getJcbAvailability().setSelected(false);
        }
    }

    private void clearForm() {
        this.productRegisterForm.getLblId().setText("");
        this.productRegisterForm.getTxtName().setText("");
        this.productRegisterForm.getTxtPrice().setText("");
        this.productRegisterForm.getTxtStock().setText("");
        checkAvailability();
        this.productRegisterForm.getTxtBrand().setText("");
        this.productRegisterForm.getTxtCode().setText("");
    }

    private void actualizarTabla(DefaultTableModel modelo) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == productRegisterForm.getBtnSave()) {
            save();
            actualizarTabla(model);
            listProducts(findAll());
            System.out.println(listProducts);
        }

        if (e.getSource() == productRegisterForm.getBtnCancel()) {
            clearForm();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == productRegisterForm.getJtTableProducts()) {
            getProductSelectedOfTable();
            setFormWithSelectedProduct(product);
        }
    }
}
