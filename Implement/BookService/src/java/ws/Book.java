/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ws;

//import BUS.ThuePhongController;
import DTO.MyDateTime;
import DBProvider.MySqlConnector;
import DBProvider.Connector;
import DBProvider.RoomDAO;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author bin
 */
@WebService()
public class Book {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getListIdRoomAvailable")
    public java.lang.Integer[] getListIdRoomAvailable() throws FileNotFoundException, IOException {
        //TODO write your implementation code here:
        RoomDAO roomDAO = new RoomDAO();
        return roomDAO.getListRoomAvailable();
       /*
        Connector connector = new MySqlConnector();

        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(new File(".\\log.txt")));

            dos.writeChars("--> getListIdRoomAvailable" + "\n");

            connector.openConnection();

            String sql = "select id from phong where phong.id_tinh_trang = 0 order by id;";

            CallableStatement statement = connector.getConnection().prepareCall(sql);


            //execute query
            ResultSet rs = statement.executeQuery();

            ArrayList lstId = new ArrayList();
            while(rs.next())
            {
                 lstId.add(rs.getInt("id"));
            }

            statement.close();

            dos.writeChars("Lst id" + "\n");
            Integer[] arrInt = new Integer[lstId.size()];
            int i;
            for(i=0;i<lstId.size();i++)
            {
                arrInt[i] = (Integer)lstId.get(i);
                dos.writeChars("" + arrInt[i] + "\n");
            }
            dos.writeChars("end lst id" + "\n");

            dos.writeChars("getListIdRoomAvailable -->" + "\n");
            return arrInt;


        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            connector.closeConnection();
            try {
                dos.flush();
                dos.close();
            }
            catch (IOException ex) {
                Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        */
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "bookRoom")
    public String bookRoom(@WebParam(name = "soPhong")
    int soPhong, @WebParam(name = "khach")
    DTO.KhachHangDTO khach, @WebParam(name = "ngayDat")
    String ngayDat) throws FileNotFoundException, IOException, ParseException {
        //TODO write your implementation code here:
        //kiem tra phong co ton tai hay khong
        RoomDAO roomDAO = new RoomDAO();
        return roomDAO.bookRoom(soPhong, khach, ngayDat);
/*
        Connector connector = new MySqlConnector();

        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(new File(".\\log.txt")));

            dos.writeChars("--> bookRoom" + "\n");
            
            connector.openConnection();

            //kiem tra phong co con trong hay khong
            String sql = "select phong.id from phong where phong.id_tinh_trang = 0  and phong.id = ?";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setInt(1, soPhong);

            //execute query
            ResultSet rs = statement.executeQuery();

            boolean hasValue = false;
            int idPhong = -1;
            while(rs.next())
            {
                 hasValue = true;
                 idPhong = rs.getInt("id");
            }
            statement.close();

            //neu khong tim duoc phong tra ve chuoi rong
            if(!hasValue)
                return "";
            
            dos.writeChars("Get duoc phong:" + idPhong + "\n");

            /////////////kiem tra khach hang////////////////
            dos.writeChars("Kiem tra khach hang da ton tai hay chua" + "\n");
            

            sql = "select id from khach_hang where id = ?;";

            dos.writeChars("lenh sql: " + sql + khach.getId() + "\n");

            statement = connector.getConnection().prepareCall(sql);
            statement.setString(1, khach.getId());

            rs = statement.executeQuery();

            if(rs.next())
            {
                dos.writeChars("Khang hang da ton tai" + "\n");
                statement.close();
            }
            else
            {
                dos.writeChars("Khach hang chua ton tai -> them khach hang" + "\n");
                
                sql = "insert into khach_hang (id,ten) values ('" + khach.getId() + "','" + khach.getName() + "');";
                statement = connector.getConnection().prepareCall(sql);

                dos.writeChars("sql" + sql + "\n");
                //chay di build ko
                //build chu
                //khoan :D roi :D  ZZZ j the
                //execute query
                if(statement.executeUpdate()>0)
                {
                    statement.close();
                    dos.writeChars("THem khach hang " + khach.getName() + " thanh cong" + "\n");
                }
                else
                {
                     dos.writeChars("Them khach hang that bai" + "\n");
                     statement.close();
                     return "";
                }

            }

            dos.writeChars("Bat dau them vao bang chi tiet thue phong" + "\n");
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
           
            //them vao bang chi tiet thue phong
            sql = "INSERT INTO CHI_TIET_THUE_PHONG(id, id_phong, ngay_thue, tong_gia, id_loai_thue) VALUES (?,?,?,?,?);";
            statement = connector.getConnection().prepareCall(sql);

            SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
            Date ngayDatPhong = null;
            if(ngayDat.equals(""))
            {
                ngayDatPhong = MyDateTime.getNow();
            }
            else
            {
                ngayDatPhong = formatDate.parse(ngayDat);
            }
            
            String sIdChiTietThue = "" + soPhong;
            SimpleDateFormat formatIdChiTietThue = new SimpleDateFormat("yyyyMMddhhmmss");
            
            String sNgayThue = formatIdChiTietThue.format(ngayDatPhong);
            sIdChiTietThue += sNgayThue;

            statement.setString(1, sIdChiTietThue);
            statement.setInt(2, soPhong);
            statement.setString(3, sdf.format(ngayDatPhong));
            statement.setInt(4, 0);
            statement.setInt(5, 0);

            if(!(statement.executeUpdate()>0))
            {
                statement.close();
                dos.writeChars("Them vao bang chi tiet thue phong that bai" + "\n");
                return "";
            }
            else
            {
                dos.writeChars("Them vao bang chi tiet thue phong thanh cong" + "\n");
                statement.close();
            }

           
            //them vao bang thue phong
            dos.writeChars("Them vao bang thue phong" + "\n");

            sql = "INSERT INTO THUE_PHONG(id_chi_tiet_thue, id_khach) VALUES (?,?);";
            statement = connector.getConnection().prepareCall(sql);
            statement.setString(1, sIdChiTietThue);
            statement.setString(2, khach.getId());

            //them vao bang thue phong
            if(statement.executeUpdate()>0)
            {
                dos.writeChars("Them vao bang thue phong thanh cong" + "\n");
                statement.close();

                //cap nhat lai thong tin tinh trang phong

                dos.writeChars("Cap nhat tinh trang phong" + "\n");
                sql = "update phong set id_tinh_trang = ? where id = ?;";

                statement = connector.getConnection().prepareCall(sql);
                statement.setInt(1, 1);
                statement.setInt(2, soPhong);

                //execute query
                if(statement.executeUpdate()>0)
                {
                    dos.writeChars("Cap nhat tinh trang phong thanh cong" + "\n");
                    dos.writeChars("Ket thuc thue phong. ma so xac nhan " + sIdChiTietThue + "\n");
                    statement.close();
                    return sIdChiTietThue;
                }
                else
                {
                    dos.writeChars("Cap nhat tinh trang phong that bai" + "\n");
                    statement.close();
                    return "";
                }
            }
            else
            {
                dos.writeChars("Them vao bang thue phong that bai" + "\n");
                statement.close();
                return "";
            }
        
        }
    catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        catch (IOException ex)
        {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        finally
        {
            try {
                dos.flush();
                dos.close();
            }
            catch (IOException ex) {
                Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
            }
            connector.closeConnection();
        }
 */
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cancelBookRoom")
    public Boolean cancelBookRoom(@WebParam(name = "securityCode")
    String securityCode) throws IOException {
        //TODO write your implementation code here:
        RoomDAO roomDAO = new RoomDAO();
        return roomDAO.cancelBookRoom(securityCode);
/*
        DataOutputStream dos = null;
        Connector connector = new MySqlConnector();
        try {
            dos = new DataOutputStream(new FileOutputStream(new File(".\\log.txt")));
            dos.writeChars("--> cancelBook" + "\n");

            connector.openConnection();

            dos.writeChars("xoa chi tiet thue phong " + "\n");
            String sql = "delete from thue_phong where id_chi_tiet_thue = ?;";
            CallableStatement statement = connector.getConnection().prepareCall(sql);
            statement.setString(1, securityCode);
            if(statement.executeUpdate()>0)
            {
                dos.writeChars("xoa chi tiet thue phong thanh cong" + "\n");
                statement.close();

                dos.writeChars("lay id phong duoc thue" + "\n");

                sql = "select id_phong from chi_tiet_thue_phong where id = ?";
                statement = connector.getConnection().prepareCall(sql);
                statement.setString(1, securityCode);

                int idPhong = -1;
                ResultSet rs = statement.executeQuery();
                while(rs.next())
                {
                    idPhong = rs.getInt("id_phong");
                    dos.writeChars("id phong:" + idPhong + "\n");
                }
                if(idPhong == -1)
                    return false;


                dos.writeChars("Cap nhat tinh trang phong" + "\n");
                sql = "update phong set id_tinh_trang = ? where id = ?;";

                statement = connector.getConnection().prepareCall(sql);
                statement.setInt(1, 0);
                statement.setInt(2, idPhong);

                //execute query
                if(statement.executeUpdate()>0)
                {
                    dos.writeChars("Cap nhat tinh trang phong thanh cong" + "\n");
                    statement.close();
                }
                else
                {
                    dos.writeChars("Cap nhat tinh trang phong that bai" + "\n");
                    statement.close();
                    return false;
                }

                dos.writeChars("Xoa chi tiet thue phong" + "\n");
                //xoa chi tiet thue phong
                sql = "delete from chi_tiet_thue_phong where id = ?;";
                statement = connector.getConnection().prepareCall(sql);
                statement.setString(1, securityCode);
                if(statement.executeUpdate()>0)
                {
                    dos.writeChars("Xoa chi tiet thue phong thanh cong" + "\n");
                    return true;
                }
                else
                {
                    dos.writeChars("Xoa chi tiet thue phong that bai" + "\n");
                    return false;
                }
            }
            else
            {
                dos.writeChars("xoa chi tiet thue phong that bai" + "\n");
                statement.close();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            connector.closeConnection();
        }
        */
    }
}