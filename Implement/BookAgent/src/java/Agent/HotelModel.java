
package Agent;

import Hotel.HotelInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author hvu
 */
public class HotelModel {
    public HotelInfo getHotelById(int hid) {
        HotelInfo info = null;
        
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document dom = builder.parse(StartUpServlet.path + "ListKhachSan.xml");
            dom.normalize();

            NodeList listHotels = dom.getElementsByTagName("KhachSan");
            for (int i = 0; i < listHotels.getLength(); i++) {
                info = new HotelInfo((Element) listHotels.item(i));
                if (info.getId() == hid) {
                    return info;
                }
            }
        } catch (SAXException ex) {
            Logger.getLogger(HotelModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HotelModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(HotelModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return info;
    }

    public ArrayList<HotelInfo> getHotels() {
        ArrayList<HotelInfo> listHotels = new ArrayList<HotelInfo>();

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document dom = builder.parse(StartUpServlet.path + "ListKhachSan.xml");
            dom.normalize();

            NodeList listNodes = dom.getElementsByTagName("KhachSan");
            for (int i = 0; i < listNodes.getLength(); i++) {
                listHotels.add(new HotelInfo((Element) listNodes.item(i)));
            }
        } catch (SAXException ex) {
            Logger.getLogger(HotelModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HotelModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(HotelModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listHotels;
    }
}
