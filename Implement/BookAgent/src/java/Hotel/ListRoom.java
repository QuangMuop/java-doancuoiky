
package Hotel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author hvu
 */
public class ListRoom {
    private List<Room> rooms;

    public ListRoom(List<Room> rooms) {
        this.rooms = rooms;
    }

    public ListRoom(Element elem) {
        // init list
        this.rooms = new ArrayList<Room>();

        NodeList roomNodes = elem.getElementsByTagName("Phong");
        for (int i = 0; i < roomNodes.getLength(); i++) {
            Element roomNode = (Element) roomNodes.item(i);
            this.rooms.add(Room.load(roomNode));
        }
    }

    static public ListRoom load(Element elem) {
        return new ListRoom(elem);
    }

    public List<Room> getRooms() {
        return this.rooms;
    }

    public Element toXmlElement(Document dom) {
        Element roomsNode = dom.createElement("DanhSachPhong");
        for (int i = 0; i < this.rooms.size(); i++) {
            Element roomNode = this.rooms.get(i).toXmlElement(dom);
            roomsNode.appendChild(roomNode);
        }
        return roomsNode;
    }

    public boolean addRoom(Room room) {
        return this.rooms.add(room);
    }

    public void save(String path)
            throws
            ParserConfigurationException,
            TransformerConfigurationException,
            FileNotFoundException,
            TransformerException,
            IOException {
        
        FileOutputStream fos = null;
        try {
            Document dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            dom.appendChild(this.toXmlElement(dom));
            DOMSource source = new DOMSource(dom);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            fos = new FileOutputStream(new File(path));
            StreamResult result = new StreamResult(fos);

            transformer.transform(source, result);
        }
        finally {
            if (fos != null) {
                fos.flush();
                fos.close();
            }
        }
    }
}
