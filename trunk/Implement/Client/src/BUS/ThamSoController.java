/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BUS;

import DAO.DAOFactory;
import DAO.IThamSoDAO;
import DTO.ThamSo;
import java.util.ArrayList;

/**
 *
 * @author bin
 */
public class ThamSoController {
    IThamSoDAO thamSoDAO;

    public ThamSoController()
    {
        thamSoDAO = DAOFactory.getInstance().getThamSoDAO();
    }

    public ThamSo layThamSo(String tenThamSo)
    {
        return thamSoDAO.getThamSo(tenThamSo);
    }

    public boolean capNhatThamSo(ThamSo thamSo)
    {
        return thamSoDAO.updateThamSo(thamSo);
    }

    public ArrayList<ThamSo> layDSThamSo()
    {
        return thamSoDAO.getDSThamSo();
    }
}
