/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEndClass;

import java.sql.Date;

/**
 *
 * @author HiHi
 */
public class TaiKhoan {
        private String tenUser;
        private String emailUser;
        private Date ngaySinh;
        private String taiKhoan;
        private String matKhau;

    public TaiKhoan(String tenUser, String emailUser, Date ngaySinh, String taiKhoan, String matKhau) {
        this.tenUser = tenUser;
        this.emailUser = emailUser;
        this.ngaySinh = ngaySinh;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTenUser() {
        return tenUser;
    }

    public void setTenUser(String tenUser) {
        this.tenUser = tenUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }
}
