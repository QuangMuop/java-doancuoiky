
package wrapper;

import java.util.List;
import ws.KhachHangDTO;
import ws.RoomDTO;



/**
 *
 * @author hvu
 */
public class WSWrapper {
    static public boolean booking(int hid, String room, Customer customer) {
        switch (hid) {
            case 0:
                WebService1.BookService service1 = new WebService1.BookService();
                KhachHangDTO dto1 = new KhachHangDTO();
                dto1.setName(customer.getName());
                dto1.setAge(customer.getAge());
                return service1.getBookPort().book(room, dto1);
            case 1:
                break;
        }
        return false;
    }

    static public String bookRoom(int hid, String rid, KhachHangDTO customer, String date) {
        switch (hid) {
            case 0:
                WebService1.BookService service = new WebService1.BookService();
                int room = Integer.parseInt(rid);
                return service.getBookPort().bookRoom(room, customer, date);
            case 1:
                break;
        }
        return null;
    }

    static public boolean cancelBookRoom(int hid, String validateCode) {
        switch (hid) {
            case 0:
                WebService1.BookService service = new WebService1.BookService();
                return service.getBookPort().cancelBookRoom(validateCode);
            case 1:
                break;
        }
        return false;
    }

    static public List<RoomDTO> updateListRoom(int hid) {
        switch (hid) {
            case 0:
                WebService1.BookService service = new WebService1.BookService();
                return service.getBookPort().getListRoom();
            case 1:
                break;
        }
        return null;
    }
}
