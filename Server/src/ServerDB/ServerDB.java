/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerDB;

import ServerBUS.HinhAnh;
import ServerDB.ConnectionDB;
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
            String qry = "SELECT ha_id,ha_name,ha_filepath,ha_dungluong,ha_date FROM hinh_anh WHERE user_id = '" + id + "'";
            ResultSet rs = connection.sqlQuery(qry);
            if (rs != null) {
                while (rs.next()) {
                    HinhAnh ha = new HinhAnh(rs.getString("ha_id"), rs.getString("ha_name"), rs.getString("ha_filepath"), rs.getString("ha_dungluong"), rs.getString("ha_date"));
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
        try{
            String qry = "SELECT ha_filepath FROM hinh_anh WHERE user_id='"+userID+"' and ha_id = '"+anhID+"'";
            ResultSet rs = connection.sqlQuery(qry);
            if(rs!= null){
                while(rs.next()){
                    pathImage = rs.getString("ha_filepath");
                }
            }
        }catch(Exception e){
            System.out.println("Nhận file không thành công");
        }finally{
            connection.closeConnect();
        }
        return pathImage;
    }
}
