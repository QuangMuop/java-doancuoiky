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
import java.util.ArrayList;
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
     * Web service operation
     */
    @WebMethod(operationName = "cancelBookRoom")
    public Boolean cancelBookRoom(@WebParam(name = "securityCode")
    String securityCode) {
        ThuePhongController thuePhongController = new ThuePhongController();
        return thuePhongController.huyDatPhong(securityCode);
    }

    /**
     * Tra ve tat ca phong
     * tra ve null neu khong co
     */
    @WebMethod(operationName = "getListRoom")
    public ws.RoomDTO[] getListRoom() {
        //TODO write your implementation code here:
        PhongController phongController = new PhongController();
        ArrayList<Phong> arrPhong = phongController.getDSPhong();
        if(arrPhong!=null)
        {
            RoomDTO[] arrRoomDTO = new RoomDTO[arrPhong.size()];

            int i;
            for(i=0;i<arrPhong.size();i++)
            {
                RoomDTO roomDTO = new RoomDTO();
                Phong phong = arrPhong.get(i);

                roomDTO.setId("" + phong.getId());
                roomDTO.setDetail(phong.getMoTa());
                roomDTO.setCost(phong.getGia() + phong.getIdLoaiPhong().getGia());

                if(phong.getIdTinhTrang().getTen().toLowerCase().equals("con trong"))
                {
                    roomDTO.setCanStay(true);
                }
                else
                {
                    roomDTO.setCanStay(false);
                }

                arrRoomDTO[i] = roomDTO;
            }

            return arrRoomDTO;
        }
        else
            return null;
    }

    /**
     * su dung de dat phong online.
     * soPhong: id cua phong can dat
     * khach: thong tin khach hang dat phong
     * ngayDat: ngay dat phong (neu truyen vao "" thi se lay ngay hien tai)
     * tra ve ma so xac nhan su dung cho viec huy dat phong sau nay
     * neu xay ra loi thi se tra ve chuoi rong
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
        ArrayList<Phong> lstPhong = phongController.getDSPhongChuaThue();

        Integer[] arrId = null;

        if(lstPhong!=null)
        {
            arrId = new Integer[lstPhong.size()];
            int i;
            for(i=0;i<lstPhong.size();i++)
            {
                arrId[i] = lstPhong.get(i).getId();
            }

            return arrId;
        }
        else
            return null;
    }
}
