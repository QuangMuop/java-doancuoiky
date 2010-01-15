/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agent;

import Common.Utility;
import Hotel.Hotel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wrapper.WSWrapper;
import ws.KhachHangDTO;

/**
 *
 * @author hvu
 */
public class RoomController extends HttpServlet {
    
    public enum ACTION_CODE {
        BOOK_NAVIGATE,
        UNBOOK_NAVIGATE,
        BOOK,
        UNBOOK,
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
            int hid = Integer.parseInt(request.getParameter("hid"));
            HotelModel model = new HotelModel();
            request.setAttribute("hotel", model.getHotelById(hid));
            switch (mapActionCode(action)) {
                
                case BOOK:
                    
                    String rid = request.getParameter("rid");
                    KhachHangDTO khachHangDto = new KhachHangDTO();
                    khachHangDto.setName(request.getParameter("name"));
                    khachHangDto.setId(request.getParameter("cmnd"));
                    khachHangDto.setBirthDay(request.getParameter("birth"));
                    String result = "Thao tác không thành công.";
                    String validation = null;
                    String date = Utility.now("dd/MM/yyyy");
                    if ((validation = WSWrapper.bookRoom(hid, rid, khachHangDto, date)) != null) {
                        result = "Đặt chỗ thành công. Mã số xác nhận của bạn là <b>" + validation + "</b>";
                    }
                    else {
                        request.setAttribute("result", "dang ky khong thanh cong");
                    }
                    request.setAttribute("result", result);
                    getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
                    break;
                    
                case BOOK_NAVIGATE:
                    
                    getServletContext().getRequestDispatcher("/customer.jsp").forward(request, response);
                    break;
                    
                case UNBOOK:
                    
                    validation = request.getParameter("validation");
                    result = "Thao tác không thành công.";
                    if (WSWrapper.cancelBookRoom(hid, validation)) {
                        result = "Thao tác thành công.";
                    }
                    else {
                        result = "Thao tác không thành công. Do mã xác nhận không hợp lệ.";
                    }
                    request.setAttribute("result", result);
                    getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
                    break;
                    
                case UNBOOK_NAVIGATE:
                    
                    getServletContext().getRequestDispatcher("/unbook.jsp").forward(request, response);
                    break;
            }
        }
        finally {
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
        if (action.equals("book-nav")) {
            return ACTION_CODE.BOOK_NAVIGATE;
        }
        else if (action.equals("cancel-nav")) {
            return ACTION_CODE.UNBOOK_NAVIGATE;
        }
        else if (action.equals("book")) {
            return ACTION_CODE.BOOK;
        }
        else if (action.equals("cancel")) {
            return ACTION_CODE.UNBOOK;
        }
        return ACTION_CODE.INVALID;
    }
//
//    private Hotel getHotelInfo(int hid) {
//        HotelModel model = new
//        return hotelModel.getHotelById(hid);
//    }
}
