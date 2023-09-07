package views.Shop;

import controllers.Shop.checkoutformcontroller.CheckOutFormController;
import entitys.ShoppingCart;
import persistence.CheckOutRepository;
import services.CheckOutServiceImp;

public class CheckOutFormView extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    public CheckOutFormView(ShoppingCart shoppingCart) {
        
        CheckOutServiceImp checkOutServiceImp = new CheckOutServiceImp(new CheckOutRepository());
        
        initComponents();
        CheckOutFormController checkOutFormController = new CheckOutFormController(this, shoppingCart, checkOutServiceImp);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCheckOut = new javax.swing.JTable();
        lblDate = new javax.swing.JLabel();
        lblCheckOutNumber = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblTotalPrice = new javax.swing.JLabel();
        lblSelectPaymentMethodText = new javax.swing.JLabel();
        lblClientName = new javax.swing.JLabel();
        lblCreditCardText = new javax.swing.JLabel();
        lblCashText = new javax.swing.JLabel();
        jrbCash = new javax.swing.JRadioButton();
        jrbCreditCard = new javax.swing.JRadioButton();
        btnPay = new javax.swing.JButton();
        lblClientNameText = new javax.swing.JLabel();
        lblTotalPriceText = new javax.swing.JLabel();
        jcbCuotes = new javax.swing.JComboBox<>();
        txtCash = new javax.swing.JTextField();
        lblCheckOutNumberText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableCheckOut.setAutoCreateRowSorter(true);
        jTableCheckOut.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Brand", "Quantity", "Price", "FinalPrice"
            }
        ));
        jTableCheckOut.setAutoscrolls(false);
        jTableCheckOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableCheckOut.setGridColor(new java.awt.Color(255, 255, 255));
        jTableCheckOut.setShowGrid(true);
        jScrollPane1.setViewportView(jTableCheckOut);
        if (jTableCheckOut.getColumnModel().getColumnCount() > 0) {
            jTableCheckOut.getColumnModel().getColumn(0).setMinWidth(0);
            jTableCheckOut.getColumnModel().getColumn(0).setMaxWidth(50);
            jTableCheckOut.getColumnModel().getColumn(1).setMaxWidth(400);
            jTableCheckOut.getColumnModel().getColumn(2).setMaxWidth(100);
            jTableCheckOut.getColumnModel().getColumn(3).setMaxWidth(50);
            jTableCheckOut.getColumnModel().getColumn(4).setMaxWidth(100);
            jTableCheckOut.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 590, 200));

        lblDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDate.setText("Saturday 9/2/2023");
        jPanel1.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        lblCheckOutNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCheckOutNumber.setText("435232");
        jPanel1.add(lblCheckOutNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 90, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 5, -1, -1));

        lblTotalPrice.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotalPrice.setText("1500.00");
        jPanel2.add(lblTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, -1, -1));

        lblSelectPaymentMethodText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSelectPaymentMethodText.setText("SELECT PAYMENT METHOD");
        jPanel2.add(lblSelectPaymentMethodText, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        lblClientName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblClientName.setText("Fernando Osorio");
        jPanel2.add(lblClientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, -1));

        lblCreditCardText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCreditCardText.setText("CREDIT CARD");
        jPanel2.add(lblCreditCardText, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        lblCashText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCashText.setText("CASH");
        jPanel2.add(lblCashText, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));
        jPanel2.add(jrbCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, 40));
        jPanel2.add(jrbCreditCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 20, 30));

        btnPay.setText("PAY");
        jPanel2.add(btnPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        lblClientNameText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblClientNameText.setText("Client name:");
        jPanel2.add(lblClientNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        lblTotalPriceText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotalPriceText.setText("Total price: $ ");
        jPanel2.add(lblTotalPriceText, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, -1));

        jcbCuotes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1  6%", "2  11%", "6  18%", "12 24%" }));
        jPanel2.add(jcbCuotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 70, 30));
        jPanel2.add(txtCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 100, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 590, 240));

        lblCheckOutNumberText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCheckOutNumberText.setText("CHECKOUT N°: ");
        jPanel1.add(lblCheckOutNumberText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CheckOutFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckOutFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckOutFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckOutFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPay;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCheckOut;
    private javax.swing.JComboBox<String> jcbCuotes;
    private javax.swing.JRadioButton jrbCash;
    private javax.swing.JRadioButton jrbCreditCard;
    private javax.swing.JLabel lblCashText;
    private javax.swing.JLabel lblCheckOutNumber;
    private javax.swing.JLabel lblCheckOutNumberText;
    private javax.swing.JLabel lblClientName;
    private javax.swing.JLabel lblClientNameText;
    private javax.swing.JLabel lblCreditCardText;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblSelectPaymentMethodText;
    private javax.swing.JLabel lblTotalPrice;
    private javax.swing.JLabel lblTotalPriceText;
    private javax.swing.JTextField txtCash;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getBtnPay() {
        return btnPay;
    }

    public void setBtnPay(javax.swing.JButton btnPay) {
        this.btnPay = btnPay;
    }

    public javax.swing.JTable getjTableCheckOut() {
        return jTableCheckOut;
    }

    public void setjTableCheckOut(javax.swing.JTable jTableCheckOut) {
        this.jTableCheckOut = jTableCheckOut;
    }

    public javax.swing.JComboBox<String> getJcbCuotes() {
        return jcbCuotes;
    }

    public void setJcbCuotes(javax.swing.JComboBox<String> jcbCuotes) {
        this.jcbCuotes = jcbCuotes;
    }

    public javax.swing.JRadioButton getJrbCash() {
        return jrbCash;
    }

    public void setJrbCash(javax.swing.JRadioButton jrbCash) {
        this.jrbCash = jrbCash;
    }

    public javax.swing.JRadioButton getJrbCreditCard() {
        return jrbCreditCard;
    }

    public void setJrbCreditCard(javax.swing.JRadioButton jrbCreditCard) {
        this.jrbCreditCard = jrbCreditCard;
    }

    public javax.swing.JLabel getLblCashText() {
        return lblCashText;
    }

    public void setLblCashText(javax.swing.JLabel lblCashText) {
        this.lblCashText = lblCashText;
    }

    public javax.swing.JLabel getLblCheckOutNumber() {
        return lblCheckOutNumber;
    }

    public void setLblCheckOutNumber(javax.swing.JLabel lblCheckOutNumber) {
        this.lblCheckOutNumber = lblCheckOutNumber;
    }

    public javax.swing.JLabel getLblCheckOutNumberText() {
        return lblCheckOutNumberText;
    }

    public void setLblCheckOutNumberText(javax.swing.JLabel lblCheckOutNumberText) {
        this.lblCheckOutNumberText = lblCheckOutNumberText;
    }

    public javax.swing.JLabel getLblClientName() {
        return lblClientName;
    }

    public void setLblClientName(javax.swing.JLabel lblClientName) {
        this.lblClientName = lblClientName;
    }

    public javax.swing.JLabel getLblClientNameText() {
        return lblClientNameText;
    }

    public void setLblClientNameText(javax.swing.JLabel lblClientNameText) {
        this.lblClientNameText = lblClientNameText;
    }

    public javax.swing.JLabel getLblCreditCardText() {
        return lblCreditCardText;
    }

    public void setLblCreditCardText(javax.swing.JLabel lblCreditCardText) {
        this.lblCreditCardText = lblCreditCardText;
    }

    public javax.swing.JLabel getLblDate() {
        return lblDate;
    }

    public void setLblDate(javax.swing.JLabel lblDate) {
        this.lblDate = lblDate;
    }

    public javax.swing.JLabel getLblSelectPaymentMethodText() {
        return lblSelectPaymentMethodText;
    }

    public void setLblSelectPaymentMethodText(javax.swing.JLabel lblSelectPaymentMethodText) {
        this.lblSelectPaymentMethodText = lblSelectPaymentMethodText;
    }

    public javax.swing.JLabel getLblTotalPrice() {
        return lblTotalPrice;
    }

    public void setLblTotalPrice(javax.swing.JLabel lblTotalPrice) {
        this.lblTotalPrice = lblTotalPrice;
    }

    public javax.swing.JLabel getLblTotalPriceText() {
        return lblTotalPriceText;
    }

    public void setLblTotalPriceText(javax.swing.JLabel lblTotalPriceText) {
        this.lblTotalPriceText = lblTotalPriceText;
    }

    public javax.swing.JTextField getTxtCash() {
        return txtCash;
    }

    public void setTxtCash(javax.swing.JTextField txtCash) {
        this.txtCash = txtCash;
    }
}
