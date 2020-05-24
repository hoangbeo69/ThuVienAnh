/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEndClass;
import java.sql.Date;
/**
 *
 * @author HiHi
 */
public class ThongTin {
    private String tenUser;
    private String email;
    private Date birth;

    public ThongTin(String tenUser, String email, Date birth) {
        this.tenUser = tenUser;
        this.email = email;
        this.birth = birth;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getTenUser() {
        return tenUser;
    }

    public void setTenUser(String tenUser) {
        this.tenUser = tenUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return tenUser + "$" + email + "$" + birth;
    }
    
}
