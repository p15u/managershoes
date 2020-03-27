/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.AccountDAL;
import Entity.Account;

/**
 *
 * @author Sang Luu Phuoc
 */
public class AccountDLL {
    // thông qua class này để truyển về Các pHương thức ở cơ sở dữ liệu 
    AccountDAL acc= new AccountDAL();
    //phương thức chuyền vào Phương thức ở cơ của Phương thức của Account 
    public boolean getLogin(String u, String p)
    {
        return acc.getLogin(u, p);
    }
    public boolean UpdateData(Account acc1){
        return acc.UpdateData(acc1);
    }
    public boolean CheckData(String u,String m){
        return acc.getCheck(u, m);
    }
    public boolean UpdatePass(Account acc2){
        return acc.UpdatePass(acc2);
    }
}
