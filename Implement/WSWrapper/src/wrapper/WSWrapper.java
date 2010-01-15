
package wrapper;

import java.util.List;
import ws.BookService;
import ws.KhachHangDTO;


/**
 *
 * @author hvu
 */
public class WSWrapper {

    static public String bookRoom(int hid, String rid, KhachHangDTO customer, String date) {
        switch (hid) {
            case 0:
                BookService service = new BookService();
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
                BookService service = new BookService();
                return service.getBookPort().cancelBookRoom(validateCode);
            case 1:
                break;
        }
        return false;
    }

    static public List<Integer> updateListRoomAvailable(int hid) {
        switch (hid) {
            case 0:
                BookService service = new BookService();
                return service.getBookPort().getListIdRoomAvailable();
            case 1:
                break;
        }
        return null;
    }

}
