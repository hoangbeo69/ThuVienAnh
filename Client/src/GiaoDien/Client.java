/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GiaoDien;

import BackEndClass.HinhAnh;
import BackEndData.GuiHinhAnhData;
import BackEndData.HinhAnhData;
import BackEndData.ListHinhAnhData;
import BackEndData.XoaAnhData;
import GiaoDien.DangNhap.DangNhapConnection;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HiHi
 */
public class Client {

    Socket socket;
    String userID;
    DataOutputStream outputStream;

    public Client() {
        try {
            this.socket = new Socket("localhost", 5555);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //hàm gửi yêu cầu tới server
    synchronized public boolean sendMessToServer(String act) {
        try {
            outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF(act);
            outputStream.flush();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public String dangNhap(String taiKhoan, String matKhau) {
        if (sendMessToServer("dang_nhap")) {
            String id = null;
            if ((id = new DangNhapConnection(socket, taiKhoan, matKhau).checkDangNhap()) != null) {
                this.userID = id;
                return id;
            }
            return null;
        }
        return null;
    }

    public ArrayList<HinhAnh> getDanhSachAnh() {
        ArrayList<HinhAnh> dsha = null;
        if (sendMessToServer("gui_list_anh")) {
            ListHinhAnhData lha = new ListHinhAnhData(userID, socket);
            if (lha.guiData()) {
                dsha = lha.layData();
            }

        }
        return dsha;
    }

    synchronized public byte [] getHinhAnh(String idAnh) {
        byte [] data = null;
        if (sendMessToServer("gui_anh")) {
            HinhAnhData had = new HinhAnhData(userID, idAnh, socket);
            if (had.guiData()) {
                data = had.layData();
            }
        }
        return data;
    }

    boolean guiAnhMoi(HinhAnh ha) {
        if (sendMessToServer("them_anh")) {
            GuiHinhAnhData ghad = new GuiHinhAnhData(userID, ha, socket);
            if (ghad.guiData()) {
                if(ghad.layData()){
                    return  true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }

    public  boolean xoaHinhAnh(String idAnh) {
        if(sendMessToServer("xoa_anh")){
            XoaAnhData xadt = new XoaAnhData(userID,idAnh,socket);
                if(xadt.guiData()){
                    if(xadt.layData()){
                        return true;
                    }else{
                        return false;
                    }
            }
        }
        return false;
    }
}
