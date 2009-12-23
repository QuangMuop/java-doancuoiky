
package Agent;

import Hotel.HotelInfo;
import java.io.IOException;
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
            Document dom = builder.parse(HotelController.path + "ListKhachSan.xml");
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
}
