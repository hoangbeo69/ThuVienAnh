/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GiaoDien;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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
    private String idAnh;
    private String name;
    byte[] arrayImage;

    public String getIdAnh() {
        return idAnh;
    }

    public HinhAnhPanel(String idAnh, String tenAnh, String dungLuong, String ngay) {
        this.idAnh = idAnh;
        this.name = tenAnh;
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
    //sự kiện khi di chuột vào panel ảnh

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

    //sự kiện khi di chuột ra khỏi panel ảnh
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

    //sự kiện khi nhấp chuột vào ảnh
    private void MouseClickedPN(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

//    #########################################
    //sự kiện khi di chuyển chuột vào button tải ảnh
    private void MouseEnteredTA(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        lbTaiAnh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbTaiAnh.setVisible(true);
        this.setkEndColor(new java.awt.Color(103, 104, 111));
        this.setkStartColor(new java.awt.Color(103, 104, 111));
    }

    //sự kiện khi di chuyển chuột ra khỏi button tải ảnh
    private void MouseClickedTA(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        String pathFile = layDuongDanSave();
        if (writeToFile(pathFile)) {
            JOptionPane.showMessageDialog(null, "Lưu Ảnh Thành Công", "Lưu Ảnh", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Lưu Ảnh Không Thành Công", "Lưu Ảnh", JOptionPane.INFORMATION_MESSAGE);
        }
    }

//    #########################################
    //sự kiện khi di chuột vào button xóa ảnh
    private void MouseEnteredXA(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        lbXoaAnh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbXoaAnh.setVisible(true);
        this.setkEndColor(new java.awt.Color(103, 104, 111));
        this.setkStartColor(new java.awt.Color(103, 104, 111));
    }

    //sự kiện khi di chuột ra khỏi button xóa ảnh
    private void MouseClickedXA(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(null, "Bạn Xác Nhận Muốn Xóa", "Xóa Ảnh", JOptionPane.YES_NO_OPTION);
        if (x == 0) {
            if (MainControl.deleteImage(idAnh)) {
                JOptionPane.showMessageDialog(null, "Xóa Ảnh Thành Công", "Xóa Ảnh", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Xóa Ảnh Thành Công", "Xóa Ảnh", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }

    //hàm set ảnh cho panel
    public void setImageDisplay(byte[] data) {
        BufferedImage bufImg = null;
        this.arrayImage = data;
        try {
            bufImg = ImageIO.read(new ByteArrayInputStream(data));
            ImageIcon imageIcon = new ImageIcon(bufImg);
//            int height = 180;
//            int width = 273;
            Image img2 = imageIcon.getImage().getScaledInstance(273, 180, 1);
            lbHinhAnh.setIcon(new ImageIcon(img2));
            lbHinhAnh.setText("Image");
            this.add(lbHinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 273, 180));
        } catch (IOException ex) {
            Logger.getLogger(HinhAnhPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //hàm mở cửa sổ chọn đường dẫn để save
    private String layDuongDanSave() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn Hình Ảnh Mới"); //tiêu đề
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png"));//lọc dạng
        fileChooser.setAcceptAllFileFilterUsed(true);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // chỉ lấy file không lấy thư mục
        fileChooser.setLocation(200, 200);
        fileChooser.setSelectedFile(new File(System.getProperty("user.dir") + "/" + this.getName()));
        int choice = fileChooser.showSaveDialog(this);
        if (choice == fileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            return fileToSave.getAbsolutePath();
        }
        return null;
    }

    //hàm ghi file vào đường dẫn đã đc chọn
    public boolean writeToFile(String path) {
        try {
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(new File(path)));
            output.write(arrayImage, 0, arrayImage.length);
            output.close();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HinhAnhPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HinhAnhPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
