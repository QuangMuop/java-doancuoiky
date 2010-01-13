/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package WS;

import Agent.HotelModel;
import Common.Configuration;
import Common.Utility;
import Hotel.Hotel;
import Hotel.HotelDTO;
import Hotel.ListHotel;
import Hotel.ListRoom;
import Hotel.Room;
import Hotel.RoomDTO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author hvu
 */
@WebService()
public class HotelRegister {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "submit")
    public String submit(@WebParam(name = "hotel")
    HotelDTO hotel, @WebParam(name = "rooms")
    RoomDTO[] rooms) {
        try {
            // validate parameters
            if (hotel == null || rooms == null) {
                return "Parameters must not be null.";
            }
            // validate rooms size
            if (rooms.length <= 0) {
                return "The number of rooms is not valid.";
            }

            Document hotelDom = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(Configuration.HOTELS_PATH);
            ListHotel hotels = ListHotel.load(hotelDom.getDocumentElement());
            Hotel newHotel = new Hotel(hotel);
            // set new id
            int id = HotelModel.getHotelFreeId();
            newHotel.setId(id);
            // set path
            List<Room> lstRooms = new ArrayList<Room>();
            for (int i = 0; i < rooms.length; i++) {
                lstRooms.add(new Room(rooms[i]));
            }
            ListRoom roomsList = new ListRoom(lstRooms);
            String roomsPath = Configuration.STARTUP_PATH + hotel.getName() + Utility.now() + ".xml";
            roomsList.save(roomsPath);
            newHotel.setPath(roomsPath);

            // save
            hotels.addHotel(newHotel);
            hotels.save(Configuration.HOTELS_PATH);
            
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(HotelRegister.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HotelRegister.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        } catch (TransformerException ex) {
            Logger.getLogger(HotelRegister.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        } catch (SAXException ex) {
            Logger.getLogger(HotelRegister.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        } catch (IOException ex) {
            Logger.getLogger(HotelRegister.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(HotelRegister.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }

        return "Hotel added";
    }

}
