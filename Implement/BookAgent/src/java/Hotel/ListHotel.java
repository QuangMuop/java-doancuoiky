
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
public class ListHotel {
    List<Hotel> hotels;

    public ListHotel(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public ListHotel(Element elem) {
        // init list
        this.hotels = new ArrayList<Hotel>();
        
        NodeList hotelNodes = elem.getElementsByTagName("KhachSan");
        for (int i = 0; i < hotelNodes.getLength(); i++) {
            Element hotelNode = (Element) hotelNodes.item(i);
            this.hotels.add(Hotel.load(hotelNode));
        }
    }

    public List<Hotel> getHotels() {
        return this.hotels;
    }

    /**
     * Tao ra XML node cho list khach san
     * @param dom Xml document
     * @return Element
     */
    public Element toXmlElement(Document dom) {
        Element hotelsNode = dom.createElement("DanhSachKhachSan");
        for (int i = 0; i < this.hotels.size(); i++) {
            Element hotelNode = this.hotels.get(i).toXmlElement(dom);
            hotelsNode.appendChild(hotelNode);
        }
        return hotelsNode;
    }

    static public ListHotel load(Element elem) {
        return new ListHotel(elem);
    }

    public boolean addHotel(Hotel hotel) {
        return this.hotels.add(hotel);
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

    public int size() {
        return this.hotels.size();
    }
}
