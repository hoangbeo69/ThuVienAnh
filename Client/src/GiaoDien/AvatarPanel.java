/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GiaoDien;

import java.awt.Color;
import java.awt.Cursor;
import static java.awt.Cursor.HAND_CURSOR;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author HiHi
 */
public class AvatarPanel extends keeptoo.KGradientPanel {

    JLabel lbDate = new JLabel();
    JLabel lbDownLoad = new JLabel();
    JLabel lbHinhAnh = new JLabel();
    JLabel lbTenAnh = new JLabel();

    public AvatarPanel(String tenAnh, String dungLuong, String ngay, String gio) {

        this.setkBorderRadius(0);
        this.setBackground(new java.awt.Color(255, 255, 255));
        this.setkEndColor(new java.awt.Color(71, 74, 81));
        this.setkStartColor(new java.awt.Color(71, 74, 81));
        this.setMinimumSize(new java.awt.Dimension(273, 237));
        this.setPreferredSize(new java.awt.Dimension(273, 237));
        this.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/calendar_15px.png"))); // NOI18N
        lbDate.setText("20/11/2020");
        lbDate.setForeground(new Color(136, 138, 143));
        this.add(lbDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 180, 30));

        lbDownLoad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDownLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/download_20px.png"))); // NOI18N
        lbDownLoad.setVisible(false);
        this.add(lbDownLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 30, 30));

        lbHinhAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/2608782.jpg"))); // NOI18N
        lbHinhAnh.setText("jLabel1");
        this.add(lbHinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 273, 180));

        lbTenAnh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTenAnh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTenAnh.setText("Hinhanh.jpg");
        lbTenAnh.setForeground(new Color(136, 138, 143));
        this.add(lbTenAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 220, 31));

        //thêm các sự kiện khi tương tac với panel ảnh
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredPN(evt);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedPN(evt);
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MouseClickedPN(evt);
            }
        });

        //thêm các sự kiện khi tương tác với lbDownload
        lbDownLoad.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredDL(evt);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExitedDL(evt);
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MouseClickedDL(evt);
            }
        });

    }
//###########################################
    //

    private void MouseEnteredPN(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        lbDownLoad.setVisible(true);
        lbDate.setForeground(new Color(154, 154, 159));
        lbTenAnh.setForeground(new Color(154, 154, 159));
        this.setBackground(Color.cyan);
        this.setkEndColor(new java.awt.Color(103, 104, 111));
        this.setkStartColor(new java.awt.Color(103, 104, 111));
    }

    private void MouseExitedPN(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        lbDownLoad.setVisible(false);
        lbDate.setForeground(new Color(136, 138, 143));
        lbTenAnh.setForeground(new Color(136, 138, 143));
        this.setBackground(Color.white);
        this.setkEndColor(new java.awt.Color(71, 74, 81));
        this.setkStartColor(new java.awt.Color(71, 74, 81));
    }

    private void MouseClickedPN(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        lbDate.setVisible(true);
    }

//    #########################################
    //
    private void MouseEnteredDL(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        lbDownLoad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbDownLoad.setVisible(true);
        this.setkEndColor(new java.awt.Color(103, 104, 111));
        this.setkStartColor(new java.awt.Color(103, 104, 111));
    }

    private void MouseExitedDL(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void MouseClickedDL(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        lbDate.setVisible(true);
    }

}
