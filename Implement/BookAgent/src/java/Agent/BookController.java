/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agent;

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
public class BookController extends HttpServlet {

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
            switch (mapActionCode(action)) {
                case BOOK:
                    break;
                case BOOK_NAVIGATE:
                    break;
                case UNBOOK:
                    out.print("unbook at " + request.getParameter("hid"));
                    break;
                case UNBOOK_NAVIGATE:
                    getServletContext().getRequestDispatcher("/unbook.jsp").forward(request, response);
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
        if (action.equals("book-nav")) {
            return ACTION_CODE.BOOK_NAVIGATE;
        }
        else if (action.equals("unbook-nav")) {
            return ACTION_CODE.UNBOOK_NAVIGATE;
        }
        else if (action.equals("book")) {
            return ACTION_CODE.BOOK;
        }
        else if (action.equals("unbook")) {
            return ACTION_CODE.UNBOOK;
        }
        return ACTION_CODE.INVALID;
    }
}
