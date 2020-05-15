/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerBUS;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import ServerDB.ServerDB;

/**
 *
 * @author HiHi
 */
public class DangNhapBUS {

    private String taiKhoan;
    private String matKhau;
    Socket socket;
    public DangNhapBUS(Socket socket) {
        this.socket = socket;
    }
    public boolean layDuLieuClient(){
        try {
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            byte[] byteRead = new byte[1024];
            input.read(byteRead,0,byteRead.length);
            String[] data = new String(byteRead).trim().split("\\$");
            taiKhoan = data[0];
            matKhau = data[1];
            System.out.println(taiKhoan + matKhau);
            return  true;
        } catch (IOException ex) {
            Logger.getLogger(DangNhapBUS.class.getName()).log(Level.SEVERE, null, ex);
            return  false;
        }
    }
    public boolean traDulieuClient(){
        ObjectOutputStream output = null;
        try {
            ServerDB serverDb = new ServerDB();
            String id = serverDb.checkDangNhap(taiKhoan,matKhau);
            output = new ObjectOutputStream(socket.getOutputStream());
            output.write(id.getBytes(),0,id.getBytes().length);
            output.flush();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(DangNhapBUS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
}
