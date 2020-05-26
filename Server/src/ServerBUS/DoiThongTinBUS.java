/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerBUS;

import ServerClass.ThongTin;
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
public class DoiThongTinBUS {

    Socket socket;
    ThongTin thongTin;
    public DoiThongTinBUS(Socket socket) {
        this.socket = socket;
    }

    public boolean layDuLieuClient() {
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            String data = input.readUTF();
            String[] dataArray = data.split("\\$");
             this.thongTin = new ThongTin(dataArray[0],dataArray[1],dataArray[2],java.sql.Date.valueOf(dataArray[3]));
            
        } catch (IOException ex) {
            Logger.getLogger(DoiThongTinBUS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public void traDuLieuClient() {
        DataOutputStream output = null;
        try {
            ServerDB serverDB = new ServerDB();
            output = new DataOutputStream(socket.getOutputStream());
            if(serverDB.updateThongTin(thongTin)){
                output.writeUTF("success");
            }else{
                output.writeUTF("fail");
            }
            output.flush();
        } catch (IOException ex) {
            Logger.getLogger(DoiThongTinBUS.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

}
