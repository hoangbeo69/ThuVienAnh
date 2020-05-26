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
public class DoiMatKhauBUS {

    Socket socket;

    public DoiMatKhauBUS(Socket socket) {
        this.socket = socket;
    }

    public boolean layDuLieuClient() {
        return true;
    }

    public void traDuLieuClient() {

    }

}
