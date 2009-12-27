/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;


/**
 *
 * @author bin
 */
public class LoaiPhong{
    int id;
    String ten;
    int gia;

    public void setId(int id)
    {
        this.id = id;
    }

    public void setTen(String ten)
    {
        this.ten = ten;
    }

    public void setGia(int gia)
    {
        this.gia = gia;
    }

    public int getId()
    {
        return this.id;
    }

    public int getGia()
    {
        return this.gia;
    }

    public String getTen()
    {
        return this.ten;
    }
}
