/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GiaoDien;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import keeptoo.KTextField;

/**
 *
 * @author HiHi
 */
public class MainControl extends javax.swing.JFrame {

    /**
     * Creates new form MainControl
     */
    public MainControl() {
        this.setUndecorated(true);
        this.setSize(1315, 760);
        initComponents();

//        JPanel panel1 = new JPanel();
//        panel1.setSize(273, 245);
//        panel1.setBackground(Color.red);
//        JLabel label1 = new JLabel();
//        label1.setIcon(new ImageIcon("/image/2608278.jpg"));
//        label1.setBounds(0, 0, panel1.getWidth(), 190);
//        panel1.add(label1);
//        panel1.setOpaque(false);
//        panelHinhAnh.add(panel1);
//        keeptoo.KGradientPanel kGradientPanel2 = new keeptoo.KGradientPanel();
//        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
//        JLabel  lbDate = new JLabel();
//        JLabel lbDownLoad = new JLabel();
//        JLabel  lbHinhAnh = new JLabel();
//        JLabel lbTenAnh = new JLabel();
//                kGradientPanel2.setkBorderRadius(0);
//        kGradientPanel2.setkEndColor(new java.awt.Color(71,74,81));
//        kGradientPanel2.setkStartColor(new java.awt.Color(71,74,81));
//        kGradientPanel2.setMinimumSize(new java.awt.Dimension(273, 237));
//        kGradientPanel2.setPreferredSize(new java.awt.Dimension(273, 237));
//        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
//        
//        
//        
//        lbDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
//        lbDate.setText("20/11/2020");
//        lbDate.setForeground(new Color(142,144,149));
//        kGradientPanel2.add(lbDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 220, 30));
//
//        lbDownLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/download_35px.png"))); // NOI18N
//        kGradientPanel2.add(lbDownLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 40, 40));
//
//        lbHinhAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/2608782.jpg"))); // NOI18N
//        lbHinhAnh.setText("jLabel1");
//        kGradientPanel2.add(lbHinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 273, 180));
//
//        lbTenAnh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
//        lbTenAnh.setText("Hinhanh.jpg");
//        lbTenAnh.setForeground(new Color(142,144,149));
//        kGradientPanel2.add(lbTenAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 210, 31));
        
        AvatarPanel ava = new AvatarPanel("3","3","4","5");
        panelHinhAnh.add(ava);

        JPanel panel2 = new JPanel();
        panel2.setSize(273, 245);
        panel2.setBackground(Color.yellow);
        panelHinhAnh.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setSize(273, 245);
        panel3.setBackground(Color.orange);
        panelHinhAnh.add(panel3);

        JPanel panel4 = new JPanel();
        panel4.setSize(273, 245);
        panel4.setBackground(Color.green);
        panelHinhAnh.add(panel4);

        JPanel panel5 = new JPanel();
        panel5.setSize(273, 245);
        panel5.setBackground(Color.gray);
        panelHinhAnh.add(panel5);

        JPanel panel6 = new JPanel();
        panel6.setSize(273, 245);
        panel6.setBackground(Color.black);
        panelHinhAnh.add(panel6);

        JPanel panel7 = new JPanel();
        panel7.setSize(273, 245);
        panel7.setBackground(Color.pink);
        panelHinhAnh.add(panel7);

        JPanel panel8 = new JPanel();
        panel8.setSize(273, 245);
        panel8.setBackground(Color.blue);
        panelHinhAnh.add(panel8);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHead = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        lbBackground = new javax.swing.JLabel();
        panelNextPage = new javax.swing.JPanel();
        panelFunction = new javax.swing.JPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        panelHinhAnh = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1315, 760));
        setMinimumSize(new java.awt.Dimension(1315, 760));
        setPreferredSize(new java.awt.Dimension(1315, 760));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHead.setMaximumSize(new java.awt.Dimension(1314, 135));
        panelHead.setMinimumSize(new java.awt.Dimension(1314, 135));
        panelHead.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setkBorderRadius(125);
        kGradientPanel1.setOpaque(false);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        panelHead.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 5, 120, 120));

        lbBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/SzQGbZV_d.jpg"))); // NOI18N
        panelHead.add(lbBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1315, 135));

        getContentPane().add(panelHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1315, 135));

        panelNextPage.setBackground(new java.awt.Color(6, 49, 119));
        panelNextPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelNextPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 707, 1320, 60));

        panelFunction.setBackground(new java.awt.Color(6, 18, 52));
        panelFunction.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panelFunctionLayout = new javax.swing.GroupLayout(panelFunction);
        panelFunction.setLayout(panelFunctionLayout);
        panelFunctionLayout.setHorizontalGroup(
            panelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1315, Short.MAX_VALUE)
        );
        panelFunctionLayout.setVerticalGroup(
            panelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(panelFunction, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 135, -1, 50));

        kGradientPanel2.setkBorderRadius(0);
        kGradientPanel2.setkEndColor(new java.awt.Color(25, 30, 49));
        kGradientPanel2.setkGradientFocus(0);
        kGradientPanel2.setkStartColor(new java.awt.Color(9, 20, 51));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHinhAnh.setMaximumSize(new java.awt.Dimension(1225, 527));
        panelHinhAnh.setMinimumSize(new java.awt.Dimension(1225, 527));
        panelHinhAnh.setName(""); // NOI18N
        panelHinhAnh.setOpaque(false);
        panelHinhAnh.setPreferredSize(new java.awt.Dimension(1225, 527));
        panelHinhAnh.setLayout(new java.awt.GridLayout(2, 4, 45, 45));
        kGradientPanel2.add(panelHinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 7, 1230, 520));

        getContentPane().add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1320, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainControl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lbBackground;
    private javax.swing.JPanel panelFunction;
    private javax.swing.JPanel panelHead;
    private javax.swing.JPanel panelHinhAnh;
    private javax.swing.JPanel panelNextPage;
    // End of variables declaration//GEN-END:variables
}
