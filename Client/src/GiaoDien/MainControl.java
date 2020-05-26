/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GiaoDien;

import java.awt.Color;
import BackEndClass.HinhAnh;
import Client.Client;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author HiHi
 */
public class MainControl extends javax.swing.JFrame {

    /**
     * Creates new form MainControl
     */
    static public Client client;
    String taiKhoan;
    static private ArrayList<HinhAnh> danhSachAnh;
    private Boolean NEWEST = true;
    private int currentPage = 1;
    private int currentDungLuong = 0;

//Tạo Giao diện chính của chương trình
    public MainControl(Client client, String taiKhoan, String id) {
        this.client = client;
        this.taiKhoan = taiKhoan;
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
        this.setUndecorated(true);
        this.initComponents();
        this.setSize(1315, 755);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setBackground(new Color(0, 0, 0, 0));

        lbTenTaiKhoan.setText(taiKhoan.substring(0, 1).toUpperCase() + taiKhoan.substring(1)); //set tên tài khoản vào lbTenTaiKhoan
        danhSachAnh = client.getDanhSachAnh(); //nhận danh sách ảnh từ server
        if (danhSachAnh.size() != 0) {
            setDungLuong();
            sortFirstList();
            DisplayFirstPageImage();
        }
    }

    //kiểm tra dung lượng đã sử dụng
    public void setDungLuong() {
        for (HinhAnh ha : danhSachAnh) {
            currentDungLuong += ha.getDungluong();
        }
        float percent = (float) currentDungLuong / 104857600;
        lbDungLuong.setText("Dung lượng đã sử dụng " + String.format("%.2f", percent * 100) + "% của 100 MB");
    }

    //show list những ảnh tại page 1
    public void DisplayFirstPageImage() {
        currentPage =1;
        if (NEWEST) {
            sortFirstList();
        } else {
            sortLatestList();
        }
        if (danhSachAnh.size() > 8) {
            newDisplayImage(0, 7);
            panelHinhAnh.validate();
        } else {
            newDisplayImage(0, danhSachAnh.size() - 1);
            panelHinhAnh.validate();
        }
    }

    //thay đổi lbCountTrang khi nhấn next hoặc prev
    public void setPageCount(int count) {
        lbPageCount.setText("" + count);
        lbPageCount.validate();
    }

    //lấy danh danh sách các hình ảnh được hiển thị trong list từ vị trí start đên end    
    public void newDisplayImage(int start, int end) {

        //xóa tất cả phân tử có trong panelHinhanh và vẽ lại từ đầu
        panelHinhAnh.removeAll();
        panelHinhAnh.repaint();
        panelHinhAnh.validate();
        for (int i = start; i <= end; i++) {
            HinhAnh ha = (HinhAnh) danhSachAnh.get(i);
            addNewPanelAnh(ha);
        }
    }

    //tạo mới panel ảnh và thêm vào giao diện
    public void addNewPanelAnh(HinhAnh ha) {
        HinhAnhPanel hap = new HinhAnhPanel(ha.getId(), ha.getName(), ha.getDungluong() + "", ha.getDate().toString());
        panelHinhAnh.add(hap);

        new addImageToPanel(hap).start(); // cho chạy 1 luồng để set hình ảnh cho panel
    }

    // luồng hàm set ảnh cho panel ảnh
    class addImageToPanel implements Runnable {

        HinhAnhPanel hap;
        Thread t1;

        public addImageToPanel(HinhAnhPanel hap) {
            this.hap = hap;
        }

        @Override
        public void run() {
            byte[] data = client.getHinhAnh(hap.getIdAnh()); //lấy byte data của image
            if (data.length != 0) {
                data = client.getHinhAnh(hap.getIdAnh());
                hap.setImageDisplay(data);
                hap.validate();
            } else {
                System.out.println("Không nhận đc data");
            }
        }

        public void start() {
            if (t1 == null) {
                t1 = new Thread(this);
                t1.start();
            }
        }
    }

    //Xóa 1 ảnh 
    static boolean deleteImage(String idAnh) {
        if (client.xoaHinhAnh(idAnh)) {
            setDanhSachAnh(client.getDanhSachAnh());
            return true;

        } else {
            return false;
        }
    }

    //sắp xếp danh sách ảnh theo ngày mới đễn cũ
    public void sortFirstList() {
        Collections.sort(danhSachAnh, new Comparator<HinhAnh>() {
            @Override
            public int compare(HinhAnh o1, HinhAnh o2) {
                if (o1.getDate().compareTo(o2.getDate()) == 0) {
                    return 0;
                } else if (o1.getDate().compareTo(o2.getDate()) == 1) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
        );
    }

    //sắp xếp danh sách ảnh theo ngày cũ đến mới
    public void sortLatestList() {
        Collections.sort(danhSachAnh, new Comparator<HinhAnh>() {
            @Override
            public int compare(HinhAnh o1, HinhAnh o2) {
                if (o1.getDate().compareTo(o2.getDate()) == 0) {
                    return 0;
                } else if (o1.getDate().compareTo(o2.getDate()) == 1) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHead = new javax.swing.JPanel();
        lbTenTaiKhoan = new javax.swing.JLabel();
        lbDungLuong = new javax.swing.JLabel();
        btnChinhSua = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JLabel();
        btnLogout = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbBackground = new javax.swing.JLabel();
        panelNextPage = new javax.swing.JPanel();
        lbPageCount = new javax.swing.JLabel();
        btnDoublePrev = new javax.swing.JLabel();
        btnNext = new javax.swing.JLabel();
        btnDoubleNext = new javax.swing.JLabel();
        btnPrev = new javax.swing.JLabel();
        panelFunction = new javax.swing.JPanel();
        btnSortImgae = new javax.swing.JLabel();
        btnThemAnh = new javax.swing.JLabel();
        panelBackGround = new keeptoo.KGradientPanel();
        panelHinhAnh = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1315, 760));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHead.setMaximumSize(new java.awt.Dimension(1314, 135));
        panelHead.setMinimumSize(new java.awt.Dimension(1314, 135));
        panelHead.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTenTaiKhoan.setFont(new java.awt.Font("Dialog", 1, 26)); // NOI18N
        lbTenTaiKhoan.setForeground(new java.awt.Color(204, 204, 204));
        lbTenTaiKhoan.setText("Hoangbeo69");
        panelHead.add(lbTenTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 200, 50));

        lbDungLuong.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbDungLuong.setForeground(new java.awt.Color(204, 204, 204));
        panelHead.add(lbDungLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 430, 30));

        btnChinhSua.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnChinhSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_edit_property_25px.png"))); // NOI18N
        btnChinhSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChinhSuaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnChinhSuaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnChinhSuaMouseExited(evt);
            }
        });
        panelHead.add(btnChinhSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 30, 30));

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
        panelHead.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 0, 40, 40));

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
        panelHead.add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 0, 40, 40));

        btnLogout.setBackground(new java.awt.Color(255, 255, 255));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/logout_rounded_left_35px_2.png"))); // NOI18N
        btnLogout.setText(" ");
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogoutMouseExited(evt);
            }
        });
        panelHead.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 0, 40, 40));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/circle-cropped.png"))); // NOI18N
        panelHead.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 120, 120));

        lbBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/CoverPage.png"))); // NOI18N
        panelHead.add(lbBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1315, 135));

        getContentPane().add(panelHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1315, 135));

        panelNextPage.setBackground(new java.awt.Color(25, 30, 49));
        panelNextPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbPageCount.setBackground(new java.awt.Color(153, 153, 153));
        lbPageCount.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbPageCount.setForeground(new java.awt.Color(255, 255, 255));
        lbPageCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPageCount.setText("1");
        panelNextPage.add(lbPageCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 35, 35));

        btnDoublePrev.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnDoublePrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_double_left_30px_1.png"))); // NOI18N
        btnDoublePrev.setText("jLabel2");
        btnDoublePrev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDoublePrevMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDoublePrevMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDoublePrevMouseExited(evt);
            }
        });
        panelNextPage.add(btnDoublePrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 35, 35));

        btnNext.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_forward_30px_3.png"))); // NOI18N
        btnNext.setText("jLabel2");
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNextMouseExited(evt);
            }
        });
        panelNextPage.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 35, 35));

        btnDoubleNext.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnDoubleNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_double_right_30px_1.png"))); // NOI18N
        btnDoubleNext.setText("jLabel2");
        btnDoubleNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDoubleNextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDoubleNextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDoubleNextMouseExited(evt);
            }
        });
        panelNextPage.add(btnDoubleNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 35, 35));

        btnPrev.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_back_30px_1.png"))); // NOI18N
        btnPrev.setText("jLabel2");
        btnPrev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrevMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrevMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPrevMouseExited(evt);
            }
        });
        panelNextPage.add(btnPrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 35, 35));

        getContentPane().add(panelNextPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 707, 1315, 55));

        panelFunction.setBackground(new java.awt.Color(6, 18, 52));
        panelFunction.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnSortImgae.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnSortImgae.setForeground(new java.awt.Color(204, 204, 204));
        btnSortImgae.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSortImgae.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_sort_down_30px_1.png"))); // NOI18N
        btnSortImgae.setText("Mới Nhất");
        btnSortImgae.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSortImgaeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSortImgaeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSortImgaeMouseExited(evt);
            }
        });

        btnThemAnh.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnThemAnh.setForeground(new java.awt.Color(204, 204, 204));
        btnThemAnh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnThemAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_add_image_30px_1.png"))); // NOI18N
        btnThemAnh.setText("Thêm Mới");
        btnThemAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemAnhMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnThemAnhMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnThemAnhMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelFunctionLayout = new javax.swing.GroupLayout(panelFunction);
        panelFunction.setLayout(panelFunctionLayout);
        panelFunctionLayout.setHorizontalGroup(
            panelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFunctionLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(btnThemAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 979, Short.MAX_VALUE)
                .addComponent(btnSortImgae, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        panelFunctionLayout.setVerticalGroup(
            panelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFunctionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThemAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSortImgae, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(panelFunction, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 135, 1315, 50));

        panelBackGround.setkBorderRadius(0);
        panelBackGround.setkEndColor(new java.awt.Color(25, 30, 49));
        panelBackGround.setkGradientFocus(0);
        panelBackGround.setkStartColor(new java.awt.Color(9, 20, 51));
        panelBackGround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHinhAnh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        panelHinhAnh.setMaximumSize(new java.awt.Dimension(1225, 527));
        panelHinhAnh.setMinimumSize(new java.awt.Dimension(1225, 527));
        panelHinhAnh.setName(""); // NOI18N
        panelHinhAnh.setOpaque(false);
        panelHinhAnh.setPreferredSize(new java.awt.Dimension(1315, 527));
        panelHinhAnh.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 45, 45));
        panelBackGround.add(panelHinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 1315, 620));

        getContentPane().add(panelBackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1315, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
//<editor-fold defaultstate="collapsed" desc="Getter setter danh sach anh">

    public ArrayList<HinhAnh> getDanhSachAnh() {
        return danhSachAnh;
    }

    static void setDanhSachAnh(ArrayList<HinhAnh> danhSanh) {
        danhSachAnh = danhSanh;
    }

//        //</editor-fold> //done
// <editor-fold defaultstate="collapsed" desc="Button chỉnh sửa thông tin">     
    private void btnChinhSuaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChinhSuaMouseEntered
        // TODO add your handling code here:

        btnChinhSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_edit_property_25px_1.png")));
        btnChinhSua.validate();
    }//GEN-LAST:event_btnChinhSuaMouseEntered

    private void btnChinhSuaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChinhSuaMouseExited
        // TODO add your handling code here:
        btnChinhSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_edit_property_25px.png")));
        btnChinhSua.validate();
    }//GEN-LAST:event_btnChinhSuaMouseExited

    private void btnChinhSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChinhSuaMouseClicked
        // TODO add your handling code here:
        new SuaThongTinForm(taiKhoan,client).setVisible(true);
    }//GEN-LAST:event_btnChinhSuaMouseClicked
    // </editor-fold>  
// <editor-fold defaultstate="collapsed" desc="Button Logout">   
    //btn đăng xuất
    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(null, "Bạn Có Chắc Chắn Đăng Xuất", "Đăng Xuất", JOptionPane.YES_NO_OPTION);
        if (option == 0) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new DangNhapForm().setVisible(true);
                }
            });
            this.dispose();
            this.disable();
        }
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
        // TODO add your handling code here:
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_logout_rounded_left_35px_3.png")));
        btnLogout.validate();
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        // TODO add your handling code here:
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/logout_rounded_left_35px_2.png")));
        btnLogout.validate();
    }//GEN-LAST:event_btnLogoutMouseExited
    // </editor-fold>  //done
// <editor-fold defaultstate="collapsed" desc="Button Thu gọn cửa sổ"> 
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
// <editor-fold defaultstate="collapsed" desc="Button Tắt cửa sổ chương trình">
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
// <editor-fold defaultstate="collapsed" desc="Button Sắp xếp danh sách ảnh">
    private void btnSortImgaeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSortImgaeMouseClicked
        // TODO add your handling code here:
        if (NEWEST) {
            NEWEST = false;
            btnSortImgae.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_sort_up_30px_1.png")));
            btnSortImgae.setText("Cũ Nhất");
            sortLatestList();
            DisplayFirstPageImage();
            btnSortImgae.validate();
        } else {
            NEWEST = true;
            btnSortImgae.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_sort_down_30px_1.png")));
            btnSortImgae.setText("Mới Nhất");
            sortFirstList();
            DisplayFirstPageImage();
            btnSortImgae.validate();
        }
    }//GEN-LAST:event_btnSortImgaeMouseClicked

    private void btnSortImgaeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSortImgaeMouseEntered
        // TODO add your handling code here:
        btnSortImgae.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnSortImgaeMouseEntered

    private void btnSortImgaeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSortImgaeMouseExited
        // TODO add your handling code here:
        btnSortImgae.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_btnSortImgaeMouseExited
    // </editor-fold> //done
// <editor-fold defaultstate="collapsed" desc="Button Thêm ảnh">
    private void btnThemAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemAnhMouseClicked
        // TODO add your handling code here:
        HinhAnh ha;
        if ((ha = themHinhAnhMoi()) != null) {
            if (client.guiAnhMoi(ha)) {
                this.setOpacity(0.95f);
                JOptionPane.showMessageDialog(null, "Lưu Ảnh Mới Thành Công", "Lưu Ảnh", JOptionPane.INFORMATION_MESSAGE);
                this.setOpacity(1f);
                danhSachAnh = client.getDanhSachAnh();
                DisplayFirstPageImage();
            } else {
                this.setOpacity(0.95f);
                JOptionPane.showMessageDialog(null, "Lưu Ảnh Mới Không Thành Công", "Lưu Ảnh", JOptionPane.ERROR_MESSAGE);
                this.setOpacity(1f);
            }

        }
    }//GEN-LAST:event_btnThemAnhMouseClicked
    //mở của sổ để chọn file cần lưu
    private HinhAnh themHinhAnhMoi() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn Hình Ảnh Mới"); //tiêu đề
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png"));//lọc dạng
        fileChooser.setAcceptAllFileFilterUsed(true);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // chỉ lấy file không lấy thư mục
        fileChooser.setLocation(200, 200);
        int choice = fileChooser.showOpenDialog(this);
        if (choice == fileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            // String tenAnh = fileToSave.getName();
            int dungLuong = (int) fileToSave.length();
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            Random r = new Random();
            String idAnh = "IMG" + r.nextInt(99999);
            return new HinhAnh(idAnh, fileToSave.getPath(), dungLuong, date); //tạm thời file path là ten anh de su dung file path tiện hơn khi đọc và sửa sau
        }
        return null;
    }

    private void btnThemAnhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemAnhMouseEntered
        // TODO add your handling code here:
        btnThemAnh.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnThemAnhMouseEntered

    private void btnThemAnhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemAnhMouseExited
        // TODO add your handling code here:
        btnThemAnh.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_btnThemAnhMouseExited
    // </editor-fold> //done
// <editor-fold defaultstate="collapsed" desc="Button Đến trang cuối">

    private void btnDoubleNextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoubleNextMouseEntered
        // TODO add your handling code here:
        btnDoubleNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_double_right_30px.png")));
        btnDoubleNext.validate();
    }//GEN-LAST:event_btnDoubleNextMouseEntered

    private void btnDoubleNextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoubleNextMouseExited
        // TODO add your handling code here:
        btnDoubleNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_double_right_30px_1.png")));
        btnDoubleNext.validate();
    }//GEN-LAST:event_btnDoubleNextMouseExited

    private void btnDoubleNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoubleNextMouseClicked
        // TODO add your handling code here:
        if (danhSachAnh.size() % 8 == 0) {
            this.currentPage = danhSachAnh.size() / 8;
            setPageCount(currentPage);
            newDisplayImage((currentPage - 1) * 8, currentPage * 8 - 1);
            panelHinhAnh.validate();
        } else {
            this.currentPage = danhSachAnh.size() / 8;
            setPageCount(currentPage + 1);
            newDisplayImage((currentPage) * 8, currentPage * 8 + (danhSachAnh.size() % 8) - 1);
            panelHinhAnh.validate();
        }
    }//GEN-LAST:event_btnDoubleNextMouseClicked

    // </editor-fold> //done
// <editor-fold defaultstate="collapsed" desc="Button Đến trang sau">

    private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked
        // TODO add your handling code here:
        if (danhSachAnh.size() > (this.currentPage * 8)) {
            ++this.currentPage;
            setPageCount(currentPage);
            if (danhSachAnh.size() > (this.currentPage * 8)) {

                newDisplayImage((this.currentPage - 1) * 8, this.currentPage * 8 - 1);
                panelHinhAnh.validate();
            } else {
                newDisplayImage((this.currentPage - 1) * 8, danhSachAnh.size() - 1);
                panelHinhAnh.validate();
            }
        }

    }//GEN-LAST:event_btnNextMouseClicked

    private void btnNextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseEntered
        // TODO add your handling code here:
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_forward_30px.png")));
        btnNext.validate();
    }//GEN-LAST:event_btnNextMouseEntered

    private void btnNextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseExited
        // TODO add your handling code here:
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_forward_30px_3.png")));
        btnNext.validate();
    }//GEN-LAST:event_btnNextMouseExited

// </editor-fold> //done
// <editor-fold defaultstate="collapsed" desc="Button đến trang trước">
    private void btnPrevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevMouseClicked
        // TODO add your handling code here:
        if (this.currentPage > 1) {
            --this.currentPage;
            setPageCount(this.currentPage);
            newDisplayImage((this.currentPage - 1) * 8, this.currentPage * 8 - 1);
            panelHinhAnh.validate();
        }
    }//GEN-LAST:event_btnPrevMouseClicked

    private void btnPrevMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevMouseExited
        // TODO add your handling code here:
        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_back_30px_1.png")));
        btnPrev.validate();
    }//GEN-LAST:event_btnPrevMouseExited

    private void btnPrevMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevMouseEntered
        // TODO add your handling code here:
        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_back_30px.png")));
        btnPrev.validate();
    }//GEN-LAST:event_btnPrevMouseEntered
    // </editor-fold> //done
// <editor-fold defaultstate="collapsed" desc="Button Đến trang đầu">
    private void btnDoublePrevMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoublePrevMouseExited
        // TODO add your handling code here:
        btnDoublePrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_double_left_30px_1.png")));
        btnDoublePrev.validate();
    }//GEN-LAST:event_btnDoublePrevMouseExited

    private void btnDoublePrevMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoublePrevMouseEntered
        // TODO add your handling code here:
        btnDoublePrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGiaoDien/icons8_double_left_30px.png")));
        btnDoublePrev.validate();
    }//GEN-LAST:event_btnDoublePrevMouseEntered

    private void btnDoublePrevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoublePrevMouseClicked
        // TODO add your handling code here:
        setPageCount(1);
        if (danhSachAnh.size() > 8) {
            newDisplayImage(0, 7);
            panelHinhAnh.validate();
        } else {
            newDisplayImage(0, danhSachAnh.size() - 1);
            panelHinhAnh.validate();
        }
    }//GEN-LAST:event_btnDoublePrevMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        for (double i = 0.0; i <= 1.0; i = i + 0.1) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_formWindowOpened
    // </editor-fold> // done

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnChinhSua;
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel btnDoubleNext;
    private javax.swing.JLabel btnDoublePrev;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JLabel btnNext;
    private javax.swing.JLabel btnPrev;
    private javax.swing.JLabel btnSortImgae;
    private javax.swing.JLabel btnThemAnh;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbBackground;
    private javax.swing.JLabel lbDungLuong;
    private javax.swing.JLabel lbPageCount;
    private javax.swing.JLabel lbTenTaiKhoan;
    private keeptoo.KGradientPanel panelBackGround;
    private javax.swing.JPanel panelFunction;
    private javax.swing.JPanel panelHead;
    private javax.swing.JPanel panelHinhAnh;
    private javax.swing.JPanel panelNextPage;
    // End of variables declaration//GEN-END:variables

}
