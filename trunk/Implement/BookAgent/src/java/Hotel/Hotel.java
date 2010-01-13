
package Hotel;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 *
 * @author hvu
 */
public class Hotel {
    private int id;
    private String name;
    private String address;
    private String detail;
    private int room;
    private String path;


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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String description) {
        this.detail = description;
    }
    
    public int getRoom() {
        return room;
    }

    public void setRoom(int value) {
        this.room = value;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String value) {
        this.path = value;
    }

    public Hotel(HotelDTO hotelDto) {
        this.name = hotelDto.getName();
        this.address = hotelDto.getAddress();
        this.detail = hotelDto.getDetail();
    }

    public Hotel(Element elem) {
        id = Integer.parseInt(elem.getAttribute("id"));
        name = elem.getElementsByTagName("Ten").item(0).getTextContent();
        address = elem.getElementsByTagName("DiaChi").item(0).getTextContent();
        detail = elem.getElementsByTagName("MoTa").item(0).getTextContent();
        room = Integer.parseInt(elem.getElementsByTagName("SoPhong").item(0).getTextContent());
        path = elem.getElementsByTagName("DuongDan").item(0).getTextContent();
    }

    public Element toXmlElement(Document dom) {

        Element hotelNode = dom.createElement("KhachSan");

        hotelNode.setAttribute("id", String.valueOf(this.id));

        Element nameNode = dom.createElement("Ten");
        nameNode.setTextContent(this.name);
        hotelNode.appendChild(nameNode);

        Element addressNode = dom.createElement("DiaChi");
        addressNode.setTextContent(this.address);
        hotelNode.appendChild(addressNode);

        Element roomNode = dom.createElement("SoPhong");
        roomNode.setTextContent(String.valueOf(this.room));
        hotelNode.appendChild(roomNode);

        Element descNode = dom.createElement("MoTa");
        descNode.setTextContent(this.detail);
        hotelNode.appendChild(descNode);

        Element pathNode = dom.createElement("DuongDan");
        pathNode.setTextContent(this.path);
        hotelNode.appendChild(pathNode);

        return hotelNode;
        
    }

    static public Hotel load(Element elem) {
        return new Hotel(elem);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Hotel) {
            Hotel hotel = (Hotel) obj;
            return this.id == hotel.id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.id;
        return hash;
    }
}
