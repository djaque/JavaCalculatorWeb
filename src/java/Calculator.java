/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.apache.coyote.http11.Constants.a;

/**
 *
 * @author dany
 */
public class Calculator extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
            String paramA = request.getParameter("a");
            String paramB = request.getParameter("b");
            String operation = request.getParameter("o");
            String msg = "";
            
            int first = 0;
            int second = 0;
            
            // Used to catch errors
            try {
                first = Integer.parseInt(paramA);
            } catch(Exception e){
                msg = msg + e.toString() + "\n";
            }
            try {
                second = Integer.parseInt(paramB);
            } catch(Exception e){
                msg = msg + e.toString() + "\n";
            }
            
            int process_value = 0;
            if (null != operation) {
                switch (operation) {
                    case "plus":
                        process_value = add(first, second);
                        break;
                    case "minus":
                        process_value = minus(first, second);
                        break;
                    case "times":
                        process_value = first * second;
                        break;
                    default:
                        process_value = first / second;
               }
               
               request.setAttribute("a", paramA);
               request.setAttribute("b", paramB);
               request.setAttribute("op", operation);
               request.setAttribute("value", process_value);
            }
            request.setAttribute("msg", msg);
            
            request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
    public static int minus(int a, int b) {
        return a - b;
    }

    public static int add(int a, int b) {
        return a + b;
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
