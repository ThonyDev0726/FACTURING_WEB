package ModelDAO;

import DataBase.Conexion;
import Interfaces.crud_cliente;
import Model.CLIENTE;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author perez
 */
public class CLIENTE_DAO implements crud_cliente {

    CLIENTE c = new CLIENTE();
    Conexion cn = new Conexion();
    CallableStatement cs;
    Connection con;
    ResultSet rs;

    /* ============== VARIABLES PARA PROCEDIMIENTOS ALMACENADOS ==============*/
    String LISTAR_EN_LINEA = "CALL A_SELECT_CLIENTE_LINEA()";
    String LISTAR = "CALL A_SELECT_CLIENTE()";
    String LISTAR_ID = "CALL A_S_ID_CLIENTE(?)";
    String CREAR = "CALL INSERT_CLIENTE(?,?,?,?,?,?,?,?,?,?,?,?)";
    String ACTUALIZAR = "CALL UPDATE_CLIENTE(?,?,?,?,?,?,?,?,?)";
    String ELIMINAR = "CALL DELETE_CLIENTE(?)";
    String ACTUALIZAR_ESTADO = "CALL UPDATE_CLIENTE_ESTADO(?,?)";

    @Override
    public List listar() {
        ArrayList<CLIENTE> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR);
            rs = cs.executeQuery();
            while (rs.next()) {
                CLIENTE cli = new CLIENTE();
                cli.setID_CLIENTE(rs.getInt(1));
                cli.setCLI_ESTADO(rs.getString(2));
                cli.setCLI_NOMBRES(rs.getString(3));
                cli.setCLI_APELLIDOS(rs.getString(4));
                cli.setCLI_CEDULA(rs.getString(5));
                cli.setCLI_RUC(rs.getString(6));
                cli.setCLI_EMAIL(rs.getString(7));
                cli.setCLI_TELEFONO(rs.getString(8));
                cli.setCLI_DIRECCION(rs.getString(9));
                cli.setCLI_CUMPLEANOS(rs.getString(10));
                lista.add(cli);
            }
            System.out.println(LISTAR);
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS CLIENTES" + ex);
        }
        return lista;
    }
    
    @Override
    public List listar_en_linea() {
        ArrayList<CLIENTE> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR_EN_LINEA);
            rs = cs.executeQuery();
            while (rs.next()) {
                CLIENTE cli = new CLIENTE();
                cli.setID_CLIENTE(rs.getInt(1));
                cli.setCLI_ESTADO(rs.getString(2));
                cli.setCLI_NOMBRES(rs.getString(3));
                cli.setCLI_APELLIDOS(rs.getString(4));
                cli.setCLI_CEDULA(rs.getString(5));
                cli.setCLI_RUC(rs.getString(6));
                cli.setCLI_EMAIL(rs.getString(7));
                cli.setCLI_TELEFONO(rs.getString(8));
                cli.setCLI_DIRECCION(rs.getString(9));
                cli.setCLI_CUMPLEANOS(rs.getString(10));
                lista.add(cli);
            }
            System.out.println(LISTAR);
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS CLIENTES" + ex);
        }
        return lista;
    }

    @Override
    public CLIENTE list(int id) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR_ID);
            cs.setInt(1, id);
            rs = cs.executeQuery();
            while (rs.next()) {
                c.setID_CLIENTE(rs.getInt(1));
                c.setCLI_NOMBRES(rs.getString(2));
                c.setCLI_APELLIDOS(rs.getString(3));
                c.setCLI_CEDULA(rs.getString(4));
                c.setCLI_RUC(rs.getString(5));
                c.setCLI_EMAIL(rs.getString(6));
                c.setCLI_TELEFONO(rs.getString(7));
                c.setCLI_DIRECCION(rs.getString(8));
                c.setCLI_CUMPLEANOS(rs.getString(9));
            }
            System.out.println(LISTAR_ID);
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS CLIENTES" + ex);
        }
        return c;
    }

    @Override
    public String add(CLIENTE cli) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(CREAR);
            cs.setString(1, cli.getCLI_NOMBRES());
            cs.setString(2, cli.getCLI_APELLIDOS());
            cs.setString(3, cli.getCLI_RUC());
            cs.setString(4, cli.getCLI_CEDULA());
            cs.setString(5, cli.getCLI_EMAIL());
            cs.setString(6, cli.getCLI_TELEFONO());
            cs.setString(7, cli.getCLI_DIRECCION());
            cs.setString(8, cli.getCLI_CUMPLEANOS());
            cs.setString(9, cli.getCLI_CREACION());
            cs.setString(10, cli.getCLI_CREADOR());
            cs.setString(11, cli.getCLI_IP());
            cs.setString(12, cli.getCLI_ESTADO());
            cs.execute();
            System.out.println(CREAR);
        } catch (SQLException ex) {
            System.out.println("ERROR AL CREAR EL CLIENTE");
            System.out.println(ex);
            return "El cliente no fue creado con exito!";
        }
        return "El cliente fue creado con exito!";
    }

    @Override
    public String update(CLIENTE cli) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ACTUALIZAR);
            cs.setInt(1, cli.getID_CLIENTE());
            cs.setString(2, cli.getCLI_NOMBRES());
            cs.setString(3, cli.getCLI_APELLIDOS());
            cs.setString(4, cli.getCLI_CEDULA());
            cs.setString(5, cli.getCLI_RUC());
            cs.setString(6, cli.getCLI_EMAIL());
            cs.setString(7, cli.getCLI_TELEFONO());
            cs.setString(8, cli.getCLI_DIRECCION());
            cs.setString(9, cli.getCLI_CUMPLEANOS());
            System.out.println(ACTUALIZAR);
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR AL ACTUALIZAR EL CLIENTE");
            System.out.println(ex);
            return "El cliente no fue actualizado!";
        }
        return "El cliente fue actualizado con exito!";
    }

    @Override
    public String actualizar_estado(int id, String estado) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ACTUALIZAR_ESTADO);
            cs.setInt(1, id);
            cs.setString(2, estado);
            System.out.println(ACTUALIZAR_ESTADO);
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR AL DAR DE BAJA AL CLIENTE");
            System.out.println(ex);
            return "Error al dar baja al cliente!";
        }
        return "El cliente fue dado de baja con exito!";
    }

    @Override
    public String delete(int id) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ELIMINAR);
            cs.setInt(1, id);
            System.out.println(ELIMINAR);
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el cliente!");
            System.out.println(ex);
            return "Error al eliminar el cliente!";
        }
        return "El cliente fue eliminado con exito!";
    }

    

}
