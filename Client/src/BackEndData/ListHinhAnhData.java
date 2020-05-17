/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEndData;

import BackEndClass.HinhAnh;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HiHi
 */
public class ListHinhAnhData {

    String id;
    DataInputStream inputStream;
    DataOutputStream outputStream;
    ObjectInputStream inputStreamObject;
    Socket socket ;
    public ListHinhAnhData(String id,Socket socket ) {
        this.id = id;
        this.socket = socket;
    }

    public boolean guiData() {
        try {
            outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF(id);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ListHinhAnhData.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public ArrayList<HinhAnh> layData() {
        ArrayList<HinhAnh> dsha = new ArrayList<HinhAnh>();
        try {
            inputStream = new DataInputStream(socket.getInputStream());
            int size = inputStream.readInt();
            inputStreamObject = new ObjectInputStream(socket.getInputStream());
            for (int count = 0; count <= size; count++) {
                byte[] byteRead = new byte[1024];
                inputStreamObject.read(byteRead, 0, byteRead.length);
                String[] data = new String(byteRead).trim().split("\\$");
                HinhAnh ha = new HinhAnh(data[0],data[1],Integer.parseInt(data[2]),java.sql.Date.valueOf(data[3]));
                dsha.add(ha);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ListHinhAnhData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsha;
    }
}
