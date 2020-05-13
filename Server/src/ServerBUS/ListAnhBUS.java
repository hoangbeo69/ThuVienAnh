/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerBUS;

import ServerDB.ServerDB;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
public class ListAnhBUS {

    Socket socket;
    String id;

    public ListAnhBUS(Socket socket) {
        this.socket = socket;
    }

    public boolean layDuLieuClient() {
        
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            this.id = input.readUTF();
            return true;
        } catch (IOException ex) {

            Logger.getLogger(ListAnhBUS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean traDuLieuClient() {
        try {
            ServerDB serverDB = new ServerDB();
            ArrayList<HinhAnh> dsha = serverDB.getListHinhAnh(id);
            DataOutputStream outputLength = new DataOutputStream(socket.getOutputStream());
            outputLength.writeInt(dsha.size() - 1);
            outputLength.flush();
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            for (HinhAnh ha : dsha) {
                byte[] byteSend = new byte[1024];
                byteSend = ha.toString().getBytes();
                output.write(byteSend, 0, byteSend.length);
                output.flush();
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ListAnhBUS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
