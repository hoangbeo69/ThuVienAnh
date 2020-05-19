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

//(`ha_id`, `ha_name`, `ha_filepath`, `ha_dungluong`, `user_id`, `ha_date`) VALUES ('', '', '', '', '', '')

    public Boolean updateThemAnh(String pathfile,String id, HinhAnh ha) {
        connection = new ConnectionDB();
        
        Boolean success = connection.sqlUpdate("INSERT INTO hinh_anh (ha_id,ha_name,ha_filepath,ha_dungluong,user_id,ha_date) VALUES ('" 
                +ha.getId()+"','"
                +ha.getName()+"','"
                +pathfile+"',"
                +ha.getDungluong()+",'"
                +id+"','"
                +ha.getDate()+"');");
        connection.checkConnect();
        return success;
    }

    public boolean xoaAnh(String id, String idAnh) {
        connection = new ConnectionDB();
        boolean success  = connection.sqlUpdate("DELETE FROM hinh_anh WHERE ha_id = '"+idAnh+"' AND user_id='"+id+"';");
        connection.closeConnect();
        return success;
    }
}
