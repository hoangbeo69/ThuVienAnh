/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerBUS;

import java.net.Socket;

/**
 *
 * @author HiHi
 */
public class DoiThongTinBUS {

    Socket socket;

    public DoiThongTinBUS(Socket socket) {
        this.socket = socket;
    }

    public boolean layDuLieuClient() {
        return true;
    }

    public void traDuLieuClient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
