package views.Shop;

import controllers.Shop.shopformcontroller.ShopFormController;
import javax.swing.JButton;
import javax.swing.JTextField;
import services.ClientServiceImp;
import services.ProductServiceImp;
import services.ShoppingCartServiceImp;

public class ShopFormView extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;

    public ShopFormView(ProductServiceImp productServiceImp, ClientServiceImp clientServiceImp, ShoppingCartServiceImp shoppingCartServiceImp) {
        initComponents();
        var shopFormController = new ShopFormController(this, productServiceImp, clientServiceImp, shoppingCartServiceImp);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpNuevaVenta = new javax.swing.JPanel();
        jpTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jpProductFind = new javax.swing.JPanel();
        lblProductCode = new javax.swing.JLabel();
        txtProductCode = new javax.swing.JTextField();
        lblProductName = new javax.swing.JLabel();
        lblProductBrand = new javax.swing.JLabel();
        txtProductBrand = new javax.swing.JTextField();
        txtProductStock = new javax.swing.JTextField();
        lblProductStock = new javax.swing.JLabel();
        txtProductPrice = new javax.swing.JTextField();
        lblProductPrice = new javax.swing.JLabel();
        lblProductQuantity = new javax.swing.JLabel();
        txtProductQuantityToSell = new javax.swing.JTextField();
        btnRemove = new javax.swing.JButton();
        txtProductName = new javax.swing.JTextField();
        btnFindProduct = new javax.swing.JButton();
        jpTableShoppingForm = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblSsn = new javax.swing.JLabel();
        txtClientSsn = new javax.swing.JTextField();
        txtClientName = new javax.swing.JTextField();
        lblNameClient = new javax.swing.JLabel();
        btnAddToShoppingCart = new javax.swing.JButton();
        lblTotalPrice = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnFindClient = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1020, 535));
        setMinimumSize(new java.awt.Dimension(1020, 535));
        setPreferredSize(new java.awt.Dimension(1020, 535));

        jpNuevaVenta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jpNuevaVenta.setPreferredSize(new java.awt.Dimension(1034, 490));
        jpNuevaVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpTitle.setPreferredSize(new java.awt.Dimension(1020, 57));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/market icons/shoppingsystemicons/shopping system icon 64px.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
        jLabel2.setText("Shopping System");

        javax.swing.GroupLayout jpTitleLayout = new javax.swing.GroupLayout(jpTitle);
        jpTitle.setLayout(jpTitleLayout);
        jpTitleLayout.setHorizontalGroup(
            jpTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTitleLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(231, 231, 231)
                .addComponent(jLabel2)
                .addContainerGap(340, Short.MAX_VALUE))
        );
        jpTitleLayout.setVerticalGroup(
            jpTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jpNuevaVenta.add(jpTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 80));

        jpProductFind.setPreferredSize(new java.awt.Dimension(1020, 57));

        lblProductCode.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblProductCode.setText("Product Code");

        txtProductCode.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblProductName.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblProductName.setText("Name");

        lblProductBrand.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblProductBrand.setText("Brand");

        txtProductBrand.setEditable(false);
        txtProductBrand.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtProductStock.setEditable(false);
        txtProductStock.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtProductStock.setFocusable(false);

        lblProductStock.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblProductStock.setText("Stock");

        txtProductPrice.setEditable(false);
        txtProductPrice.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblProductPrice.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblProductPrice.setText("Price");

        lblProductQuantity.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblProductQuantity.setText("Quantity");

        txtProductQuantityToSell.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/market icons/general icons/cancel icon 2 20px.png"))); // NOI18N
        btnRemove.setFocusable(false);

        txtProductName.setEditable(false);
        txtProductName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnFindProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/market icons/general icons/find icon 20px.png"))); // NOI18N
        btnFindProduct.setFocusable(false);

        javax.swing.GroupLayout jpProductFindLayout = new javax.swing.GroupLayout(jpProductFind);
        jpProductFind.setLayout(jpProductFindLayout);
        jpProductFindLayout.setHorizontalGroup(
            jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProductFindLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProductCode)
                    .addComponent(txtProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProductBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductBrand))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProductStock, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductStock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpProductFindLayout.createSequentialGroup()
                        .addComponent(txtProductQuantityToSell, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFindProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove))
                    .addComponent(lblProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jpProductFindLayout.setVerticalGroup(
            jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProductFindLayout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addGroup(jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpProductFindLayout.createSequentialGroup()
                        .addGroup(jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblProductCode)
                                .addComponent(lblProductName)
                                .addComponent(lblProductBrand))
                            .addGroup(jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblProductStock)
                                .addComponent(lblProductPrice)
                                .addComponent(lblProductQuantity)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProductBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProductStock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProductQuantityToSell, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnRemove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(btnFindProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jpNuevaVenta.add(jpProductFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, 80));

        jTableProducts.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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

        javax.swing.GroupLayout jpTableShoppingFormLayout = new javax.swing.GroupLayout(jpTableShoppingForm);
        jpTableShoppingForm.setLayout(jpTableShoppingFormLayout);
        jpTableShoppingFormLayout.setHorizontalGroup(
            jpTableShoppingFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        jpTableShoppingFormLayout.setVerticalGroup(
            jpTableShoppingFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTableShoppingFormLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpNuevaVenta.add(jpTableShoppingForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 900, 230));

        lblSsn.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblSsn.setText("SSN");

        txtClientSsn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtClientName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblNameClient.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblNameClient.setText("Name");

        btnAddToShoppingCart.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAddToShoppingCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/market icons/shoppingsystemicons/generate shopping cart icon 48px.png"))); // NOI18N
        btnAddToShoppingCart.setText("add to cart");

        lblTotalPrice.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblTotalPrice.setText("Total a pagar: $");

        lblTotal.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        btnFindClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/market icons/general icons/find icon 20px.png"))); // NOI18N
        btnFindClient.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtClientSsn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSsn))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNameClient)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFindClient, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTotalPrice)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddToShoppingCart, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalPrice)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddToShoppingCart, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSsn)
                    .addComponent(lblNameClient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtClientSsn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnFindClient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        jpNuevaVenta.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 900, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
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

    public JButton getBtnFindClient() {
        return btnFindClient;
    }

    public void setBtnFindClient(JButton btnFindClient) {
        this.btnFindClient = btnFindClient;
    }

    public JButton getBtnFindProduct() {
        return btnFindProduct;
    }

    public void setBtnFindProduct(JButton btnFindProduct) {
        this.btnFindProduct = btnFindProduct;
    }

    public JTextField getTxtProductName() {
        return txtProductName;
    }

    public void setTxtProductName(JTextField txtProductName) {
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAddToShoppingCart;
    private javax.swing.JButton btnFindClient;
    private javax.swing.JButton btnFindProduct;
    private javax.swing.JButton btnRemove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProducts;
    public javax.swing.JPanel jpNuevaVenta;
    private javax.swing.JPanel jpProductFind;
    private javax.swing.JPanel jpTableShoppingForm;
    private javax.swing.JPanel jpTitle;
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
}
