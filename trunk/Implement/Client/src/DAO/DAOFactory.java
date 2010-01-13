/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

public abstract class DAOFactory {		
    public abstract IPhongDAO getPhongDAO();
    public abstract IKhachHangDAO getKhachHangDAO();
    public abstract IThuePhongDAO getThuePhongDAO();
    public abstract ILoaiKhachHangDAO getLoaiKhachHangDAO();
    public abstract ITinhTrangPhongDAO getTinhTrangPhongDAO();
    public abstract ILoaiPhongDAO getLoaiPhongDAO();
    public abstract IThamSoDAO getThamSoDAO();
    public abstract IKhachSanDAO getKhachSanDAO();
    public abstract Connector getConnector();

    public static DAOFactory getInstance()
    {
        return new MySqlDAOFactory();
    }
}
