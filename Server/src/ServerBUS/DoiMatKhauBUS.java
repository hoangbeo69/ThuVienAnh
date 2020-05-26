/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerBUS;

import ServerClass.TaiKhoan;
import ServerDB.ServerDB;
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
public class DoiMatKhauBUS {

    Socket socket;
    TaiKhoan taiKhoan;
    String matKhauMoi;
    public DoiMatKhauBUS(Socket socket) {
        this.socket = socket;
    }

    public boolean layDuLieuClient() {
        DataInputStream input = null;
        try {
            input = new DataInputStream(socket.getInputStream());
            String data= input.readUTF();
            String[] dataArray = data.split("\\$");
            this.taiKhoan = new TaiKhoan(dataArray[0], dataArray[1], dataArray[2]);
            this.matKhauMoi = dataArray[3];
        } catch (IOException ex) {
            Logger.getLogger(DoiMatKhauBUS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
        return  true;
    }

    public void traDuLieuClient() {
        DataOutputStream output = null;
        try {
            ServerDB serverDB = new ServerDB();
            output = new DataOutputStream(socket.getOutputStream());
            if(serverDB.checkDangNhap(taiKhoan.getTaiKhoan(),taiKhoan.getMatKhau()).equals("null")){ 
                output.writeUTF("sai_mat_khau");
            }else{
                if(serverDB.updateMatKhau(taiKhoan.getIdUser(),matKhauMoi)){
                    output.writeUTF("success");
                }else{
                    output.writeUTF("fail");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(DoiMatKhauBUS.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

}
