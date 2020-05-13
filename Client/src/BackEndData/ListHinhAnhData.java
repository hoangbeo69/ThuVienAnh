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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HiHi
 */
public class ListHinhAnhData {

    OutputStream output;
    InputStream input;
    String id;

    public ListHinhAnhData(String id, InputStream input, OutputStream output) {
        this.id = id;
        this.output = output;
        this.input = input;
    }

    public boolean guiData() {
        try {
            DataOutputStream output = new DataOutputStream(this.output);
            output.writeUTF(id);
            output.flush();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ListHinhAnhData.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public ArrayList<HinhAnh> layData() {
        ArrayList<HinhAnh> dsha = new ArrayList<HinhAnh>();
        try {
            DataInputStream input = new DataInputStream(this.input);
            int size = input.readInt();
            System.out.println(size);
            ObjectInputStream inputStream = new ObjectInputStream(this.input);
            for (int count = 0; count < size; count++) {
                byte[] byteRead = new byte[1024];
                inputStream.read(byteRead, 0, byteRead.length);
                String[] data = new String(byteRead).trim().split("\\$");
                HinhAnh ha = new HinhAnh(data[0],data[1],data[2],data[3],data[4]);
                System.out.println(ha.toString());
                dsha.add(ha);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ListHinhAnhData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsha;
    }
}
