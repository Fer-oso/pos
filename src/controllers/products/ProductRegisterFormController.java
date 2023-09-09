package controllers.products;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import entitys.Product;
import services.ProductServiceImp;
import views.Products.ProductRegisterFormView;

public class ProductRegisterFormController extends MouseAdapter implements ActionListener {

    private final ProductRegisterFormView productRegisterFormView;

    private final ProductServiceImp productService;

    private DefaultTableModel model = new DefaultTableModel();
    List<Product> listProducts = new ArrayList<>();
    Product product;

    /*Constructors*/
    public ProductRegisterFormController(ProductRegisterFormView productRegisterFormView, ProductServiceImp productService) {

        this.productRegisterFormView = productRegisterFormView;

        this.productService = productService;

        listProducts();
        
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
            
            createNewProduct();
            
            save();
            
            refreshTable();
            
            listProducts();
            
            System.out.println(listProducts);
        }

        if (e.getSource() == productRegisterFormView.getBtnCancel()) {
            
            clearForm();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == productRegisterFormView.getJtTableProducts()) {
            
            getProductSelectedOfTable();
            
            setFormWithSelectedProduct();
        }
    }
   
    /*Functions*/
    
    private void createNewProduct() {

        String name = productRegisterFormView.getTxtName().getText();
         
        Double price = Double.valueOf(productRegisterFormView.getTxtPrice().getText());
        
        Integer stock = Integer.valueOf(productRegisterFormView.getTxtStock().getText());
        
        boolean availability = productRegisterFormView.getJcbAvailability().isSelected();
        
        String brand = productRegisterFormView.getTxtBrand().getText();
       
        String productCode = productRegisterFormView.getTxtCode().getText();
     
        product = new Product(name, price, availability, stock, brand, productCode);
        
        System.out.println(product);
    }
    
    private Product save() {
        
        return productService.save(product);
    }
    
    private void listProducts() {
        
        listProducts = productService.findAll();
        
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

    private void refreshTable() {
        
        for (int i = 0; i < model.getRowCount(); i++) {
            
            model.removeRow(i);
           
            i = i - 1;
        }
    }

}
