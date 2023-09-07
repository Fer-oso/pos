package views.Shop;

import controllers.Shop.shoppingcartform.ShoppingCartFormController;
import entitys.ShoppingCart;
import services.ShoppingCartServiceImp;

public class ShoppingCartFormView extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

  
    public ShoppingCartFormView(ShoppingCart shoppingCart, ShoppingCartServiceImp shoppingCartServiceImp) {
        initComponents();
        ShoppingCartFormController shoppingCartController = new ShoppingCartFormController(this, shoppingCart, shoppingCartServiceImp );

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpNuevaVenta = new javax.swing.JPanel();
        lblProductCode = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        lblSsn = new javax.swing.JLabel();
        txtClientSsn = new javax.swing.JTextField();
        txtClientName = new javax.swing.JTextField();
        lblNameClient = new javax.swing.JLabel();
        btnGenerateOrder = new javax.swing.JButton();
        lblTotalPrice = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jpNuevaVenta.setBackground(new java.awt.Color(255, 255, 255));
        jpNuevaVenta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jpNuevaVenta.setPreferredSize(new java.awt.Dimension(1034, 490));
        jpNuevaVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblProductCode.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        lblProductCode.setText("Shopping Cart");
        jpNuevaVenta.add(lblProductCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        btnCancel.setText("Cancel ");
        jpNuevaVenta.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 450, 90, 30));

        lblSsn.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblSsn.setText("SSN");
        jpNuevaVenta.add(lblSsn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, -1, -1));

        txtClientSsn.setEditable(false);
        txtClientSsn.setFocusable(false);
        jpNuevaVenta.add(txtClientSsn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 150, 30));

        txtClientName.setEditable(false);
        jpNuevaVenta.add(txtClientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, 150, 30));

        lblNameClient.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblNameClient.setText("Name");
        jpNuevaVenta.add(lblNameClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, -1, -1));

        btnGenerateOrder.setText("Generate Order");
        jpNuevaVenta.add(btnGenerateOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 450, -1, 30));

        lblTotalPrice.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblTotalPrice.setText("Total $");
        jpNuevaVenta.add(lblTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, -1, -1));

        lblTotal.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblTotal.setText("    ");
        jpNuevaVenta.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, 96, -1));

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

        jpNuevaVenta.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 669, 260));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnGenerateOrder;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProducts;
    public javax.swing.JPanel jpNuevaVenta;
    private javax.swing.JLabel lblNameClient;
    public javax.swing.JLabel lblProductCode;
    public javax.swing.JLabel lblSsn;
    public javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalPrice;
    public javax.swing.JTextField txtClientName;
    public javax.swing.JTextField txtClientSsn;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getBtnGenerateOrder() {
        return btnGenerateOrder;
    }

    public void setBtnGenerateOrder(javax.swing.JButton btnGenerateOrder) {
        this.btnGenerateOrder = btnGenerateOrder;
    }

    public javax.swing.JTable getjTableProducts() {
        return jTableProducts;
    }

    public void setjTableProducts(javax.swing.JTable jTableProducts) {
        this.jTableProducts = jTableProducts;
    }

    public javax.swing.JLabel getLblNameClient() {
        return lblNameClient;
    }

    public void setLblNameClient(javax.swing.JLabel lblNameClient) {
        this.lblNameClient = lblNameClient;
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

    public javax.swing.JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(javax.swing.JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

   
}
