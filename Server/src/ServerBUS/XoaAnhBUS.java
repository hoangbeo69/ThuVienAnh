/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerBUS;

import ServerDB.ServerDB;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HiHi
 */
public class XoaAnhBUS {

    String id;
    String idAnh;
    Socket socket;

    public XoaAnhBUS(Socket socket) {
        this.socket = socket;
    }

    public boolean layDuLieuClient() {
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            String data = input.readUTF();
            String[] dataArray = data.split("\\$");
            this.id = dataArray[0];
            this.idAnh = dataArray[1];
            return true;
        } catch (IOException ex) {
            Logger.getLogger(XoaAnhBUS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void traDuLieuClient() {
        ServerDB serverDB = new ServerDB();
        String filePath = serverDB.getFilePathHinhAnh(this.id, this.idAnh);
        if (filePath != null && deleteAnhFile(filePath)) {
            DataOutputStream output = null;
            try {
                output = new DataOutputStream(socket.getOutputStream());
                try {
                    if (serverDB.deleteAnh(this.id, this.idAnh)) {
                        output.writeUTF("success");
                    }
                } catch (IOException ex) {
                    output.writeUTF("success");
                    
                    Logger.getLogger(XoaAnhBUS.class.getName()).log(Level.SEVERE, null, ex);
                }
                output.flush();
            } catch (IOException ex) {
                    Logger.getLogger(XoaAnhBUS.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }

    }

    public boolean deleteAnhFile(String path) {
        try {
            File file = new File(System.getProperty("user.dir") + "/src/DataImage/" + path);
            file.delete();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
