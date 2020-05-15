/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEndData;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

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

    public ImageIcon layData() {
        ImageIcon imageIcon = null;
        DataInputStream inputLength = null;
        try {
            inputLength = new DataInputStream(this.socket.getInputStream());
            String  doDai  = inputLength.readUTF();
            int lengthData = Integer.parseInt(doDai.trim());
            
            inputStream = new ObjectInputStream(this.socket.getInputStream());
            byte[] arrayData = new byte[lengthData];
            inputStream.readNBytes(arrayData, 0, arrayData.length);
            
            BufferedImage bufImg = ImageIO.read(new ByteArrayInputStream(arrayData));
            imageIcon = new ImageIcon(bufImg);
            
//            JFrame frame = new JFrame();
//            JLabel lb = new JLabel();
//            lb.setSize(500,500);
//            lb.setIcon(imageIcon);
//            frame.setSize(600, 600);
//            frame.add(lb);
//            frame.setVisible(true);
            
            return imageIcon;
        } catch (IOException ex) {
            Logger.getLogger(HinhAnhData.class.getName()).log(Level.SEVERE, null, ex);
            return imageIcon;
        }
    }

}
