/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.TinhTrangPhong;
import java.util.ArrayList;

/**
 *
 * @author bin
 */
public interface ITinhTrangPhongDAO {
    public ArrayList<TinhTrangPhong> getDSTinhTrangPhong();
    public TinhTrangPhong getTinhTrangPhongTheoId(int id);
    public TinhTrangPhong getTinhTrangPhongTheoTen(String ten);
}
