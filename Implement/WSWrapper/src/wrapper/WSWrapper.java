
package wrapper;

import ws.KhachHangDTO;



/**
 *
 * @author hvu
 */
public class WSWrapper {
    static public boolean booking(int hid, String room, Customer customer) {
        switch (hid) {
            case 0:
                WebService1.BookService1 service1 = new WebService1.BookService1();
                KhachHangDTO dto1 = new KhachHangDTO();
                dto1.setName(customer.getName());
                dto1.setAge(customer.getAge());
                return service1.getBookPort().book(room, dto1);
            case 1:
                WebApplication2.BookService service2 = new WebApplication2.BookService();
                KhachHangDTO dto2 = new KhachHangDTO();
                dto2.setName(customer.getName());
                dto2.setAddress(customer.getAddress());
                dto2.setAge(customer.getAge());
                return service2.getBookPort().book(room, dto2);
        }
        return false;
    }
}
