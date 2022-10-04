/*
 * SUCck nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * SUCck nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelDAO;

import DataBase.Conexion;
import Interfaces.crud_sucursal;
import Model.SUCURSAL;
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
public class SUCURSAL_DAO implements crud_sucursal {

    SUCURSAL c = new SUCURSAL();
    Conexion cn = new Conexion();
    CallableStatement cs;
    Connection con;
    ResultSet rs;

    /* ============== VARIABLES PARA PROCEDIMIENTOS ALMACENADOS ==============*/
    String LISTAR_EN_LINEA = "CALL A_SELECT_SUCURSAL_LINEA()";
    String LISTAR = "CALL A_SELECT_SUCURSAL()";
    String LISTAR_ID = "CALL A_S_ID_SUCURSAL(?)";
    String CREAR = "CALL INSERT_SUCURSAL(?,?,?,?,?,?,?)";
    String ACTUALIZAR = "CALL UPDATE_SUCURSAL(?,?,?,?,?,?,?)";
    String ELIMINAR = "CALL DELETE_SUCURSAL(?)";
    String ACTUALIZAR_ESTADO = "CALL UPDATE_SUCURSAL_ESTADO(?,?)";

    @Override
    public List listar() {
        ArrayList<SUCURSAL> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR);
            rs = cs.executeQuery();
            while (rs.next()) {
                SUCURSAL SUC = new SUCURSAL();
                SUC.setID_SUCURSAL(rs.getInt(1));
                SUC.setEMP_NOMBRE(rs.getString(2));
                SUC.setSUC_NOMBRE(rs.getString(3));
                SUC.setSUC_ESTADO(rs.getString(4));
                SUC.setSUC_TELEFONO(rs.getString(5));
                SUC.setSUC_EMAIL(rs.getString(6));
                SUC.setSUC_DIRECCION(rs.getString(7));
                SUC.setSUC_UBICACION(rs.getString(8));
                lista.add(SUC);
            }
            System.out.println(LISTAR);
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LAS SUCURSALES" + ex);
        }
        return lista;
    }

    @Override
    public SUCURSAL list(int idSucursal) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR_ID);
            cs.setInt(1, idSucursal);
            rs = cs.executeQuery();
            while (rs.next()) {
                c.setID_SUCURSAL(rs.getInt(1));
                c.setSUC_NOMBRE(rs.getString(2));
                c.setSUC_TELEFONO(rs.getString(3));
                c.setSUC_EMAIL(rs.getString(4));
                c.setSUC_DIRECCION(rs.getString(5));
                c.setSUC_UBICACION(rs.getString(6));
                c.setSUC_ESTADO(rs.getString(7));
            }
            System.out.println(LISTAR_ID);
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS CLIENTES" + ex);
        }
        return c;
    }

    @Override
    public String add(SUCURSAL suc) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(CREAR);
            cs.setInt(1, suc.getFK_EMPRESA());
            cs.setString(2, suc.getSUC_NOMBRE());
            cs.setString(3, suc.getSUC_TELEFONO());
            cs.setString(4, suc.getSUC_EMAIL());
            cs.setString(5, suc.getSUC_DIRECCION());
            cs.setString(6, suc.getSUC_UBICACION());
            cs.setString(7, suc.getSUC_ESTADO());
            cs.execute();
            System.out.println(CREAR);
        } catch (SQLException ex) {
            System.out.println("ERROR AL CREAR LA SUCURSAL");
            System.out.println(ex);
            return "La sucursal no fue creada con exito!";
        }
        return "La sucursal fue creada con exito!";
    }

    @Override
    public String update(SUCURSAL suc) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(ACTUALIZAR);
            cs.setInt(1, suc.getID_SUCURSAL());
            cs.setString(2, suc.getSUC_NOMBRE());
            cs.setString(3, suc.getSUC_TELEFONO());
            cs.setString(4, suc.getSUC_EMAIL());
            cs.setString(5, suc.getSUC_DIRECCION());
            cs.setString(6, suc.getSUC_UBICACION());
            cs.setString(7, suc.getSUC_ESTADO());
            cs.execute();
            System.out.println(ACTUALIZAR);
        } catch (SQLException ex) {
            System.out.println("ERROR AL ACTUALIZAR LA SUCURSAL");
            System.out.println(ex);
            return "La sucursal no fue actualizada con exito!";
        }
        return "La sucursal fue actualizada con exito!";
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
            System.out.println("Error al eliminar la sucursal!");
            System.out.println(ex);
            return "Error al eliminar la sucursal!";
        }
        return "La sucursal fue eliminada con exito!";
    }

    @Override
    public List listar_en_linea() {
        ArrayList<SUCURSAL> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR_EN_LINEA);
            rs = cs.executeQuery();
            while (rs.next()) {
                SUCURSAL SUC = new SUCURSAL();
                SUC.setID_SUCURSAL(rs.getInt(1));
                SUC.setSUC_NOMBRE(rs.getString(2));
                lista.add(SUC);
            }
            System.out.println(LISTAR);
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LAS SUCURSALES" + ex);
        }
        return lista;
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
            System.out.println("ERROR AL DAR DE BAJA A LA SUCURSAL");
            System.out.println(ex);
            return "Error al dar baja a la sucursal!";
        }
        return "La sucursal fue dado de baja con exito!";
    }

}
