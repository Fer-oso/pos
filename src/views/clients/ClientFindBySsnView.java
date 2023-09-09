package views.clients;

import controllers.clients.ClientFindBySsnController;
import services.ClientServiceImp;

public class ClientFindBySsnView extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;

    public ClientFindBySsnView(ClientServiceImp clientService) {
        initComponents();
        var clientFindBySsnController = new ClientFindBySsnController(this, clientService);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpForm = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblLastname = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        lblAge = new javax.swing.JLabel();
        lblAvailability = new javax.swing.JLabel();
        jcbAvailability = new javax.swing.JCheckBox();
        lblSsn = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTableClients = new javax.swing.JTable();
        jpContainer = new javax.swing.JPanel();
        jpTable = new javax.swing.JPanel();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtSsn = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Find by SSN form", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 14))); // NOI18N
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

        lblLastname.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblLastname.setText("Lastname");
        jpForm.add(lblLastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 60, 30));
        jpForm.add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 140, 30));
        jpForm.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 140, 30));

        lblAge.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblAge.setText("Age");
        jpForm.add(lblAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, 30));

        lblAvailability.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblAvailability.setText("Availability");
        jpForm.add(lblAvailability, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 100, 30));

        jcbAvailability.setText("YES/NO");
        jpForm.add(jcbAvailability, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 100, 30));

        lblSsn.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblSsn.setText("SSN");
        jpForm.add(lblSsn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 50, 30));

        lblPhone.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblPhone.setText("Phone");
        jpForm.add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 40, 30));

        btnCancel.setText("Cancel");
        jpForm.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 90, 30));
        jpForm.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 417, -1, -1));

        jtTableClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Lastname", "Age", "Availability", "SSN", "Phone"
            }
        ));
        jtTableClients.setFocusable(false);
        jScrollPane1.setViewportView(jtTableClients);

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
        jpForm.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 140, 30));
        jpForm.add(txtSsn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 140, 30));

        btnSave.setText("Save");
        jpForm.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 90, 30));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Find by SSN form");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 220, 30));
        jPanel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 87, 30));

        btnSearch.setText("Search");
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



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jcbAvailability;
    private javax.swing.JPanel jpContainer;
    private javax.swing.JPanel jpForm;
    private javax.swing.JPanel jpTable;
    private javax.swing.JTable jtTableClients;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblAvailability;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblLastname;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSsn;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSsn;
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

    public javax.swing.JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(javax.swing.JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

    public javax.swing.JButton getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(javax.swing.JButton btnEdit) {
        this.btnEdit = btnEdit;
    }

    public javax.swing.JButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(javax.swing.JButton btnSave) {
        this.btnSave = btnSave;
    }

    public javax.swing.JCheckBox getJcbAvailability() {
        return jcbAvailability;
    }

    public void setJcbAvailability(javax.swing.JCheckBox jcbAvailability) {
        this.jcbAvailability = jcbAvailability;
    }

    public javax.swing.JTable getJtTableClients() {
        return jtTableClients;
    }

    public void setJtTableClients(javax.swing.JTable jtTableClients) {
        this.jtTableClients = jtTableClients;
    }

    public javax.swing.JTextField getTxtAge() {
        return txtAge;
    }

    public void setTxtAge(javax.swing.JTextField txtAge) {
        this.txtAge = txtAge;
    }

    public javax.swing.JTextField getTxtLastName() {
        return txtLastName;
    }

    public void setTxtLastName(javax.swing.JTextField txtLastName) {
        this.txtLastName = txtLastName;
    }

    public javax.swing.JTextField getTxtPhone() {
        return txtPhone;
    }

    public void setTxtPhone(javax.swing.JTextField txtPhone) {
        this.txtPhone = txtPhone;
    }

    public javax.swing.JTextField getTxtSsn() {
        return txtSsn;
    }

    public void setTxtSsn(javax.swing.JTextField txtSsn) {
        this.txtSsn = txtSsn;
    }

    public javax.swing.JTextField getTxtName() {
        return txtName;
    }

    public void setTxtName(javax.swing.JTextField txtName) {
        this.txtName = txtName;
    }

    public javax.swing.JButton getBtnSearch() {
        return btnSearch;
    }

    public void setBtnSearch(javax.swing.JButton btnSearch) {
        this.btnSearch = btnSearch;
    }

    public javax.swing.JTextField getTxtSearch() {
        return txtSearch;
    }

    public void setTxtSearch(javax.swing.JTextField txtSearch) {
        this.txtSearch = txtSearch;
    }
    
    
}
