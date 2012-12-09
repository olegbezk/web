
package stars.server;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import stars.beans.StarsSessionBean;
import stars.entities.Constellation;
import stars.entities.Star;

/**
 *
 * @author Eugeny
 */
@WebServlet(name = "EditStarServlet", urlPatterns = {"/EditStar"})
public class EditStarServlet extends HttpServlet {
    @EJB
    private StarsSessionBean starsSessionBean;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        String latinName = request.getParameter("latinName");
        Star star = starsSessionBean.findStar(id);
        Constellation constellation = star.getConstellation();
        if (latinName == null) { // отправляем в JSP
            request.setAttribute("star", star);
            request.setAttribute("constellation", constellation);
            request.getRequestDispatcher("/editstar.jsp").forward(request, response);
        } else {
            String russianName = request.getParameter("russianName");
            String declinationStr = request.getParameter("declination");
            String rightAscensionStr = request.getParameter("ascension");
            String magnitudeStr = request.getParameter("magnitude");
            String distanceStr = request.getParameter("distance");
            long declination = Long.parseLong(declinationStr);
            long ascension = Long.parseLong(rightAscensionStr);
            int magnitude = Integer.parseInt(magnitudeStr);
            int distance = Integer.parseInt(distanceStr);
            starsSessionBean.updateStar(star, star.getConstellation(), latinName, russianName, declination, ascension, magnitude, distance);
            response.sendRedirect("ViewStars?id="+star.getStarPK().getConstellationId());
        }
    }

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
        processRequest(request, response);
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
