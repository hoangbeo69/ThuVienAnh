/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HiHi
 */
public class ConnectionDB {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;

    String DB_Name = null;
    String User_Name = null;
    String User_Pass = null;

    String ipAddress = "localhost:3306";

    public ConnectionDB() {
        checkDriver();
        DB_Name = "quanlyhinhanh";
        User_Name = "root";
        User_Pass = "password";
        setupConnect();
    }

    private void checkDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setupConnect() {
        try {
            String url = "jdbc:mysql://" + ipAddress + "/" + DB_Name + "?useUnicode=true&characterEncoding=UTF-8";
            conn = DriverManager.getConnection(url, User_Name, User_Pass);
            stmt = conn.createStatement();
//            System.out.println("**\n Success! Đã kết nối tới '" + DB_Name + "'");

        } catch (SQLException e) {
            System.err.println("-- ERROR! Không thể kết nối tới '" + DB_Name + "'");
//            JOptionPane.showMessageDialog(null, "-- ERROR! Không thể kết nối tới '" + DB_Name + "'");
        }
    }

    public ResultSet sqlQuery(String qry) {
        if (checkConnect()) {
            try {
                rset = stmt.executeQuery(qry);
//                System.out.println("Success Query !!! " + qry);
                return rset;
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return null;
    }

    public Boolean sqlUpdate(String qry) {
        System.out.println(qry);
        if (checkConnect()) {
            try {
                stmt.executeUpdate(qry);
//                System.out.println("Success Update Query " + qry);
                return true;
            } catch (SQLException ex) {
                System.err.println("-- ERROR! không thể update '" + DB_Name + "'");

                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return false;
    }

    public void closeConnect() {
        try {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
//            System.out.println("Success! Đóng kết nối tới '" + DB_Name + "' thành công.\n**");
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "-- ERROR! Không thể đóng kết nối tới " + DB_Name + "\n" + ex.getLocalizedMessage());
        }
    }

    public Boolean checkConnect() {
        if (conn == null || stmt == null) {
//           JOptionPane.showMessageDialog(null, "-- ERROR! Chưa thiết lập kết nối tới '" + DB_Name + "'. Vui lòng đăng nhập để thiết lập kết nối!");
            return false;
        }
        return true;
    }
}
