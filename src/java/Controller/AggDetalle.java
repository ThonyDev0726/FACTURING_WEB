package Controller;

import Model.DETALLE_FACTURA;
import Model.PRODUCTO;
import Model.USUARIO;
import ModelDAO.DETALLE_FACTURA_DAO;
import ModelDAO.PRODUCTO_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author kamir
 */
public class AggDetalle extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger("LoginLogger");

    String LOGIN = "Vista/Login.jsp";

    //
    private Integer ID_DETALLE;
    private Integer FK_FACTURA;
    private Integer FK_PRODUCTO;
    private String FK_PRODUCTO_STRING;
    private Integer DET_CANTIDAD;
    private String DET_CANTIDAD_STRING;
    private Double DET_TOTAL;
    private String DET_TOTAL_STRING;
    private Integer PRO_STOCK;
    PRODUCTO_DAO dao = new PRODUCTO_DAO();
    DETALLE_FACTURA_DAO daoDet = new DETALLE_FACTURA_DAO();
    DETALLE_FACTURA det = new DETALLE_FACTURA();
    PRODUCTO producto = new PRODUCTO();

    public AggDetalle() {
        super();
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/plain");
        String strJson = request.getParameter("datosUsuario"); // obtiene lo enviado por AJAX
        JSONObject json = new JSONObject(strJson);
        FK_PRODUCTO_STRING = json.get("txtIdProd").toString();// DATO DEL JSON
        FK_PRODUCTO = Integer.parseInt(FK_PRODUCTO_STRING);// DATO DEL JSON
//        FK_PRODUCTO = 1;// DATO DEL JSON
        DET_CANTIDAD_STRING = (String) json.get("txtProCantidad").toString();// DATO DEL JSON
        DET_CANTIDAD = Integer.parseInt(DET_CANTIDAD_STRING);// DATO DEL JSON
//        DET_CANTIDAD = 5;// DATO DEL JSON
        DET_TOTAL_STRING = (String) json.get("txtProTotal").toString();// DATO DEL JSON
        DET_TOTAL = Double.parseDouble(DET_TOTAL_STRING);// DATO DEL JSON
//        DET_TOTAL = 10.0;// DATO DEL JSON

        HttpSession session = request.getSession();
        USUARIO usu = (USUARIO) session.getAttribute("usuario");
        if (usu == null) {
            writer.print("Iniciar sesion");
        } else {
            PRO_STOCK = dao.listStock(FK_PRODUCTO);
            System.out.println("PRO_STOCK " + PRO_STOCK);
            System.out.println("DET_CANTIDAD " + DET_CANTIDAD);
            if (DET_CANTIDAD < PRO_STOCK) {
                det.setDET_CANTIDAD(DET_CANTIDAD);
                det.setFK_FACTURA(1);
                det.setFK_PRODUCTO(DET_CANTIDAD);
                det.setDET_CANTIDAD(DET_CANTIDAD);
                det.setDET_TOTAL(DET_TOTAL);
                daoDet.add(det);
                Integer Stock = PRO_STOCK - DET_CANTIDAD;
                dao.actualizarStock(FK_PRODUCTO, Stock);
                writer.print("Producto agregado");
            } else {
                writer.print("Stock insuficiente");
            }
        }
        writer.flush();
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            processRequest(request, response);
        } catch (ServletException | IOException e) {
            logger.warning(e.getLocalizedMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ServletException | IOException e) {
            logger.warning(e.getLocalizedMessage());
        }
    }
}
