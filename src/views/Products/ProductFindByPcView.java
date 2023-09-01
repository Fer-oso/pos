package views.Products;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import controllers.products.ProductFindByPcController;
import services.ProductServiceImp;

public class ProductFindByPcView extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;
  
    public ProductFindByPcView(ProductServiceImp productService) {
        initComponents();
        var productFindByPcController = new ProductFindByPcController(this,productService);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpContainer = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        jpForm = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        lblStock = new javax.swing.JLabel();
        lblAvailability = new javax.swing.JLabel();
        jcbAvailability = new javax.swing.JCheckBox();
        lblBrand = new javax.swing.JLabel();
        txtBrand = new javax.swing.JTextField();
        lblCode = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jpTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTableProducts = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setMaximumSize(new java.awt.Dimension(1016, 512));
        setPreferredSize(new java.awt.Dimension(1016, 512));

        jpContainer.setBackground(new java.awt.Color(255, 255, 255));

        jpForm.setBackground(new java.awt.Color(255, 255, 255));
        jpForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jpForm.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 140, 30));

        lblName.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblName.setText("Name");
        jpForm.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 70, 30));

        lblPrice.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblPrice.setText("Price");
        jpForm.add(lblPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 60, 30));
        jpForm.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 140, 30));
        jpForm.add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 140, 30));

        lblStock.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblStock.setText("Stock");
        jpForm.add(lblStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 70, 30));

        lblAvailability.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblAvailability.setText("Availability");
        jpForm.add(lblAvailability, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 100, 30));

        jcbAvailability.setText("YES/NO");
        jpForm.add(jcbAvailability, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 100, 30));

        lblBrand.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblBrand.setText("Brand");
        jpForm.add(lblBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 70, 30));
        jpForm.add(txtBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 140, 30));

        lblCode.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblCode.setText("Code");
        jpForm.add(lblCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 60, 30));
        jpForm.add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 140, 30));

        btnDelete.setText("Delete");
        jpForm.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 90, 30));

        btnCancel.setText("Cancel");
        jpForm.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 90, 30));

        lblSearch.setText("Search");
        jpForm.add(lblSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        txtSearch.setMinimumSize(new java.awt.Dimension(100, 22));
        txtSearch.setPreferredSize(new java.awt.Dimension(100, 22));
        jpForm.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 100, 30));

        btnSearch.setText("Search");
        jpForm.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 70, -1));

        btnEdit.setText("Edit");
        jpForm.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 90, 30));

        jpTable.setBackground(new java.awt.Color(255, 255, 255));

        jtTableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Price", "Stock", "Availability", "Brand", "Product code"
            }
        ));
        jScrollPane1.setViewportView(jtTableProducts);

        javax.swing.GroupLayout jpTableLayout = new javax.swing.GroupLayout(jpTable);
        jpTable.setLayout(jpTableLayout);
        jpTableLayout.setHorizontalGroup(
            jpTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jpTableLayout.setVerticalGroup(
            jpTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jpContainerLayout = new javax.swing.GroupLayout(jpContainer);
        jpContainer.setLayout(jpContainerLayout);
        jpContainerLayout.setHorizontalGroup(
            jpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContainerLayout.createSequentialGroup()
                .addGroup(jpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpContainerLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(lblId)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpContainerLayout.setVerticalGroup(
            jpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContainerLayout.createSequentialGroup()
                .addComponent(jpForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jpContainerLayout.createSequentialGroup()
                .addGroup(jpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpContainerLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(lblId))
                    .addComponent(jpTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }
    
    public JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(JButton btnEdit) {
        this.btnEdit = btnEdit;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public void setBtnSearch(JButton jButton1) {
        this.btnSearch = jButton1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JCheckBox getJcbAvailability() {
        return jcbAvailability;
    }

    public void setJcbAvailability(JCheckBox jcbAvailability) {
        this.jcbAvailability = jcbAvailability;
    }

    public JPanel getJpContainer() {
        return jpContainer;
    }

    public void setJpContainer(JPanel jpContainer) {
        this.jpContainer = jpContainer;
    }

    public JPanel getJpForm() {
        return jpForm;
    }

    public void setJpForm(JPanel jpForm) {
        this.jpForm = jpForm;
    }

    public JPanel getJpTable() {
        return jpTable;
    }

    public void setJpTable(JPanel jpTable) {
        this.jpTable = jpTable;
    }

    public JTable getJtTableProducts() {
        return jtTableProducts;
    }

    public void setJtTableProducts(JTable jtTableProducts) {
        this.jtTableProducts = jtTableProducts;
    }

    public JTextField getTxtBrand() {
        return txtBrand;
    }

    public void setTxtBrand(JTextField txtBrand) {
        this.txtBrand = txtBrand;
    }

    public JTextField getTxtCode() {
        return txtCode;
    }

    public void setTxtCode(JTextField txtCode) {
        this.txtCode = txtCode;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    public JTextField getTxtPrice() {
        return txtPrice;
    }

    public void setTxtPrice(JTextField txtPrice) {
        this.txtPrice = txtPrice;
    }

    public JTextField getTxtSearch() {
        return txtSearch;
    }

    public void setTxtSearch(JTextField txtSearch) {
        this.txtSearch = txtSearch;
    }

    public JTextField getTxtStock() {
        return txtStock;
    }

    public void setTxtStock(JTextField txtStock) {
        this.txtStock = txtStock;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jcbAvailability;
    private javax.swing.JPanel jpContainer;
    private javax.swing.JPanel jpForm;
    private javax.swing.JPanel jpTable;
    private javax.swing.JTable jtTableProducts;
    private javax.swing.JLabel lblAvailability;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblStock;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
