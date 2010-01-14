
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
    private boolean stay;


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

    public boolean getStay() {
        return this.stay;
    }

    public void setStay(boolean stay) {
        this.stay = stay;
    }

    public Room() {
    }

    public Room(RoomDTO roomDto) {
        this.id = roomDto.getId();
        this.cost = roomDto.getCost();
        this.stay = roomDto.getStay();
    }

    public Room(Element xmlNode) {
        id = xmlNode.getAttribute("id");
        cost = Integer.parseInt(xmlNode.getElementsByTagName("Gia").item(0).getTextContent());
        stay = Boolean.parseBoolean(xmlNode.getAttribute("Trong"));
    }

    public static Room load(Element elem) {
        return new Room(elem);
    }

    public Element toXmlElement(Document dom) {
        Element roomNode = dom.createElement("Phong");

        roomNode.setAttribute("id", String.valueOf(this.id));
        roomNode.setAttribute("Trong", String.valueOf(this.stay));

        Element costNode = dom.createElement("Gia");
        costNode.setTextContent(String.valueOf(this.cost));
        roomNode.appendChild(costNode);

        return roomNode;
    }
}
