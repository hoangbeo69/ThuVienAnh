/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEndData;

import BackEndClass.TaiKhoan;
import BackEndClass.ThongTin;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HiHi
 */
public class DangKyData {

    Socket socket;
    TaiKhoan taiKhoan;
    ThongTin thongTin;

    public DangKyData(TaiKhoan taiKhoan, ThongTin thongTin, Socket socket) {
        this.socket = socket;
        this.taiKhoan = taiKhoan;
        this.thongTin = thongTin;

    }

    public boolean guiData() {
        DataOutputStream output = null;
        try {
            output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF(thongTin.toString());
            output.flush();
            output.writeUTF(taiKhoan.toString());
            output.flush();
        } catch (IOException ex) {
            Logger.getLogger(DangKyData.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public String[] layData() {
        DataInputStream input = null;
        String[] dataIn = null;
        try {
            input = new DataInputStream(socket.getInputStream());
            dataIn = input.readUTF().split("\\$");
        } catch (IOException ex) {
            Logger.getLogger(DangKyData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataIn;
    }

}
