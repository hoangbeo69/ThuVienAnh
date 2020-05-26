/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerBUS;

import ServerDB.ServerDB;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Modifier;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HiHi
 */
public class HinhAnhBUS {

    Socket socket;
    String userID;
    String anhID;
    DataInputStream inputMess;
    DataOutputStream outputMess;
    ObjectOutputStream outputFile;
    public HinhAnhBUS(Socket socket) {
        this.socket = socket;
    }

    public boolean layDuLieuClient() {
        try {
            inputMess = new DataInputStream(socket.getInputStream());
            String data = inputMess.readUTF();
            String[] dataA = data.split("\\$");
            this.userID = dataA[0];
            this.anhID = dataA[1];
            return true;
        } catch (IOException ex) {
            Logger.getLogger(HinhAnhBUS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public void traDulieuClient() {
        try {

            ServerDB serverDB = new ServerDB();
            String filePath = serverDB.getFilePathHinhAnh(userID, anhID);
            byte[] dataImageSend = readFilePath(filePath);

            outputMess = new DataOutputStream(socket.getOutputStream());
            outputMess.writeUTF(""+dataImageSend.length);
            outputFile = new ObjectOutputStream(socket.getOutputStream());
            outputFile.write(dataImageSend, 0, dataImageSend.length);
            outputFile.flush();

            System.out.println("Gửi " + filePath + " thành công");
        } catch (IOException ex) {
            Logger.getLogger(HinhAnhBUS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public byte[] readFilePath(String path) {
        try {
            File file = new File(System.getProperty("user.dir") + "/src/DataImage/" + path);

            BufferedInputStream input = new BufferedInputStream(new FileInputStream(file));
            byte[] data = new byte[(int) file.length()];
            int x =input.read(data, 0, data.length);
            input.close();
            return data;
        } catch (IOException ex) {
            return null;
        }
    }

}
