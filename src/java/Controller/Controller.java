package Controller;

import java.io.PrintWriter;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ThonyDev0726
 */
public class Controller extends HttpServlet {
    //========================================================================================== VARIABLES GLOBALES     

    String MAIN = "index.jsp";
    String LOGIN = "views/Login.jsp";
    String REGISTER = "views/Register.jsp";
    /**/
    String ERROR = "views/Login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        //========================================================================================== GLOBALES

        switch (action) {
            case "main":
                acceso = MAIN;
                break;
            case "iniciar-sesion":
                acceso = LOGIN;
                break;
            case "registro":
                acceso = REGISTER;
                break;
            case "error":
                acceso = ERROR;
                break;
            default:
                acceso = MAIN;
        }
        RequestDispatcher view = request.getRequestDispatcher(acceso);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
