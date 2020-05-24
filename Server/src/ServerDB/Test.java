/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerDB;

import ServerClass.TaiKhoan;
import ServerClass.ThongTin;
import java.util.Arrays;

/**
 *
 * @author HiHi
 */
public class Test {

    public static void main(String[] args) {
        ThongTin tt = new ThongTin("Nguyen van a ", "nguyenminhhoang@gmail.com", java.sql.Date.valueOf("2019-11-24"));
        TaiKhoan tk = new TaiKhoan(tt.getIdUser(),"hoangbeo600", "hoangbeo69");
        
        ServerDB server = new ServerDB();
        System.out.println(server.checkTaiKhoan(tk.getTaiKhoan()));
//        if(server.themNguoiDung(tt) && server.themTaiKhoan(tk)){
//            System.out.println("Hello");
//        }

    }
}
