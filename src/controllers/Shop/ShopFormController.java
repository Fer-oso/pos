package controllers.Shop;

import entitys.Client;
import entitys.Product;
import entitys.SelectedProduct;
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

import views.Shop.ShopForm;

public class ShopFormController extends MouseAdapter implements ActionListener {

    private final ProductServiceImp productServiceImp;

    private final ClientServiceImp clientServiceImp;

    private final ShopForm shopForm;

    private DefaultTableModel model = new DefaultTableModel();

    private final List<SelectedProduct> listSelectedProducts = new ArrayList<>();

    private Product product;

    private Client client;

    private SelectedProduct selectedProduct;

    int productQuantity;

    int row;

    Integer id;

    Integer ssn;

    public ShopFormController(ShopForm shopForm, ProductServiceImp productServiceImp, ClientServiceImp clientServiceImp) {

        this.shopForm = shopForm;

        this.productServiceImp = productServiceImp;

        this.clientServiceImp = clientServiceImp;

        this.shopForm.getTxtProductCode().addActionListener(this);

        this.shopForm.getTxtProductQuantityToSell().addActionListener(this);

        this.shopForm.getBtnRemove().addActionListener(this);
        
        this.shopForm.getTxtClientSsn().addActionListener(this);

        this.shopForm.getjTableProducts().addMouseListener(this);

    }

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

        int stockActual;

        if (!"".equals(this.shopForm.getTxtProductQuantityToSell().getText())) {

            int productStock = Integer.parseInt(this.shopForm.getTxtProductStock().getText());

            productQuantity = Integer.parseInt(this.shopForm.getTxtProductQuantityToSell().getText());

            if (productStock >= productQuantity) { // si el producto se puede vender

                selectedProduct = createSelectedProduct(); // crea un producto seleccionado

                this.shopForm.getTxtProductQuantityToSell().setText("");

                addProductToList(selectedProduct); // añade a la lista el producto seleccionado

                stockActual = (productStock - productQuantity);

                this.shopForm.getTxtProductStock().setText("" + stockActual);

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

            for (int i = 0; i < listSelectedProducts.size(); i++) {

                if (listSelectedProducts.get(i).getProductCode().equals(selectedProduct.getProductCode())) {

                    JOptionPane.showMessageDialog(null, "producto ya esta en la lista");

                    listSelectedProducts.get(i).setProductQuantity(listSelectedProducts.get(i).getProductQuantity() + productQuantity);

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

        Integer id = product.getId();

        String productCode = product.getProductCode();

        String productName = product.getName();

        String productBrand = product.getBrand();

        double productPrice = product.getPrice();

        double finalPrice = productQuantity * productPrice;

        return new SelectedProduct(id, productCode, productName, productBrand, productPrice, productQuantity, finalPrice);

    }

    private void listProductsCarshop() {

        model = (DefaultTableModel) this.shopForm.getjTableProducts().getModel();

        //MODELO TABLA
        Object[] product = new Object[6];

        for (int i = 0; i < listSelectedProducts.size(); i++) {

            product[0] = listSelectedProducts.get(i).getProductCode();

            product[1] = listSelectedProducts.get(i).getProductName();

            product[2] = listSelectedProducts.get(i).getProductBrand();

            product[3] = listSelectedProducts.get(i).getProductQuantity();

            product[4] = listSelectedProducts.get(i).getProductPrice();

            product[5] = listSelectedProducts.get(i).getFinalPrice();

            model.addRow(product);
        }

        this.shopForm.getjTableProducts().setModel(model);

        calculateFinalPrice();

    }

    private void calculateFinalPrice() {

        double precioProductTabla, precioFinal, totalAPagar = 0, valor = 0;

        int cantidadProductTabla;

        for (int i = 0; i < this.shopForm.getjTableProducts().getRowCount(); i++) {

            cantidadProductTabla = Integer.parseInt(String.valueOf(this.shopForm.getjTableProducts().getModel().getValueAt(i, 3)));

            precioProductTabla = Double.parseDouble(String.valueOf(this.shopForm.getjTableProducts().getModel().getValueAt(i, 4)));

            precioFinal = cantidadProductTabla * precioProductTabla;

            this.shopForm.getjTableProducts().getModel().setValueAt(precioFinal, i, 5);

            precioFinal = cantidadProductTabla * precioProductTabla;
        }

        for (int i = 0; i < this.shopForm.getjTableProducts().getRowCount(); i++) {

            valor = Double.parseDouble(String.valueOf(this.shopForm.getjTableProducts().getModel().getValueAt(i, 5)));

            totalAPagar = totalAPagar + valor;

            this.shopForm.getLblTotal().setText("" + totalAPagar);

            System.out.println(valor);

            System.out.println(totalAPagar);
        }
        totalAPagar = 0;
    }

    private void getProductSelectedOfTable() {

        row = this.shopForm.getjTableProducts().getSelectedRow();

        selectedProduct = listSelectedProducts.get(row);

        id = selectedProduct.getId();

        System.out.println(id);
    }

    private void actualizarTabla(DefaultTableModel modelo) {

        for (int i = 0; i < modelo.getRowCount(); i++) {

            modelo.removeRow(i);

            i = i - 1;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.shopForm.getTxtProductCode()) {

            findProduct();
        }

        if (e.getSource() == this.shopForm.getTxtProductQuantityToSell()) {

            checkQuantityLessStock();

            actualizarTabla(model);

            listProductsCarshop();

        }

        if (e.getSource() == this.shopForm.getBtnRemove()) {

            removeProductToList(id);

            actualizarTabla(model);

            listProductsCarshop();
        }

        if (e.getSource() == this.shopForm.getTxtClientSsn()) {

            findClient();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == shopForm.getjTableProducts()) {

            getProductSelectedOfTable();

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

                JOptionPane.showMessageDialog(null, "Cliente no existe");

                this.shopForm.getTxtClientSsn().setText("");
            }

        }
    }

}

/*

   private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {                                         
        registarVenta();
        registrarDetalleVenta();
    }                                        

  

    private void registarVenta(){
    String cliente = nombreClienteTablaVenta.getText();
    String vendedor = lblVendedor.getText();
    int total = Integer.parseInt(lblTotal.getText());
        venta.setCliente(cliente);
        venta.setVendedor(vendedor);
        venta.setTotal(total);
        ventaDAO.registarVenta(venta);
    }
    
    private void registrarDetalleVenta(){
        for (int i = 0; i < tablaNuevaVenta.getRowCount(); i++) {
                String findProduct = tablaNuevaVenta.getValueAt(i, 0).toString();
                int cantidadProduct = Integer.parseInt(tablaNuevaVenta.getValueAt(i, 3).toString());
                int precioProduct =Integer.parseInt(tablaNuevaVenta.getValueAt(i, 4).toString());
                int id = 1;
               detalleVenta.setCodigoProduct(findProduct);
               detalleVenta.setCantidad(cantidadProduct);
               detalleVenta.setPrecio(precioProduct);
               detalleVenta.setIdVenta(id);
               ventaDAO.registrarDetallesVenta(detalleVenta);
        }
    }

 */
