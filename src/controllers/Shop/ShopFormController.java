package controllers.Shop;

import entitys.Product;
import entitys.SelectedProduct;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.ProductServiceImp;

import views.Shop.ShopForm;

public class ShopFormController extends KeyAdapter {

    private final ShopForm shopForm;
    private Product product;
    private final ProductServiceImp productServiceImp;

    public ShopFormController(ShopForm shopForm, ProductServiceImp productServiceImp) {
        this.shopForm = shopForm;
        this.productServiceImp = productServiceImp;
        this.shopForm.txtProductCode.addKeyListener(this);
        this.shopForm.txtProductQuantityToSell.addKeyListener(this);
        this.shopForm.tblShop.addKeyListener(this);
    }

    DefaultTableModel model = new DefaultTableModel();

    private double precioProductTabla = 0;
    private int cantidadProductTabla = 0;
    private double precioFinal = 0;
    private double precioFinalProductsTabla = 0;
    private double totalAPagar = 0;

    private double valor = 0;

    private void findProduct() {

        if (!"".equals(this.shopForm.txtProductCode.getText())) {
            String productCode = (this.shopForm.txtProductCode.getText());
            product = productServiceImp.findByPc(productCode).get();

            if (product.getName() != null) {
                this.shopForm.txtProductName.setText("" + product.getName());
                this.shopForm.txtProductBrand.setText("" + product.getBrand());
                this.shopForm.txtProductPrice.setText("" + product.getPrice());
                this.shopForm.txtProductStock.setText("" + product.getStock());
                this.shopForm.txtProductQuantityToSell.requestFocus();
            } else {
                this.shopForm.txtProductName.setText("");
                this.shopForm.txtProductBrand.setText("");
                this.shopForm.txtProductPrice.setText("");
                this.shopForm.txtProductStock.setText("");
                this.shopForm.txtProductCode.requestFocus();
                this.shopForm.txtProductQuantityToSell.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Insert product code");
            this.shopForm.txtProductCode.requestFocus();
            this.shopForm.txtProductQuantityToSell.setText("");
        }
    }

    private void cantidadProduct() {
        if (!"".equals(this.shopForm.txtProductQuantityToSell.getText())) {
            listProductsCarshop();
            this.shopForm.txtProductQuantityToSell.setText("");
        }
    }

    private void checkStockOfProducts() {
        model = (DefaultTableModel) this.shopForm.tblShop.getModel();

        for (int i = 0; i < this.shopForm.tblShop.getRowCount(); i++) {

            int cantidadStockTablaVenta = Integer.parseInt(String.valueOf(this.shopForm.tblShop.getModel().getValueAt(i, 3)));
            int cantidadStockAlmacen = Integer.parseInt(this.shopForm.txtProductStock.getText());
            if (cantidadStockTablaVenta > cantidadStockAlmacen) {
                JOptionPane.showMessageDialog(null, "Cantidad supera el stock", "Error", JOptionPane.ERROR_MESSAGE);
                this.shopForm.requestFocus();
            } else {
                totalAPagar();
            }
        }

    }

    private void listProductsCarshop() {

        String productCode = this.shopForm.txtProductCode.getText();
        String productName = this.shopForm.txtProductName.getText();
        String productBrand = this.shopForm.txtProductBrand.getText();
        double productPrice = Double.parseDouble(this.shopForm.txtProductPrice.getText());
        int productStock = Integer.parseInt(this.shopForm.txtProductStock.getText());
        int productQuantity = Integer.parseInt(this.shopForm.txtProductQuantityToSell.getText());
        double finalPrice = productQuantity * productPrice;

        SelectedProduct selectedProduct = new SelectedProduct(productCode, productName, productBrand, productPrice, productQuantity, finalPrice);

        if (productStock >= productQuantity) {    
            List<SelectedProduct> listSelectedProducts = new ArrayList<>();
            listSelectedProducts.add(selectedProduct);
            model = (DefaultTableModel) this.shopForm.tblShop.getModel();
            for (int i = 0; i < this.shopForm.tblShop.getRowCount(); i++) {
                if (this.shopForm.tblShop.getValueAt(i, 0).equals(this.shopForm.txtProductCode.getText())) {
                    JOptionPane.showMessageDialog(null, "product added");
                    return;
                }
            }

            //MODELO TABLA
            Object[] product = new Object[6];

            for (int i = 0; i < listSelectedProducts.size(); i++) {
                product[0] = listSelectedProducts.get(i).getProductCode();
                product[1] = listSelectedProducts.get(i).getProductName();
                product[2] = listSelectedProducts.get(i).getProductBrand();
                product[3] = listSelectedProducts.get(i).getProductStock();
                product[4] = listSelectedProducts.get(i).getProductPrice();
                product[5] = listSelectedProducts.get(i).getFinalPrice();
                model.addRow(product);
            }

            int stockActual = (productStock - productQuantity);

            this.shopForm.tblShop.setModel(model);

            //stockVenta.setText("" + stockActual);
            totalAPagar();
        } else {
            JOptionPane.showMessageDialog(null, "Stock no disponible");

        }
    }

    private void totalAPagar() {

        for (int i = 0; i < this.shopForm.tblShop.getRowCount(); i++) {
            cantidadProductTabla = Integer.parseInt(String.valueOf(this.shopForm.tblShop.getModel().getValueAt(i, 3)));
            precioProductTabla = Double.parseDouble(String.valueOf(this.shopForm.tblShop.getModel().getValueAt(i, 4)));
            precioFinal = cantidadProductTabla * precioProductTabla;
            /*       if (cantidadProductTabla > Integer.parseInt(this.shopForm.stockVenta.getText())) {
              
            }else{    }*/
            this.shopForm.tblShop.getModel().setValueAt(precioFinal, i, 5);
            precioFinal = cantidadProductTabla * precioProductTabla;
        }

        for (int i = 0; i < this.shopForm.tblShop.getRowCount(); i++) {
            valor = Double.parseDouble(String.valueOf(this.shopForm.tblShop.getModel().getValueAt(i, 5)));
            totalAPagar = totalAPagar + valor;
            this.shopForm.lblTotal.setText("" + totalAPagar);
            System.out.println(valor);
            System.out.println(totalAPagar);
        }
        totalAPagar = 0;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            findProduct();
            cantidadProduct();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            checkStockOfProducts();
        }

    }

}

/*

   jtbpGeneral.setSelectedIndex(3);

    private void btnEliminarProductVentaActionPerformed(java.awt.event.ActionEvent evt) {                                                         
       tablaVenta = (DefaultTableModel) tablaNuevaVenta.getModel();
       tablaVenta.removeRow(tablaNuevaVenta.getSelectedRow());
    }                                                        

    private void dniClienteTablaVentaKeyPressed(java.awt.event.KeyEvent evt) {                                                
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(dniClienteTablaVenta.getText())) {
                    int dni = Integer.parseInt(dniClienteTablaVenta.getText());
                    cliente =clienteDAO.buscarCliente(dni);
                    if(cliente.getName() !=null){
                        nombreClienteTablaVenta.setText(""+cliente.getName());    
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Cliente no existe");
                        nombreClienteTablaVenta.setText("");
                        dniClienteTablaVenta.setText("");
                    }
                    
            }
        }
    }



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
