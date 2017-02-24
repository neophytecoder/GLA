/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package firststep;

import firststep.Compliment;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cirstea
 */
@WebServlet(name = "DispatchServlet", urlPatterns = {"/salut"})
public class DispatchServlet extends HttpServlet {

    @EJB
    private Compliment compliment;
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String userPath = request.getServletPath();

        if (userPath.equals(
                "/salut")) {

            String name = (String) request.getParameter("name");
            String helloMessage = compliment.compliment(name);

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Greetings</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> "
                    + helloMessage + "</h1>");

            out.println("</body>");
            out.println("</html>");
        }

    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Controller";
    }// </editor-fold>
}