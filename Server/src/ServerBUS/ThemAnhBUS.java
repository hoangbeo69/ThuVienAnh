/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerBUS;

import ServerDB.ServerDB;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HiHi
 */
public class ThemAnhBUS {

    Socket socket;

    public ThemAnhBUS(Socket socket) {
        this.socket = socket;
    }

    public void layDuLieuCliet() {
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            String data = input.readUTF();
            String[] dataArray = data.split("\\$");
            HinhAnh ha = new HinhAnh(dataArray[1], dataArray[2], Integer.parseInt(dataArray[3]), java.sql.Date.valueOf(dataArray[4]));
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            byte[] dataRead = new byte[ha.getDungluong()];
            inputStream.readNBytes(dataRead, 0, dataRead.length);
            String pathFile = null;
            if ( (pathFile = saveFile(dataRead, ha.getName())) != null) {
                
                if (themAnhDB(pathFile,dataArray[0], ha)) {
                    sendResult("success");
                } else {
                    sendResult("fail");
                }
            } else {
                sendResult("fail");
            }
        } catch (IOException ex) {
            Logger.getLogger(ThemAnhBUS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String saveFile(byte[] dataRead, String nameFile) {
        BufferedOutputStream output = null;
        try {
            Random r = new Random();
            int random = r.nextInt(1000);
            File file = new File(System.getProperty("user.dir") + "/src/DataImage/" + random + nameFile);
            output = new BufferedOutputStream(new FileOutputStream(file));
            output.write(dataRead, 0, dataRead.length);
            return file.getName();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ThemAnhBUS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ThemAnhBUS.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(ThemAnhBUS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean themAnhDB(String pathFile,String id, HinhAnh ha) {
        ServerDB serverDB = new ServerDB();
        if (serverDB.updateThemAnh(pathFile,id, ha)) {
            return true;
        } else {
            return false;
        }
    }

    public void sendResult(String mess) {
        try {
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF(mess);
            outputStream.flush();
        } catch (IOException ex) {
            Logger.getLogger(ThemAnhBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
