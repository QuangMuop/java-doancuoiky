/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agent;

import Hotel.Hotel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hvu
 */
public class HotelController extends HttpServlet {
    HotelModel hotelModel = new HotelModel();

    private enum ACTION_CODE {
        GET_HOTEL_INFO,
        GET_HOTELS,
        GET_ROOMS,
        INVALID
    }

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String action = request.getParameter("action");
            int hid;

            switch (mapActionCode(action)) {
                case GET_HOTELS:
                    break;
                case GET_HOTEL_INFO:
                    hid = Integer.parseInt(request.getParameter("hid"));
                    request.setAttribute("hotel", getHotelInfo(hid));
                    getServletContext().getRequestDispatcher("/hotels.jsp").forward(request, response);
                    break;
                case GET_ROOMS:
                    hid = Integer.parseInt(request.getParameter("hid"));
                    request.setAttribute("hotel", getHotelInfo(hid));
                    getServletContext().getRequestDispatcher("/roomlist.jsp").forward(request, response);
                    break;
                case INVALID:
                    break;
            }
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private ACTION_CODE mapActionCode(String action) {
        if (action.equals("get-hotels")) {
            return ACTION_CODE.GET_HOTELS;
        }
        else if (action.equals("get-hotel-info")) {
            return ACTION_CODE.GET_HOTEL_INFO;
        }
        else if (action.equals("get-rooms")) {
            return ACTION_CODE.GET_ROOMS;
        }
        return ACTION_CODE.INVALID;
    }

    private Hotel getHotelInfo(int hid) {
        return hotelModel.getHotelById(hid);
    }
}
