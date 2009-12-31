/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;


/**
 *
 * @author bin
 */
public class LoaiKhachHang {
    int id;
    String ten;
    int gia;

    public LoaiKhachHang()
    {

    }

    public int getGia()
    {
        return this.gia;
    }

    public int getId()
    {
        return this.id;
    }

    public String getTen()
    {
        return this.ten;
    }

    public void setGia(int gia)
    {
        this.gia = gia;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setTen(String ten)
    {
        this.ten = ten;
    }
}
