/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerClass;

import java.sql.Date;
import java.util.Random;

/**
 *
 * @author HiHi
 */
public class TaiKhoan {

    private String taiKhoan;
    private String matKhau;
    private String idUser;

    public TaiKhoan( String idUser,String taiKhoan, String matKhau) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.idUser = idUser;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    @Override
    public String toString() {
        return taiKhoan + "$" + matKhau;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

}
