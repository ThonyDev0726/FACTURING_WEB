package Controller;

import Converters.Convertidor;
import Model.CATEGORIA_PRODUCTO;
import Model.PRODUCTO;
import Model.USUARIO;
import ModelDAO.CATEGORIA_PRODUCTO_DAO;
import ModelDAO.PRODUCTO_DAO;
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

    /* ==================== VARIABLES GLOBALES ==================== */
    Convertidor convertidor = new Convertidor();
    PRODUCTO producto = new PRODUCTO();
    PRODUCTO_DAO proDAO = new PRODUCTO_DAO();
    CATEGORIA_PRODUCTO categoria = new CATEGORIA_PRODUCTO();
    CATEGORIA_PRODUCTO_DAO DAO = new CATEGORIA_PRODUCTO_DAO();
    LocalDate todaysDate = LocalDate.now();
    String fecha = todaysDate.toString();
    /* ==================== VARIABLES RUTA ==================== */
    String REGISTROS = "views/administrador/productos.jsp";
    String EDITAR_CATEGORIA = "views/administrador/categorias-editar.jsp";
    String EDITAR_PRODUCTO = "views/administrador/productos-editar.jsp";
    /* ==================== VARIABLES CATEGORIA ==================== */
    Integer ID_CATEGORIA;
    String CAT_DESCRIPCION;
    String CAT_ESTADO;
    String CAT_IP;
    /* ==================== VARIABLES PRODUCTO ==================== */
    Integer ID_PRODUCTO;
    Integer FK_SUCURSAL;
    Integer FK_PROVEEDOR;
    Integer FK_CATEGORIA;
    String PRO_NOMBRE;
    String PRO_CODIGO;
    String PRO_CODIGO_AUX;
    Integer PRO_STOCK;
    Double PRO_VALOR_FABRICA;
    Double PRO_VALOR_UNITARIO;
    Integer PRO_GANANCIA;
    String PRO_IVA_TIPO;
    String PRO_USO;
    String PRO_USO_EXTRA;
    String PRO_IMG1;
    String PRO_IMG2;
    String PRO_IMG3;
    String PRO_IMG4;
    String PRO_CREACION;
    String PRO_CREADOR;
    String PRO_IP;
    String PRO_ESTADO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        /* ==================== GLOBALES ==================== */
        String LOGIN = "views/Login.jsp";
        HttpSession session = request.getSession();
        USUARIO usu = (USUARIO) session.getAttribute("usuario");
        if (usu == null) {
            request.setAttribute("iniciarSesion", "Debes iniciar sesion, para acceder al contenido!!");
            request.getRequestDispatcher(LOGIN).forward(request, response);
        } else {
            switch (action) {
                /* ==================== CATEGORIA DE PRODUCTOS ==================== */
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
                /* ==================== PRODUCTOS ==================== */
                    case "editar-a":
                    request.setAttribute("idProducto", request.getParameter("idProducto"));
                    acceso = EDITAR_PRODUCTO;
                    break;
                    case "dar_baja":
                    ID_PRODUCTO = Integer.parseInt(request.getParameter("idProducto"));
                    PRO_ESTADO = "DE BAJA";
                    /* ========== ENVIO EL OBJETO A LA DB=========*/
                    if (proDAO.actualizar_estado(ID_PRODUCTO, PRO_ESTADO) == "El producto fue dada de baja con exito!") {
                        request.setAttribute("msj_si", "El producto fue dada de baja con exito!");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (proDAO.actualizar_estado(ID_PRODUCTO, PRO_ESTADO) == "Error al dar baja al producto!") {
                        request.setAttribute("msj_no", "Error al dar baja al producto!");
                        request.setAttribute("div_no", "visible");
                        request.setAttribute("div_si", "sr-only");
                    }
                    acceso = REGISTROS;
                    break;
                    case "eliminar":
                    ID_PRODUCTO = Integer.parseInt((String) request.getParameter("idProducto"));
                    /* ========== ENVIO EL OBJETO A LA DB=========*/
                    if (proDAO.delete(ID_PRODUCTO) == "El producto fue eliminada con exito!") {
                        request.setAttribute("msj_si", "El producto fue eliminado con exito");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (proDAO.delete(ID_PRODUCTO) == "Error al eliminar el producto!") {
                        request.setAttribute("msj_no", "No se pudo eliminar el producto!");
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
        /* ==================== GLOBALES ==================== */
        String LOGIN = "views/Login.jsp";
        HttpSession session = request.getSession();
        USUARIO usu = (USUARIO) session.getAttribute("usuario");
        if (usu == null) {
            request.setAttribute("iniciarSesion", "Debes iniciar sesion, para acceder al contenido!!");
            request.getRequestDispatcher(LOGIN).forward(request, response);
        } else {
            /* ==================== CATEGORIA DE PRODUCTOS ==================== */
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
                /* ==================== PRODUCTOS ==================== */
                case "Guardar":
                    FK_SUCURSAL = Integer.parseInt(request.getParameter("cbx-sucursal"));
                    FK_PROVEEDOR = Integer.parseInt(request.getParameter("txt-id-proveedor"));
                    FK_CATEGORIA = convertidor.obtenerNumero(request.getParameter("txt-categoria"));
                    PRO_NOMBRE = request.getParameter("txt-nombre-producto");
                    PRO_CODIGO = request.getParameter("txt-codigo");
                    PRO_CODIGO_AUX = request.getParameter("txt-codigo-auxiliar");
                    PRO_STOCK = Integer.parseInt(request.getParameter("txt-stock"));
                    PRO_VALOR_FABRICA = Double.parseDouble(request.getParameter("txt-valor-fabrica"));
                    PRO_VALOR_UNITARIO = Double.parseDouble(request.getParameter("txt-valor-unitario"));
                    PRO_GANANCIA = Integer.parseInt(request.getParameter("txt-ganancia"));
                    PRO_IVA_TIPO = request.getParameter("txt-iva-tipo");
                    PRO_USO = request.getParameter("txt-uso-producto");
                    PRO_USO_EXTRA = request.getParameter("txt-uso-extra");
                    PRO_IMG1 = request.getParameter("txt-img-1");
                    PRO_IMG2 = request.getParameter("txt-img-2");
                    PRO_IMG3 = request.getParameter("txt-img-3");
                    PRO_IMG4 = request.getParameter("txt-img-4");
                    PRO_CREACION = fecha;
                    PRO_CREADOR = request.getParameter("txt-usuario");
                    PRO_IP = request.getParameter("txt-ip");
                    PRO_ESTADO = "EN LINEA";
                    /* ==================== PRODUCTOS ==================== */
                    producto.setFK_SUCURSAL(FK_SUCURSAL);
                    producto.setFK_PROVEEDOR(FK_PROVEEDOR);
                    producto.setFK_CATEGORIA(FK_CATEGORIA);
                    producto.setPRO_NOMBRE(PRO_NOMBRE);
                    producto.setPRO_CODIGO(PRO_CODIGO);
                    producto.setPRO_CODIGO_AUX(PRO_CODIGO_AUX);
                    producto.setPRO_STOCK(PRO_STOCK);
                    producto.setPRO_VALOR_FABRICA(PRO_VALOR_FABRICA);
                    producto.setPRO_VALOR_UNITARIO(PRO_VALOR_UNITARIO);
                    producto.setPRO_GANANCIA(PRO_GANANCIA);
                    producto.setPRO_IVA_TIPO(PRO_IVA_TIPO);
                    producto.setPRO_USO(PRO_USO);
                    producto.setPRO_USO_EXTRA(PRO_USO_EXTRA);
                    producto.setPRO_IMG1(PRO_IMG1);
                    producto.setPRO_IMG2(PRO_IMG2);
                    producto.setPRO_IMG3(PRO_IMG3);
                    producto.setPRO_IMG4(PRO_IMG4);
                    producto.setPRO_CREACION(PRO_CREACION);
                    producto.setPRO_CREADOR(PRO_CREADOR);
                    producto.setPRO_IP(PRO_IP);
                    producto.setPRO_ESTADO(PRO_ESTADO);
                    if (proDAO.add(producto) == "El producto fue creado con exito!") {
                        request.setAttribute("msj_si", "El producto " + PRO_NOMBRE + " fue creado con exito!");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (proDAO.add(producto) == "El producto no fue creado con exito!") {
                        request.setAttribute("msj_no", "El producto no fue creado con exito!");
                        request.setAttribute("div_no", "visible");
                        request.setAttribute("div_si", "sr-only");
                    }
                    acceso = REGISTROS;
                    break;                
                case "Actualizar":
                    ID_PRODUCTO = Integer.parseInt(request.getParameter("txt-id-producto"));
                    FK_SUCURSAL = Integer.parseInt(request.getParameter("cbx-sucursal"));
                    FK_PROVEEDOR = Integer.parseInt(request.getParameter("txt-id-proveedor"));
                    FK_CATEGORIA = convertidor.obtenerNumero(request.getParameter("txt-categoria"));
                    PRO_NOMBRE = request.getParameter("txt-nombre-producto");
                    PRO_CODIGO = request.getParameter("txt-codigo");
                    PRO_CODIGO_AUX = request.getParameter("txt-codigo-auxiliar");
                    PRO_STOCK = Integer.parseInt(request.getParameter("txt-stock"));
                    PRO_VALOR_FABRICA = Double.parseDouble(request.getParameter("txt-ganancia"));
                    PRO_VALOR_UNITARIO = Double.parseDouble(request.getParameter("txt-valor-unitario"));
                    PRO_GANANCIA = Integer.parseInt(request.getParameter("txt-ganancia"));
                    PRO_IVA_TIPO = request.getParameter("txt-iva-tipo");
                    PRO_USO = request.getParameter("txt-uso-producto");
                    PRO_USO_EXTRA = request.getParameter("txt-uso-extra");
                    PRO_IMG1 = request.getParameter("txt-img-1");
                    PRO_IMG2 = request.getParameter("txt-img-2");
                    PRO_IMG3 = request.getParameter("txt-img-3");
                    PRO_IMG4 = request.getParameter("txt-img-4");
                    PRO_ESTADO = request.getParameter("cbx-estado");
                    /* ==================== PRODUCTOS ==================== */
                    producto.setID_PRODUCTO(ID_PRODUCTO);
                    producto.setFK_SUCURSAL(FK_SUCURSAL);
                    producto.setFK_PROVEEDOR(FK_PROVEEDOR);
                    producto.setFK_CATEGORIA(FK_CATEGORIA);
                    producto.setPRO_NOMBRE(PRO_NOMBRE);
                    producto.setPRO_CODIGO(PRO_CODIGO);
                    producto.setPRO_CODIGO_AUX(PRO_CODIGO_AUX);
                    producto.setPRO_STOCK(PRO_STOCK);
                    producto.setPRO_VALOR_FABRICA(PRO_VALOR_FABRICA);
                    producto.setPRO_VALOR_UNITARIO(PRO_VALOR_UNITARIO);
                    producto.setPRO_GANANCIA(PRO_GANANCIA);
                    producto.setPRO_IVA_TIPO(PRO_IVA_TIPO);
                    producto.setPRO_USO(PRO_USO);
                    producto.setPRO_USO_EXTRA(PRO_USO_EXTRA);
                    producto.setPRO_IMG1(PRO_IMG1);
                    producto.setPRO_IMG2(PRO_IMG2);
                    producto.setPRO_IMG3(PRO_IMG3);
                    producto.setPRO_IMG4(PRO_IMG4);
                    producto.setPRO_ESTADO(PRO_ESTADO);
                    if (proDAO.update(producto) == "El producto fue actualizado con exito!") {
                        request.setAttribute("msj_si", "El producto " + PRO_NOMBRE + " fue actualizado con exito!");
                        request.setAttribute("div_si", "visible");
                        request.setAttribute("div_no", "sr-only");
                    } else if (proDAO.update(producto) == "El producto no fue actualizado con exito!") {
                        request.setAttribute("msj_no", "El producto no fue actualizado con exito!");
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
