
package views.Shop;

import controllers.Shop.shopformcontroller.ShopFormController;
import services.ClientServiceImp;
import services.ProductServiceImp;
import services.ShoppingCartServiceImp;

public class ShopFormView extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;

    public ShopFormView(ProductServiceImp productServiceImp, ClientServiceImp clientServiceImp, ShoppingCartServiceImp shoppingCartServiceImp) {
        initComponents();
        ShopFormController shopFormController = new ShopFormController(this, productServiceImp, clientServiceImp, shoppingCartServiceImp);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpNuevaVenta = new javax.swing.JPanel();
        lblProductCode = new javax.swing.JLabel();
        txtProductCode = new javax.swing.JTextField();
        lblProductBrand = new javax.swing.JLabel();
        txtProductBrand = new javax.swing.JTextField();
        lblProductQuantity = new javax.swing.JLabel();
        txtProductQuantityToSell = new javax.swing.JTextField();
        lblProductPrice = new javax.swing.JLabel();
        txtProductPrice = new javax.swing.JTextField();
        lblProductStock = new javax.swing.JLabel();
        txtProductStock = new javax.swing.JTextField();
        btnRemove = new javax.swing.JButton();
        lblSsn = new javax.swing.JLabel();
        txtClientSsn = new javax.swing.JTextField();
        txtClientName = new javax.swing.JTextField();
        lblNameClient = new javax.swing.JLabel();
        btnAddToShoppingCart = new javax.swing.JButton();
        lblTotalPrice = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblProductName = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setMaximumSize(new java.awt.Dimension(1016, 512));
        setPreferredSize(new java.awt.Dimension(1016, 512));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpNuevaVenta.setBackground(new java.awt.Color(255, 255, 255));
        jpNuevaVenta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jpNuevaVenta.setPreferredSize(new java.awt.Dimension(1034, 490));

        lblProductCode.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblProductCode.setText("Product Code");

        lblProductBrand.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblProductBrand.setText("Brand");

        lblProductQuantity.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblProductQuantity.setText("Quantity");

        lblProductPrice.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblProductPrice.setText("Price");

        lblProductStock.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblProductStock.setText("Stock");

        txtProductStock.setFocusable(false);

        lblSsn.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblSsn.setText("SSN");

        lblNameClient.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblNameClient.setText("Name");

        btnAddToShoppingCart.setText("add to cart");

        lblTotalPrice.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblTotalPrice.setText("Total a pagar: $");

        lblTotal.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblTotal.setText("    ");

        lblProductName.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblProductName.setText("Name");

        jTableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "product code", "Name", "Brand", "Quantity", "Price", "Final price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableProducts);

        javax.swing.GroupLayout jpNuevaVentaLayout = new javax.swing.GroupLayout(jpNuevaVenta);
        jpNuevaVenta.setLayout(jpNuevaVentaLayout);
        jpNuevaVentaLayout.setHorizontalGroup(
            jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNuevaVentaLayout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNuevaVentaLayout.createSequentialGroup()
                        .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                                .addComponent(lblSsn)
                                .addGap(123, 123, 123)
                                .addComponent(lblNameClient))
                            .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                                .addComponent(txtClientSsn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnAddToShoppingCart)
                                .addGap(8, 8, 8)
                                .addComponent(lblTotalPrice)
                                .addGap(3, 3, 3)
                                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(221, 221, 221))
                    .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                        .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                                        .addComponent(lblProductCode)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblProductName)
                                        .addGap(60, 60, 60)
                                        .addComponent(lblProductBrand)
                                        .addGap(115, 115, 115)
                                        .addComponent(lblProductStock)
                                        .addGap(67, 67, 67)
                                        .addComponent(lblProductPrice)
                                        .addGap(41, 41, 41)
                                        .addComponent(lblProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                                        .addComponent(txtProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtProductBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)
                                        .addComponent(txtProductStock, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(txtProductQuantityToSell, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(150, 150, 150))))
        );
        jpNuevaVentaLayout.setVerticalGroup(
            jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductName)
                    .addComponent(lblProductCode)
                    .addComponent(lblProductBrand)
                    .addComponent(lblProductStock)
                    .addComponent(lblProductPrice)
                    .addComponent(lblProductQuantity))
                .addGap(6, 6, 6)
                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtProductBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtProductStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtProductQuantityToSell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSsn)
                    .addComponent(lblNameClient))
                .addGap(18, 18, 18)
                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtClientSsn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddToShoppingCart, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalPrice)
                    .addComponent(lblTotal))
                .addGap(27, 27, 27))
        );

        getContentPane().add(jpNuevaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAddToShoppingCart;
    private javax.swing.JButton btnRemove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProducts;
    public javax.swing.JPanel jpNuevaVenta;
    private javax.swing.JLabel lblNameClient;
    public javax.swing.JLabel lblProductBrand;
    public javax.swing.JLabel lblProductCode;
    public javax.swing.JLabel lblProductName;
    public javax.swing.JLabel lblProductPrice;
    public javax.swing.JLabel lblProductQuantity;
    public javax.swing.JLabel lblProductStock;
    public javax.swing.JLabel lblSsn;
    public javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalPrice;
    public javax.swing.JTextField txtClientName;
    public javax.swing.JTextField txtClientSsn;
    private javax.swing.JTextField txtProductBrand;
    private javax.swing.JTextField txtProductCode;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductPrice;
    private javax.swing.JTextField txtProductQuantityToSell;
    private javax.swing.JTextField txtProductStock;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JLabel getLblNameClient() {
        return lblNameClient;
    }

    public void setLblNameClient(javax.swing.JLabel lblNameClient) {
        this.lblNameClient = lblNameClient;
    }

    public javax.swing.JLabel getLblProductBrand() {
        return lblProductBrand;
    }

    public void setLblProductBrand(javax.swing.JLabel lblProductBrand) {
        this.lblProductBrand = lblProductBrand;
    }

    public javax.swing.JLabel getLblProductCode() {
        return lblProductCode;
    }

    public void setLblProductCode(javax.swing.JLabel lblProductCode) {
        this.lblProductCode = lblProductCode;
    }

    public javax.swing.JLabel getLblProductPrice() {
        return lblProductPrice;
    }

    public void setLblProductPrice(javax.swing.JLabel lblProductPrice) {
        this.lblProductPrice = lblProductPrice;
    }

    public javax.swing.JLabel getLblProductQuantity() {
        return lblProductQuantity;
    }

    public void setLblProductQuantity(javax.swing.JLabel lblProductQuantity) {
        this.lblProductQuantity = lblProductQuantity;
    }

    public javax.swing.JLabel getLblProductStock() {
        return lblProductStock;
    }

    public void setLblProductStock(javax.swing.JLabel lblProductStock) {
        this.lblProductStock = lblProductStock;
    }

    public javax.swing.JLabel getLblSsn() {
        return lblSsn;
    }

    public void setLblSsn(javax.swing.JLabel lblSsn) {
        this.lblSsn = lblSsn;
    }

    public javax.swing.JLabel getLblTotal() {
        return lblTotal;
    }

    public void setLblTotal(javax.swing.JLabel lblTotal) {
        this.lblTotal = lblTotal;
    }

    public javax.swing.JLabel getLblTotalPrice() {
        return lblTotalPrice;
    }

    public void setLblTotalPrice(javax.swing.JLabel lblTotalPrice) {
        this.lblTotalPrice = lblTotalPrice;
    }

    

    public javax.swing.JTextField getTxtClientName() {
        return txtClientName;
    }

    public void setTxtClientName(javax.swing.JTextField txtClientName) {
        this.txtClientName = txtClientName;
    }

    public javax.swing.JTextField getTxtClientSsn() {
        return txtClientSsn;
    }

    public void setTxtClientSsn(javax.swing.JTextField txtClientSsn) {
        this.txtClientSsn = txtClientSsn;
    }

    public javax.swing.JTextField getTxtProductBrand() {
        return txtProductBrand;
    }

    public void setTxtProductBrand(javax.swing.JTextField txtProductBrand) {
        this.txtProductBrand = txtProductBrand;
    }

    public javax.swing.JTextField getTxtProductCode() {
        return txtProductCode;
    }

    public void setTxtProductCode(javax.swing.JTextField txtProductCode) {
        this.txtProductCode = txtProductCode;
    }

    public javax.swing.JTextField getTxtProductName() {
        return txtProductName;
    }

    public void setTxtProductName(javax.swing.JTextField txtProductName) {
        this.txtProductName = txtProductName;
    }

    public javax.swing.JTextField getTxtProductPrice() {
        return txtProductPrice;
    }

    public void setTxtProductPrice(javax.swing.JTextField txtProductPrice) {
        this.txtProductPrice = txtProductPrice;
    }

    public javax.swing.JTextField getTxtProductQuantityToSell() {
        return txtProductQuantityToSell;
    }

    public void setTxtProductQuantityToSell(javax.swing.JTextField txtProductQuantityToSell) {
        this.txtProductQuantityToSell = txtProductQuantityToSell;
    }

    public javax.swing.JTextField getTxtProductStock() {
        return txtProductStock;
    }

    public void setTxtProductStock(javax.swing.JTextField txtProductStock) {
        this.txtProductStock = txtProductStock;
    }

    public javax.swing.JLabel getLblProductName() {
        return lblProductName;
    }

    public void setLblProductName(javax.swing.JLabel lblProductName) {
        this.lblProductName = lblProductName;
    }

    public javax.swing.JTable getjTableProducts() {
        return jTableProducts;
    }

    public void setjTableProducts(javax.swing.JTable jTableProducts) {
        this.jTableProducts = jTableProducts;
    }

    public javax.swing.JButton getBtnRemove() {
        return btnRemove;
    }

    public void setBtnRemove(javax.swing.JButton btnRemove) {
        this.btnRemove = btnRemove;
    }

    public javax.swing.JButton getBtnAddToShoppingCart() {
        return btnAddToShoppingCart;
    }

    public void setBtnAddToShoppingCart(javax.swing.JButton btnAddToShoppingCart) {
        this.btnAddToShoppingCart = btnAddToShoppingCart;
    }
}
