/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerBUS;
import java.sql.Date;
/**
 *
 * @author HiHi
 */
public class HinhAnh {

    String id;
    String name;
    int dungluong;
    Date date;
    
    public HinhAnh(String id, String name, int dungluong, Date date) {
        this.id = id;
        this.name = name;
        this.dungluong = dungluong;
        this.date = date;
    }

    @Override
    public String toString() {
        return id + "$" + name  + "$" + dungluong + "$" + date.toString();
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public int getDungluong() {
        return dungluong;
    }

    public void setDungluong(int dungluong) {
        this.dungluong = dungluong;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
