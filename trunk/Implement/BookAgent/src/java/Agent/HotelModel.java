
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
        try
        {
        List<ws.RoomDTO> listRoomDto = WSWrapper.updateListRoom(hid);

        List<Room> rooms = this.listHotel.getHotels().get(hid).getListRoom().getRooms();
        rooms.clear();
        for (int i = 0; i < listRoomDto.size(); i++) {
            Room room = new Room();
            room.setId(listRoomDto.get(i).getId());
            room.setCost(listRoomDto.get(i).getCost());
            room.setStay(listRoomDto.get(i).isCanStay());
            rooms.add(room);
        }
        }
        catch(Exception ex) 
        {
        }
        return this.listHotel.getHotels().get(hid);
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
