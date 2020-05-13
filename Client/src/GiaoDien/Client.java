/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GiaoDien;

import BackEndClass.HinhAnh;
import BackEndData.ListHinhAnhData;
import GiaoDien.DangNhap.DangNhapConnection;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
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

    public Client() {
        try {
            socket = new Socket("localhost", 5555);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //hàm gửi yêu cầu tới server
    public boolean sendMessToServer(String act) {
        try {
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            outputStream.writeUTF(act);
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
                return id;
            }
            return null;
        }
        return null;
    }

    public ArrayList<HinhAnh> getDanhSachAnh(String id) {
        ArrayList<HinhAnh> dsha = null;
        if(sendMessToServer("gui_list_anh")){
        try {
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            ListHinhAnhData lha = new ListHinhAnhData(id, input, output);
            if (lha.guiData()) {
                dsha = lha.layData();
            }

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return dsha;
    }
}
