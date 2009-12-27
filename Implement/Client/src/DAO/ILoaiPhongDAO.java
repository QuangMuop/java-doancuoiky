/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.LoaiPhong;
import java.util.ArrayList;

/**
 *
 * @author bin
 */
public interface ILoaiPhongDAO {
    public ArrayList<LoaiPhong> getDSLoaiPhong();
    public LoaiPhong getLoaiPhongTheoId(int id);
    public LoaiPhong getLoaiPhongTheoTen(String ten);
}
