/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BUS;

import DAO.DAOFactory;
import DAO.IKhachSanDAO;
import DTO.KhachSan;

/**
 *
 * @author bin
 */
public class KhachSanController {

    IKhachSanDAO khachSanDAO;

    public KhachSanController()
    {
        khachSanDAO = DAOFactory.getInstance().getKhachSanDAO();
    }

    public KhachSan layKhachSan()
    {
        return khachSanDAO.getKhachSan();
    }

    public boolean capNhatKhachSan(KhachSan khachSan)
    {
        return khachSanDAO.updateKhachSan(khachSan, khachSan.getId());
    }
}
