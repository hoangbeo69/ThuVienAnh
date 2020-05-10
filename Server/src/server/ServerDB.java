/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.ResultSet;

/**
 *
 * @author HiHi
 */
class ServerDB {
    ConnectionDB connection;
    public ServerDB(){
        
    }
    public String checkDangNhap(String taiKhoan,String matKhau){
        connection = new ConnectionDB();
        String id = "null";
        try {
            String qry = "SELECT user_id as id FROM tai_khoan WHERE tk_username ='"+taiKhoan+"' and tk_password = '"+matKhau+"'";
            ResultSet rs = connection.sqlQuery(qry);
            if(rs != null){
                rs.next();
                id  = rs.getString("id");
            }
        } catch (Exception e) {
        } finally {
            connection.closeConnect();
        }
        return  id;
    }
}
