/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Sang Luu Phuoc
 */
public class DataAcessHelper {
    // các câu lệnh liên kết với lại với server
    protected Connection con = null;
    String drive = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String urdb = "jdbc:sqlserver://127.0.0.1:1433;databaseName=QLshopgiay;";
    String user = "sa";
    String pass = "nhuthung09";

    //phương thức connect
    public void getConnect() {
        try {
            Class.forName(drive);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(urdb, user, pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối tới CSDL");
        }
    }

    //lệnh đóng SQl
    public void getClose() {
        try {
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể đóng kết nối tới CSDL");
        }
    }
}
