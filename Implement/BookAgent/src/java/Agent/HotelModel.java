
package Agent;

import Common.Configuration;
import Hotel.Hotel;
import Hotel.ListHotel;
import Hotel.Room;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import wrapper.WSWrapper;
import ws.KhachHangDTO;

/**
 *
 * @author hvu
 */
public class HotelModel {
    private ListHotel listHotel;
    private Hotel currentHotel;

    public HotelModel() {
        try {
            Document hotelDom = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(Configuration.HOTELS_PATH);
            this.listHotel = ListHotel.load(hotelDom.getDocumentElement());
            this.currentHotel = null;
        } catch (SAXException ex) {
            Logger.getLogger(HotelModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HotelModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(HotelModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static public int getHotelFreeId() throws ParserConfigurationException, SAXException, IOException {
        int max = -1;

        Document hotelDom = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(Configuration.STARTUP_PATH + "\\hotels.xml");
        ListHotel hotels = ListHotel.load(hotelDom.getDocumentElement());
        for (int i = 0; i < hotels.getHotels().size(); i++) {
            Hotel hotel = hotels.getHotels().get(i);
            if (max < hotel.getId()) {
                max = hotel.getId();
            }
        }

        max++;
        return max;
    }

    public Hotel getHotelById(int hid) {
        if (hid < 0 || hid >= this.listHotel.getHotels().size()) {
            throw new IndexOutOfBoundsException("Hotel index");
        }
        // update list room
        KhachHangDTO dto= new KhachHangDTO();
        dto.setId("1324");
        dto.setName("ajfhksad");
        dto.setBirthDay("01/01/1988");
        WSWrapper.bookRoom(hid, "10", null, "15/01/2010");
        List<Integer> lst = WSWrapper.updateListRoomAvailable(hid);
        Hotel hotel = this.listHotel.getHotels().get(hid);
        List<Room> rooms = hotel.getListRoom().getRooms();
        for (int i = 0; i < rooms.size(); i++) {
            rooms.get(i).setStay(false);
            for (int j = 0; j < lst.size(); j++) {
                if (rooms.get(i).getId().equals(String.valueOf(lst.get(j)))) {
                    rooms.get(i).setStay(true);
                    break;
                }
            }
        }
        return hotel;
    }

    public ListHotel getListHotel() {
        return this.listHotel;
    }

    public Hotel getCurrentHotel() {
        return this.currentHotel;
    }

    public void setCurrentHotel(Hotel hotel) {
        this.currentHotel = hotel;
    }
}
