package Controller;

import Model.CLIENTE;
import Model.USUARIO;
import ModelDAO.CLIENTE_DAO;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;

/**
 *
 * @author perez
 */
@WebServlet(name = "Clientes", urlPatterns = {"/Clientes"})
public class Clientes extends HttpServlet {

    //==========================================================================VARIABLES GLOBALES     
    CLIENTE cli = new CLIENTE();
    CLIENTE_DAO DAO = new CLIENTE_DAO();
    LocalDate todaysDate = LocalDate.now();
    String fecha = todaysDate.toString();
    /**/
    Integer ID_CLIENTE;
    String CLI_NOMBRES;
    String CLI_APELLIDOS;
    String CLI_RUC;
    String CLI_CEDULA;
    String CLI_EMAIL;
    String CLI_TELEFONO;
    String CLI_DIRECCION;
    String CLI_CUMPLEANOS;
    String CLI_CREACION;
    String CLI_CREADOR;
    String CLI_IP;
    String CLI_ESTADO;

    /**/
    String REGISTROS = "views/administrador/clientes.jsp";
    String EDITAR = "views/administrador/clientes-editar.jsp";

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
                case "registro-clientes":
                    request.setAttribute("div_si", "sr-only");
                    request.setAttribute("div_no", "sr-only");
                    acceso = REGISTROS;
                    break;
                case "editar-a":
                    request.setAttribute("idCliente", request.getParameter("idCliente"));
                    acceso = EDITAR;
                    break;
                case "dar_baja":
                    ID_CLIENTE = Integer.parseInt(request.getParameter("idCliente"));
                    CLI_ESTADO = "DE BAJA";
                    /* ========== ENVIO EL OBJETO A LA DB=========*/
                    if (DAO.actualizar_estado(ID_CLIENTE, CLI_ESTADO) == "El cliente fue dado de baja con exito!") {
                        request.setAttribute("msj_si", "El cliente fue dado de baja con exito!");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (DAO.actualizar_estado(ID_CLIENTE, CLI_ESTADO) == "Error al dar baja al cliente!") {
                        request.setAttribute("msj_no", "No se pudo dar de baja al cliente!");
                        request.setAttribute("div_no", "visible");
                        request.setAttribute("div_si", "sr-only");
                    }
                    acceso = REGISTROS;
                    break;
                case "eliminar":
                    ID_CLIENTE = Integer.parseInt((String) request.getParameter("idCliente"));
                    /* ========== ENVIO EL OBJETO A LA DB=========*/
                    if (DAO.delete(ID_CLIENTE) == "El cliente fue eliminado con exito!") {
                        request.setAttribute("msj_si", "El cliente fue eliminado con exito");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (DAO.delete(ID_CLIENTE) == "Error al eliminar el cliente!") {
                        request.setAttribute("msj_no", "No se pudo eliminar al cliente!");
                        request.setAttribute("div_no", "visible");
                        request.setAttribute("div_si", "sr-only");
                    }
                    acceso = REGISTROS;
                    break;
                default:
                    request.setAttribute("div_si", "sr-only");
                    request.setAttribute("div_no", "sr-only");
                    acceso = REGISTROS;
            }
            RequestDispatcher view = request.getRequestDispatcher(acceso);
            view.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
                case "registro-clientes":
                    request.setAttribute("div_si", "sr-only");
                    request.setAttribute("div_no", "sr-only");
                    acceso = REGISTROS;
                    break;
                case "Guardar":
                    CLI_NOMBRES = request.getParameter("txt-nombres");
                    CLI_APELLIDOS = request.getParameter("txt-apellidos");
                    CLI_RUC = request.getParameter("txt-ruc");
                    CLI_CEDULA = request.getParameter("txt-cedula");
                    CLI_EMAIL = request.getParameter("txt-email");
                    CLI_TELEFONO = request.getParameter("txt-telefono");
                    CLI_DIRECCION = request.getParameter("txt-direccion");
                    CLI_CUMPLEANOS = request.getParameter("txt-cumple");
                    CLI_CREACION = fecha;
//                String CLI_CREADOR = request.getParameter("");
                    CLI_CREADOR = "ANTHONYX";
                    CLI_IP = request.getParameter("txt-ip");
                    CLI_ESTADO = "EN LINEA";
                    /* ========== DAR VALORES AL OBJETO =========*/
                    cli.setCLI_NOMBRES(CLI_NOMBRES.toUpperCase());
                    cli.setCLI_APELLIDOS(CLI_APELLIDOS.toUpperCase());
                    cli.setCLI_RUC(CLI_RUC.toUpperCase());
                    cli.setCLI_CEDULA(CLI_CEDULA.toUpperCase());
                    cli.setCLI_TELEFONO(CLI_TELEFONO.toUpperCase());
                    cli.setCLI_EMAIL(CLI_EMAIL);
                    cli.setCLI_CUMPLEANOS(CLI_CUMPLEANOS.toUpperCase());
                    cli.setCLI_DIRECCION(CLI_DIRECCION.toUpperCase());
                    cli.setCLI_CREACION(CLI_CREACION.toUpperCase());
                    cli.setCLI_CREADOR(CLI_CREADOR.toUpperCase());
                    cli.setCLI_IP(CLI_IP.toUpperCase());
                    cli.setCLI_ESTADO(CLI_ESTADO.toUpperCase());
                    /* ========== ENVIO EL OBJETO A LA DB=========*/
                    if (DAO.add(cli) == "El cliente fue creado con exito!") {
                        request.setAttribute("msj_si", "El cliente " + CLI_NOMBRES + " " + CLI_APELLIDOS + " fue creado con exito");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (DAO.add(cli) == "El cliente no fue creado con exito!") {
                        request.setAttribute("msj_no", "El cliente no fue creado!");
                        request.setAttribute("div_no", "visible");
                        request.setAttribute("div_si", "sr-only");
                    }
                    acceso = REGISTROS;
                    break;
                case "editar-a":
                    request.setAttribute("idCliente", request.getParameter("idCliente"));
                    acceso = EDITAR;
                    break;
                case "Actualizar":
                    ID_CLIENTE = Integer.parseInt(request.getParameter("txt-id-cliente-u"));
                    CLI_NOMBRES = request.getParameter("txt-nombres-u");
                    CLI_APELLIDOS = request.getParameter("txt-apellidos-u");
                    CLI_RUC = request.getParameter("txt-ruc-u");
                    CLI_CEDULA = request.getParameter("txt-cedula-u");
                    CLI_EMAIL = request.getParameter("txt-email-u");
                    CLI_TELEFONO = request.getParameter("txt-telefono-u");
                    CLI_DIRECCION = request.getParameter("txt-direccion-u");
                    CLI_CUMPLEANOS = request.getParameter("txt-cumple-u");
                    CLI_ESTADO = request.getParameter("cbx-estado");
                    /* ========== DAR VALORES AL OBJETO =========*/
                    cli.setID_CLIENTE(ID_CLIENTE);
                    cli.setCLI_NOMBRES(CLI_NOMBRES.toUpperCase());
                    cli.setCLI_APELLIDOS(CLI_APELLIDOS.toUpperCase());
                    cli.setCLI_RUC(CLI_RUC.toUpperCase());
                    cli.setCLI_CEDULA(CLI_CEDULA.toUpperCase());
                    cli.setCLI_EMAIL(CLI_EMAIL);
                    cli.setCLI_TELEFONO(CLI_TELEFONO.toUpperCase());
                    cli.setCLI_DIRECCION(CLI_DIRECCION.toUpperCase());
                    cli.setCLI_CUMPLEANOS(CLI_CUMPLEANOS.toUpperCase());
                    cli.setCLI_ESTADO(CLI_ESTADO.toUpperCase());
                    /* ========== ENVIO EL OBJETO A LA DB=========*/
                    if (DAO.update(cli) == "El cliente fue actualizado con exito!") {
                        request.setAttribute("msj_si", "El cliente " + CLI_NOMBRES + " " + CLI_APELLIDOS + " fue actualizado con exito");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (DAO.update(cli) == "El cliente no fue actualizado!") {
                        request.setAttribute("msj_no", "No se pudo actualizar al cliente " + CLI_NOMBRES + " " + CLI_APELLIDOS + "!");
                        request.setAttribute("div_no", "visible");
                        request.setAttribute("div_si", "sr-only");
                    }
                    acceso = REGISTROS;
                    break;
                case "dar_baja":
                    ID_CLIENTE = Integer.parseInt((String) request.getParameter("idCliente"));
                    CLI_ESTADO = "DE BAJA";
                    /* ========== ENVIO EL OBJETO A LA DB=========*/
                    if (DAO.actualizar_estado(ID_CLIENTE, CLI_ESTADO) == "El cliente fue dado de baja con exito!") {
                        request.setAttribute("msj_si", "El cliente " + CLI_NOMBRES + " " + CLI_APELLIDOS + " fue dado de baja con exito");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (DAO.actualizar_estado(ID_CLIENTE, CLI_ESTADO) == "Error al dar baja al cliente!") {
                        request.setAttribute("msj_no", "No se pudo dar de baja al cliente " + CLI_NOMBRES + " " + CLI_APELLIDOS + "!");
                        request.setAttribute("div_no", "visible");
                        request.setAttribute("div_si", "sr-only");
                    }
                    break;
                default:
                    request.setAttribute("div_si", "sr-only");
                    request.setAttribute("div_no", "sr-only");
                    acceso = REGISTROS;
            }
            RequestDispatcher view = request.getRequestDispatcher(acceso);
            view.forward(request, response);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
