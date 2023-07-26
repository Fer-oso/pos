package views;

import controllers.POSController;
import views.Shop.ShopCarHistory;
import views.Shop.ShopForm;
import views.Shop.ShopCarLast;

public class POS extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    public POS() {
        initComponents();
        POSController posController = new POSController(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuShop = new javax.swing.JMenu();
        jMenuItemShopForm = new javax.swing.JMenuItem();
        jMenuShopCar = new javax.swing.JMenu();
        jMenuItemShopCarLast = new javax.swing.JMenuItem();
        jMenuItemShopCarHistory = new javax.swing.JMenuItem();
        jMenuClient = new javax.swing.JMenu();
        jMenuClientFind = new javax.swing.JMenu();
        jMenuItemClientByName = new javax.swing.JMenuItem();
        jMenuItemClientByCI = new javax.swing.JMenuItem();
        jMenuItemClientRegister = new javax.swing.JMenuItem();
        jMenuProduct = new javax.swing.JMenu();
        jMenuProductFind = new javax.swing.JMenu();
        jMenuItemProductByName = new javax.swing.JMenuItem();
        jMenuItemProductByPC = new javax.swing.JMenuItem();
        jMenuItemProductRegister = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1040, 512));

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(1016, 512));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenuShop.setText("Shop");

        jMenuItemShopForm.setText("Shop Form");
        jMenuItemShopForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemShopFormActionPerformed(evt);
            }
        });
        jMenuShop.add(jMenuItemShopForm);

        jMenuShopCar.setText("Shop Car");

        jMenuItemShopCarLast.setText("Last");
        jMenuItemShopCarLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemShopCarLastActionPerformed(evt);
            }
        });
        jMenuShopCar.add(jMenuItemShopCarLast);

        jMenuItemShopCarHistory.setText("History");
        jMenuItemShopCarHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemShopCarHistoryActionPerformed(evt);
            }
        });
        jMenuShopCar.add(jMenuItemShopCarHistory);

        jMenuShop.add(jMenuShopCar);

        jMenuBar1.add(jMenuShop);

        jMenuClient.setText("Client");

        jMenuClientFind.setText("Find");

        jMenuItemClientByName.setText("by name");
        jMenuClientFind.add(jMenuItemClientByName);

        jMenuItemClientByCI.setText("by C.I");
        jMenuClientFind.add(jMenuItemClientByCI);

        jMenuClient.add(jMenuClientFind);

        jMenuItemClientRegister.setText("Register");
        jMenuItemClientRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClientRegisterActionPerformed(evt);
            }
        });
        jMenuClient.add(jMenuItemClientRegister);

        jMenuBar1.add(jMenuClient);

        jMenuProduct.setText("Product");

        jMenuProductFind.setText("Find");

        jMenuItemProductByName.setText("by name");
        jMenuProductFind.add(jMenuItemProductByName);

        jMenuItemProductByPC.setText("by PC");
        jMenuProductFind.add(jMenuItemProductByPC);

        jMenuProduct.add(jMenuProductFind);

        jMenuItemProductRegister.setText("Register");
        jMenuProduct.add(jMenuItemProductRegister);

        jMenuBar1.add(jMenuProduct);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemShopCarLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemShopCarLastActionPerformed
        
            jDesktopPane1.add(new ShopCarLast()).setVisible(true);
    }//GEN-LAST:event_jMenuItemShopCarLastActionPerformed

    private void jMenuItemShopFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemShopFormActionPerformed
        ShopForm shopForm = new ShopForm();
            jDesktopPane1.add(shopForm).setVisible(true);
    }//GEN-LAST:event_jMenuItemShopFormActionPerformed

    private void jMenuItemShopCarHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemShopCarHistoryActionPerformed
        jDesktopPane1.add(new ShopCarHistory()).setVisible(true);
    }//GEN-LAST:event_jMenuItemShopCarHistoryActionPerformed

    private void jMenuItemClientRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClientRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemClientRegisterActionPerformed

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
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new POS().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenu jMenuClient;
    public javax.swing.JMenu jMenuClientFind;
    private javax.swing.JMenuItem jMenuItemClientByCI;
    private javax.swing.JMenuItem jMenuItemClientByName;
    public javax.swing.JMenuItem jMenuItemClientRegister;
    public javax.swing.JMenuItem jMenuItemProductByName;
    public javax.swing.JMenuItem jMenuItemProductByPC;
    public javax.swing.JMenuItem jMenuItemProductRegister;
    public javax.swing.JMenuItem jMenuItemShopCarHistory;
    public javax.swing.JMenuItem jMenuItemShopCarLast;
    public javax.swing.JMenuItem jMenuItemShopForm;
    public javax.swing.JMenu jMenuProduct;
    public javax.swing.JMenu jMenuProductFind;
    public javax.swing.JMenu jMenuShop;
    public javax.swing.JMenu jMenuShopCar;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
