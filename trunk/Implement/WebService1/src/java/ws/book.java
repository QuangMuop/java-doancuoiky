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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author hvu
 */
@WebService()
public class book {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "book")
    public boolean book(@WebParam(name = "room")
    String room, @WebParam(name = "customer")
    KhachHangDTO customer) {
        //TODO write your implementation code here:
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(new File(".\\test.txt")));
            dos.writeChars("KS1\nDang ky: " + room + "\nKhach hang: " + customer.getName());
            return true;
        } catch (IOException ex) {
            Logger.getLogger(book.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dos.flush();
                dos.close();
            } catch (IOException ex) {
                Logger.getLogger(book.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    /**
     * su dung de dat phong online.
     * soPhong: id cua phong can dat
     * khach: thong tin khach hang dat phong
     * ngayDat: ngay dat phong (neu truyen vao null thi se lay ngay hien tai)
     * tra ve ma so xac nhan su dung cho viec huy dat phong sau nay
     * neu xay ra loi thi se tra ve chuoi rong
     */
    @WebMethod(operationName = "bookRoom")
    public String bookRoom(@WebParam(name = "soPhong")
    int soPhong, @WebParam(name = "khach")
    KhachHangDTO khach, @WebParam(name = "ngayDat")
    Date ngayDat) {
        //TODO write your implementation code here:
        //kiem tra phong co ton tai hay khong
        PhongController phongController = new PhongController();
        Phong phong = phongController.getPhongTheoId(soPhong);
        if(phong==null || phong.getIdTinhTrang().getTen().toLowerCase().equals("da thue"))
        {
            //neu phong can dat khong ton tai hoac phong da co nguoi
            return "";
        }

        if(ngayDat == null)
        {
            ngayDat = MyDateTime.getNow();
        }

        ThuePhongController thuePhongController = new ThuePhongController();
        LoaiThue loaiThue = thuePhongController.layLoaiThueTheoTen("Dat phong");

        KhachHang myKhachDTO = new KhachHang();
        myKhachDTO.setId(khach.getId());
        myKhachDTO.setTen(khach.getName());
        
        ThuePhong thuePhong = new ThuePhong();
        thuePhong.setIdLoaiThue(loaiThue);
        thuePhong.addKhachHang(myKhachDTO);
        thuePhong.setNgayThue(ngayDat);
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
    @WebMethod(operationName = "cancelBookRoom")
    public Boolean cancelBookRoom(@WebParam(name = "securityCode")
    String securityCode) {
        ThuePhongController thuePhongController = new ThuePhongController();
        return thuePhongController.huyDatPhong(securityCode);
    }
}
