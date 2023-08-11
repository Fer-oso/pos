
package views.Shop;

import controllers.Shop.ShopFormController;
import services.ProductServiceImp;

public class ShopForm extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;

    public ShopForm(ProductServiceImp productServiceImp) {
        initComponents();
        ShopFormController shopFormController = new ShopFormController(this, productServiceImp);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
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
        jScrollPane = new javax.swing.JScrollPane();
        tblShop = new javax.swing.JTable();
        btnEliminarProductoVenta = new javax.swing.JButton();
        lblSsn = new javax.swing.JLabel();
        txtClientSsn = new javax.swing.JTextField();
        txtClientName = new javax.swing.JTextField();
        lblNameClient = new javax.swing.JLabel();
        btnVenta = new javax.swing.JButton();
        lblTotalPrice = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblCodigoVenta3 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setMaximumSize(new java.awt.Dimension(1016, 512));
        setPreferredSize(new java.awt.Dimension(1016, 512));

        jpNuevaVenta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

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

        tblShop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Descripcion", "Cantidad", "Precio", "Precio final"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblShop.setRowSelectionAllowed(false);
        jScrollPane.setViewportView(tblShop);

        lblSsn.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblSsn.setText("SSN");

        lblNameClient.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblNameClient.setText("Name");

        lblTotalPrice.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblTotalPrice.setText("Total a pagar: $");

        lblTotal.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblTotal.setText("    ");

        lblCodigoVenta3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblCodigoVenta3.setText("Name");

        javax.swing.GroupLayout jpNuevaVentaLayout = new javax.swing.GroupLayout(jpNuevaVenta);
        jpNuevaVenta.setLayout(jpNuevaVentaLayout);
        jpNuevaVentaLayout.setHorizontalGroup(
            jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane)
                    .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                        .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtClientSsn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblSsn)))
                                .addGap(18, 18, 18)
                                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNameClient)
                                    .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                                        .addComponent(txtClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(btnVenta)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTotalPrice)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblProductCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtProductCode, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                                .addGap(23, 23, 23)
                                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCodigoVenta3))
                                .addGap(18, 18, 18)
                                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(txtProductBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblProductBrand))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblProductStock)
                                    .addComponent(txtProductStock, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblProductPrice)
                                    .addComponent(txtProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                                        .addComponent(txtProductQuantityToSell, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEliminarProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(49, 49, 49))))
        );
        jpNuevaVentaLayout.setVerticalGroup(
            jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                        .addComponent(lblCodigoVenta3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                        .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProductBrand)
                            .addComponent(lblProductPrice)
                            .addComponent(lblProductStock)
                            .addComponent(lblProductCode)
                            .addComponent(lblProductQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnEliminarProductoVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtProductBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProductStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProductQuantityToSell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtProductCode))))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpNuevaVentaLayout.createSequentialGroup()
                        .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSsn)
                            .addComponent(lblNameClient))
                        .addGap(18, 18, 18)
                        .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtClientSsn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNuevaVentaLayout.createSequentialGroup()
                                .addGroup(jpNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTotalPrice)
                                    .addComponent(lblTotal))
                                .addGap(8, 8, 8))))
                    .addComponent(btnVenta))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 787, Short.MAX_VALUE)
            .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
            .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1016, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEliminarProductoVenta;
    public javax.swing.JButton btnVenta;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane;
    public javax.swing.JPanel jpNuevaVenta;
    public javax.swing.JLabel lblCodigoVenta3;
    private javax.swing.JLabel lblNameClient;
    public javax.swing.JLabel lblProductBrand;
    public javax.swing.JLabel lblProductCode;
    public javax.swing.JLabel lblProductPrice;
    public javax.swing.JLabel lblProductQuantity;
    public javax.swing.JLabel lblProductStock;
    public javax.swing.JLabel lblSsn;
    public javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalPrice;
    public javax.swing.JTable tblShop;
    public javax.swing.JTextField txtClientName;
    public javax.swing.JTextField txtClientSsn;
    public javax.swing.JTextField txtProductBrand;
    public javax.swing.JTextField txtProductCode;
    public javax.swing.JTextField txtProductName;
    public javax.swing.JTextField txtProductPrice;
    public javax.swing.JTextField txtProductQuantityToSell;
    public javax.swing.JTextField txtProductStock;
    // End of variables declaration//GEN-END:variables
}
