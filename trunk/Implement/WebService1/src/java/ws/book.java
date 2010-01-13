/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ws;

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
        return false;
    }

}
