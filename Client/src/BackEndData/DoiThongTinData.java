package BackEndData;

import BackEndClass.ThongTin;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HiHi
 */
public class DoiThongTinData {

    ThongTin thongTin;
    Socket socket;

    public DoiThongTinData(ThongTin thongTin, Socket socket) {
        this.socket = socket ;
        this.thongTin  = thongTin;
    }

    public boolean guiData() {
        DataOutputStream output = null;
        try {
            output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF(thongTin.toString());
            output.flush();
        } catch (IOException ex) {
            Logger.getLogger(DoiThongTinData.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
        return true;
    }

    public String layData() {
        String mess = "fail";
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
             mess  =input.readUTF();
        } catch (IOException ex) {
            Logger.getLogger(DoiThongTinData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  mess;
    }

}
