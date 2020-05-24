/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerBUS;

import ServerClass.TaiKhoan;
import ServerClass.ThongTin;
import ServerDB.ServerDB;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HiHi
 */
public class DangKyBUS {

    Socket socket;
    TaiKhoan taiKhoan;
    ThongTin thongTin;

    public DangKyBUS(Socket socket) {
        this.socket = socket;
    }

    public boolean layDuLieuClient() {
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            String[] str1 = input.readUTF().split("\\$");
            thongTin = new ThongTin(str1[0], str1[1], java.sql.Date.valueOf(str1[2]));
            String[] str2 = input.readUTF().split("\\$");
            taiKhoan = new TaiKhoan(thongTin.getIdUser(),str2[0], str2[1]);
        } catch (IOException ex) {
            Logger.getLogger(DangKyBUS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean traDuLieuClient() {
        DataOutputStream outputStream = null;
        try {
            ServerDB serverDb = new ServerDB();
            outputStream = new DataOutputStream(socket.getOutputStream());
            boolean checkTaiKhoan = serverDb.checkTaiKhoan(taiKhoan.getTaiKhoan());
            boolean checkEmail = serverDb.checkEmail(thongTin.getEmail());
            if (checkEmail && checkTaiKhoan) {
                if (serverDb.themNguoiDung(thongTin) && serverDb.themTaiKhoan(taiKhoan)) {
                    outputStream.writeUTF("success");
                    return true;
                } else {
                    outputStream.writeUTF("fail");
                    return false;
                }
            }else{
                String mess;
                if(!checkEmail&&!checkTaiKhoan){
                    mess = "trung_taikhoan$trung_email";
                }else if(!checkEmail){
                    mess = "trung_email";
                }else {
                    mess = "trung_taikhoan";
                }
                outputStream.writeUTF(mess);
            }
        } catch (IOException ex) {
            Logger.getLogger(DangKyBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
