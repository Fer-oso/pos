package views.Products;

import controllers.products.ProductFindByPcController;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import services.ProductServiceImp;

public class ProductFindByPcView extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;

 
    public ProductFindByPcView(ProductServiceImp productService) {
        initComponents();
        var productFindByPcController = new ProductFindByPcController(this, productService);
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public void setBtnSearch(JButton btnSearch) {
        this.btnSearch = btnSearch;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpForm = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        txtCode = new javax.swing.JTextField();
        lblStock = new javax.swing.JLabel();
        lblAvailability = new javax.swing.JLabel();
        jcbAvailability = new javax.swing.JCheckBox();
        lblBrand = new javax.swing.JLabel();
        lblCode = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTableProducts = new javax.swing.JTable();
        jpContainer = new javax.swing.JPanel();
        jpTable = new javax.swing.JPanel();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        txtBrand = new javax.swing.JTextField();
        btnSave1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product register form", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 14))); // NOI18N
        setClosable(true);
        setIconifiable(true);
        setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        setMaximumSize(new java.awt.Dimension(1030, 535));
        setPreferredSize(new java.awt.Dimension(1040, 535));
        setVerifyInputWhenFocusTarget(false);

        jpForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblName.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblName.setText("Name");
        jpForm.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 30));

        lblPrice.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblPrice.setText("Price");
        jpForm.add(lblPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 60, 30));
        jpForm.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 140, 30));
        jpForm.add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 140, 30));

        lblStock.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblStock.setText("Stock");
        jpForm.add(lblStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, 30));

        lblAvailability.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblAvailability.setText("Availability");
        jpForm.add(lblAvailability, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 100, 30));

        jcbAvailability.setText("YES/NO");
        jpForm.add(jcbAvailability, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 100, 30));

        lblBrand.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblBrand.setText("Brand");
        jpForm.add(lblBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 50, 30));

        lblCode.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblCode.setText("Code");
        jpForm.add(lblCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 40, 30));

        btnCancel.setText("Cancel");
        jpForm.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 90, 30));
        jpForm.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 417, -1, -1));

        jtTableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Price", "Stock", "Availability", "Brand", "Product code"
            }
        ));
        jtTableProducts.setFocusable(false);
        jScrollPane1.setViewportView(jtTableProducts);

        jpForm.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 6, 760, 330));

        jpContainer.setBackground(new java.awt.Color(255, 255, 255));

        jpTable.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpTableLayout = new javax.swing.GroupLayout(jpTable);
        jpTable.setLayout(jpTableLayout);
        jpTableLayout.setHorizontalGroup(
            jpTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpTableLayout.setVerticalGroup(
            jpTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpContainerLayout = new javax.swing.GroupLayout(jpContainer);
        jpContainer.setLayout(jpContainerLayout);
        jpContainerLayout.setHorizontalGroup(
            jpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContainerLayout.createSequentialGroup()
                .addComponent(jpTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpContainerLayout.setVerticalGroup(
            jpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContainerLayout.createSequentialGroup()
                .addComponent(jpTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpForm.add(jpContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(996, 423, -1, -1));

        btnEdit.setText("Edit");
        jpForm.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 90, 30));

        btnDelete.setText("Delete");
        jpForm.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 90, 30));
        jpForm.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 140, 30));
        jpForm.add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 140, 30));
        jpForm.add(txtBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 140, 30));

        btnSave1.setText("Save");
        jpForm.add(btnSave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 90, 30));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Find by pc form");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 220, 30));
        jPanel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 87, 30));

        btnSearch.setText("Find");
        jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 68, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jpForm, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(JButton btnEdit) {
        this.btnEdit = btnEdit;
    }

    public JTextField getTxtSearch() {
        return txtSearch;
    }

    public void setTxtSearch(JTextField txtSearch) {
        this.txtSearch = txtSearch;
    }
    
    

    public void setBtnCancel(JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

    public JButton getBtnSave() {
        return btnSearch;
    }

    public void setBtnSave(JButton btnSave) {
        this.btnSearch = btnSave;
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
        return txtSearch;
    }

    public void setTxtName(JTextField txtName) {
        this.txtSearch = txtName;
    }

    public JTextField getTxtPrice() {
        return txtPrice;
    }

    public void setTxtPrice(JTextField txtPrice) {
        this.txtPrice = txtPrice;
    }

    public JTextField getTxtStock() {
        return txtCode;
    }

    public void setTxtStock(JTextField txtStock) {
        this.txtCode = txtStock;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave1;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JLabel lblStock;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JLabel getLblId() {
        return lblId;
    }

    public void setLblId(javax.swing.JLabel lblId) {
        this.lblId = lblId;
    }

    public javax.swing.JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(javax.swing.JButton btnDelete) {
        this.btnDelete = btnDelete;
    }
}
