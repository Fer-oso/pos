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
import views.Products.ProductFindByPcFormView;

public class ProductFindByPcController extends MouseAdapter implements ActionListener {

    private final ProductFindByPcFormView productFindByPcFormView;

    private final ProductServiceImp productService;

    private DefaultTableModel model = new DefaultTableModel();

    List<Product> listProducts = new ArrayList<>();
    int row;
    int id;
    Product product;

    /*Constructors*/
    
    public ProductFindByPcController(ProductFindByPcFormView productFindByPcFormView, ProductServiceImp productService) {

        this.productFindByPcFormView = productFindByPcFormView;

        this.productService = productService;

        listProducts = productService.findAll();

        listProducts();

        addACtionsListeners();
    }

    /*Actions*/
    private void addACtionsListeners() {

        this.productFindByPcFormView.getJtTableProducts().addMouseListener(this);

        this.productFindByPcFormView.getBtnSearch().addActionListener(this);

        this.productFindByPcFormView.getBtnEdit().addActionListener(this);

        this.productFindByPcFormView.getBtnDelete().addActionListener(this);

        this.productFindByPcFormView.getBtnCancel().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == productFindByPcFormView.getBtnSearch()) {

            listProducts = findByPc();

            refreshTable();

            listProducts();

            System.out.println(listProducts);
        }

        if (e.getSource() == productFindByPcFormView.getBtnEdit()) {

            editProduct();

            refreshTable();

            listProducts();

            System.out.println(listProducts);
        }

        if (e.getSource() == productFindByPcFormView.getBtnDelete()) {

            deleteProduct();

            refreshTable();

            listProducts();

            System.out.println(listProducts);
        }

        if (e.getSource() == productFindByPcFormView.getBtnCancel()) {

            clearForm();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == productFindByPcFormView.getJtTableProducts()) {

            getProductSelectedOfTable();

            setFormWithSelectedProduct(product);
        }
    }

    private void listProducts() {

        model = (DefaultTableModel) this.productFindByPcFormView.getJtTableProducts().getModel();

        for (var pr : listProducts) {

            Object[] productObject = {pr.getId(), pr.getName(), pr.getPrice(), pr.isAvailability(),
                pr.getStock(), pr.getBrand(), pr.getProductCode()};

            model.addRow(productObject);
        }
        this.productFindByPcFormView.getJtTableProducts().setModel(model);

    }

    private Product editProduct() {

        setProductWithDataOfForm();

        return productService.update(row, product);
    }

    private void deleteProduct() {

        productService.delete(id);
    }

    private List<Product> findByPc() {

        String productCode = this.productFindByPcFormView.getTxtSearch().getText();

        product = productService.findByPc(productCode).get();

        List<Product> listProductByName = new ArrayList<>();

        listProductByName.add(product);

        return listProductByName;
    }

    private void getProductSelectedOfTable() {

        row = this.productFindByPcFormView.getJtTableProducts().getSelectedRow();

        product = listProducts.get(row);

        id = product.getId();
    }

    private void setProductWithDataOfForm() {

        product.setName(productFindByPcFormView.getTxtName().getText());

        product.setPrice(Double.valueOf(productFindByPcFormView.getTxtPrice().getText()));

        product.setStock(Integer.valueOf(productFindByPcFormView.getTxtStock().getText()));

        product.setAvailability(productFindByPcFormView.getJcbAvailability().isSelected());

        product.setBrand(productFindByPcFormView.getTxtBrand().getText());

        product.setProductCode(productFindByPcFormView.getTxtCode().getText());
    }

    private void setFormWithSelectedProduct(Product product) {

        this.productFindByPcFormView.getLblId().setText(String.valueOf(product.getId()));

        this.productFindByPcFormView.getTxtName().setText(product.getName());

        this.productFindByPcFormView.getTxtPrice().setText(String.valueOf(product.getPrice()));

        this.productFindByPcFormView.getTxtStock().setText(String.valueOf(product.getStock()));

        checkAvailability();

        this.productFindByPcFormView.getTxtBrand().setText(product.getBrand());

        this.productFindByPcFormView.getTxtCode().setText(product.getProductCode());
    }

    private void checkAvailability() {

        if (product.isAvailability()) {

            this.productFindByPcFormView.getJcbAvailability().setSelected(true);

        } else {

            this.productFindByPcFormView.getJcbAvailability().setSelected(false);
        }
    }

    private void refreshTable() {

        for (int i = 0; i < model.getRowCount(); i++) {

            model.removeRow(i);

            i = i - 1;
        }
    }

    private void clearForm() {

        this.productFindByPcFormView.getLblId().setText("");

        this.productFindByPcFormView.getTxtName().setText("");

        this.productFindByPcFormView.getTxtPrice().setText("");

        this.productFindByPcFormView.getTxtStock().setText("");

        this.productFindByPcFormView.getJcbAvailability().setSelected(false);

        this.productFindByPcFormView.getTxtBrand().setText("");

        this.productFindByPcFormView.getTxtCode().setText("");
    }
}
