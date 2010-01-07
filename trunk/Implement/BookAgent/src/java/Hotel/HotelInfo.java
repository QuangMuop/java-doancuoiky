
package Hotel;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


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
    private String path;
    private int[] roomTypes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void serDescription(String description) {
        this.description = description;
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

    public String getPath() {
        return this.path;
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
            path = xmlNode.getElementsByTagName("DuongDan").item(0).getTextContent();
        }
        catch (Exception ex) {
            Logger.getLogger(HotelInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Element toXMLNode() {
        try {
            Document dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element hotelNode = dom.createElement("KhachSan");
            Attr idAttr = dom.createAttribute("id");
            // retrieve validate id for this hotel
            idAttr.setValue(String.valueOf(this.id));

            Element nameNode = dom.createElement("Ten");
            nameNode.setTextContent(this.name);
            hotelNode.appendChild(nameNode);

            Element addressNode = dom.createElement("DiaChi");
            addressNode.setTextContent(this.address);
            hotelNode.appendChild(addressNode);

            Element roomNode = dom.createElement("SoPhong");
            roomNode.setTextContent(String.valueOf(this.numberOfRooms));
            hotelNode.appendChild(roomNode);

            Element imgNode = dom.createElement("Hinh");
            imgNode.setTextContent(String.valueOf(this.path));
            hotelNode.appendChild(imgNode);

            Element descNode = dom.createElement("MoTa");
            descNode.setTextContent(this.description);
            hotelNode.appendChild(descNode);

            Element pathNode = dom.createElement("DuongDan");
            pathNode.setTextContent(this.path);
            hotelNode.appendChild(pathNode);
            
            return hotelNode;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(HotelInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    static public HotelInfo load(Element xmlNode) {
        return new HotelInfo(xmlNode);
    }

    /**
     * Static function to get free id for new hotel
     * @return id, max id of all ids are exist
     */
    static public int getHotelFreeId() {
        int id = -1;


        try {
            Document dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("");
            NodeList lstHotels = dom.getDocumentElement().getElementsByTagName("KhachSan");
            for (int i = 0; i < lstHotels.getLength(); i++) {
                int hid = Integer.parseInt(((Element) lstHotels.item(i)).getAttribute("id"));
                if (id < hid) {
                    id = hid;
                }
            }
            // id = max id
            id++;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(HotelInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(HotelInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HotelInfo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }
}