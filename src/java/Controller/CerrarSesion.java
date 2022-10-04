package Controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author ThonyDev0726
 *
 */
public class CerrarSesion extends HttpServlet {

    String ERROR = "views/Login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session.removeAttribute("usuario");
        session.removeAttribute("idUsuario_global");
        session.removeAttribute("usuClave_global");
        session.removeAttribute("usuLetra_global");
        session.removeAttribute("usuUsuario_global");
        session.removeAttribute("usuCargo_global");
        request.setAttribute("iniciarSesion", "Cerraste sesion!!");
        request.getRequestDispatcher(ERROR).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
