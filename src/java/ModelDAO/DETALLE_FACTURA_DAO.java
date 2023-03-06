package ModelDAO;

import DataBase.Conexion;
import Model.DETALLE_FACTURA;
import java.util.List;
import Interfaces.crud_detalle_factura;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DETALLE_FACTURA_DAO implements crud_detalle_factura {

    Conexion cn = new Conexion();
    CallableStatement cs;
    Connection con;
    ResultSet rs;

    /* ============== VARIABLES PARA PROCEDIMIENTOS ALMACENADOS ==============*/
    String CREAR = "CALL INSERT_DETALLE(?,?,?,?)";

    @Override
    public List listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DETALLE_FACTURA list(int idDetalle_factura) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String add(DETALLE_FACTURA cli) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(CREAR);
            cs.setInt(1, cli.getFK_FACTURA());
            cs.setInt(2, cli.getFK_PRODUCTO());
            cs.setInt(3, cli.getDET_CANTIDAD());
            cs.setDouble(4, cli.getDET_TOTAL());
            cs.execute();
            System.out.println(CREAR);
        } catch (SQLException ex) {
            System.out.println("ERROR AL CREAR EL DETALLE");
            System.out.println(ex);
            return "El detalle no fue creado con exito!";
        }
        return "El detalle fue creado con exito!";
    }

    @Override
    public String update(DETALLE_FACTURA mp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List listar_en_linea() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String actualizar_estado(int id, String estado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
