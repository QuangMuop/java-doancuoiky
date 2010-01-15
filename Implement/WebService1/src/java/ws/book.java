/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ws;


import BUS.PhongController;
import BUS.ThuePhongController;
import DAO.MySqlPhongDAO;
import DTO.KhachHang;
import DTO.LoaiThue;
import DTO.Phong;
import DTO.ThuePhong;
import Utils.MyDateTime;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class book {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cancelBookRoom")
    public Boolean cancelBookRoom(@WebParam(name = "securityCode")
    String securityCode) {
        //TODO write your implementation code here:
        ThuePhongController thuePhongController = new ThuePhongController();
        return thuePhongController.huyDatPhong(securityCode);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "bookRoom")
    public String bookRoom(@WebParam(name = "soPhong")
    int soPhong, @WebParam(name = "khach")
    KhachHangDTO khach, @WebParam(name = "ngayDat")
    String ngayDat) {
        //TODO write your implementation code here:

        //kiem tra phong co ton tai hay khong
        PhongController phongController = new PhongController();
        Phong phong = phongController.getPhongTheoId(soPhong);
        if(phong==null || phong.getIdTinhTrang().getTen().toLowerCase().equals("da thue"))
        {
            //neu phong can dat khong ton tai hoac phong da co nguoi
            return "";
        }

        Date ngayDatPhong = null;
        if(ngayDat.equals(""))
        {
            ngayDatPhong = MyDateTime.getNow();
        }
        else
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                ngayDatPhong = sdf.parse(ngayDat);
            } catch (ParseException ex) {
                Logger.getLogger(book.class.getName()).log(Level.SEVERE, null, ex);
                return "";
            }
        }

        ThuePhongController thuePhongController = new ThuePhongController();
        LoaiThue loaiThue = thuePhongController.layLoaiThueTheoTen("Dat phong");

        KhachHang myKhachDTO = new KhachHang();
        myKhachDTO.setId(khach.getId());
        myKhachDTO.setTen(khach.getName());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            myKhachDTO.setNgaySinh(sdf.parse(khach.getBirthDay()));
        } catch (ParseException ex) {
            Logger.getLogger(book.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }

        ThuePhong thuePhong = new ThuePhong();
        thuePhong.setIdLoaiThue(loaiThue);
        thuePhong.addKhachHang(myKhachDTO);
        thuePhong.setNgayThue(ngayDatPhong);
        thuePhong.setPhong(phong);
        thuePhong.setTongGia(0);

        String error = thuePhongController.kiemTraNghiepVuThuePhong(thuePhong);
        if(error.equals(""))
        {
            return thuePhongController.tiepNhanViecThuePhong(thuePhong);
        }
        else
            return "";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getListIdRoomAvailable")
    public java.lang.Integer[] getListIdRoomAvailable() {
        //TODO write your implementation code here:
        PhongController phongController = new PhongController();
        
        return phongController.getListIdPhongChuaThue();
    }

}
