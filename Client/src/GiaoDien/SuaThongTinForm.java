/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GiaoDien;

import BackEndClass.TaiKhoan;
import BackEndClass.ThongTin;
import Client.Client;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author HiHi
 */
public class SuaThongTinForm extends javax.swing.JFrame {

    /**
     * Creates new form SuaThongTinForm
     */
    private String taiKhoan;
    private Client client;

    public SuaThongTinForm(String taiKhoan, Client client) {
        this.taiKhoan = taiKhoan;
        this.client = client;
        this.setUndecorated(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initComponents();
        this.setSize(740, 440);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setBackground(new Color(0, 0, 0, 0));
        tfNgaySinh.setFormats("yyyy-MM-dd");
        tfNgaySinh.getEditor().setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 1));
        tfNgaySinh.getEditor().setOpaque(false);
        tfNgaySinh.getEditor().setForeground(new Color(204, 204, 204, 204));
        tfNgaySinh.getEditor().setCaretColor(new Color(204, 204, 204));
        JButton btn_pick = (JButton) tfNgaySinh.getComponent(1);
        btn_pick.setOpaque(false);
        btn_pick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_calendar_32px_1.png")));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        btnMinimize = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        lbMatKhauCu = new javax.swing.JLabel();
        tfMatKhauCu = new javax.swing.JPasswordField();
        jSeparator12 = new javax.swing.JSeparator();
        lbMatKhauMoi = new javax.swing.JLabel();
        tfMatKhauMoi = new javax.swing.JPasswordField();
        jSeparator13 = new javax.swing.JSeparator();
        lbXacNhanMatKhau = new javax.swing.JLabel();
        tfXNMatKhau = new javax.swing.JPasswordField();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        lbTenNguoiDung = new javax.swing.JLabel();
        tfTenNguoiDung = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        lbEmail = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        lbNgaySinh = new javax.swing.JLabel();
        tfNgaySinh = new org.jdesktop.swingx.JXDatePicker();
        lbDoiMatKhau = new javax.swing.JLabel();
        btnDoiMatKhau = new keeptoo.KGradientPanel();
        lbDoiThongTin = new javax.swing.JLabel();
        btnDoiThongTin = new keeptoo.KGradientPanel();
        lbThongBaoThongTin = new javax.swing.JLabel();
        lbThongBaoMatKhau = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(740, 440));
        setSize(new java.awt.Dimension(740, 440));
        setType(java.awt.Window.Type.POPUP);

        kGradientPanel1.setBackground(new java.awt.Color(204, 204, 204));
        kGradientPanel1.setForeground(new java.awt.Color(204, 204, 204));
        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(9, 20, 51));
        kGradientPanel1.setkGradientFocus(0);
        kGradientPanel1.setkStartColor(new java.awt.Color(1, 185, 107));
        kGradientPanel1.setkTransparentControls(false);
        kGradientPanel1.setMinimumSize(new java.awt.Dimension(740, 440));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(740, 440));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMinimize.setForeground(new java.awt.Color(204, 0, 0));
        btnMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_minus_35px.png"))); // NOI18N
        btnMinimize.setPreferredSize(new java.awt.Dimension(40, 40));
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
        kGradientPanel1.add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 40, 40));

        btnClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_multiply_35px_2.png"))); // NOI18N
        btnClose.setPreferredSize(new java.awt.Dimension(40, 40));
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
        kGradientPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 40, 40));

        lbMatKhauCu.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lbMatKhauCu.setForeground(new java.awt.Color(204, 204, 204));
        lbMatKhauCu.setText("Mật Khẩu Cũ");
        kGradientPanel1.add(lbMatKhauCu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 190, 30));

        tfMatKhauCu.setBackground(new java.awt.Color(255, 255, 255));
        tfMatKhauCu.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfMatKhauCu.setForeground(new java.awt.Color(240, 240, 240));
        tfMatKhauCu.setBorder(null);
        tfMatKhauCu.setCaretColor(new java.awt.Color(255, 255, 255));
        tfMatKhauCu.setNextFocusableComponent(tfMatKhauMoi);
        tfMatKhauCu.setOpaque(false);
        kGradientPanel1.add(tfMatKhauCu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 290, 35));

        jSeparator12.setForeground(new java.awt.Color(204, 204, 204));
        kGradientPanel1.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 290, -1));

        lbMatKhauMoi.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lbMatKhauMoi.setForeground(new java.awt.Color(204, 204, 204));
        lbMatKhauMoi.setText("Mật Khẩu Mới");
        kGradientPanel1.add(lbMatKhauMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 190, 30));

        tfMatKhauMoi.setBackground(new java.awt.Color(255, 255, 255));
        tfMatKhauMoi.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfMatKhauMoi.setForeground(new java.awt.Color(240, 240, 240));
        tfMatKhauMoi.setBorder(null);
        tfMatKhauMoi.setCaretColor(new java.awt.Color(255, 255, 255));
        tfMatKhauMoi.setNextFocusableComponent(tfXNMatKhau);
        tfMatKhauMoi.setOpaque(false);
        kGradientPanel1.add(tfMatKhauMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 290, 35));

        jSeparator13.setForeground(new java.awt.Color(204, 204, 204));
        kGradientPanel1.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 290, -1));

        lbXacNhanMatKhau.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lbXacNhanMatKhau.setForeground(new java.awt.Color(204, 204, 204));
        lbXacNhanMatKhau.setText("Xác Nhận Mật Khẩu Mới");
        kGradientPanel1.add(lbXacNhanMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 190, 30));

        tfXNMatKhau.setBackground(new java.awt.Color(255, 255, 255));
        tfXNMatKhau.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfXNMatKhau.setForeground(new java.awt.Color(240, 240, 240));
        tfXNMatKhau.setBorder(null);
        tfXNMatKhau.setCaretColor(new java.awt.Color(255, 255, 255));
        tfXNMatKhau.setOpaque(false);
        kGradientPanel1.add(tfXNMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 290, 35));

        jSeparator11.setForeground(new java.awt.Color(204, 204, 204));
        kGradientPanel1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 290, -1));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setVerifyInputWhenFocusTarget(false);
        kGradientPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, 250));

        lbTenNguoiDung.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lbTenNguoiDung.setForeground(new java.awt.Color(204, 204, 204));
        lbTenNguoiDung.setText("Tên Người Dùng");
        kGradientPanel1.add(lbTenNguoiDung, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 190, 30));

        tfTenNguoiDung.setBackground(new java.awt.Color(255, 255, 255));
        tfTenNguoiDung.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        tfTenNguoiDung.setForeground(new java.awt.Color(240, 240, 240));
        tfTenNguoiDung.setBorder(null);
        tfTenNguoiDung.setCaretColor(new java.awt.Color(255, 255, 255));
        tfTenNguoiDung.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfTenNguoiDung.setNextFocusableComponent(tfEmail);
        tfTenNguoiDung.setOpaque(false);
        kGradientPanel1.add(tfTenNguoiDung, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 290, 35));

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        kGradientPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 290, -1));

        lbEmail.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lbEmail.setForeground(new java.awt.Color(204, 204, 204));
        lbEmail.setText("Email");
        kGradientPanel1.add(lbEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 190, 30));

        tfEmail.setBackground(new java.awt.Color(255, 255, 255));
        tfEmail.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        tfEmail.setForeground(new java.awt.Color(240, 240, 240));
        tfEmail.setBorder(null);
        tfEmail.setCaretColor(new java.awt.Color(255, 255, 255));
        tfEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfEmail.setNextFocusableComponent(tfNgaySinh);
        tfEmail.setOpaque(false);
        kGradientPanel1.add(tfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 290, 35));

        jSeparator9.setForeground(new java.awt.Color(204, 204, 204));
        kGradientPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 290, -1));

        jSeparator8.setForeground(new java.awt.Color(204, 204, 204));
        kGradientPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 150, -1));

        lbNgaySinh.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lbNgaySinh.setForeground(new java.awt.Color(204, 204, 204));
        lbNgaySinh.setText("Ngày Sinh");
        kGradientPanel1.add(lbNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 190, 30));

        tfNgaySinh.setBackground(new java.awt.Color(255, 255, 255));
        tfNgaySinh.setForeground(new java.awt.Color(240, 240, 240));
        tfNgaySinh.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        tfNgaySinh.setDoubleBuffered(true);
        tfNgaySinh.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        tfNgaySinh.setMaximumSize(new java.awt.Dimension(190, 40));
        tfNgaySinh.setMinimumSize(new java.awt.Dimension(190, 40));
        tfNgaySinh.setPreferredSize(new java.awt.Dimension(190, 40));
        kGradientPanel1.add(tfNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 190, 40));

        lbDoiMatKhau.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbDoiMatKhau.setForeground(new java.awt.Color(204, 204, 204));
        lbDoiMatKhau.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDoiMatKhau.setText("Đổi Mật Khẩu");
        lbDoiMatKhau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbDoiMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDoiMatKhauMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbDoiMatKhauMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbDoiMatKhauMouseExited(evt);
            }
        });
        kGradientPanel1.add(lbDoiMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 170, 50));

        btnDoiMatKhau.setBackground(new java.awt.Color(255, 255, 255));
        btnDoiMatKhau.setToolTipText("");
        btnDoiMatKhau.setkBorderRadius(50);
        btnDoiMatKhau.setkEndColor(new java.awt.Color(255, 255, 255));
        btnDoiMatKhau.setkFillBackground(false);
        btnDoiMatKhau.setkGradientFocus(300);
        btnDoiMatKhau.setkStartColor(new java.awt.Color(102, 102, 102));
        btnDoiMatKhau.setkTransparentControls(false);
        btnDoiMatKhau.setOpaque(false);
        btnDoiMatKhau.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        kGradientPanel1.add(btnDoiMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 170, 50));

        lbDoiThongTin.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbDoiThongTin.setForeground(new java.awt.Color(204, 204, 204));
        lbDoiThongTin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDoiThongTin.setText("Đổi Thông Tin");
        lbDoiThongTin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbDoiThongTin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDoiThongTinMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbDoiThongTinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbDoiThongTinMouseExited(evt);
            }
        });
        kGradientPanel1.add(lbDoiThongTin, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 170, 50));

        btnDoiThongTin.setBackground(new java.awt.Color(255, 255, 255));
        btnDoiThongTin.setToolTipText("");
        btnDoiThongTin.setkBorderRadius(50);
        btnDoiThongTin.setkEndColor(new java.awt.Color(255, 255, 255));
        btnDoiThongTin.setkFillBackground(false);
        btnDoiThongTin.setkGradientFocus(300);
        btnDoiThongTin.setkStartColor(new java.awt.Color(102, 102, 102));
        btnDoiThongTin.setkTransparentControls(false);
        btnDoiThongTin.setOpaque(false);
        btnDoiThongTin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        kGradientPanel1.add(btnDoiThongTin, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 170, 50));

        lbThongBaoThongTin.setForeground(new java.awt.Color(255, 51, 51));
        kGradientPanel1.add(lbThongBaoThongTin, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 290, 30));

        lbThongBaoMatKhau.setForeground(new java.awt.Color(255, 51, 51));
        lbThongBaoMatKhau.setToolTipText("");
        kGradientPanel1.add(lbThongBaoMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 290, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
// <editor-fold defaultstate="collapsed" desc="Button Đổi Mật Khẩu">  

    public boolean checkRongDoiMatKhau() {
        if (tfMatKhauCu.getText().equals("") || tfMatKhauMoi.getText().equals("") || tfXNMatKhau.getText().equals("")) {
            lbThongBaoThongTin.setText("Bạn Cần Nhập Nhập Đầy Đủ Thông Tin");
            return false;
        } else if (!tfMatKhauMoi.getText().equals(tfXNMatKhau.getText())) {
            lbThongBaoMatKhau.setText("Mật Khẩu Xác Nhận Không Trùng Khớp");
            return false;
        } else {
            lbThongBaoMatKhau.setText("");
            return true;
        }
    }


    private void lbDoiMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDoiMatKhauMouseClicked
        if (checkRongDoiMatKhau()) {
            TaiKhoan taiKhoan = new TaiKhoan(this.taiKhoan, tfMatKhauCu.getText());
            String messReponse = client.doiMatKhau(taiKhoan, tfMatKhauMoi.getText());
            String thongBao = "";
            switch (messReponse) {
                case "sai_mat_khau":
                    thongBao = "Sai Mật Khẩu Hiện Tại \n";
                    break;
                case "fail":
                    thongBao = "Đổi Mật Khẩu Không Thành Công Mời Bạn Thử Lại \n";
                    break;
                default:
                    break;
                case "success":
                    JOptionPane.showMessageDialog(null, "Đổi Mật Khẩu Thành Công", "Đổi Mật Khẩu", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
            lbThongBaoMatKhau.setText(thongBao);
        }
    }//GEN-LAST:event_lbDoiMatKhauMouseClicked

    private void lbDoiMatKhauMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDoiMatKhauMouseEntered
        // TODO add your handling code here:
        lbDoiMatKhau.setForeground(new Color(255, 255, 255));
        btnDoiMatKhau.setkEndColor(new Color(255, 255, 255));
        btnDoiMatKhau.setkStartColor(new Color(102, 102, 102));
        btnDoiMatKhau.setkFillBackground(true);
    }//GEN-LAST:event_lbDoiMatKhauMouseEntered

    private void lbDoiMatKhauMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDoiMatKhauMouseExited
        // TODO add your handling code here:
        lbDoiMatKhau.setForeground(new Color(204, 204, 204));
        btnDoiMatKhau.setkEndColor(new Color(255, 255, 255));
        btnDoiMatKhau.setkStartColor(new Color(102, 102, 102));
        btnDoiMatKhau.setkFillBackground(false);
    }//GEN-LAST:event_lbDoiMatKhauMouseExited
// </editor-fold> //done
// <editor-fold defaultstate="collapsed" desc="Button Đổi Thông Tin">  

    public boolean checkRongDoiThongTin() {
        if (tfTenNguoiDung.getText().equals("") || tfEmail.getText().equals("") || tfNgaySinh.getDate() == null) {
            lbThongBaoThongTin.setText("Bạn Cần Nhập Đây Đủ Thông Tin");
            return false;
        } else {
            return true;
        }
    }
    private void lbDoiThongTinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDoiThongTinMouseClicked
        // TODO add your handling code here:
        if (checkRongDoiThongTin()) {
            ThongTin thongTin = new ThongTin(tfTenNguoiDung.getText(), tfEmail.getText(), new java.sql.Date(tfNgaySinh.getDate().getTime()));
            String messReponse = client.doiThongTin(thongTin);
            String thongBao = "";
            switch (messReponse) {
                case "fail":
                    thongBao = "Đổi Mật Khẩu Không Thành Công Mời Bạn Thử Lại \n";
                    break;
                default:
                    break;
                case "success":
                    JOptionPane.showMessageDialog(null, "Đổi Thông Tin Thành Công", "Đổi Thông Tin", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
            lbThongBaoMatKhau.setText(thongBao);
        }
    }//GEN-LAST:event_lbDoiThongTinMouseClicked

    private void lbDoiThongTinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDoiThongTinMouseEntered
        // TODO add your handling code here:
        lbDoiThongTin.setForeground(new Color(255, 255, 255));
        btnDoiThongTin.setkEndColor(new Color(255, 255, 255));
        btnDoiThongTin.setkStartColor(new Color(102, 102, 102));
        btnDoiThongTin.setkFillBackground(true);
    }//GEN-LAST:event_lbDoiThongTinMouseEntered

    private void lbDoiThongTinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDoiThongTinMouseExited
        // TODO add your handling code here:
        lbDoiThongTin.setForeground(new Color(204, 204, 204));
        btnDoiThongTin.setkEndColor(new Color(255, 255, 255));
        btnDoiThongTin.setkStartColor(new Color(102, 102, 102));
        btnDoiThongTin.setkFillBackground(false);
    }//GEN-LAST:event_lbDoiThongTinMouseExited
// </editor-fold> //done
// <editor-fold defaultstate="collapsed" desc="Button Thu Nhỏ Cửa Sổ">    
    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        // TODO add your handling code here:
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseEntered
        // TODO add your handling code here:
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_minus_35px_1.png")));
        btnMinimize.validate();
    }//GEN-LAST:event_btnMinimizeMouseEntered

    private void btnMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseExited

        // TODO add your handling code here:
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_minus_35px.png")));
        btnMinimize.validate();
    }//GEN-LAST:event_btnMinimizeMouseExited
    // </editor-fold> //done
// <editor-fold defaultstate="collapsed" desc="Button Đóng Cửa Sổ">    
    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(null, "Bạn Có Chắc Chắn Muốn Thoát", "Thoát", JOptionPane.YES_NO_OPTION);
        if (x == 0) {
            this.dispose();
            this.disable();
        }
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered
        // TODO add your handling code here:
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_multiply_35px_3.png")));
        btnClose.validate();
    }//GEN-LAST:event_btnCloseMouseEntered

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
        // TODO add your handling code here:
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_multiply_35px_2.png")));
        btnClose.validate();
    }//GEN-LAST:event_btnCloseMouseExited
    // </editor-fold> //done

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//                /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DangNhapForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DangNhapForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DangNhapForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DangNhapForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SuaThongTinForm().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClose;
    private keeptoo.KGradientPanel btnDoiMatKhau;
    private keeptoo.KGradientPanel btnDoiThongTin;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lbDoiMatKhau;
    private javax.swing.JLabel lbDoiThongTin;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbMatKhauCu;
    private javax.swing.JLabel lbMatKhauMoi;
    private javax.swing.JLabel lbNgaySinh;
    private javax.swing.JLabel lbTenNguoiDung;
    private javax.swing.JLabel lbThongBaoMatKhau;
    private javax.swing.JLabel lbThongBaoThongTin;
    private javax.swing.JLabel lbXacNhanMatKhau;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JPasswordField tfMatKhauCu;
    private javax.swing.JPasswordField tfMatKhauMoi;
    private org.jdesktop.swingx.JXDatePicker tfNgaySinh;
    private javax.swing.JTextField tfTenNguoiDung;
    private javax.swing.JPasswordField tfXNMatKhau;
    // End of variables declaration//GEN-END:variables
}
