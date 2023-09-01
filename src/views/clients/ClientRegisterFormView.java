package views.clients;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import controllers.clients.ClientRegisterFormController;
import javax.swing.JLabel;
import services.ClientServiceImp;

public class ClientRegisterFormView extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;

    public ClientRegisterFormView(ClientServiceImp clientServiceImp) {
        initComponents();
        var clientRegisterFormController = new ClientRegisterFormController(this, clientServiceImp);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpContainer = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        jpForm = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        txtLastname = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        lblAge = new javax.swing.JLabel();
        lblAvailability = new javax.swing.JLabel();
        jcbAvailability = new javax.swing.JCheckBox();
        lblSsn = new javax.swing.JLabel();
        txtSsn = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jpTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTableClients = new javax.swing.JTable();

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

        lblLastName.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblLastName.setText("Lastname");
        jpForm.add(lblLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 60, 30));
        jpForm.add(txtLastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 140, 30));
        jpForm.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 140, 30));

        lblAge.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblAge.setText("Age");
        jpForm.add(lblAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 70, 30));

        lblAvailability.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblAvailability.setText("Availability");
        jpForm.add(lblAvailability, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 100, 30));

        jcbAvailability.setText("YES/NO");
        jpForm.add(jcbAvailability, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 100, 30));

        lblSsn.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblSsn.setText("Ssn");
        jpForm.add(lblSsn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 70, 30));
        jpForm.add(txtSsn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 140, 30));

        lblPhone.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblPhone.setText("Phone");
        jpForm.add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 60, 30));
        jpForm.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 140, 30));

        btnSave.setText("Save");
        jpForm.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 90, 30));

        btnCancel.setText("Cancel");
        jpForm.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 90, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Client Register Form");
        jpForm.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 30));

        jpTable.setBackground(new java.awt.Color(255, 255, 255));

        jtTableClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "LastName", "Age", "Availability", "Ssn", "Phone"
            }
        ));
        jScrollPane1.setViewportView(jtTableClients);

        javax.swing.GroupLayout jpTableLayout = new javax.swing.GroupLayout(jpTable);
        jpTable.setLayout(jpTableLayout);
        jpTableLayout.setHorizontalGroup(
            jpTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE))
        );
        jpTableLayout.setVerticalGroup(
            jpTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jpContainerLayout = new javax.swing.GroupLayout(jpContainer);
        jpContainer.setLayout(jpContainerLayout);
        jpContainerLayout.setHorizontalGroup(
            jpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContainerLayout.createSequentialGroup()
                .addGroup(jpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpForm, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpContainerLayout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(lblId)))
                .addComponent(jpTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpContainerLayout.setVerticalGroup(
            jpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpForm, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jpContainerLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(lblId))
            .addComponent(jpTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(JButton btnSave) {
        this.btnSave = btnSave;
    }

    public JTable getJtTableClients() {
        return jtTableClients;
    }

    public void setJtTableClients(JTable jtTableClients) {
        this.jtTableClients = jtTableClients;
    }

    public JTextField getTxtAge() {
        return txtAge;
    }

    public void setTxtAge(JTextField txtAge) {
        this.txtAge = txtAge;
    }

    public JTextField getTxtLastname() {
        return txtLastname;
    }

    public void setTxtLastname(JTextField txtLastname) {
        this.txtLastname = txtLastname;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    public JTextField getTxtPhone() {
        return txtPhone;
    }

    public void setTxtPhone(JTextField txtPhone) {
        this.txtPhone = txtPhone;
    }

    public JTextField getTxtSsn() {
        return txtSsn;
    }

    public void setTxtSsn(JTextField txtSsn) {
        this.txtSsn = txtSsn;
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }
   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancel;
    public javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JCheckBox jcbAvailability;
    private javax.swing.JPanel jpContainer;
    private javax.swing.JPanel jpForm;
    private javax.swing.JPanel jpTable;
    private javax.swing.JTable jtTableClients;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblAvailability;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSsn;
    public javax.swing.JTextField txtAge;
    public javax.swing.JTextField txtLastname;
    private javax.swing.JTextField txtName;
    public javax.swing.JTextField txtPhone;
    public javax.swing.JTextField txtSsn;
    // End of variables declaration//GEN-END:variables
}
