/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEndData;

import BackEndClass.HinhAnh;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HiHi
 */
public class GuiHinhAnhData {

    Socket socket;
    String userId;
    HinhAnh ha;
    String pathFile;
    File file;

    public GuiHinhAnhData(String userID, HinhAnh ha, Socket socket) {
        this.socket = socket;
        this.ha = ha;
        this.userId = userID;
        this.file = new File(ha.getName());
        ha.setName(file.getName());
    }

    public boolean guiData() {
        try {
            DataOutputStream outputMess = new DataOutputStream(socket.getOutputStream());
            outputMess.writeUTF(userId + "$" + ha.toString());
            outputMess.flush();
            byte[] data = null;
            if((data = getDataFile())!= null){
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.write(data, 0, data.length);
                outputStream.flush();
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(GuiHinhAnhData.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    public boolean layData(){
        try {
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            String result = inputStream.readUTF();
            if(result.equals("success")){ //susscess
                
                return true;
            }else{
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(GuiHinhAnhData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public byte[] getDataFile() {
        byte[] data = new byte[(int) this.file.length()];
        BufferedInputStream inputFile = null;
        try {
            inputFile = new BufferedInputStream(new FileInputStream(this.file));
            inputFile.read(data, 0, data.length);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GuiHinhAnhData.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(GuiHinhAnhData.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                inputFile.close();
            } catch (IOException ex) {
                Logger.getLogger(GuiHinhAnhData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return data;
    }

}
