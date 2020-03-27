/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.UserDAL;
import Entity.User;
import java.util.ArrayList;

/**
 *
 * @author Sang Luu Phuoc
 */
public class UserDLL {

    //class đại điện cho phương thức để truyền vào phương thức gọi đến cơ sở dữ liệu
    UserDAL us = new UserDAL();

    public ArrayList<User> getAll() {
        return us.getAll();
    }

    public ArrayList<User> getbyID(int id) {
        return us.getbyID(id);
    }

    public boolean AddData(User user) {
        return us.AddData(user);
    }

    public boolean UpdateData(User user) {
        return us.UpdateData(user);
    }

    public boolean DelData(int id) {
        return us.DeleteData(id);
    }
}
