/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerDB;

import ServerClass.HinhAnh;
import ServerClass.TaiKhoan;
import ServerClass.ThongTin;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HiHi
 */
public class ServerDB {

    ConnectionDB connection;

    public ServerDB() {

    }

    public String checkDangNhap(String taiKhoan, String matKhau) {
        connection = new ConnectionDB();
        String id = "null";
        try {
            String qry = "SELECT user_id as id FROM tai_khoan WHERE tk_username ='" + taiKhoan + "' and tk_password = '" + matKhau + "'";
            ResultSet rs = connection.sqlQuery(qry);
            if (rs != null) {
                rs.next();
                id = rs.getString("id");
            }
        } catch (Exception e) {
            return id;
        } finally {
            connection.closeConnect();
        }
        return id;
    }

    public ArrayList getListHinhAnh(String id) {
        connection = new ConnectionDB();
        ArrayList<HinhAnh> dsha = new ArrayList<>();
        try {
            String qry = "SELECT ha_id,ha_name,ha_dungluong,ha_date FROM hinh_anh WHERE user_id = '" + id + "'";
            ResultSet rs = connection.sqlQuery(qry);
            if (rs != null) {
                while (rs.next()) {
                    HinhAnh ha = new HinhAnh(rs.getString("ha_id"), rs.getString("ha_name"), rs.getInt("ha_dungluong"), java.sql.Date.valueOf(rs.getString("ha_date")));
                    dsha.add(ha);
                }
            }
            System.out.println("Nhận List thành công");
        } catch (Exception e) {
            System.out.println("Nhân list hình ảnh không thành công");
        } finally {
            connection.closeConnect();
        }
        return dsha;
    }

    public String getFilePathHinhAnh(String userID, String anhID) {
        connection = new ConnectionDB();
        String pathImage = null;
        try {
            String qry = "SELECT ha_filepath FROM hinh_anh WHERE user_id='" + userID + "' and ha_id = '" + anhID + "'";
            ResultSet rs = connection.sqlQuery(qry);
            if (rs != null) {
                while (rs.next()) {
                    pathImage = rs.getString("ha_filepath");
                }
            }
        } catch (Exception e) {
            System.out.println("Nhận file không thành công");
        } finally {
            connection.closeConnect();
        }
        return pathImage;
    }

//(`ha_id`, `ha_name`, `ha_filepath`, `ha_dungluong`, `user_id`, `ha_date`) VALUES ('', '', '', '', '', '')
    public Boolean updateThemAnh(String pathfile, String id, HinhAnh ha) {
        connection = new ConnectionDB();

        Boolean success = connection.sqlUpdate("INSERT INTO hinh_anh (ha_id,ha_name,ha_filepath,ha_dungluong,user_id,ha_date) VALUES ('"
                + ha.getId() + "','"
                + ha.getName() + "','"
                + pathfile + "',"
                + ha.getDungluong() + ",'"
                + id + "','"
                + ha.getDate() + "');");
        connection.closeConnect();
        return success;
    }

    public boolean xoaAnh(String id, String idAnh) {
        connection = new ConnectionDB();
        boolean success = connection.sqlUpdate("DELETE FROM hinh_anh WHERE ha_id = '" + idAnh + "' AND user_id='" + id + "';");
        connection.closeConnect();
        return success;
    }

    public boolean checkTaiKhoan(String taiKhoan) {
        connection = new ConnectionDB();
//        String id = null;
        try {
            String qry = "SELECT user_id as id FROM tai_khoan WHERE tk_username ='" + taiKhoan + "'";
            ResultSet rs = connection.sqlQuery(qry);
            if (rs != null) {
                rs.next();
//                id = rs.getString("id");
                rs.getString("id");
            }
        } catch (Exception e) {
            return true;
        } finally {
            connection.closeConnect();
        }

        return false;
    }

    public boolean checkEmail(String email) {
        connection = new ConnectionDB();
        try {
            String qry = "SELECT user_id as id FROM user WHERE user_email ='" + email.toLowerCase() + "'";
            ResultSet rs = connection.sqlQuery(qry);
            if (rs != null) {
                rs.next();
                rs.getString("id");
            }
        } catch (Exception e) {
            return true;
        } finally {
            connection.closeConnect();
        }
        return false;
    }

    public boolean themNguoiDung(ThongTin thongTin) {
        connection = new ConnectionDB();

        Boolean success = connection.sqlUpdate("INSERT INTO `user` (`user_id`, `user_name`, `user_birth`, `user_email`, `user_dungluong`) VALUES ('"
                + thongTin.getIdUser() + "','"
                + thongTin.getTenUser() + "','"
                + thongTin.getBirth() + "','"
                + thongTin.getEmail() + "',"
                + 104857600 + ");");
        connection.closeConnect();
        return success;
    }

    public boolean themTaiKhoan(TaiKhoan taiKhoan) {
        connection = new ConnectionDB();
        Boolean success = connection.sqlUpdate("INSERT INTO `tai_khoan` (`user_id`, `tk_username`, `tk_password`) VALUES ('"
                + taiKhoan.getIdUser() + "','"
                + taiKhoan.getTaiKhoan() + "','"
                + taiKhoan.getMatKhau() + "');");
        connection.closeConnect();
        return success;
    }

    public boolean updateThongTin(ThongTin thongTin) {
        connection = new ConnectionDB();
        Boolean success = connection.sqlUpdate("UPDATE user set "
                + " user_name = '" + thongTin.getTenUser()
                + "', user_birth = " + thongTin.getBirth().toString()
                + ", user_email = '" + thongTin.getEmail()
                + "' WHERE user_id = '" + thongTin.getIdUser() + "';");
        connection.closeConnect();
        return success;
    }

    public boolean updateMatKhau(String idUser, String matKhauMoi) {
        connection = new ConnectionDB();
        Boolean success = connection.sqlUpdate("UPDATE tai_khoan set "
                + "tk_password = '" + matKhauMoi
                + "' WHERE user_id = '" + idUser + "';");
        connection.closeConnect();
        return success;
    }
}
