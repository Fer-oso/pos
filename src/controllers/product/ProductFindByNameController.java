package controllers.product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.Product;
import services.ProductServiceImp;
import views.Product.ProductFindByName;

public class ProductFindByNameController extends MouseAdapter implements ActionListener {

    private final ProductServiceImp productService;
    private final ProductFindByName productFindByName;

    private DefaultTableModel model = new DefaultTableModel();
    List<Product> listProducts = new ArrayList<>();
    int row;
    Product product;

    public ProductFindByNameController(ProductFindByName productFindByName, ProductServiceImp productService) {
        this.productFindByName = productFindByName;
        this.productService = productService;
        listProducts(findAll());
        this.productFindByName.getJtTableProducts().addMouseListener(this);
        this.productFindByName.getBtnSearch().addActionListener(this);
        this.productFindByName.getBtnEdit().addActionListener(this);
        this.productFindByName.getBtnDelete().addActionListener(this);
        this.productFindByName.getBtnCancel().addActionListener(this);

    }

    private List<Product> findByName() {
        String productName = this.productFindByName.getTxtSearch().getText();
        List<Product> listProductByName = productService.findByName(productName);
        return listProductByName;
    }

    private List<Product> findAll() {
        return productService.findAll();
    }

    private Product editProduct() {
        return productService.update(row, getDataOfForm());
    }

    private void deleteProduct() {
        productService.delete(row);
    }

    private void listProducts(List<Product> listProducts) {
        this.listProducts = listProducts;
        model = (DefaultTableModel) this.productFindByName.getJtTableProducts().getModel();
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
        this.productFindByName.getJtTableProducts().setModel(model);

    }

    private Product getProductSelectedOfTable() {
        row = this.productFindByName.getJtTableProducts().getSelectedRow();
        product = listProducts.get(row);
        return product;

    }

    private Product getDataOfForm() {
        product.setName(productFindByName.getTxtName().getText());
        product.setPrice(Double.valueOf(productFindByName.getTxtPrice().getText()));
        product.setStock(Integer.valueOf(productFindByName.getTxtStock().getText()));
        product.setAvailability(productFindByName.getJcbAvailability().isSelected());
        product.setBrand(productFindByName.getTxtBrand().getText());
        product.setProductCode(productFindByName.getTxtCode().getText());
        // int id = Integer.parseInt(productFindByName.getLblId().getText());
        return product;
    }

    private void setFormWithSelectedProduct(Product product) {
        this.productFindByName.getLblId().setText(String.valueOf(product.getId()));
        this.productFindByName.getTxtName().setText(product.getName());
        this.productFindByName.getTxtPrice().setText(String.valueOf(product.getPrice()));
        this.productFindByName.getTxtStock().setText(String.valueOf(product.getStock()));
        checkAvailability();
        this.productFindByName.getTxtBrand().setText(product.getBrand());
        this.productFindByName.getTxtCode().setText(product.getProductCode());
    }

    private void checkAvailability() {
        if (getProductSelectedOfTable().isAvailability()) {

            this.productFindByName.getJcbAvailability().setSelected(true);
        } else {
            this.productFindByName.getJcbAvailability().setSelected(false);
        }
    }

    private void actualizarTabla(DefaultTableModel modelo) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    private void clearForm() {
        this.productFindByName.getLblId().setText("");
        this.productFindByName.getTxtName().setText("");
        this.productFindByName.getTxtPrice().setText("");
        this.productFindByName.getTxtStock().setText("");
        this.productFindByName.getJcbAvailability().setSelected(false);
        this.productFindByName.getTxtBrand().setText("");
        this.productFindByName.getTxtCode().setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == productFindByName.getBtnSearch()) {
            actualizarTabla(model);
            listProducts(findByName());
            System.out.println(listProducts);
        }

        if (e.getSource() == productFindByName.getBtnEdit()) {
            editProduct();
            actualizarTabla(model);
            listProducts(findAll());

            System.out.println(listProducts);

        }

        if (e.getSource() == productFindByName.getBtnDelete()) {
            deleteProduct();
            actualizarTabla(model);
            listProducts(findAll());

            System.out.println(listProducts);

        }

        if (e.getSource() == productFindByName.getBtnCancel()) {
            clearForm();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == productFindByName.getJtTableProducts()) {
            getProductSelectedOfTable();
            setFormWithSelectedProduct(product);
        }

//         if (true) {
//            actualizarTabla(model);
//            listProducts(findAll());
//            System.out.println(listProducts);
//        }
    }
}
