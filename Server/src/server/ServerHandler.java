/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import ServerBUS.DangNhapBus;
import ServerBUS.ListAnhBUS;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HiHi
 */
public class ServerHandler {

    Socket socket;
    ObjectInputStream inputStream;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    public void handle(String mess) {
        //đăng nhập - gửi list hình ảnh - gửi từng ảnh - đổi mk - đổi thông tin - xóa ảnh - thêm ảnh - 
        //dang_nhap - gui_list_anh  - gui_anh - doi_mat_khau  - doi_thong_tin - xoa_anh - them_anh - tai_anh

        switch (mess) {
            case "dang_nhap":
                dangNhap();
                break;
            case "gui_list_anh":
                guiListAnh();
                break;
            case "gui_anh":
                guiAnh();
                break;
            case "doi_mat_khau":
                doiMatKhau();
                break;
            case "doi_thong_tin":
                doiThongTin();
                break;
            case "xoa_anh":
                xoaAnh();
                break;
            case "them_anh":
                themAnh();
                break;
            case "tai_anh":
                taiAnh();
                break;

        }
    }

    public void dangNhap() {
        DangNhapBus dangNhap = new DangNhapBus(socket);
        if (dangNhap.layDuLieuClient()) {
            dangNhap.traDulieuClient();
        }
    }
    public void guiListAnh(){
        ListAnhBUS listAnh = new ListAnhBUS(socket);
        if(listAnh.layDuLieuClient()){
            listAnh.traDuLieuClient();
        }
    }
}
