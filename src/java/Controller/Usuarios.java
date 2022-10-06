package Controller;

import Converters.Convertidor;
import Model.USUARIO;
import ModelDAO.USUARIO_DAO;
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
@WebServlet(name = "Usuarios", urlPatterns = {"/Usuarios"})
public class Usuarios extends HttpServlet {

    USUARIO usu = new USUARIO();
    USUARIO_DAO DAO = new USUARIO_DAO();
    Convertidor c = new Convertidor();
    //========================================================================================== VARIABLES GLOBALES     
    String REGISTROS = "views/administrador/usuarios.jsp";
    String EDITAR = "views/administrador/usuarios.jsp";
    LocalDate todaysDate = LocalDate.now();
    String fecha = todaysDate.toString();
    /**/
    Integer ID_USUARIO;
    Integer FK_SUCURSAL;
    Integer FK_EMPLEADO;
    String FK_EMPLEADO_LETRA;
    String USU_USUARIO;
    String USU_CLAVE;
    String USU_PARAMETRO;
    String USU_CODIGO;
    String USU_CREACION;
    String USU_CREADOR;
    String USU_IP;
    String USU_ACTIVIDAD;
    String USU_ESTADO;

    /**/
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
                case "registro-usuarios":
                    request.setAttribute("div_si", "sr-only");
                    request.setAttribute("div_no", "sr-only");
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
                case "registro-usuarios":
                    request.setAttribute("div_si", "sr-only");
                    request.setAttribute("div_no", "sr-only");
                    acceso = REGISTROS;
                    break;
                case "Guardar":
                    FK_SUCURSAL = Integer.parseInt(request.getParameter("cbx-sucursal"));
                    FK_EMPLEADO_LETRA = request.getParameter("txt-id-empleado");
                    FK_EMPLEADO = c.obtenerNumero(FK_EMPLEADO_LETRA);;                    
                    USU_USUARIO = request.getParameter("txt-cedula");
                    USU_CLAVE = request.getParameter("txt-clave");
                    USU_PARAMETRO = request.getParameter("cbx-parametro");
//                    USU_CODIGO = request.getParameter("");
                    USU_CODIGO = "asd5a5d2cAdg5";
                    USU_CREACION = request.getParameter(fecha);
                    USU_CREADOR = request.getParameter("txt-creador");
                    USU_IP = request.getParameter("txt-ip");
//                    USU_ACTIVIDAD = request.getParameter("");
                    USU_ACTIVIDAD = "INACTIVO";
                    USU_ESTADO = "EN LINEA";
                    /* ========== DAR VALORES AL OBJETO ========= */
                    usu.setFK_EMPLEADO(FK_EMPLEADO);
                    usu.setFK_SUCURSAL(FK_SUCURSAL);
                    usu.setUSU_USUARIO(USU_USUARIO);
                    usu.setUSU_CLAVE(USU_CLAVE);
                    usu.setUSU_PARAMETRO(USU_PARAMETRO);
                    usu.setUSU_CODIGO(USU_CODIGO);
                    usu.setUSU_CREACION(fecha);
                    usu.setUSU_CREADOR(USU_CREADOR);
                    usu.setUSU_IP(USU_IP);
                    usu.setUSU_ACTIVIDAD(USU_ACTIVIDAD);
                    usu.setUSU_ESTADO(USU_ESTADO);
                    /* ========== ENVIO EL OBJETO A LA DB========= */
                    if (DAO.add(usu) == "El usuario fue creado con exito!") {
                        request.setAttribute("msj_si", "El usuario " + USU_USUARIO + " fue creado con exito");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (DAO.add(usu) == "El usuario no fue creado con exito!") {
                        request.setAttribute("msj_no", "El usuario no fue creado!");
                        request.setAttribute("div_no", "visible");
                        request.setAttribute("div_si", "sr-only");
                    }
                    acceso = REGISTROS;
                    break;
                case "editar-a":
                    request.setAttribute("idusuario", request.getParameter("idusuario"));
                    acceso = EDITAR;
                    break;
                case "Actualizar":
                    ID_USUARIO = Integer.parseInt(request.getParameter(""));
                    FK_SUCURSAL = Integer.parseInt(request.getParameter(""));
                    FK_EMPLEADO = Integer.parseInt(request.getParameter(""));
                    USU_USUARIO = request.getParameter("");
                    USU_CLAVE = request.getParameter("");
                    USU_PARAMETRO = request.getParameter("");
                    USU_CODIGO = request.getParameter("");
                    USU_CREACION = request.getParameter("");
                    USU_CREADOR = request.getParameter("");
                    USU_IP = request.getParameter("");
                    USU_ACTIVIDAD = request.getParameter("");
                    USU_ESTADO = request.getParameter("");
                    /* ========== DAR VALORES AL OBJETO ========= */
                    usu.setFK_EMPLEADO(FK_EMPLEADO);
                    usu.setFK_SUCURSAL(FK_SUCURSAL);
                    usu.setUSU_USUARIO(USU_USUARIO);
                    usu.setUSU_CLAVE(USU_CLAVE);
                    usu.setUSU_PARAMETRO(USU_PARAMETRO);
                    usu.setUSU_CODIGO(USU_CODIGO);
                    usu.setUSU_CREACION(USU_CREACION);
                    usu.setUSU_CREADOR(USU_CREADOR);
                    usu.setUSU_IP(USU_IP);
                    usu.setUSU_ACTIVIDAD(USU_ACTIVIDAD);
                    usu.setUSU_ESTADO(USU_ESTADO);
                    /* ========== ENVIO EL OBJETO A LA DB========= */
                    if (DAO.update(this.usu) == "El usuario fue actualizado con exito!") {
                        request.setAttribute("msj_si", "El usuario " + USU_USUARIO + " fue actualizado con exito");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (DAO.update(this.usu) == "El usuario no fue actualizado!") {
                        request.setAttribute("msj_no", "No se pudo actualizar al usuario " + USU_USUARIO + "!");
                        request.setAttribute("div_no", "visible");
                        request.setAttribute("div_si", "sr-only");
                    }
                    acceso = REGISTROS;
                    break;
                case "dar_baja":
                    ID_USUARIO = Integer.parseInt((String) request.getParameter("idusuario"));
                    USU_ESTADO = "DE BAJA";
                    /* ========== ENVIO EL OBJETO A LA DB========= */
                    if (DAO.actualizar_estado(ID_USUARIO, USU_ESTADO) == "El usuario fue dado de baja con exito!") {
                        request.setAttribute("msj_si", "El usuario " + USU_USUARIO + " fue dado de baja con exito");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (DAO.actualizar_estado(ID_USUARIO, USU_ESTADO) == "Error al dar baja al usuario!") {
                        request.setAttribute("msj_no", "No se pudo dar de baja al usuario " + FK_SUCURSAL + " " + USU_USUARIO + "!");
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
