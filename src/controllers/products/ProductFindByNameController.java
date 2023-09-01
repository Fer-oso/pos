package controllers.products;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import entitys.Product;
import services.ProductServiceImp;
import views.Products.ProductFindByNameView;

public class ProductFindByNameController extends MouseAdapter implements ActionListener {

    private final ProductFindByNameView productFindByNameView;

    private final ProductServiceImp productService;

    private DefaultTableModel model = new DefaultTableModel();
    private List<Product> listProducts;
    private int row;
    private int id;
    private Product product;

    /*Constructors*/
    
    public ProductFindByNameController(ProductFindByNameView productFindByNameView, ProductServiceImp productService) {

        this.productFindByNameView = productFindByNameView;

        this.productService = productService;
        
        this.listProducts = productService.findAll();

        listProducts();

        addActionsListeners();
    }

    /*Actions*/
    
    private void addActionsListeners() {

        productFindByNameView.getJtTableProducts().addMouseListener(this);

        productFindByNameView.getBtnSearch().addActionListener(this);

        productFindByNameView.getBtnEdit().addActionListener(this);

        productFindByNameView.getBtnDelete().addActionListener(this);

        productFindByNameView.getBtnCancel().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == productFindByNameView.getBtnSearch()) {
            
            refreshTable();
            
            listProducts = findByName();

            listProducts();

            System.out.println(listProducts);
        }

        if (e.getSource() == productFindByNameView.getBtnEdit()) {

            editProduct();

            refreshTable();

            listProducts();

            System.out.println(listProducts);

        }

        if (e.getSource() == productFindByNameView.getBtnDelete()) {

            deleteProduct();

            refreshTable();

            listProducts();

            System.out.println(listProducts);

        }

        if (e.getSource() == productFindByNameView.getBtnCancel()) {

            clearForm();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == productFindByNameView.getJtTableProducts()) {

            getProductSelectedOfTable();

            setFormWithSelectedProduct();
        }
    }

    /*Functions*/
    
    private void listProducts() {

        model = (DefaultTableModel) productFindByNameView.getJtTableProducts().getModel();

        for (var pr : listProducts) {

            Object[] productObject = {pr.getId(), pr.getName(), pr.getPrice(), pr.isAvailability(),
                pr.getStock(), pr.getBrand(), pr.getProductCode()};

            model.addRow(productObject);
        }
        
        this.productFindByNameView.getJtTableProducts().setModel(model);
    }

    private Product editProduct() {

        setProductWithDataOfForm();

        return productService.update(row, product);
    }

    private void deleteProduct() {

        productService.delete(id);
    }

    private List<Product> findByName() {

        String productName = productFindByNameView.getTxtSearch().getText();

        return productService.findByName(productName);
    }

    private void getProductSelectedOfTable() {

        row = this.productFindByNameView.getJtTableProducts().getSelectedRow();

        product = listProducts.get(row);

        id = product.getId();
    }

    private void setProductWithDataOfForm() {

        product.setName(productFindByNameView.getTxtName().getText());

        product.setPrice(Double.valueOf(productFindByNameView.getTxtPrice().getText()));

        product.setStock(Integer.valueOf(productFindByNameView.getTxtStock().getText()));

        product.setAvailability(productFindByNameView.getJcbAvailability().isSelected());

        product.setBrand(productFindByNameView.getTxtBrand().getText());

        product.setProductCode(productFindByNameView.getTxtCode().getText());
    }

    private void setFormWithSelectedProduct() {

        productFindByNameView.getLblId().setText(String.valueOf(product.getId()));

        productFindByNameView.getTxtName().setText(product.getName());

        productFindByNameView.getTxtPrice().setText(String.valueOf(product.getPrice()));

        productFindByNameView.getTxtStock().setText(String.valueOf(product.getStock()));

        checkAvailability();

        productFindByNameView.getTxtBrand().setText(product.getBrand());

        productFindByNameView.getTxtCode().setText(product.getProductCode());
    }

    private void checkAvailability() {

        if (product.isAvailability()) {

            productFindByNameView.getJcbAvailability().setSelected(true);

        } else {

            productFindByNameView.getJcbAvailability().setSelected(false);
        }
    }

    private void refreshTable() {

        for (int i = 0; i < model.getRowCount(); i++) {

            model.removeRow(i);

            i = i - 1;
        }
    }

    private void clearForm() {

        productFindByNameView.getLblId().setText("");

        productFindByNameView.getTxtName().setText("");

        productFindByNameView.getTxtPrice().setText("");

        productFindByNameView.getTxtStock().setText("");

        productFindByNameView.getJcbAvailability().setSelected(false);

        productFindByNameView.getTxtBrand().setText("");

        productFindByNameView.getTxtCode().setText("");
    }

}
