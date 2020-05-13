/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerBUS;

/**
 *
 * @author HiHi
 */
public class HinhAnh {

    String id;
    String name;
    String filePath;
    String dungluong;
    String date;
    
    public HinhAnh(String id, String name, String filePath, String dungluong, String date) {
        this.id = id;
        this.name = name;
        this.filePath = filePath;
        this.dungluong = dungluong;
        this.date = date;
    }

    @Override
    public String toString() {
        return id + "$" + name + "$" + filePath + "$" + dungluong + "$" + date;
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDungluong() {
        return dungluong;
    }

    public void setDungluong(String dungluong) {
        this.dungluong = dungluong;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
