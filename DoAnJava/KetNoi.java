/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoAnJava;

import java.sql.Connection;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class KetNoi {
     private static final String userName = "sa";
    private static final String password = "12345";
    private static final String url = "jdbc:sqlserver://DESKTOP-OBBHLLS\\SQLEXPRESS:1433;encrypt=true;trustServerCertificate=true;databaseName=QLSACH";
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối đến cơ sở dữ liệu!");
            e.printStackTrace();
        }
        return conn;    
    }

    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws IOException {
    try {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }
    
}
