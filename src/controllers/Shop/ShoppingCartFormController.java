package controllers.Shop;

import entitys.ShoppingCart;
import entitys.SelectedProduct;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import services.ShoppingCartServiceImp;

import views.Shop.ShoppingCartForm;

public class ShoppingCartFormController extends MouseAdapter implements ActionListener {

    /*Views*/
    
    private final ShoppingCartForm shoppingCartForm;

    /*Entitys*/
    private final ShoppingCart shoppingCart;

    /*Services*/
    
    ShoppingCartServiceImp shoppingCartServiceImp;
    
    /*Global variables*/
    
    private final List<SelectedProduct> listShoppingCartProducts;

    private DefaultTableModel model = new DefaultTableModel();

    /*Constructors*/
    
    public ShoppingCartFormController(ShoppingCartForm shoppingCartForm, ShoppingCart shoppingCart, ShoppingCartServiceImp shoppingCartServiceImp) {

        this.shoppingCartForm = shoppingCartForm;

        this.shoppingCart = shoppingCart;
        
        this.shoppingCartServiceImp = shoppingCartServiceImp;

        listShoppingCartProducts = shoppingCart.getProducts();

        listProductsCarshop();

        this.shoppingCartForm.getBtnGenerateOrder().addActionListener(this);

        this.shoppingCartForm.getBtnCancel().addActionListener(this);

    }

    /*Actions Events*/
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == shoppingCartForm.getBtnCancel()) {
            
             shoppingCartForm.setVisible(false);
             
             shoppingCartForm.setDefaultCloseOperation(2);
            
        }
        
        if (e.getSource() == shoppingCartForm.getBtnGenerateOrder()) {
            
        shoppingCartServiceImp.save(shoppingCart);

        shoppingCartServiceImp.show(shoppingCart);
        
        
        }
        
    }
    
    /*Functions*/

    private void listProductsCarshop() {

        model = (DefaultTableModel) this.shoppingCartForm.getjTableProducts().getModel();

        //MODELO TABLA
        Object[] product = new Object[6];

        for (int i = 0; i < listShoppingCartProducts.size(); i++) {

            product[0] = listShoppingCartProducts.get(i).getProductCode();

            product[1] = listShoppingCartProducts.get(i).getProductName();

            product[2] = listShoppingCartProducts.get(i).getProductBrand();

            product[3] = listShoppingCartProducts.get(i).getProductQuantity();

            product[4] = listShoppingCartProducts.get(i).getProductPrice();

            product[5] = listShoppingCartProducts.get(i).getFinalPrice();

            model.addRow(product);
        }

        this.shoppingCartForm.getjTableProducts().setModel(model);

        this.shoppingCartForm.getLblTotal().setText("" + shoppingCart.getFinalPrice());
        
        this.shoppingCartForm.getTxtClientName().setText("" + shoppingCart.getClient().getName());
        
        this.shoppingCartForm.getTxtClientSsn().setText("" + shoppingCart.getClient().getSsn());

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
