package ModelDAO;

import Converters.Encriptador;
import DataBase.Conexion;
import Interfaces.crud_usuario;
import Model.USUARIO;
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
public class USUARIO_DAO implements crud_usuario {

    /* ========= VARIABLES GLOBALES ========= */
    Encriptador enc = new Encriptador();
    USUARIO c = new USUARIO();
    Conexion cn = new Conexion();
    CallableStatement cs;
    Connection con;
    ResultSet rs;

    /* ========= VARIABLES PROCEDIMIENTOS ========= */
    String CONSULTAR_USUARIO = "CALL U_S_ID_USUARIO(?)";
    String CONSULTAR_CLAVE = "CALL U_S_USU_CLAVE(?)";
    String CONSULTAR_CARGO = "CALL U_S_USU_PARAMETRO(?)";
    String CONSULTAR_ESTADO = "CALL U_S_USU_ESTADO(?)";
    String LISTAR = "CALL SELECT_ALL_USUARIO()";
    String LISTAR_ID = "CALL A_S_ID_USUARIO(?)";
    String CREAR = "CALL INSERT_USUARIO(?,?,?,?,?,?,?,?,?,?,?)";

    /* ========= VARIABLES PROCEDIMIENTOS PARAMETROS ========= */
    Integer ID_USUARIO;
    String CLAVE = "";
    String CARGO = "";
    String ESTADO = "";

    /* =================== LOGIN =================== */
    @Override
    public Integer consultarUsuario(String USU_USUARIO) {
        try {
            ID_USUARIO = 0;
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(CONSULTAR_USUARIO);
            cs.setString(1, USU_USUARIO);
            rs = cs.executeQuery();
            while (rs.next()) {
                ID_USUARIO = Integer.parseInt(rs.getString(1));
            }
            System.out.println(CONSULTAR_USUARIO);
        } catch (SQLException ex) {
            System.out.println("ID_USUARIO no encontrado: " + ex);
            return 0;
        }
        return ID_USUARIO;
    }

    @Override
    public String obtenerClave(int ID_USUARIO) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(CONSULTAR_CLAVE);
            cs.setInt(1, ID_USUARIO);
            rs = cs.executeQuery();
            while (rs.next()) {
                CLAVE = rs.getString(1);
            }
            System.out.println(CONSULTAR_CLAVE);
        } catch (Exception e) {
            System.out.println("USU_CLAVE no encontrada: " + e);
        }
        return CLAVE;
    }

    @Override
    public String consultarCargo(int ID_USUARIO) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(CONSULTAR_CARGO);
            cs.setInt(1, ID_USUARIO);
            rs = cs.executeQuery();
            while (rs.next()) {
                CARGO = rs.getString(1);
            }
            System.out.println(CONSULTAR_USUARIO);
        } catch (Exception e) {
            System.out.println("USU_CARGO no encontrada: " + e);
        }
        return CARGO;
    }

    @Override
    public String consultarEstado(int ID_USUARIO) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(CONSULTAR_ESTADO);
            cs.setInt(1, ID_USUARIO);
            rs = cs.executeQuery();
            while (rs.next()) {
                ESTADO = rs.getString(1);
            }
            System.out.println(CONSULTAR_ESTADO);
        } catch (Exception e) {
            System.out.println("USU_ESTADO no encontrado: " + e);
        }
        System.out.println(ESTADO);
        return ESTADO;
    }

    /* ========= CRUD ========= */
    @Override
    public List listar() {
        ArrayList<USUARIO> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR);
            rs = cs.executeQuery();
            while (rs.next()) {
                USUARIO cli = new USUARIO();
                cli.setID_USUARIO(rs.getInt(1));
                cli.setSUC_NOMBRE(rs.getString(2));
                cli.setEMP_NOMBRES(rs.getString(3));
                cli.setEMP_APELLIDOS(rs.getString(4));
                cli.setEMP_IMG(rs.getString(5));
                cli.setUSU_USUARIO(rs.getString(6));
                cli.setUSU_CLAVE(rs.getString(7));
                cli.setUSU_PARAMETRO(rs.getString(8));
                cli.setUSU_ESTADO(rs.getString(9));
                cli.setUSU_CREADOR(rs.getString(10));
                lista.add(cli);
            }
            System.out.println(LISTAR);
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS USUARIOS" + ex);
        }
        return lista;
    }

    @Override
    public USUARIO list(int idUsuario) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR_ID);
            cs.setInt(1, idUsuario);
            rs = cs.executeQuery();
            while (rs.next()) {
                c.setID_USUARIO(rs.getInt(1));
                c.setSUC_NOMBRE(rs.getString(2));
                c.setEMP_NOMBRES(rs.getString(3));
                c.setEMP_APELLIDOS(rs.getString(4));
                c.setEMP_IMG(rs.getString(5));
                c.setUSU_USUARIO(rs.getString(6));
                c.setUSU_CLAVE(rs.getString(7));
                c.setUSU_PARAMETRO(rs.getString(8));
                c.setUSU_ESTADO(rs.getString(9));
                c.setUSU_CREADOR(rs.getString(10));
            }
            System.out.println(c.toString());
            System.out.println(LISTAR_ID);
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS EMPLEADOS" + ex);
        }
        return c;
    }

    @Override
    public String add(USUARIO mp) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(CREAR);
            cs.setInt(1, mp.getFK_SUCURSAL());
            cs.setInt(2, mp.getFK_EMPLEADO());
            cs.setString(3, mp.getUSU_USUARIO());
            cs.setString(4, enc.encriptar(mp.getUSU_CLAVE()));
            cs.setString(5, mp.getUSU_PARAMETRO());
            cs.setString(6, mp.getUSU_CODIGO());
            cs.setString(7, mp.getUSU_CREACION());
            cs.setString(8, mp.getUSU_CREADOR());
            cs.setString(9, mp.getUSU_IP());
            cs.setString(10, mp.getUSU_ACTIVIDAD());
            cs.setString(11, mp.getUSU_ESTADO());
            cs.execute();
            System.out.println(CREAR);
        } catch (SQLException ex) {
            System.out.println("ERROR AL CREAR EL USUARIO");
            System.out.println(ex);
            return "El usuario no fue creado con exito!";
        }
        return "El usuario fue creado con exito!";
    }

    @Override
    public String update(USUARIO mp) {
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

    @Override
    public String update_password(int i, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
