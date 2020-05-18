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
    DataOutputStream outputLength;
    ObjectOutputStream output;

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
            outputLength = new DataOutputStream(socket.getOutputStream());
            outputLength.writeInt(dsha.size());
            if (dsha.size() != 0) {
                output = new ObjectOutputStream(socket.getOutputStream());
                for (HinhAnh ha : dsha) {
                    output.write(ha.toString().getBytes(), 0, ha.toString().getBytes().length);
                    output.flush();
                }
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ListAnhBUS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
