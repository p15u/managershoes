/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Sang Luu Phuoc
 */
public class ProductDAL extends DataAcessHelper {

    // câu lệnh SQL
    private final String GET_ALL = "Select * From Product";
    private final String GET_BY_ID = "select * from Product where ProductID=?";
    private final String ADD_DATA = "Insert into Product values(?,?,?,?,?,?,?)";
    private final String UPDATE_DATA = "Update Product set NamePr=?,Brand=?,Price=?,Quantity=?,Description=?,CatID=? where ProductID=?";
    private final String REMOVE_DATA = "Delete from Product where ProductID=?";
    private final String GET_BY_NAME = "Select * From Product Where NamePr=?";
    private final String UPDATE_SL = "UPdate Product set Quantity=? where ProductID=?";
    
    // phương thức lấy tât cả các giá trị của Product vào arraylist
    public ArrayList<Product> getAll() {
        ArrayList<Product> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Product pr = new Product();
                    pr.setproId(rs.getInt("ProductID"));
                    pr.setname(rs.getString("NamePr"));
                    pr.setbrand(rs.getString("Brand"));
                    pr.setprice(rs.getInt("Price"));
                    pr.setquantity(rs.getInt("Quantity"));
                    pr.setDesc(rs.getString("Description"));
                    pr.setcatid(rs.getInt("CatID"));
                    objs.add(pr);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi thông tin sản phẩm");
        }
        return objs;

    }
    
    //phương thức lấy Tên và ID từ bảng Product ra ArrayList
    public ArrayList<Product> getbyIDfromOrder(int id) {
        ArrayList<Product> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                Product item = new Product();
                item.setname(rs.getString("NamePr"));
                item.setproId(rs.getInt("ProductID"));
                objs.add(item);
            }

            getClose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể lấy dữ liệu ID");
        }
        return objs;
    }
    
    // Phương thức tìm ID của để xuất ra thông tin của sản phẩm ra list
    public ArrayList<Product> getbyIDFind(int id) {
        ArrayList<Product> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                Product item = new Product();
                item.setname(rs.getString("Name"));
                item.setbrand(rs.getString("Brand"));
                item.setprice(rs.getInt("Price"));
                item.setquantity(rs.getInt("Quantity"));
                item.setDesc(rs.getString("Description"));
                item.setcatid(rs.getInt("CatID"));
                item.setproId(rs.getInt("ProductID"));
                objs.add(item);
            }

            getClose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể lấy dữ liệu ID");
        }
        return objs;
    }

    //phương thức tìm lấy ID đưa vào để lấy ID sản phẩm và kích cỡ của sản phẩm
    public ArrayList<Product> getByID(int id) {
        ArrayList<Product> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                Product item = new Product();
                item.setproId(rs.getInt("ProductID"));
                item.setDesc(rs.getString("Description"));
                objs.add(item);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }

    // phương thức thêm sản phẩm chuyền vào là thực thể Product
    public boolean Adddata(Product pr) {
        boolean check = true;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_DATA);
            ps.setInt(1, pr.getproid());
            ps.setString(2, pr.getname());
            ps.setString(3, pr.getbrand());
            ps.setInt(4, pr.getprice());
            ps.setInt(5, pr.getquantity());
            ps.setString(6, pr.getDesc());
            ps.setInt(7, pr.getcatid());
            int count = ps.executeUpdate();
            if (count > 0) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    
    // phương thức xóa dữ liệu khi chuyền vào ID của sản phẩm sẽ thực hiện phưởng thức SQL trên và xóa đi dữ liệu
    public boolean DelData(int u) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(REMOVE_DATA);
            ps.setInt(1, u);
            int count = ps.executeUpdate();
            if (count > 0) {
                check = true;
            } else {
                check = false;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    // câu lệnh sửa cập nhận dữ liệu để sửa
    public boolean UpdateData(Product pr) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA);
            ps.setString(1, pr.getname());
            ps.setString(2, pr.getbrand());
            ps.setInt(3, pr.getprice());
            ps.setInt(4, pr.getquantity());
            ps.setString(5, pr.getDesc());
            ps.setInt(6, pr.getcatid());
            ps.setInt(7, pr.getproid());
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
    
    //
    public ArrayList<Product> getByName(String name) {
        ArrayList<Product> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_NAME);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                Product item = new Product();
                item.setproId(rs.getInt("ProductID"));
                item.setname(rs.getString("NamePr"));
                item.setbrand(rs.getString("Brand"));
                item.setprice(rs.getInt("Price"));
                item.setquantity(rs.getInt("Quantity"));
                item.setDesc(rs.getString("Description"));
                item.setcatid(rs.getInt("CatID"));
                objs.add(item);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }

    public boolean UpdateSL(Product pr) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_SL);

            ps.setInt(1, pr.getquantity());

            ps.setInt(2, pr.getproid());
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
