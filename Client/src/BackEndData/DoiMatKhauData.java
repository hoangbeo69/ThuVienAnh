/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEndData;

import BackEndClass.TaiKhoan;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HiHi
 */
public class DoiMatKhauData {

    TaiKhoan taiKhoan;
    Socket socket;
    String matKhauMoi;

    public DoiMatKhauData(TaiKhoan taiKhoan, String matKhauMoi, Socket socket) {
        this.taiKhoan = taiKhoan;
        this.socket = socket;
        this.matKhauMoi = matKhauMoi;
    }

    public boolean guiData() {
        DataOutputStream output = null;
        try {
            output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF(taiKhoan.toString() + "$" + matKhauMoi);
            output.flush();
        } catch (IOException ex) {
            Logger.getLogger(DoiMatKhauData.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public String layData() {
        String result = "fail";
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            result = input.readUTF();
        } catch (IOException ex) {
            Logger.getLogger(DoiMatKhauData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
