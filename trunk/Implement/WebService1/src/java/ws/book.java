/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ws;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
public class book {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "book")
    public boolean book(@WebParam(name = "room")
    String room, @WebParam(name = "customer")
    KhachHangDTO customer) {
        //TODO write your implementation code here:
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(new File(".\\test.txt")));
            dos.writeChars("KS1\nDang ky: " + room + "\nKhach hang: " + customer.getName());
            return true;
        } catch (IOException ex) {
            Logger.getLogger(book.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dos.flush();
                dos.close();
            } catch (IOException ex) {
                Logger.getLogger(book.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

}
