/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.KhachSan;

/**
 *
 * @author bin
 */
public interface IKhachSanDAO {
    public KhachSan getKhachSan();
    public boolean updateKhachSan(KhachSan khachSan, int id);
}
