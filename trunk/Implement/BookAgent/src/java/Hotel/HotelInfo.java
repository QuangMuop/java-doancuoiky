
package Hotel;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 *
 * @author hvu
 */
public class HotelInfo {
    private int id;
    private String name;
    private String address;
    private String description;
    private int numberOfRooms;
    private int maxNumberOfPeople;
    private int[] roomTypes;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getMaxNumberOfPeople() {
        return maxNumberOfPeople;
    }

    public int[] getRoomTypes() {
        return roomTypes;
    }


    public HotelInfo() {
    
    }

    public HotelInfo(Element xmlNode) {
        try {
            id = Integer.parseInt(xmlNode.getAttribute("id"));
            name = xmlNode.getElementsByTagName("Ten").item(0).getTextContent();
            address = xmlNode.getElementsByTagName("DiaChi").item(0).getTextContent();
            description = xmlNode.getElementsByTagName("MoTa").item(0).getTextContent();
            numberOfRooms = Integer.parseInt(xmlNode.getElementsByTagName("SoPhong").item(0).getTextContent());
        }
        catch (Exception ex) {
            Logger.getLogger(HotelInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static public HotelInfo load(Element xmlNode) {
        HotelInfo info = new HotelInfo();
        try {
            info.id = Integer.parseInt(xmlNode.getAttribute("id"));
            info.name = xmlNode.getElementsByTagName("Ten").item(0).getNodeValue();
            info.address = xmlNode.getElementsByTagName("DiaChi").item(0).getNodeValue();
            info.description = xmlNode.getElementsByTagName("MoTa").item(0).getNodeValue();
            info.numberOfRooms = Integer.parseInt(xmlNode.getElementsByTagName("SoPhong").item(0).getNodeValue());
        }
        catch (Exception ex) {
            Logger.getLogger(HotelInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return info;
    }
}
