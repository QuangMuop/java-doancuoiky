
package Agent;

import Common.Configuration;
import Hotel.Hotel;
import Hotel.ListHotel;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author hvu
 */
public class HotelModel {
    private ListHotel hotels;
    private Hotel currentHotel;

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
        if (hid < 0 || hid >= this.hotels.getHotels().size()) {
            throw new IndexOutOfBoundsException("Hotel index");
        }
        return this.hotels.getHotels().get(hid);
    }

    public ListHotel getHotels() {
        return this.hotels;
    }
}
