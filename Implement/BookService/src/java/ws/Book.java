/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ws;

import BUS.PhongController;
import BUS.ThuePhongController;
import DTO.KhachHang;
import DTO.LoaiThue;
import DTO.Phong;
import DTO.ThuePhong;
import Utils.MyDateTime;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
public class Book {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getListIdRoomAvailable")
    public java.lang.Integer[] getListIdRoomAvailable() {
        //TODO write your implementation code here:
        PhongController phongController = new PhongController();

        return phongController.getListIdPhongChuaThue();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "bookRoom")
    public String bookRoom(@WebParam(name = "soPhong")
    int soPhong, @WebParam(name = "khach")
    ws.KhachHangDTO khach, @WebParam(name = "ngayDat")
    String ngayDat) {
        //TODO write your implementation code here:
        //kiem tra phong co ton tai hay khong

        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(new File(".\\log.txt")));

            dos.writeChars("--> bookRoom" + "\n");

            PhongController phongController = new PhongController();
            Phong phong = phongController.getPhongTheoId(soPhong);

            dos.writeChars("Get duoc phong:" + phong.getId() + "\n");

            if(phong==null || phong.getIdTinhTrang().getTen().toLowerCase().equals("da thue"))
            {
                //neu phong can dat khong ton tai hoac phong da co nguoi
                return "";
            }

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date ngayDatPhong = null;
            if(ngayDat.equals(""))
            {
                ngayDatPhong = MyDateTime.getNow();
            }
            else
            {
                try {
                    ngayDatPhong = sdf.parse(ngayDat);
                } catch (ParseException ex) {
                    Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
                    return "";
                }
            }

            dos.writeChars("Ngay dat phong:" + sdf.format(ngayDatPhong) + "\n");
            
            LoaiThue loaiThue = new LoaiThue();
            loaiThue.setId(0);
            loaiThue.setLoai("Dat phong");

            dos.writeChars("Loai Thue:" + loaiThue.getLoai()+ "\n");

            KhachHang myKhachDTO = new KhachHang();
            myKhachDTO.setId(khach.getId());
            myKhachDTO.setTen(khach.getName());

            try {
                myKhachDTO.setNgaySinh(sdf.parse(khach.getBirthDay()));
            } catch (ParseException ex) {
                Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
                return "";
            }

            dos.writeChars("Ngay sinh cua khach:" + sdf.format(myKhachDTO.getNgaySinh()) + "\n");

            ThuePhong thuePhong = new ThuePhong();
            thuePhong.setIdLoaiThue(loaiThue);
            thuePhong.addKhachHang(myKhachDTO);
            thuePhong.setNgayThue(ngayDatPhong);
            thuePhong.setPhong(phong);
            thuePhong.setTongGia(0);

            dos.writeChars("Kiem tra nghiep vu thue phong " + "\n");

            ThuePhongController thuePhongController = new ThuePhongController();
            String error = thuePhongController.kiemTraNghiepVuThuePhong(thuePhong);

            dos.writeChars("Bat dau thue phong" + "\n");

            if(error.equals(""))
            {                
                String code = thuePhongController.tiepNhanViecThuePhong(thuePhong,dos);
                dos.writeChars("Ma so xac nhan:" + code + "\n");
                dos.writeChars("bookRoom <--" + "\n");
                return code;
            }
            else
            {
                dos.writeChars("bookRoom (loi) <--" + "\n");
                return "";
            }
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
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cancelBookRoom")
    public Boolean cancelBookRoom(@WebParam(name = "securityCode")
    String securityCode) {
        //TODO write your implementation code here:
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(new File(".\\log.txt")));
            dos.writeChars("--> cancelBook" + "\n");

            ThuePhongController thuePhongController = new ThuePhongController();

            boolean result = thuePhongController.huyDatPhong(securityCode);

            dos.writeChars("cancelBook <--" + result + "\n");
            return result;
        }
        catch (IOException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally {
            try {
                dos.flush();
                dos.close();
            }
            catch (IOException ex) {
                Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}