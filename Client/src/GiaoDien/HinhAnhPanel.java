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
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author HiHi
 */
public class HinhAnhPanel extends keeptoo.KGradientPanel {

    JLabel lbDate = new JLabel();
    JLabel lbTaiAnh = new JLabel();
    JLabel lbHinhAnh = new JLabel();
    JLabel lbTenAnh = new JLabel();
    JLabel lbXoaAnh = new JLabel();
    private ImageIcon img;
    private String idAnh ;

    public String getIdAnh() {
        return idAnh;
    }
    public HinhAnhPanel(String idAnh,String tenAnh, String dungLuong, String ngay) {
        this.idAnh = idAnh;
        this.setkBorderRadius(0);
        this.setBackground(new java.awt.Color(255, 255, 255));
        this.setkEndColor(new java.awt.Color(71, 74, 81));
        this.setkStartColor(new java.awt.Color(71, 74, 81));
        this.setMinimumSize(new java.awt.Dimension(273, 237));
        this.setPreferredSize(new java.awt.Dimension(273, 237));
        this.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/calendar_15px.png"))); // NOI18N
        lbDate.setText(ngay);
        lbDate.setForeground(new Color(136, 138, 143));
        this.add(lbDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 263, 30));

        lbTaiAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTaiAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/download_20px.png"))); // NOI18N
        lbTaiAnh.setVisible(false);
        this.add(lbTaiAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 30, 30));

        lbXoaAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbXoaAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete_25px.png"))); // NOI18N
        lbXoaAnh.setVisible(false);
        this.add(lbXoaAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 30, 30));

//        lbHinhAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageDemo/65954627_1025536354316241_7630705637017518080_n.jpg"))); // NOI18N
//        lbHinhAnh.setText("jLabel1");
//        this.add(lbHinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 273, 180));
        lbTenAnh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTenAnh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTenAnh.setText(tenAnh);
        lbTenAnh.setForeground(new Color(136, 138, 143));
        this.add(lbTenAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 263, 31));

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

        //thêm các sự kiện khi tương tác với lbTaiAnh
        lbTaiAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredTA(evt);
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MouseClickedTA(evt);
            }
        });

        lbXoaAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEnteredXA(evt);
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MouseClickedXA(evt);
            }
        });

    }
//###########################################
    //

    private void MouseEnteredPN(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        lbTaiAnh.setVisible(true);
        lbXoaAnh.setVisible(true);
        lbDate.setForeground(new Color(154, 154, 159));
        lbTenAnh.setForeground(new Color(154, 154, 159));
        this.setBackground(Color.cyan);
        this.setkEndColor(new java.awt.Color(103, 104, 111));
        this.setkStartColor(new java.awt.Color(103, 104, 111));
    }

    private void MouseExitedPN(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        lbTaiAnh.setVisible(false);
        lbXoaAnh.setVisible(false);
        lbDate.setForeground(new Color(136, 138, 143));
        lbTenAnh.setForeground(new Color(136, 138, 143));
        this.setBackground(Color.white);
        this.setkEndColor(new java.awt.Color(71, 74, 81));
        this.setkStartColor(new java.awt.Color(71, 74, 81));
    }

    private void MouseClickedPN(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

//    #########################################
    //sự kiện của btn tải ảnh
    private void MouseEnteredTA(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        lbTaiAnh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbTaiAnh.setVisible(true);
        this.setkEndColor(new java.awt.Color(103, 104, 111));
        this.setkStartColor(new java.awt.Color(103, 104, 111));
    }

    private void MouseClickedTA(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:

    }

//    #########################################
    //sự kiện của btn xóa ảnh
    private void MouseEnteredXA(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        lbXoaAnh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbXoaAnh.setVisible(true);
        this.setkEndColor(new java.awt.Color(103, 104, 111));
        this.setkStartColor(new java.awt.Color(103, 104, 111));
    }

    private void MouseClickedXA(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    public void setImageDisplay(ImageIcon imageIcon) {
        int height = 180;
        int width = 273;
        this.img = imageIcon;
        Image img2 = imageIcon.getImage().getScaledInstance(273, 180, 1);
        lbHinhAnh.setIcon(new ImageIcon(img2));
        lbHinhAnh.setText("Image");
        this.add(lbHinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 273, 180));
    }

    public ImageIcon getImg() {
        return img;
    }
    
}
