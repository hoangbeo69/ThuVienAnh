/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HiHi
 */
public class ServerWorkThread implements Runnable {

    Thread t = null;
    Socket socket;

    public ServerWorkThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            boolean work = true;
            String message = null;
            ServerHandler handler = new ServerHandler(socket);
            while ((message = inputStream.readUTF()) != null) {
                handler.handle(message);
            }
        } catch (IOException ex) {
            System.out.println("\r==  Disconect with "+socket.getRemoteSocketAddress() +"  == ");
            System.out.println("\r  --Thread "+ t.getName() + " is stoped--");
        }

    }

    public void start() {
        if (t == null) {
            t = new Thread(this, socket.getRemoteSocketAddress().toString());
            t.start();
        }
    }

}
