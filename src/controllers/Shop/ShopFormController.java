package controllers.Shop;

import entitys.Product;
import entitys.SelectedProduct;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.ProductServiceImp;

import views.Shop.ShopForm;

public class ShopFormController extends MouseAdapter implements ActionListener {

    private final ProductServiceImp productServiceImp;
    
    private final ShopForm shopForm;

    private DefaultTableModel model = new DefaultTableModel();
    
    private final List<SelectedProduct> listSelectedProducts = new ArrayList<>();

    private Product product;
    
    private SelectedProduct selectedProduct;

    private int productStock;
    
    private int productQuantity;

    private double precioProductTabla = 0;
    
    private int cantidadProductTabla = 0;
    
    private double precioFinal = 0;
    
    private double precioFinalProductsTabla = 0;
    
    private double totalAPagar = 0;

    private int stockActual;

    private double valor = 0;

    int row;
    int id;

    public ShopFormController(ShopForm shopForm, ProductServiceImp productServiceImp) {
        
        this.shopForm = shopForm;
        
        this.productServiceImp = productServiceImp;
        
        this.shopForm.getTxtProductCode().addActionListener(this);
        
        this.shopForm.getTxtProductQuantityToSell().addActionListener(this);

        this.shopForm.getjTableProducts().addMouseListener(this);

    }

    private void findProduct() {

        if (!"".equals(this.shopForm.getTxtProductCode().getText())) {
            
            String productCode = (this.shopForm.getTxtProductCode().getText());
            
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
        
        if (!"".equals(this.shopForm.getTxtProductQuantityToSell().getText())) {

            productStock = Integer.parseInt(this.shopForm.getTxtProductStock().getText());
            
            productQuantity = Integer.parseInt(this.shopForm.getTxtProductQuantityToSell().getText());

            if (productStock >= productQuantity) {
     
                addProductToList();

            } else {
                
                JOptionPane.showMessageDialog(null, "Stock no disponible");

            }
        }
    }

   

    private void addProductToList() {

        if (listSelectedProducts.isEmpty()){
            
            selectedProduct = createSelectedProduct();
            
            listSelectedProducts.add(selectedProduct);
            
            stockActual = (productStock - productQuantity);

            this.shopForm.getTxtProductStock().setText("" + stockActual);
            
            System.out.println(listSelectedProducts);
               
        } else {
            
            for (int i = 0; i < listSelectedProducts.size(); i++) {
                
                if (listSelectedProducts.get(i).getProductCode().equals(this.shopForm.getTxtProductCode().getText())) {
                    
                    JOptionPane.showMessageDialog(null, "producto ya esta en la lista");
                    
                    System.out.println(listSelectedProducts);
                    
                    actualizarTabla(model);
                    
                    
                }else{
                    
                listSelectedProducts.add(selectedProduct);
                
                }
            }
        }
    }
    
    private SelectedProduct createSelectedProduct() {
        
        Integer id = product.getId();
        
        String productCode = this.shopForm.getTxtProductCode().getText();
        
        String productName = this.shopForm.getTxtProductName().getText();
        
        String productBrand = this.shopForm.getTxtProductBrand().getText();
        
        double productPrice = Double.parseDouble(this.shopForm.getTxtProductPrice().getText());
        
        double finalPrice = productQuantity * productPrice;

        this.shopForm.getTxtProductQuantityToSell().setText("");

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

    private void checkStockOfProducts() {
        
        for (int i = 0; i < this.shopForm.getjTableProducts().getRowCount(); i++) {

            int cantidadStockTablaVenta = Integer.parseInt(String.valueOf(this.shopForm.getjTableProducts().getModel().getValueAt(i, 3)));
            
            int cantidadStockAlmacen = Integer.parseInt(this.shopForm.getTxtProductStock().getText());
            
            if (cantidadStockTablaVenta > cantidadStockAlmacen) {
                
                JOptionPane.showMessageDialog(null, "Cantidad supera el stock", "Error", JOptionPane.ERROR_MESSAGE);
                
                this.shopForm.requestFocus();
                
            } else {
                
                calculateFinalPrice();
            }
        }
    }

    private void calculateFinalPrice() {

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
            
            listProductsCarshop();
            
            checkStockOfProducts();
        }

        if (e.getSource() == shopForm.getjTableProducts()) {
            
            getProductSelectedOfTable();

        }
    }

//    public void mouseClicked(MouseEvent e) {
//        if (e.getSource() == shopForm.getjTableProducts()) {
//            getProductSelectedOfTable();
//
//        }
//    }
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
