package Controller;

import Model.USUARIO;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author perez
 */
@WebServlet(name = "Venta", urlPatterns = {"/Venta"})
public class Venta extends HttpServlet {

    //========================================================================================== VARIABLES GLOBALES     
    String REGISTROS = "views/administrador/facturacion.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        //========================================================================================== GLOBALES
        String LOGIN = "views/Login.jsp";
        HttpSession session = request.getSession();
        USUARIO usu = (USUARIO) session.getAttribute("usuario");
        if (usu == null) {
            request.setAttribute("iniciarSesion", "Debes iniciar sesion, para acceder al contenido!!");
            request.getRequestDispatcher(LOGIN).forward(request, response);
        } else {
            switch (action) {
                case "registro-venta":
                    acceso = REGISTROS;
                    break;
                default:
                    acceso = REGISTROS;
            }
            RequestDispatcher view = request.getRequestDispatcher(acceso);
            view.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
