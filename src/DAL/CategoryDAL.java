/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Category;
import com.sun.corba.se.spi.presentation.rmi.PresentationManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Sang Luu Phuoc
 */
public class CategoryDAL extends DataAcessHelper {
    // câu lệnh SQL liên kết với với câu lệnh Query trên SQl
    private final String GET_BY_ID = "select * FROM Category where CatID= ?";
    private final String GET_ALL = "select * from Category ";
    
    // câu lệnh lấy ID loại giày và tên sản phẩm 
    public ArrayList<Category> getByID(int id) {
        ArrayList<Category> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                Category item = new Category();
                item.setcatid(rs.getInt("CatID"));
                item.setname(rs.getString("Name"));
                objs.add(item);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    // lấy tất cá thông tin từ loại giày (Nam Nữ)
    public ArrayList<Category> GetALL() {
        ArrayList<Category> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Category item = new Category();
                    item.setcatid(rs.getInt("CatID"));
                    item.setname(rs.getString("Name"));
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
}
