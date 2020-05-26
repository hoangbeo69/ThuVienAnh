/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import ServerBUS.DangKyBUS;
import ServerBUS.DangNhapBUS;
import ServerBUS.DoiMatKhauBUS;
import ServerBUS.DoiThongTinBUS;
import ServerBUS.HinhAnhBUS;
import ServerBUS.ListAnhBUS;
import ServerBUS.ThemAnhBUS;
import ServerBUS.XoaAnhBUS;
import java.io.ObjectInputStream;
import java.net.Socket;

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

    synchronized public void handle(String mess) {
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
            case "dang_ky":
                dangKy();
                break;
            case "xoa_anh":
                xoaAnh();
                break;
            case "them_anh":
                themAnh();
                break;
        }
    }

    public void dangNhap() {
        DangNhapBUS dangNhap = new DangNhapBUS(this.socket);
        if (dangNhap.layDuLieuClient()) {
            dangNhap.traDulieuClient();
        }
    }

    public void guiListAnh() {
        ListAnhBUS listAnh = new ListAnhBUS(this.socket);
        if (listAnh.layDuLieuClient()) {
            listAnh.traDuLieuClient();
        }
    }

    public void guiAnh() {
        HinhAnhBUS hinhanh = new HinhAnhBUS(this.socket);
        if (hinhanh.layDuLieuClient()) {
            hinhanh.traDulieuClient();
        }
    }

    public void themAnh() {
        ThemAnhBUS themanh = new ThemAnhBUS(this.socket);
        themanh.layDuLieuCliet();
    }

    public void xoaAnh() {
        XoaAnhBUS xoaanh = new XoaAnhBUS(this.socket);
        if (xoaanh.layDuLieuClient()) {
            xoaanh.traDuLieuClient();
        }

    }

    public void dangKy() {
        DangKyBUS dangky = new DangKyBUS(this.socket);
        if (dangky.layDuLieuClient()) {
            dangky.traDuLieuClient();
        }
    }

    public void doiThongTin() {
        DoiThongTinBUS doiThongTin = new DoiThongTinBUS(this.socket);
        if (doiThongTin.layDuLieuClient()) {
            doiThongTin.traDuLieuClient();
        }
    }

    public void doiMatKhau() {
        DoiMatKhauBUS doiMatKhau = new DoiMatKhauBUS(this.socket);
        if (doiMatKhau.layDuLieuClient()) {
            doiMatKhau.traDuLieuClient();
        }
    }
}
