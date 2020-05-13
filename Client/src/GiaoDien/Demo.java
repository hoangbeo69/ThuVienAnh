/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GiaoDien;

/**
 *
 * @author HiHi
 */
public class Demo {

    public static void main(String[] args) {
        Client client = new Client();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainControl(client, "hoangbeo69", "USER01").setVisible(true);
            }
        });
    }
}
