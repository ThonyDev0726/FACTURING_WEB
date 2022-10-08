package Controller;

import Model.CATEGORIA_PRODUCTO;
import Model.USUARIO;
import ModelDAO.CATEGORIA_PRODUCTO_DAO;
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
@WebServlet(name = "Productos", urlPatterns = {"/Productos"})
public class Productos extends HttpServlet {

    CATEGORIA_PRODUCTO categoria = new CATEGORIA_PRODUCTO();
    CATEGORIA_PRODUCTO_DAO DAO = new CATEGORIA_PRODUCTO_DAO();
    LocalDate todaysDate = LocalDate.now();
//========================================================================================== VARIABLES GLOBALES     
    String REGISTROS = "views/administrador/productos.jsp";
    String EDITAR_CATEGORIA = "views/administrador/categorias-editar.jsp";
    String EDITAR_PRODUCTO = "views/administrador/productos-editar.jsp";
//========================================================================================== VARIABLES CATEGORIA     
    Integer ID_CATEGORIA;
    String CAT_DESCRIPCION;
    String CAT_ESTADO;
    String CAT_IP;
//========================================================================================== VARIABLES GLOBALES     

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
                case "registro-productos":
                    request.setAttribute("div_si", "sr-only");
                    request.setAttribute("div_no", "sr-only");
                    acceso = REGISTROS;
                    break;
                case "editar-categoria":
                    request.setAttribute("idCategoria", request.getParameter("idCategoria"));
                    acceso = EDITAR_CATEGORIA;
                    break;
                case "dar_baja_categoria":
                    ID_CATEGORIA = Integer.parseInt(request.getParameter("idCategoria"));
                    CAT_ESTADO = "DE BAJA";
                    /* ========== ENVIO EL OBJETO A LA DB=========*/
                    if (DAO.actualizar_estado(ID_CATEGORIA, CAT_ESTADO) == "La categoria de producto fue dada de baja con exito!") {
                        request.setAttribute("msj_si", "La categoria de producto fue dada de baja con exito!");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (DAO.actualizar_estado(ID_CATEGORIA, CAT_ESTADO) == "Error al dar baja a la categoria de producto!") {
                        request.setAttribute("msj_no", "Error al dar baja a la categoria de producto!");
                        request.setAttribute("div_no", "visible");
                        request.setAttribute("div_si", "sr-only");
                    }
                    acceso = REGISTROS;
                    break;
                case "eliminar_categoria":
                    ID_CATEGORIA = Integer.parseInt((String) request.getParameter("idCategoria"));
                    /* ========== ENVIO EL OBJETO A LA DB=========*/
                    if (DAO.delete(ID_CATEGORIA) == "La categoria fue eliminada con exito!") {
                        request.setAttribute("msj_si", "La categoria fue eliminada con exito");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (DAO.delete(ID_CATEGORIA) == "Error al eliminar la categoria!") {
                        request.setAttribute("msj_no", "No se pudo eliminar la categoria!");
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
                case "Guardar categoria":
                    CAT_DESCRIPCION = request.getParameter("txt-categoria-descripcion");
                    CAT_ESTADO = "EN LINEA";
                    CAT_IP = request.getParameter("txt-ip");

                    /* ========== DAR VALORES AL OBJETO =========*/
                    categoria.setCAT_DESCRIPCION(CAT_DESCRIPCION);
                    categoria.setCAT_ESTADO(CAT_ESTADO);
                    categoria.setCAT_IP(CAT_IP);
                    /* ========== ENVIO EL OBJETO A LA DB=========*/
                    if (DAO.add(categoria) == "La categoria fue creada con exito!") {
                        request.setAttribute("msj_si", "La categoria " + CAT_DESCRIPCION + " " + CAT_ESTADO + " fue creada con exito");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (DAO.add(categoria) == "La categoria no fue creada con exito!") {
                        request.setAttribute("msj_no", "La categoria no fue creada!");
                        request.setAttribute("div_no", "visible");
                        request.setAttribute("div_si", "sr-only");
                    }
                    acceso = REGISTROS;
                    break;
                case "editar-a":
                    request.setAttribute("idCliente", request.getParameter("idCliente"));
                    acceso = EDITAR_CATEGORIA;
                    break;
                case "Actualizar categoria":
                    ID_CATEGORIA = Integer.parseInt(request.getParameter("txt-id-categoria"));
                    CAT_DESCRIPCION = request.getParameter("txt-descripcion");
                    CAT_ESTADO = request.getParameter("cbx-estado");
                    /* ========== DAR VALORES AL OBJETO =========*/
                    categoria.setID_CATEGORIA(ID_CATEGORIA);
                    categoria.setCAT_DESCRIPCION(CAT_DESCRIPCION);
                    categoria.setCAT_ESTADO(CAT_ESTADO);
                    /* ========== ENVIO EL OBJETO A LA DB=========*/
                    if (DAO.update(categoria) == "La categoria de producto fue actualizada con exito!") {
                        request.setAttribute("msj_si", "La categoria de producto " + CAT_DESCRIPCION + " fue actualizado con exito");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (DAO.update(categoria) == "La categoria de producto no fue actualizada!") {
                        request.setAttribute("msj_no", "No se pudo actualizar la categoria " + CAT_DESCRIPCION + "!");
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
