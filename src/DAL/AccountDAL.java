/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Sang Luu Phuoc
 */
public class AccountDAL extends DataAcessHelper {
    // câu lệnh SQL để liên kết với server
    private final String GET_LOGIN = "select * from Account where Username=? and Password=?";
    private final String UPDATE_DATA = "Update Account set Username=?,Password=?,maxacnhan=? where AccID=?";
    private final String CHECK_DATA = "select * from Account where Username=? and maxacnhan=?";
    private final String UPDATE_PASS = "Update Account set Password=? where AccID=?";
    
    // phương thức check account
    public boolean getLogin(String u, String p) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_LOGIN);
            ps.setString(1, u);
            ps.setString(2, p);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    // phương thức thay đổi thông tin của account
    public boolean UpdateData(Account acc) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA);
            //
            ps.setString(1, acc.getuser());
            ps.setString(2, acc.getpass());

            ps.setString(3, acc.getMaxacnhan());
            ps.setInt(4, acc.getaccid());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    // phương thức kiểm tra xem khi đổi pass word phải có mã xác nhận để xác minh là người dùng thật sự
    public boolean getCheck(String u, String p) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(CHECK_DATA);
            ps.setString(1, u);
            ps.setString(2, p);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    
    // cập nhật mật khẩu mới khi người đúng thay đổi mật khẩu
    public boolean UpdatePass(Account acc) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_PASS);
            ps.setString(1, acc.getpass());
            ps.setInt(2, acc.getaccid());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
