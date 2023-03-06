package Controller;

import Model.EMPLEADO;
import Model.USUARIO;
import ModelDAO.EMPLEADO_DAO;
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
@WebServlet(name = "Empleados", urlPatterns = {"/Empleados"})
public class Empleados extends HttpServlet {
//========================================================================================== VARIABLES GLOBALES     

    EMPLEADO emp = new EMPLEADO();
    EMPLEADO_DAO DAO = new EMPLEADO_DAO();
    LocalDate todaysDate = LocalDate.now();
    String fecha = todaysDate.toString();
    /**/
    Integer ID_EMPLEADO;
    Integer FK_SUCURSAL;
    String EMP_NOMBRES;
    String EMP_APELLIDOS;
    String EMP_CEDULA;
    String EMP_EMAIL;
    String EMP_TELEFONO;
    String EMP_DIRECCION;
    String EMP_CUMPLEANOS;
    String EMP_CREACION;
    String EMP_CREADOR;
    String EMP_IP;
    String EMP_ESTADO;
    String EMP_IMG;

    /**/
    String REGISTROS = "views/administrador/empleados.jsp";
    String EDITAR = "views/administrador/empleados-editar.jsp";

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
                case "registro-empleados":
                    acceso = REGISTROS;
                    request.setAttribute("div_si", "sr-only");
                    request.setAttribute("div_no", "sr-only");
                    break;
                case "editar-a":
                    request.setAttribute("idEmpleado", request.getParameter("idEmpleado"));
                    acceso = EDITAR;
                    break;
                case "dar_baja":
                    ID_EMPLEADO = Integer.parseInt(request.getParameter("idEmpleado"));
                    EMP_ESTADO = "DE BAJA";
                    /* ========== ENVIO EL OBJETO A LA DB=========*/
                    if (DAO.actualizar_estado(ID_EMPLEADO, EMP_ESTADO) == "El empleado fue dado de baja con exito!") {
                        request.setAttribute("msj_si", "El empleado fue dado de baja con exito!");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (DAO.actualizar_estado(ID_EMPLEADO, EMP_ESTADO) == "Error al dar baja al empleado!") {
                        request.setAttribute("msj_no", "No se pudo dar de baja al empleado!");
                        request.setAttribute("div_no", "visible");
                        request.setAttribute("div_si", "sr-only");
                    }
                    acceso = REGISTROS;
                    break;
                case "eliminar":
                    ID_EMPLEADO = Integer.parseInt((String) request.getParameter("idEmpleado"));
                    /* ========== ENVIO EL OBJETO A LA DB=========*/
                    if (DAO.delete(ID_EMPLEADO) == "El empleado fue eliminado con exito!") {
                        request.setAttribute("msj_si", "El empleado fue eliminado con exito!");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (DAO.delete(ID_EMPLEADO) == "Error al eliminar el empleado!") {
                        request.setAttribute("msj_no", "No se pudo eliminar al empleado!");
                        request.setAttribute("div_no", "visible");
                        request.setAttribute("div_si", "sr-only");
                    }
                    acceso = REGISTROS;
                    break;
                default:
                    acceso = REGISTROS;
                    request.setAttribute("div_si", "sr-only");
                    request.setAttribute("div_no", "sr-only");
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
                case "registro-empleados":
                    request.setAttribute("div_si", "sr-only");
                    request.setAttribute("div_no", "sr-only");
                    acceso = REGISTROS;
                    break;
                case "Guardar":
                    FK_SUCURSAL = Integer.parseInt(request.getParameter("cbx-sucursal"));
                    EMP_NOMBRES = request.getParameter("txt-nombres");
                    EMP_APELLIDOS = request.getParameter("txt-apellidos");
                    EMP_CEDULA = request.getParameter("txt-cedula");
                    EMP_EMAIL = request.getParameter("txt-email");
                    EMP_TELEFONO = request.getParameter("txt-telefono");
                    EMP_DIRECCION = request.getParameter("txt-direccion");
                    EMP_CUMPLEANOS = request.getParameter("txt-cumple");
                    EMP_CREACION = fecha;
                    EMP_CREADOR = "ANTHONYX";
                    EMP_IP = request.getParameter("txt-ip");
                    EMP_ESTADO = "EN LINEA";
                    EMP_IMG = request.getParameter("txt-img");
                    /* ========== DAR VALORES AL OBJETO =========*/
                    emp.setFK_SUCURSAL(FK_SUCURSAL);
                    emp.setEMP_NOMBRES(EMP_NOMBRES.toUpperCase());
                    emp.setEMP_APELLIDOS(EMP_APELLIDOS.toUpperCase());
                    emp.setEMP_CEDULA(EMP_CEDULA.toUpperCase());
                    emp.setEMP_TELEFONO(EMP_TELEFONO.toUpperCase());
                    emp.setEMP_EMAIL(EMP_EMAIL);
                    emp.setEMP_CUMPLEANOS(EMP_CUMPLEANOS.toUpperCase());
                    emp.setEMP_DIRECCION(EMP_DIRECCION.toUpperCase());
                    emp.setEMP_CREACIOM(EMP_CREACION.toUpperCase());
                    emp.setEMP_CREADOR(EMP_CREADOR.toUpperCase());
                    emp.setEMP_IP(EMP_IP.toUpperCase());
                    emp.setEMP_ESTADO(EMP_ESTADO.toUpperCase());
                    emp.setEMP_IMG(EMP_IMG);
                    /* ========== ENVIO EL OBJETO A LA DB=========*/
                    switch (DAO.add(emp)) {
                        case "El Empleado fue creado con exito!":
                            request.setAttribute("msj_si", "El EMPLEADO " + EMP_NOMBRES + " " + EMP_APELLIDOS + " fue creado con exito");
                            request.setAttribute("div_si", "visible");
                            request.setAttribute("div_no", "sr-only");
                            break;
                        case "El Empleado no fue creado con exito!":
                            request.setAttribute("msj_no", "El Empleado no fue creado con exito!");
                            request.setAttribute("div_no", "visible");
                            request.setAttribute("div_si", "sr-only");
                            break;
                        default:
                            request.setAttribute("msj_no", "El Empleado no fue creado con exito!");
                            request.setAttribute("div_no", "visible");
                            request.setAttribute("div_si", "sr-only");

                    }
                    acceso = REGISTROS;
                    break;
                case "editar-a":
                    request.setAttribute("idEmpleado", request.getParameter("idEmpleado"));
                    acceso = EDITAR;
                    break;
                case "Actualizar":
                    ID_EMPLEADO = Integer.parseInt(request.getParameter("id-empleado-u"));
                    FK_SUCURSAL = Integer.parseInt(request.getParameter("cbx-sucursal-u"));
                    EMP_NOMBRES = request.getParameter("txt-nombres-u");
                    EMP_APELLIDOS = request.getParameter("txt-apellidos-u");
                    EMP_CEDULA = request.getParameter("txt-cedula-u");
                    EMP_EMAIL = request.getParameter("txt-email-u");
                    EMP_TELEFONO = request.getParameter("txt-telefono-u");
                    EMP_DIRECCION = request.getParameter("txt-direccion-u");
                    EMP_CUMPLEANOS = request.getParameter("txt-cumple-u");
                    EMP_ESTADO = request.getParameter("cbx-estado-u");
                    EMP_IMG = request.getParameter("txt-img");
                    /* ========== DAR VALORES AL OBJETO =========*/
                    emp.setID_EMPLEADO(ID_EMPLEADO);
                    emp.setFK_SUCURSAL(FK_SUCURSAL);
                    emp.setEMP_NOMBRES(EMP_NOMBRES.toUpperCase());
                    emp.setEMP_APELLIDOS(EMP_APELLIDOS.toUpperCase());
                    emp.setEMP_CEDULA(EMP_CEDULA.toUpperCase());
                    emp.setEMP_EMAIL(EMP_EMAIL);
                    emp.setEMP_TELEFONO(EMP_TELEFONO.toUpperCase());
                    emp.setEMP_DIRECCION(EMP_DIRECCION.toUpperCase());
                    emp.setEMP_CUMPLEANOS(EMP_CUMPLEANOS.toUpperCase());
                    emp.setEMP_ESTADO(EMP_ESTADO);
                    emp.setEMP_IMG(EMP_IMG);
                    /* ========== ENVIO EL OBJETO A LA DB=========*/
                    if (DAO.update(emp) == "El empleado fue actualizado con exito!") {
                        request.setAttribute("msj_si", "El empleado " + EMP_NOMBRES + " " + EMP_APELLIDOS + " fue actualizado con exito");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (DAO.update(emp) == "El Empleado no fue actualizado!") {
                        request.setAttribute("msj_no", "No se pudo actualizar al empleado " + EMP_NOMBRES + " " + EMP_APELLIDOS + "!");
                        request.setAttribute("div_no", "visible");
                        request.setAttribute("div_si", "sr-only");
                    }
                    acceso = REGISTROS;
                    break;
                case "dar_baja":
                    ID_EMPLEADO = Integer.parseInt((String) request.getParameter("idEmpleado"));
                    EMP_ESTADO = "DE BAJA";
                    /* ========== ENVIO EL OBJETO A LA DB=========*/
                    if (DAO.actualizar_estado(ID_EMPLEADO, EMP_ESTADO) == "El EMPLEADO fue dado de baja con exito!") {
                        request.setAttribute("msj_si", "El EMPLEADO " + EMP_NOMBRES + " " + EMP_APELLIDOS + " fue dado de baja con exito");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (DAO.actualizar_estado(ID_EMPLEADO, EMP_ESTADO) == "Error al dar baja al EMPLEADO!") {
                        request.setAttribute("msj_no", "No se pudo dar de baja al EMPLEADO " + EMP_NOMBRES + " " + EMP_APELLIDOS + "!");
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
