package Controller;

import Model.SUCURSAL;
import Model.USUARIO;
import ModelDAO.SUCURSAL_DAO;
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
@WebServlet(name = "Empresa", urlPatterns = {"/Empresa"})
public class Empresa extends HttpServlet {
//==========================================================================VARIABLES GLOBALES     

    SUCURSAL suc = new SUCURSAL();
    SUCURSAL_DAO DAO = new SUCURSAL_DAO();
    LocalDate todaysDate = LocalDate.now();
    String fecha = todaysDate.toString();
    /**/
    Integer ID_SUCURSAL;
    Integer FK_EMPRESA;
    String SUC_NOMBRE;
    String SUC_TELEFONO;
    String SUC_EMAIL;
    String SUC_DIRECCION;
    String SUC_UBICACION;
    String SUC_ESTADO;

    /**/
    //========================================================================================== VARIABLES GLOBALES     
    String REGISTROS = "views/administrador/empresa.jsp";
    String EDITAR_SUCURSAL = "views/administrador/sucursal-editar.jsp";

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
                case "registro-empresa":
                    request.setAttribute("div_si", "sr-only");
                    request.setAttribute("div_no", "sr-only");
                    acceso = REGISTROS;
                    break;
                case "editar-sucursal":
                    request.setAttribute("idSucursal", request.getParameter("idSucursal"));
                    acceso = EDITAR_SUCURSAL;
                    break;
                case "dar_baja":
                    ID_SUCURSAL = Integer.parseInt(request.getParameter("idSucursal"));
                    SUC_ESTADO = "DE BAJA";
                    /* ========== ENVIO EL OBJETO A LA DB=========*/
                    if (DAO.actualizar_estado(ID_SUCURSAL, SUC_ESTADO) == "La sucursal fue dado de baja con exito!") {
                        request.setAttribute("msj_si", "LA sucursal fue dado de baja con exito!");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (DAO.actualizar_estado(ID_SUCURSAL, SUC_ESTADO) == "Error al dar baja a la sucursal!") {
                        request.setAttribute("msj_no", "No se pudo dar de baja a la sucusal!");
                        request.setAttribute("div_no", "visible");
                        request.setAttribute("div_si", "sr-only");
                    }
                    acceso = REGISTROS;
                    break;
                case "eliminar":
                    ID_SUCURSAL = Integer.parseInt((String) request.getParameter("idSucursal"));
                    /* ========== ENVIO EL OBJETO A LA DB=========*/
                    if (DAO.delete(ID_SUCURSAL) == "La sucursal fue eliminada con exito!") {
                        request.setAttribute("msj_si", "La sucursal fue eliminada con exito!");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (DAO.delete(ID_SUCURSAL) == "Error al eliminar la sucursal!") {
                        request.setAttribute("msj_no", "Error al eliminar la sucursal!");
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
        switch (action) {
            case "registro-clientes":
                request.setAttribute("div_crear", "sr-only");
                acceso = REGISTROS;
                break;
            case "Guardar":
                FK_EMPRESA = 1;
                SUC_NOMBRE = request.getParameter("txt-nombre-suc");
                SUC_TELEFONO = request.getParameter("txt-telefono-suc");
                SUC_EMAIL = request.getParameter("txt-email-suc");
                SUC_DIRECCION = request.getParameter("txt-direccion-suc");
                SUC_UBICACION = request.getParameter("txt-ubicacion-suc");
                SUC_ESTADO = "EN LINEA";
                /* ========== ENVIO EL OBJETO A LA DB=========*/
                suc.setFK_EMPRESA(FK_EMPRESA);
                suc.setSUC_NOMBRE(SUC_NOMBRE);
                suc.setSUC_TELEFONO(SUC_TELEFONO);
                suc.setSUC_EMAIL(SUC_EMAIL);
                suc.setSUC_DIRECCION(SUC_DIRECCION);
                suc.setSUC_UBICACION(SUC_UBICACION);
                suc.setSUC_ESTADO(SUC_ESTADO);
                /* ========== ENVIO EL OBJETO A LA DB=========*/
                if (DAO.add(suc) == "La sucursal fue creada con exito!") {
                    request.setAttribute("msj_si", "La sucursal " + SUC_NOMBRE + " fue creada con exito");
                    request.setAttribute("div_si", "visible");
                    request.setAttribute("div_no", "sr-only");
                } else if (DAO.add(suc) == "La sucursal no fue creada con exito!") {
                    request.setAttribute("msj_no", "La sucursal no fue creada!");
                    request.setAttribute("div_no", "visible");
                    request.setAttribute("div_si", "sr-only");
                }
                acceso = REGISTROS;
                break;
            case "Actualizar":
                ID_SUCURSAL = Integer.parseInt(request.getParameter("txt-id-sucursal"));
                SUC_NOMBRE = request.getParameter("txt-nombre-suc");
                SUC_TELEFONO = request.getParameter("txt-telefono-suc");
                SUC_EMAIL = request.getParameter("txt-email-suc");
                SUC_DIRECCION = request.getParameter("txt-direccion-suc");
                SUC_UBICACION = request.getParameter("txt-ubicacion-suc");
                SUC_ESTADO = request.getParameter("cbx-estado-suc");
                /* ========== ENVIO EL OBJETO A LA DB=========*/
                suc.setID_SUCURSAL(ID_SUCURSAL);
                suc.setSUC_NOMBRE(SUC_NOMBRE);
                suc.setSUC_TELEFONO(SUC_TELEFONO);
                suc.setSUC_EMAIL(SUC_EMAIL);
                suc.setSUC_DIRECCION(SUC_DIRECCION);
                suc.setSUC_UBICACION(SUC_UBICACION);
                suc.setSUC_ESTADO(SUC_ESTADO);
                /* ========== ENVIO EL OBJETO A LA DB=========*/
                if (DAO.update(suc) == "La sucursal fue actualizada con exito!") {
                    request.setAttribute("msj_si", "La sucursal " + SUC_NOMBRE + " fue actualizada con exito");
                    request.setAttribute("div_si", "visible");
                    request.setAttribute("div_no", "sr-only");
                } else if (DAO.update(suc) == "La sucursal no fue actualizada con exito!") {
                    request.setAttribute("msj_no", "La sucursal no fue actualizada!");
                    request.setAttribute("div_no", "visible");
                    request.setAttribute("div_si", "sr-only");
                }
                /* ========== ENVIO EL OBJETO A LA DB=========*/
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
