/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
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

    public String  dangNhap(String taiKhoan, String matKhau) {
        if (sendMessToServer("dang_nhap")) {
            String id  = null;
            if ( (id = new DangNhapWork(socket,taiKhoan, matKhau).checkDangNhap()) != null) {
                return  id ;
            }
            return null;
        }
        return null;
    }

}
