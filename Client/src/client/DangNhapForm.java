/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.w3c.dom.css.RGBColor;

/**
 *
 * @author HiHi
 */
public class DangNhapForm extends javax.swing.JFrame {

    /**
     * Creates new form DangNhapForm
     */
    Client client = new Client();

    public DangNhapForm() {
        this.setUndecorated(true);
        initComponents();
        this.setSize(850, 540);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setBackground(new Color(0, 0, 0, 0));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTaiKhoan = new javax.swing.JLabel();
        lbMatKhau = new javax.swing.JLabel();
        tfMatKhau = new javax.swing.JPasswordField();
        tfTaiKhoan = new javax.swing.JTextField();
        btnClose = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lbThongBaoDangNhap = new javax.swing.JLabel();
        lbDangKyTaiKhoan = new javax.swing.JLabel();
        btnDangNhap = new keeptoo.KGradientPanel();
        lbDangNhap = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTaiKhoan.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbTaiKhoan.setForeground(new java.awt.Color(51, 51, 51));
        lbTaiKhoan.setText("Tài Khoản");
        getContentPane().add(lbTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 190, 40));

        lbMatKhau.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbMatKhau.setForeground(new java.awt.Color(51, 51, 51));
        lbMatKhau.setText("Mật Khẩu");
        getContentPane().add(lbMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 130, 40));

        tfMatKhau.setBackground(new java.awt.Color(51, 51, 51));
        tfMatKhau.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tfMatKhau.setForeground(new java.awt.Color(51, 51, 51));
        tfMatKhau.setText("jPassword");
        tfMatKhau.setBorder(null);
        tfMatKhau.setOpaque(false);
        getContentPane().add(tfMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 290, 40));

        tfTaiKhoan.setBackground(new java.awt.Color(51, 51, 51));
        tfTaiKhoan.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        tfTaiKhoan.setForeground(new java.awt.Color(51, 51, 51));
        tfTaiKhoan.setBorder(null);
        tfTaiKhoan.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfTaiKhoan.setNextFocusableComponent(tfMatKhau);
        tfTaiKhoan.setOpaque(false);
        getContentPane().add(tfTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 290, 40));

        btnClose.setBackground(new java.awt.Color(255, 255, 255));
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/multiply_30px.png"))); // NOI18N
        btnClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClose.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCloseMouseExited(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 40, 40));

        btnMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/minus_math_30px.png"))); // NOI18N
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseExited(evt);
            }
        });
        getContentPane().add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 40, 40));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 290, 10));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 290, -1));

        lbThongBaoDangNhap.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lbThongBaoDangNhap.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(lbThongBaoDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 330, 40));

        lbDangKyTaiKhoan.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbDangKyTaiKhoan.setForeground(new java.awt.Color(102, 102, 102));
        lbDangKyTaiKhoan.setText("Đăng Kí Tài Khoản");
        lbDangKyTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDangKyTaiKhoanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbDangKyTaiKhoanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbDangKyTaiKhoanMouseExited(evt);
            }
        });
        getContentPane().add(lbDangKyTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 150, 30));

        btnDangNhap.setBackground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setToolTipText("");
        btnDangNhap.setkBorderRadius(50);
        btnDangNhap.setkEndColor(new java.awt.Color(255, 255, 255));
        btnDangNhap.setkFillBackground(false);
        btnDangNhap.setkGradientFocus(300);
        btnDangNhap.setkStartColor(new java.awt.Color(102, 102, 102));
        btnDangNhap.setkTransparentControls(false);
        btnDangNhap.setOpaque(false);
        btnDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDangNhapMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDangNhapMouseExited(evt);
            }
        });
        btnDangNhap.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbDangNhap.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbDangNhap.setForeground(new java.awt.Color(51, 51, 51));
        lbDangNhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDangNhap.setText("Đăng Nhập");
        btnDangNhap.add(lbDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -4, 180, 60));

        getContentPane().add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 170, 50));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\HiHi\\Desktop\\ThuVienAnh\\Client\\src\\image\\2608782.jpg")); // NOI18N
        jLabel3.setNextFocusableComponent(this);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

//            String taiKhoan = tfTaiKhoan.getText();
//        String matKhau = tfMatKhau.getText();
//        if (taiKhoan.equals("") || matKhau.equals("")) {
//            lbThongBaoDangNhap.setText("Tài khoản hoặc mật khẩu không được để trống");
//            this.validate();
//        } else {
//
//            this.setCursor(Cursor.WAIT_CURSOR);
//            String id = null;
//            if (!(id = client.dangNhap(taiKhoan, matKhau)).equals("null")) {
//                this.setCursor(Cursor.DEFAULT_CURSOR);
//                lbThongBaoDangNhap.setText("");
//                System.out.println("Đăng Nhập Thành Công");
//                System.out.println(id);
//
//            } else {
//                this.setCursor(Cursor.DEFAULT_CURSOR);
//                tfMatKhau.setText("");
//                lbThongBaoDangNhap.setText("Tài khoản hoặc mật khẩu không chính xác");
//                this.validate();
//            }
//        }
    //sự kiện click vào thì thoát chương trình
    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        // TODO add your handling code here:
        this.dispose();
        this.disable();
    }//GEN-LAST:event_btnCloseMouseClicked

    //sự kiện click vào thì màn hình đăng nhập minimize
    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        // TODO add your handling code here:
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    //sự kiện đưa chuột vào btnClose
    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered
        // TODO add your handling code here:
        btnClose.setOpaque(true);
        btnClose.setBackground(new Color(213, 208, 208));

    }//GEN-LAST:event_btnCloseMouseEntered

    //sự kiện đưa chuột ra khỏi btnClose
    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
        // TODO add your handling code here:
        btnClose.setOpaque(false);
        btnClose.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnCloseMouseExited

    private void btnMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseEntered
        // TODO add your handling code here:
        btnMinimize.setOpaque(true);
        btnMinimize.setBackground(new Color(213, 208, 208));
    }//GEN-LAST:event_btnMinimizeMouseEntered

    private void btnMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseExited
        // TODO add your handling code here:
        btnMinimize.setOpaque(false);
        btnMinimize.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnMinimizeMouseExited

    private void lbDangKyTaiKhoanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDangKyTaiKhoanMouseEntered
        // TODO add your handling code here:
        lbDangKyTaiKhoan.setForeground(new Color(70, 70, 70));
    }//GEN-LAST:event_lbDangKyTaiKhoanMouseEntered

    private void lbDangKyTaiKhoanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDangKyTaiKhoanMouseExited
        // TODO add your handling code here:
        lbDangKyTaiKhoan.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_lbDangKyTaiKhoanMouseExited

    private void lbDangKyTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDangKyTaiKhoanMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_lbDangKyTaiKhoanMouseClicked

    private void btnDangNhapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangNhapMouseEntered
        // TODO add your handling code here:
        btnDangNhap.setkFillBackground(true);
        btnDangNhap.setkFillBackground(true);
        lbDangNhap.setForeground(new Color(102, 102, 102));

    }//GEN-LAST:event_btnDangNhapMouseEntered

    private void btnDangNhapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangNhapMouseExited
        // TODO add your handling code here:
        btnDangNhap.setkFillBackground(false);
        lbDangNhap.setForeground(new Color(51, 51, 51));

    }//GEN-LAST:event_btnDangNhapMouseExited

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
            java.util.logging.Logger.getLogger(DangNhapForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhapForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhapForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhapForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhapForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClose;
    private keeptoo.KGradientPanel btnDangNhap;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbDangKyTaiKhoan;
    private javax.swing.JLabel lbDangNhap;
    private javax.swing.JLabel lbMatKhau;
    private javax.swing.JLabel lbTaiKhoan;
    private javax.swing.JLabel lbThongBaoDangNhap;
    private javax.swing.JPasswordField tfMatKhau;
    private javax.swing.JTextField tfTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
