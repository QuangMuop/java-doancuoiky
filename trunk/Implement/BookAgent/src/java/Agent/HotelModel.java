
package Agent;

import Common.Configuration;
import Common.Utility;
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
import ws.FileNotFoundException_Exception;
import ws.IOException_Exception;
import ws.KhachHangDTO;
import ws.ParseException_Exception;

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
        try {
            if (hid < 0 || hid >= this.listHotel.getHotels().size()) {
                throw new IndexOutOfBoundsException("Hotel index");
            }
            // update list room
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
        } catch (FileNotFoundException_Exception ex) {
            Logger.getLogger(HotelModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException_Exception ex) {
            Logger.getLogger(HotelModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String bookRoom(int hid, String rid, KhachHangDTO dto) {
        try {
            return WSWrapper.bookRoom(hid, rid, dto, Utility.now("dd/MM/yyyy"));
        } catch (FileNotFoundException_Exception ex) {
            Logger.getLogger(HotelModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException_Exception ex) {
            Logger.getLogger(HotelModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException_Exception ex) {
            Logger.getLogger(HotelModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
