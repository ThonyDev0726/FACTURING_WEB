/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelDAO;

import DataBase.Conexion;
import Interfaces.crud_proveedor;
import Model.PROVEEDOR;
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
public class PROVEEDOR_DAO implements crud_proveedor {

    PROVEEDOR prov = new PROVEEDOR();
    Conexion cn = new Conexion();
    CallableStatement cs;
    Connection con;
    ResultSet rs;

    /* ============== VARIABLES PARA PROCEDIMIENTOS ALMACENADOS ==============*/
    String LISTAR_EN_LINEA = "CALL A_SELECT_PROVEEDOR_LINEA()";
    String LISTAR = "CALL A_SELECT_ALL_PROVEEDOR()";
    String LISTAR_ID = "CALL A_SELECT_ID_PROVEEDOR(?)";
    String CREAR = "CALL INSERT_PROVEEDOR(?,?,?,?,?,?,?,?,?,?,?,?)";
    String ACTUALIZAR = "CALL UPDATE_PROVEEDOR(?,?,?,?,?,?,?,?,?,?)";
    String ELIMINAR = "CALL DELETE_PROVEEDOR(?)";
    String ACTUALIZAR_ESTADO = "CALL UPDATE_PROVEEDOR_ESTADO(?,?)";

    @Override
    public List listar() {
        ArrayList<PROVEEDOR> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR);
            rs = cs.executeQuery();
            while (rs.next()) {
                PROVEEDOR pro = new PROVEEDOR();
                pro.setID_PROVEEDOR(rs.getInt(1));
                pro.setSUC_NOMBRE(rs.getString(2));
                pro.setPRO_EMPRESA(rs.getString(3));
                pro.setPRO_CONTACTO(rs.getString(4));
                pro.setPRO_RUC(rs.getString(5));
                pro.setPRO_TELEFONO(rs.getString(6));
                pro.setPRO_EMAIL(rs.getString(7));
                pro.setPRO_DIRECCION(rs.getString(8));
                pro.setPRO_WEB(rs.getString(9));
                pro.setPRO_CREACION(rs.getString(10));
                pro.setPRO_CREADOR(rs.getString(11));
                pro.setPRO_ESTADO(rs.getString(12));
                lista.add(pro);
            }
            System.out.println(LISTAR);
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS PROVEEDORES" + ex);
        }
        return lista;
    }

    @Override
    public PROVEEDOR list(int idProveedor) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR_ID);
            cs.setInt(1, idProveedor);
            rs = cs.executeQuery();
            while (rs.next()) {
                prov.setID_PROVEEDOR(rs.getInt(1));
                prov.setSUC_NOMBRE(rs.getString(2));
                prov.setPRO_EMPRESA(rs.getString(3));
                prov.setPRO_CONTACTO(rs.getString(4));
                prov.setPRO_RUC(rs.getString(5));
                prov.setPRO_TELEFONO(rs.getString(6));
                prov.setPRO_EMAIL(rs.getString(7));
                prov.setPRO_DIRECCION(rs.getString(8));
                prov.setPRO_WEB(rs.getString(9));
                prov.setPRO_ESTADO(rs.getString(10));
            }
            System.out.println(LISTAR_ID);
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR EL PROVEEDOR" + ex);
        }
        return prov;
    }

    @Override
    public String add(PROVEEDOR pro) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(CREAR);
            cs.setInt(1, pro.getFK_SUCURSAL());
            cs.setString(2, pro.getPRO_EMPRESA());
            cs.setString(3, pro.getPRO_CONTACTO());
            cs.setString(4, pro.getPRO_RUC());
            cs.setString(5, pro.getPRO_TELEFONO());
            cs.setString(6, pro.getPRO_EMAIL());
            cs.setString(7, pro.getPRO_DIRECCION());
            cs.setString(8, pro.getPRO_WEB());
            cs.setString(9, pro.getPRO_CREACION());
            cs.setString(10, pro.getPRO_CREADOR());
            cs.setString(11, pro.getPRO_IP());
            cs.setString(12, pro.getPRO_ESTADO());
            cs.execute();
            System.out.println(CREAR);
        } catch (SQLException ex) {
            System.out.println("ERROR AL CREAR EL PROVEDOR");
            System.out.println(ex);
            return "El proveedor no fue creado con exito!";
        }
        return "El proveedor fue creado con exito!";
    }

    @Override
    public String update(PROVEEDOR mp) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ACTUALIZAR);
            cs.setInt(1, mp.getID_PROVEEDOR());
            cs.setInt(2, mp.getFK_SUCURSAL());
            cs.setString(3, mp.getPRO_EMPRESA());
            cs.setString(4, mp.getPRO_CONTACTO());
            cs.setString(5, mp.getPRO_RUC());
            cs.setString(6, mp.getPRO_TELEFONO());
            cs.setString(7, mp.getPRO_EMAIL());
            cs.setString(8, mp.getPRO_DIRECCION());
            cs.setString(9, mp.getPRO_WEB());
            cs.setString(10, mp.getPRO_ESTADO());
            System.out.println(ACTUALIZAR);
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR AL ACTUALIZAR EL PROVEEDOR");
            System.out.println(ex);
            return "El proveedor no fue actualizado!";
        }
        return "El proveedor fue actualizado con exito!";
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
            System.out.println("Error al eliminar el proveedor!");
            System.out.println(ex);
            return "Error al eliminar el proveedor!";
        }
        return "El proveedor fue eliminado con exito!";
    }

    @Override
    public List listar_en_linea() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
            System.out.println("ERROR AL DAR DE BAJA AL PROVEEDOR");
            System.out.println(ex);
            return "Error al dar baja al proveedor!";
        }
        return "El proveedor fue dado de baja con exito!";
    }

}
