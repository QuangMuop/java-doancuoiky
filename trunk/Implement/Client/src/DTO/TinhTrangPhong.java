/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;


/**
 *
 * @author bin
 */
public class TinhTrangPhong {
    int id;
    String ten;

    public int getId()
    {
        return this.id;
    }

    public String getTen()
    {
        return this.ten;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setTen(String ten)
    {
        this.ten = ten;
    }

    public void clone(TinhTrangPhong tinhTrang)
    {
        this.id = tinhTrang.getId();
        this.ten = tinhTrang.getTen();
    }
}
