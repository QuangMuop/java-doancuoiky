/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

public class MySqlDAOFactory extends DAOFactory {

    @Override
    public IPhongDAO getPhongDAO() {
        return new MySqlPhongDAO();
    }

    @Override
    public IKhachHangDAO getKhachHangDAO() {
        return new MySqlKhachHangDAO();
    }

    @Override
    public IThuePhongDAO getThuePhongDAO() {
        return new MySqlThuePhongDAO();
    }

    @Override
    public Connector getConnector() {
        return new MySqlConnector();
    }
    
    @Override
    public ITinhTrangPhongDAO getTinhTrangPhongDAO() {
        return new MySqlTinhTrangPhongDAO();
    }
    
    @Override
    public IThamSoDAO getThamSoDAO() {
        return new MySqlThamSoDAO();
    }

    @Override
    public IKhachSanDAO getKhachSanDAO() {
        return new MySqlKhachSanDAO();
    }
}
