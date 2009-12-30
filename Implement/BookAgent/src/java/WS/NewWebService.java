/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package WS;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author hvu
 */
@WebService()
public class NewWebService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "HotelReceive")
    public Boolean HotelReceive(@WebParam(name = "hotelXMLNode")
    final String hotelXMLNode, @WebParam(name = "hotelDetailXMLFile")
    final String hotelDetailXMLFile) {
        
        BufferedWriter writer = null;
        try {
            // Save XML content into XML file
            writer = new BufferedWriter(new FileWriter("newhotel.xml"));
            writer.write(hotelDetailXMLFile);
            writer.flush();
            writer.close();
            // Save XML document

        } catch (IOException ex) {
            Logger.getLogger(NewWebService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(NewWebService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }
}
