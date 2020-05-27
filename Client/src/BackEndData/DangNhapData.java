/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEndData;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HiHi
 */
public class DangNhapData {

    private String taiKhoan;
    private String matKhau;
    private Socket socket;

    public DangNhapData(Socket socket, String taiKhoan, String matKhau) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.socket = socket;
    }

    public String kiemTraDangNhap() {
        String data = taiKhoan + "$" + matKhau;
        String id = null;
        if (guiData(data) ) {
            id = layData();
            return id;
        }
        return id;
    }

    private boolean guiData(String data) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

            output.write(data.getBytes(), 0, data.getBytes().length);
            output.flush();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(DangNhapData.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    private String layData() {
        ObjectInputStream input = null;
        String id = null ;
        try {
            input = new ObjectInputStream(socket.getInputStream());
            byte[] dataRead = new byte[1024];

            input.read(dataRead, 0, dataRead.length);
            id =  new String(dataRead).trim();
        } catch (IOException ex) {
            Logger.getLogger(DangNhapData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
}
