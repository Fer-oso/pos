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
import views.Product.ProductFindByPc;

public class ProductFindByPcController extends MouseAdapter implements ActionListener {

    private final ProductServiceImp productService;
    private final ProductFindByPc productFindByPc;

    private DefaultTableModel model = new DefaultTableModel();
    List<Product> listProducts = new ArrayList<>();
    int row;
    Product product;

    public ProductFindByPcController(ProductFindByPc productFindByPc, ProductServiceImp productService) {
        this.productFindByPc = productFindByPc;
        this.productService = productService;
        listProducts(findAll());
        this.productFindByPc.getJtTableProducts().addMouseListener(this);
        this.productFindByPc.getBtnSearch().addActionListener(this);
        this.productFindByPc.getBtnEdit().addActionListener(this);
        this.productFindByPc.getBtnDelete().addActionListener(this);
        this.productFindByPc.getBtnCancel().addActionListener(this);

    }

    private List<Product> findByName() {
        String productName = this.productFindByPc.getTxtSearch().getText();
        List<Product> listProductByName = productService.findByName(productName);
        return listProductByName;
    }

    private List<Product> findAll() {
        return productService.findAll();
    }

    private void listProducts(List<Product> listProducts) {
        this.listProducts = listProducts;
        model = (DefaultTableModel) this.productFindByPc.getJtTableProducts().getModel();
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
        this.productFindByPc.getJtTableProducts().setModel(model);

    }

    private Product getProductSelectedOfTable() {
        row = this.productFindByPc.getJtTableProducts().getSelectedRow();
        product = listProducts.get(row);
        return product;

    }

    private Product editProduct() {
        return productService.update(row, getDataOfForm());
    }

    private void deleteProduct() {
        productService.delete(row);
    }

    private Product getDataOfForm() {
        product.setName(productFindByPc.getTxtName().getText());
        product.setPrice(Double.valueOf(productFindByPc.getTxtPrice().getText()));
        product.setStock(Integer.valueOf(productFindByPc.getTxtStock().getText()));
        product.setAvailability(productFindByPc.getJcbAvailability().isSelected());
        product.setBrand(productFindByPc.getTxtBrand().getText());
        product.setProductCode(productFindByPc.getTxtCode().getText());
        // int id = Integer.parseInt(productFindByPc.getLblId().getText());
        return product;
    }

    private void setFormWithSelectedProduct(Product product) {
        this.productFindByPc.getLblId().setText(String.valueOf(product.getId()));
        this.productFindByPc.getTxtName().setText(product.getName());
        this.productFindByPc.getTxtPrice().setText(String.valueOf(product.getPrice()));
        this.productFindByPc.getTxtStock().setText(String.valueOf(product.getStock()));
        checkAvailability();
        this.productFindByPc.getTxtBrand().setText(product.getBrand());
        this.productFindByPc.getTxtCode().setText(product.getProductCode());
    }

    private void checkAvailability() {
        if (getProductSelectedOfTable().isAvailability()) {

            this.productFindByPc.getJcbAvailability().setSelected(true);
        } else {
            this.productFindByPc.getJcbAvailability().setSelected(false);
        }
    }

    private void actualizarTabla(DefaultTableModel modelo) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    private void clearForm() {
        this.productFindByPc.getLblId().setText("");
        this.productFindByPc.getTxtName().setText("");
        this.productFindByPc.getTxtPrice().setText("");
        this.productFindByPc.getTxtStock().setText("");
        this.productFindByPc.getJcbAvailability().setSelected(false);
        this.productFindByPc.getTxtBrand().setText("");
        this.productFindByPc.getTxtCode().setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == productFindByPc.getBtnSearch()) {
            actualizarTabla(model);
            listProducts(findByName());
            System.out.println(listProducts);
        }

        if (e.getSource() == productFindByPc.getBtnEdit()) {
            editProduct();
            actualizarTabla(model);
            listProducts(findAll());

            System.out.println(listProducts);

        }

        if (e.getSource() == productFindByPc.getBtnDelete()) {
            deleteProduct();
            actualizarTabla(model);
            listProducts(findAll());

            System.out.println(listProducts);

        }

        if (e.getSource() == productFindByPc.getBtnCancel()) {
            clearForm();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == productFindByPc.getJtTableProducts()) {
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
