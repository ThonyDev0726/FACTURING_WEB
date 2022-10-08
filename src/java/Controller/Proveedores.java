/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.PROVEEDOR;
import Model.USUARIO;
import ModelDAO.PROVEEDOR_DAO;
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
@WebServlet(name = "Proveedores", urlPatterns = {"/Proveedores"})
public class Proveedores extends HttpServlet {

    //==========================================================================VARIABLES GLOBALES     
    PROVEEDOR pro = new PROVEEDOR();
    PROVEEDOR_DAO DAO = new PROVEEDOR_DAO();
    LocalDate todaysDate = LocalDate.now();
    String FECHA = todaysDate.toString();
    /**/
    Integer ID_PROVEEDOR;
    Integer FK_SUCURSAL;
    String PRO_EMPRESA;
    String PRO_NOMBRES;
    String PRO_APELLIDOS;
    String PRO_CONTACTO;
    String PRO_RUC;
    String PRO_TELEFONO;
    String PRO_EMAIL;
    String PRO_DIRECCION;
    String PRO_WEB;
    String PRO_CREACION;
    String PRO_CREADOR;
    String PRO_IP;
    String PRO_ESTADO;
    //========================================================================================== VARIABLES GLOBALES     
    String REGISTROS = "views/administrador/proveedores.jsp";
    String EDITAR = "views/administrador/proveedores-editar.jsp";

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
                case "registro-proveedores":
                    request.setAttribute("div_si", "sr-only");
                    request.setAttribute("div_no", "sr-only");
                    acceso = REGISTROS;
                    break;
                case "editar-a":
                    request.setAttribute("idProveedor", request.getParameter("idProveedor"));
                    acceso = EDITAR;
                    break;
                case "dar_baja":
                    ID_PROVEEDOR = Integer.parseInt(request.getParameter("idProveedor"));
                    PRO_ESTADO = "DE BAJA";
                    /* ========== ENVIO EL OBJETO A LA DB=========*/
                    if (DAO.actualizar_estado(ID_PROVEEDOR, PRO_ESTADO) == "El proveedor fue dado de baja con exito!") {
                        request.setAttribute("msj_si", "El proveedor fue dado de baja con exito!");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (DAO.actualizar_estado(ID_PROVEEDOR, PRO_ESTADO) == "Error al dar baja al proveedor!") {
                        request.setAttribute("msj_no", "No se pudo dar de baja al proveedor!");
                        request.setAttribute("div_no", "visible");
                        request.setAttribute("div_si", "sr-only");
                    }
                    acceso = REGISTROS;
                    break;
                case "eliminar":
                    ID_PROVEEDOR = Integer.parseInt((String) request.getParameter("idProveedor"));
                    /* ========== ENVIO EL OBJETO A LA DB=========*/
                    if (DAO.delete(ID_PROVEEDOR) == "El proveedor fue eliminado con exito!") {
                        request.setAttribute("msj_si", "El proveedor fue eliminado con exito");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (DAO.delete(ID_PROVEEDOR) == "Error al eliminar el proveedor!") {
                        request.setAttribute("msj_no", "No se pudo eliminar al proveedor!");
                        request.setAttribute("div_no", "visible");
                        request.setAttribute("div_si", "sr-only");
                    }
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
                case "Guardar":
                    FK_SUCURSAL = Integer.parseInt(request.getParameter("cbx-sucursal"));
                    PRO_EMPRESA = request.getParameter("txt-empresa");
                    PRO_NOMBRES = request.getParameter("txt-nombres");
                    PRO_APELLIDOS = request.getParameter("txt-apellidos");
                    PRO_CONTACTO = PRO_NOMBRES + " " + PRO_APELLIDOS;
                    PRO_RUC = request.getParameter("txt-ruc");
                    PRO_TELEFONO = request.getParameter("txt-telefono");
                    PRO_EMAIL = request.getParameter("txt-email");
                    PRO_DIRECCION = request.getParameter("txt-direccion");
                    PRO_WEB = request.getParameter("txt-web");
                    PRO_CREACION = FECHA;
                    PRO_CREADOR = request.getParameter("txt-creador");
                    PRO_IP = request.getParameter("txt-ip");
                    PRO_ESTADO = "EN LINEA";
                    /* ========== DAR VALORES AL OBJETO =========*/
                    pro.setFK_SUCURSAL(FK_SUCURSAL);
                    pro.setPRO_EMPRESA(PRO_EMPRESA);
                    pro.setPRO_CONTACTO(PRO_CONTACTO);
                    pro.setPRO_RUC(PRO_RUC);
                    pro.setPRO_TELEFONO(PRO_TELEFONO);
                    pro.setPRO_EMAIL(PRO_EMAIL);
                    pro.setPRO_DIRECCION(PRO_DIRECCION);
                    pro.setPRO_WEB(PRO_WEB);
                    pro.setPRO_CREACION(PRO_CREACION);
                    pro.setPRO_CREADOR(PRO_CREADOR);
                    pro.setPRO_IP(PRO_IP);
                    pro.setPRO_ESTADO(PRO_ESTADO);
                    /* ========== ENVIO EL OBJETO A LA DB=========*/
                    if (DAO.add(pro) == "El proveedor fue creado con exito!") {
                        request.setAttribute("msj_si", "El proveedor " + PRO_NOMBRES + " " + PRO_APELLIDOS + " fue creado con exito");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (DAO.add(pro) == "El proveedor no fue creado con exito!") {
                        request.setAttribute("msj_no", "El proveedor no fue creado!");
                        request.setAttribute("div_no", "visible");
                        request.setAttribute("div_si", "sr-only");
                    }
                    acceso = REGISTROS;
                    break;
                case "editar-a":
                    request.setAttribute("idProveedor", request.getParameter("idProveedor"));
                    acceso = EDITAR;
                    break;
                case "Actualizar":
                    ID_PROVEEDOR = Integer.parseInt(request.getParameter("txt-id-proveedor"));
                    FK_SUCURSAL = Integer.parseInt(request.getParameter("cbx-sucursal"));
                    PRO_EMPRESA = request.getParameter("txt-empresa");
                    PRO_CONTACTO = request.getParameter("txt-contacto");
                    PRO_RUC = request.getParameter("txt-ruc");
                    PRO_TELEFONO = request.getParameter("txt-telefono");
                    PRO_EMAIL = request.getParameter("txt-email");
                    PRO_DIRECCION = request.getParameter("txt-direccion");
                    PRO_WEB = request.getParameter("txt-web");
                    PRO_ESTADO = "EN LINEA";
                    /* ========== DAR VALORES AL OBJETO =========*/
                    pro.setID_PROVEEDOR(ID_PROVEEDOR);
                    pro.setFK_SUCURSAL(FK_SUCURSAL);
                    pro.setPRO_EMPRESA(PRO_EMPRESA);
                    pro.setPRO_CONTACTO(PRO_CONTACTO);
                    pro.setPRO_RUC(PRO_RUC);
                    pro.setPRO_TELEFONO(PRO_TELEFONO);
                    pro.setPRO_EMAIL(PRO_EMAIL);
                    pro.setPRO_DIRECCION(PRO_DIRECCION);
                    pro.setPRO_WEB(PRO_WEB);
                    pro.setPRO_ESTADO(PRO_ESTADO);
                    /* ========== ENVIO EL OBJETO A LA DB=========*/
                    if (DAO.update(pro) == "El proveedor fue actualizado con exito!") {
                        request.setAttribute("msj_si", "El proveedor " + PRO_CONTACTO + " fue actualizado con exito");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (DAO.update(pro) == "El proveedor no fue actualizado!") {
                        request.setAttribute("msj_no", "No se pudo actualizar al proveedor " + PRO_NOMBRES + " " + PRO_APELLIDOS + "!");
                        request.setAttribute("div_no", "visible");
                        request.setAttribute("div_si", "sr-only");
                    }
                    acceso = REGISTROS;
                    break;
                case "dar_baja":
                    ID_PROVEEDOR = Integer.parseInt((String) request.getParameter("idproveedor"));
                    PRO_ESTADO = "DE BAJA";
                    /* ========== ENVIO EL OBJETO A LA DB=========*/
                    if (DAO.actualizar_estado(ID_PROVEEDOR, PRO_ESTADO) == "El proveedor fue dado de baja con exito!") {
                        request.setAttribute("msj_si", "El proveedor " + PRO_NOMBRES + " " + PRO_APELLIDOS + " fue dado de baja con exito");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (DAO.actualizar_estado(ID_PROVEEDOR, PRO_ESTADO) == "Error al dar baja al proveedor!") {
                        request.setAttribute("msj_no", "No se pudo dar de baja al proveedor " + PRO_NOMBRES + " " + PRO_APELLIDOS + "!");
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
