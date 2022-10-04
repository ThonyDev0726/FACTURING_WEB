package Controller;

import Converters.Convertidor;
import Converters.Encriptador;
import Model.USUARIO;
import ModelDAO.USUARIO_DAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.StringTokenizer;

/**
 *
 * @author ThonyDev0726
 */
public class Login extends HttpServlet {

    String LOGIN = "views/Login.jsp";
    Encriptador enc = new Encriptador();
    Convertidor c = new Convertidor();
    USUARIO_DAO usuDAO = new USUARIO_DAO();
    String USU_IMG;
    String USU_NOMBRES;
    String USU_APELLIDOS;
    Integer ID_USUARIO_BASE = 0;
    String idUsuario = "";
    int idUsu = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        /* ============== VARIABLES SESION ============== */
        if (request.getParameter("btn-login") != null) {
            session.removeAttribute("usuario");
            session.removeAttribute("idUsuario_global");
            session.removeAttribute("usuClave_global");
            session.removeAttribute("usuLetra_global");
            session.removeAttribute("usuUsuario_global");
            session.removeAttribute("usuCargo_global");
            String USU_USUARIO = request.getParameter("txt-usuario");
            String USU_CLAVE = request.getParameter("txt-clave");
            idUsu = 0;

            ID_USUARIO_BASE = usuDAO.consultarUsuario(USU_USUARIO);
            if (ID_USUARIO_BASE == null || ID_USUARIO_BASE == 0) {
                idUsu = 0;
                ID_USUARIO_BASE = 0;
                session.removeAttribute("usuario");
                session.removeAttribute("idUsuario_global");
                session.removeAttribute("usuClave_global");
                session.removeAttribute("usuLetra_global");
                session.removeAttribute("usuUsuario_global");
                session.removeAttribute("usuCargo_global");
                request.setAttribute("errorSesion", "EL USUARIO INGRESADO NO ESTA ESTA REGISTRADO!!");
                request.getRequestDispatcher(LOGIN).forward(request, response);
                System.out.println("EL USUARIO ES INCORRECTO");
            } else {
                idUsu = 0;
                idUsu = ID_USUARIO_BASE;
                String usuClaveEncriptada = usuDAO.obtenerClave(idUsu);
                String usuEstado = usuDAO.consultarEstado(idUsu);
                String usuClaveDesencriptada;
                usuClaveDesencriptada = enc.desencriptar(usuClaveEncriptada);
                String claveInterfaz = USU_CLAVE;
                if (usuEstado.equals("EN LINEA")) {
                    if (usuClaveDesencriptada.equals(claveInterfaz)) {
                        String usuCargo = usuDAO.consultarCargo(idUsu);
                        if (usuCargo.equals("Administrador")) {
                            USUARIO usu1 = (USUARIO) usuDAO.list(idUsu);
                            USU_IMG = usu1.getEMP_IMG();
                            USU_NOMBRES = usu1.getEMP_NOMBRES();
                            USU_APELLIDOS = usu1.getEMP_APELLIDOS();
                            request.getSession().setAttribute("idUsuario_global", idUsuario);
                            request.getSession().setAttribute("usuLetra_global", USU_IMG);
                            StringTokenizer tonkenNombre = new StringTokenizer(USU_NOMBRES);
                            StringTokenizer tonkenApellido = new StringTokenizer(USU_APELLIDOS);
                            String PRIMER_NOMBRE = tonkenNombre.nextToken();
                            String PRIMER_APELLIDO = tonkenApellido.nextToken();
                            request.getSession().setAttribute("usuUsuario_global", PRIMER_NOMBRE + " " + PRIMER_APELLIDO);
                            request.getSession().setAttribute("usuCargo_global", usuCargo);
                            request.getSession().setAttribute("usuClave_global", USU_CLAVE);
                            USUARIO usu = new USUARIO(USU_USUARIO, USU_CLAVE);
                            session.setAttribute("usuario", usu);
                            response.sendRedirect("Dashboard?accion=administrador");
                        } else if (usuCargo.equals("Cajero")) {
                            USUARIO usu1 = (USUARIO) usuDAO.list(idUsu);
                            USU_IMG = usu1.getEMP_IMG();
                            USU_NOMBRES = usu1.getEMP_NOMBRES();
                            USU_APELLIDOS = usu1.getEMP_APELLIDOS();
                            request.getSession().setAttribute("idUsuario_global", idUsuario);
                            request.getSession().setAttribute("usuLetra_global", USU_IMG);
                            StringTokenizer tonkenNombre = new StringTokenizer(USU_NOMBRES);
                            StringTokenizer tonkenApellido = new StringTokenizer(USU_APELLIDOS);
                            String PRIMER_NOMBRE = tonkenNombre.nextToken();
                            String PRIMER_APELLIDO = tonkenApellido.nextToken();
                            request.getSession().setAttribute("usuUsuario_global", PRIMER_NOMBRE + " " + PRIMER_APELLIDO);
                            request.getSession().setAttribute("usuCargo_global", usuCargo);
                            request.getSession().setAttribute("usuClave_global", USU_CLAVE);
                            USUARIO usu = new USUARIO(USU_USUARIO, USU_CLAVE);
                            session.setAttribute("usuario", usu);
                            response.sendRedirect("Dashboard?accion=administrador");
                        }
                    } else {
                        idUsu = 0;
                        session.removeAttribute("usuario");
                        session.removeAttribute("idUsuario_global");
                        session.removeAttribute("usuClave_global");
                        session.removeAttribute("usuLetra_global");
                        session.removeAttribute("usuUsuario_global");
                        session.removeAttribute("usuCargo_global");
                        request.setAttribute("errorSesion", "LA CONTRASEÑA ES INCORRECTA!!");
                        request.getRequestDispatcher(LOGIN).forward(request, response);
                        System.out.println("LA CLAVE ES INCORRECTA");
                    }
                } else if (usuEstado.equals("DE BAJA")) {
                    idUsu = 0;
                    session.removeAttribute("usuario");
                    session.removeAttribute("idUsuario_global");
                    session.removeAttribute("usuClave_global");
                    session.removeAttribute("usuLetra_global");
                    session.removeAttribute("usuUsuario_global");
                    session.removeAttribute("usuCargo_global");
                    request.setAttribute("errorSesion", "EL USUARIO  ''" + USU_USUARIO + "''  ESTA BLOQUEADO DEL SISTEMA!!");
                    request.getRequestDispatcher(LOGIN).forward(request, response);
                    System.out.println("ESTE USUARIO ESTA BLOQUEADO!!");
                }
            }
        }
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
