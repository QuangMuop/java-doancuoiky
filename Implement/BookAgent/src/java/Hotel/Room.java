
package Hotel;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author hvu
 */
public class Room {
    private String id;
    private int cost;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Room(RoomDTO roomDto) {
        this.id = roomDto.getId();
        this.cost = roomDto.getCost();
    }

    public Room(Element xmlNode) {
        id = xmlNode.getAttribute("id");
        cost = Integer.parseInt(xmlNode.getElementsByTagName("Gia").item(0).getTextContent());
    }

    public static Room load(Element elem) {
        return new Room(elem);
    }

    public Element toXmlElement(Document dom) {
        Element roomNode = dom.createElement("Phong");

        roomNode.setAttribute("id", String.valueOf(this.id));

        Element costNode = dom.createElement("Gia");
        costNode.setTextContent(String.valueOf(this.cost));
        roomNode.appendChild(costNode);

        return roomNode;
    }
}
