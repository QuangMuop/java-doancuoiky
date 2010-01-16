/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.ThamSo;
import java.util.ArrayList;

/**
 *
 * @author bin
 */
public interface IThamSoDAO {    
    public boolean updateThamSo(ThamSo ts);
    public ThamSo getThamSo(String tenThamSo);
    public ArrayList<ThamSo> getDSThamSo();
}
