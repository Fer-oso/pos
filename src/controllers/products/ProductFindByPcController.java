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
import views.Products.ProductFindByPcView;

public class ProductFindByPcController extends MouseAdapter implements ActionListener {

    private final ProductFindByPcView productFindByPcView;

    private final ProductServiceImp productService;

    private DefaultTableModel model = new DefaultTableModel();

    List<Product> listProducts = new ArrayList<>();
    int row;
    int id;
    Product product;

    /*Constructors*/
    
    public ProductFindByPcController(ProductFindByPcView productFindByPcView, ProductServiceImp productService) {

        this.productFindByPcView = productFindByPcView;

        this.productService = productService;

        listProducts = productService.findAll();

        listProducts();

        addACtionsListeners();
    }

    /*Actions*/
    private void addACtionsListeners() {

        this.productFindByPcView.getJtTableProducts().addMouseListener(this);

        this.productFindByPcView.getBtnSearch().addActionListener(this);

        this.productFindByPcView.getBtnEdit().addActionListener(this);

        this.productFindByPcView.getBtnDelete().addActionListener(this);

        this.productFindByPcView.getBtnCancel().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == productFindByPcView.getBtnSearch()) {

            listProducts = findByPc();

            refreshTable();

            listProducts();

            System.out.println(listProducts);
        }

        if (e.getSource() == productFindByPcView.getBtnEdit()) {

            editProduct();

            refreshTable();

            listProducts();

            System.out.println(listProducts);
        }

        if (e.getSource() == productFindByPcView.getBtnDelete()) {

            deleteProduct();

            refreshTable();

            listProducts();

            System.out.println(listProducts);
        }

        if (e.getSource() == productFindByPcView.getBtnCancel()) {

            clearForm();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == productFindByPcView.getJtTableProducts()) {

            getProductSelectedOfTable();

            setFormWithSelectedProduct(product);
        }
    }

    private void listProducts() {

        model = (DefaultTableModel) this.productFindByPcView.getJtTableProducts().getModel();

        for (var pr : listProducts) {

            Object[] productObject = {pr.getId(), pr.getName(), pr.getPrice(), pr.isAvailability(),
                pr.getStock(), pr.getBrand(), pr.getProductCode()};

            model.addRow(productObject);
        }
        this.productFindByPcView.getJtTableProducts().setModel(model);

    }

    private Product editProduct() {

        setProductWithDataOfForm();

        return productService.update(row, product);
    }

    private void deleteProduct() {

        productService.delete(id);
    }

    private List<Product> findByPc() {

        String productCode = this.productFindByPcView.getTxtSearch().getText();

        product = productService.findByPc(productCode).get();

        List<Product> listProductByName = new ArrayList<>();

        listProductByName.add(product);

        return listProductByName;
    }

    private void getProductSelectedOfTable() {

        row = this.productFindByPcView.getJtTableProducts().getSelectedRow();

        product = listProducts.get(row);

        id = product.getId();
    }

    private void setProductWithDataOfForm() {

        product.setName(productFindByPcView.getTxtName().getText());

        product.setPrice(Double.valueOf(productFindByPcView.getTxtPrice().getText()));

        product.setStock(Integer.valueOf(productFindByPcView.getTxtStock().getText()));

        product.setAvailability(productFindByPcView.getJcbAvailability().isSelected());

        product.setBrand(productFindByPcView.getTxtBrand().getText());

        product.setProductCode(productFindByPcView.getTxtCode().getText());
    }

    private void setFormWithSelectedProduct(Product product) {

        this.productFindByPcView.getLblId().setText(String.valueOf(product.getId()));

        this.productFindByPcView.getTxtName().setText(product.getName());

        this.productFindByPcView.getTxtPrice().setText(String.valueOf(product.getPrice()));

        this.productFindByPcView.getTxtStock().setText(String.valueOf(product.getStock()));

        checkAvailability();

        this.productFindByPcView.getTxtBrand().setText(product.getBrand());

        this.productFindByPcView.getTxtCode().setText(product.getProductCode());
    }

    private void checkAvailability() {

        if (product.isAvailability()) {

            this.productFindByPcView.getJcbAvailability().setSelected(true);

        } else {

            this.productFindByPcView.getJcbAvailability().setSelected(false);
        }
    }

    private void refreshTable() {

        for (int i = 0; i < model.getRowCount(); i++) {

            model.removeRow(i);

            i = i - 1;
        }
    }

    private void clearForm() {

        this.productFindByPcView.getLblId().setText("");

        this.productFindByPcView.getTxtName().setText("");

        this.productFindByPcView.getTxtPrice().setText("");

        this.productFindByPcView.getTxtStock().setText("");

        this.productFindByPcView.getJcbAvailability().setSelected(false);

        this.productFindByPcView.getTxtBrand().setText("");

        this.productFindByPcView.getTxtCode().setText("");
    }
}
