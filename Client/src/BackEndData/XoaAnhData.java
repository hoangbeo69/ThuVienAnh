/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEndData;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static java.lang.System.in;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HiHi
 */
public class XoaAnhData {

    String id;
    String idAnh;
    Socket socket;

    public XoaAnhData(String userID, String idAnh, Socket socket) {
        this.id = userID;
        this.idAnh = idAnh;
        this.socket = socket;
    }

    public boolean guiData() {
        DataOutputStream output = null;
        try {
            output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF(id + "$" + idAnh);
            output.flush();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(XoaAnhData.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean layData() {
        DataInputStream input = null;
        try {
            input = new DataInputStream(socket.getInputStream());
            String s = input.readUTF();
            if(s.equals("success")){
                return true;
            }else{
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(XoaAnhData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(XoaAnhData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

}
