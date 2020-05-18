/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEndData;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author HiHi
 */
public class HinhAnhData {

    String userID;
    String idAnh;
    Socket socket ;
    ObjectInputStream inputStream;
    public HinhAnhData(String userID, String idAnh,Socket socket ) {
        this.userID = userID;
        this.idAnh = idAnh;
        this.socket = socket;
    }

    public boolean guiData() {
        try {
            DataOutputStream outputMess = new DataOutputStream(socket.getOutputStream());
            outputMess.writeUTF(this.userID + "$" + this.idAnh);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(HinhAnhData.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public byte [] layData() {
        DataInputStream inputLength = null;
        try {
            inputLength = new DataInputStream(this.socket.getInputStream());
            String  doDai  = inputLength.readUTF();
            int lengthData = Integer.parseInt(doDai.trim());
            inputStream = new ObjectInputStream(this.socket.getInputStream());
            byte[] arrayData = new byte[lengthData];
            inputStream.readNBytes(arrayData, 0, arrayData.length);     
//            JFrame frame = new JFrame();
//            JLabel lb = new JLabel();
//            lb.setSize(500,500);
//            lb.setIcon(imageIcon);
//            frame.setSize(600, 600);
//            frame.add(lb);
//            frame.setVisible(true);      
            return arrayData;
        } catch (IOException ex) {
            Logger.getLogger(HinhAnhData.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
