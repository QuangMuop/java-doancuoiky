/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package WS;

import Hotel.HotelInfo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
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
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author hvu
 */
@WebService()
public class AgentService {

    /**
     * Web service addNewHotel
     */
    @WebMethod(operationName = "operation")
    public Boolean addNewHotel(@WebParam(name = "hotel")
    final HotelInfo hotel) {
        try {
            //TODO write your implementation code here:
            // read from file
            Document dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("");
            dom.normalize();
            int hid = HotelInfo.getHotelFreeId();
            hotel.setId(hid);
            dom.getDocumentElement().appendChild(hotel.toXMLNode());

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource src = new DOMSource(dom.getDocumentElement());
            StreamResult res = new StreamResult(new File(""));

            transformer.transform(src, res);
        }
        catch (TransformerException ex) {
            Logger.getLogger(AgentService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(AgentService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AgentService.class.getName()).log(Level.SEVERE, null, ex);
        }        catch (ParserConfigurationException ex) {
            Logger.getLogger(AgentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

}
