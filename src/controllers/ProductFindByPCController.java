package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.Product;
import services.ProductServiceImp;
import views.Product.ProductFindByPC;

public class ProductFindByPCController extends MouseAdapter implements ActionListener {

    private final ProductServiceImp productService;
    private final ProductFindByPC productFindByPC;

    private DefaultTableModel model = new DefaultTableModel();
    List<Product> listProducts = new ArrayList<>();
    int row;
    Product product;
    
    public ProductFindByPCController(ProductFindByPC productFindByPC, ProductServiceImp productService) {
        this.productFindByPC = productFindByPC;
        this.productService = productService;
        listProducts(findAll());
        this.productFindByPC.getJtTableProducts().addMouseListener(this);
        this.productFindByPC.getBtnSearch().addActionListener(this);
        this.productFindByPC.getBtnEdit().addActionListener(this);
        this.productFindByPC.getBtnCancel().addActionListener(this);

    }

    private List<Product> findByPC() {
        String productCode = this.productFindByPC.getTxtSearch().getText();
        List<Product> listProductByPC = productService.findByPc(productCode);
        return listProductByPC;
    }

    private List<Product> findAll() {
        return productService.findAll();
    }

    private void listProducts(List<Product> listProducts) {
        this.listProducts = listProducts;
        model = (DefaultTableModel) this.productFindByPC.getJtTableProducts().getModel();
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
        this.productFindByPC.getJtTableProducts().setModel(model);

    }

    private Product getProductSelectedOfTable() {
        row = this.productFindByPC.getJtTableProducts().getSelectedRow();
        product = listProducts.get(row);
        return product;

    }

    private Product editProduct() {
        return productService.update(row,getDataOfForm());
    }

    private Product getDataOfForm() {
        String name = productFindByPC.getTxtName().getText();
        double price = Double.parseDouble(productFindByPC.getTxtPrice().getText());
        int stock = Integer.parseInt(productFindByPC.getTxtStock().getText());
        boolean availability = productFindByPC.getJcbAvailability().isSelected();
        String brand = productFindByPC.getTxtBrand().getText();
        String productCode = productFindByPC.getTxtCode().getText();
        //int id = Integer.parseInt(productFindByPC.getLblId().getText());
        return new Product(name, price, availability, stock, brand, productCode);
    }

    private void setFormWithSelectedProduct(Product product) {
        this.productFindByPC.getLblId().setText(String.valueOf(product.getId()));
        this.productFindByPC.getTxtName().setText(product.getName());
        this.productFindByPC.getTxtPrice().setText(String.valueOf(product.getPrice()));
        this.productFindByPC.getTxtStock().setText(String.valueOf(product.getStock()));
        checkAvailability();
        this.productFindByPC.getTxtBrand().setText(product.getBrand());
        this.productFindByPC.getTxtCode().setText(product.getProductCode());
    }

    private void checkAvailability() {
        if (getProductSelectedOfTable().isAvailability()) {

            this.productFindByPC.getJcbAvailability().setSelected(true);
        } else {
            this.productFindByPC.getJcbAvailability().setSelected(false);
        }
    }

    private void actualizarTabla(DefaultTableModel modelo) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
    
    private void clearForm(){
        this.productFindByPC.getLblId().setText("");
        this.productFindByPC.getTxtName().setText("");
        this.productFindByPC.getTxtPrice().setText("");
        this.productFindByPC.getTxtStock().setText("");
        checkAvailability();
        this.productFindByPC.getTxtBrand().setText("");
        this.productFindByPC.getTxtCode().setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == productFindByPC.getBtnSearch()) {
            actualizarTabla(model);
            listProducts(findByPC());
            System.out.println(listProducts);
        }

        if (e.getSource() == productFindByPC.getBtnEdit()) {
            editProduct();
            actualizarTabla(model);
            listProducts(findAll());
            
            System.out.println(listProducts);
            
        }
        
        if (e.getSource() == productFindByPC.getBtnCancel()) {
            clearForm();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == productFindByPC.getJtTableProducts()) {
            getProductSelectedOfTable();
            setFormWithSelectedProduct(product);
        }
    }

}
