/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelDAO;

import DataBase.Conexion;
import Interfaces.crud_producto;
import Model.PRODUCTO;
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
public class PRODUCTO_DAO implements crud_producto {

    PRODUCTO p = new PRODUCTO();
    Conexion cn = new Conexion();
    CallableStatement cs;
    Connection con;
    ResultSet rs;

    /* ============== VARIABLES PARA PROCEDIMIENTOS ALMACENADOS ==============*/
    String LISTAR_EN_LINEA = "CALL A_SELECT_ALL_PROVEEDOR_LINEA()";
    String LISTAR = "CALL SELECT_PRODUCTO()";
    String LISTAR_ID = "CALL SELECT_ID_PRODUCTO(?)";
    String CREAR = "CALL INSERT_PRODUCTO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    String ACTUALIZAR = "CALL UPDATE_PRODUCTO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    String ELIMINAR = "CALL DELETE_PRODUCTO(?)";
    String ACTUALIZAR_ESTADO = "CALL UPDATE_PRODUCTO_ESTADO(?,?)";

    @Override
    public List listar() {
        ArrayList<PRODUCTO> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR);
            rs = cs.executeQuery();
            while (rs.next()) {
                PRODUCTO pro = new PRODUCTO();
                pro.setID_PRODUCTO(rs.getInt(1));
                pro.setPROV_NOMBRE(rs.getString(2));
                pro.setCAT_NOMBRE(rs.getString(3));
                pro.setPRO_NOMBRE(rs.getString(4));
                pro.setPRO_CODIGO(rs.getString(5));
                pro.setPRO_CODIGO_AUX(rs.getString(6));
                pro.setPRO_STOCK(rs.getInt(7));
                pro.setPRO_VALOR_FABRICA(rs.getDouble(8));
                pro.setPRO_VALOR_UNITARIO(rs.getDouble(9));
                pro.setPRO_GANANCIA(rs.getInt(10));
                pro.setPRO_IVA_TIPO(rs.getString(11));
                pro.setPRO_USO(rs.getString(12));
                pro.setPRO_USO_EXTRA(rs.getString(13));
                pro.setPRO_IMG1(rs.getString(14));
                pro.setPRO_IMG2(rs.getString(15));
                pro.setPRO_IMG3(rs.getString(16));
                pro.setPRO_IMG4(rs.getString(17));
                pro.setPRO_ESTADO(rs.getString(18));
                pro.setSUC_NOMBRE(rs.getString(19));
                lista.add(pro);
            }
            System.out.println(LISTAR);
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS PRODUCTOS" + ex);
        }
        return lista;
    }

    @Override
    public PRODUCTO list(int idProducto) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR_ID);
            cs.setInt(1, idProducto);
            rs = cs.executeQuery();
            while (rs.next()) {
                p.setID_PRODUCTO(rs.getInt(1));
                p.setPROV_NOMBRE(rs.getString(2));
                p.setFK_PROVEEDOR(rs.getInt(3));
                p.setCAT_NOMBRE(rs.getString(4));
                p.setFK_CATEGORIA(rs.getInt(5));
                p.setFK_SUCURSAL(rs.getInt(6));
                p.setPRO_NOMBRE(rs.getString(7));
                p.setPRO_CODIGO(rs.getString(8));
                p.setPRO_CODIGO_AUX(rs.getString(9));
                p.setPRO_STOCK(rs.getInt(10));
                p.setPRO_VALOR_FABRICA(rs.getDouble(11));
                p.setPRO_VALOR_UNITARIO(rs.getDouble(12));
                p.setPRO_GANANCIA(rs.getInt(13));
                p.setPRO_IVA_TIPO(rs.getString(14));
                p.setPRO_USO(rs.getString(15));
                p.setPRO_USO_EXTRA(rs.getString(16));
                p.setPRO_IMG1(rs.getString(17));
                p.setPRO_IMG2(rs.getString(18));
                p.setPRO_IMG3(rs.getString(19));
                p.setPRO_IMG4(rs.getString(20));
                p.setPRO_ESTADO(rs.getString(21));
                p.setSUC_NOMBRE(rs.getString(22));
            }
            System.out.println(LISTAR_ID);
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR EL PRODUCTO" + ex);
        }
        return p;
    }

    @Override
    public String add(PRODUCTO producto) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(CREAR);
            cs.setInt(1, producto.getFK_SUCURSAL());
            cs.setInt(2, producto.getFK_PROVEEDOR());
            cs.setInt(3, producto.getFK_CATEGORIA());
            cs.setString(4, producto.getPRO_NOMBRE());
            cs.setString(5, producto.getPRO_CODIGO());
            cs.setString(6, producto.getPRO_CODIGO_AUX());
            cs.setInt(7, producto.getPRO_STOCK());
            cs.setDouble(8, producto.getPRO_VALOR_FABRICA());
            cs.setDouble(9, producto.getPRO_VALOR_UNITARIO());
            cs.setInt(10, producto.getPRO_GANANCIA());
            cs.setString(11, producto.getPRO_IVA_TIPO());
            cs.setString(12, producto.getPRO_USO());
            cs.setString(13, producto.getPRO_USO_EXTRA());
            cs.setString(14, producto.getPRO_IMG1());
            cs.setString(15, producto.getPRO_IMG2());
            cs.setString(16, producto.getPRO_IMG3());
            cs.setString(17, producto.getPRO_IMG4());
            cs.setString(18, producto.getPRO_CREACION());
            cs.setString(19, producto.getPRO_CREADOR());
            cs.setString(20, producto.getPRO_IP());
            cs.setString(21, producto.getPRO_ESTADO());
            cs.execute();
            System.out.println(CREAR);
        } catch (SQLException ex) {
            System.out.println("ERROR AL CREAR EL PRODUCTO");
            System.out.println(ex);
            return "El producto no fue creado con exito!";
        }
        return "El producto fue creado con exito!";
    }

    @Override
    public String update(PRODUCTO pro) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(ACTUALIZAR);
            cs.setInt(1, pro.getID_PRODUCTO());
            cs.setInt(2, pro.getFK_SUCURSAL());
            cs.setInt(3, pro.getFK_PROVEEDOR());
            cs.setInt(4, pro.getFK_CATEGORIA());
            cs.setString(5, pro.getPRO_NOMBRE());
            cs.setString(6, pro.getPRO_CODIGO());
            cs.setString(7, pro.getPRO_CODIGO_AUX());
            cs.setInt(8, pro.getPRO_STOCK());
            cs.setDouble(9, pro.getPRO_VALOR_FABRICA());
            cs.setDouble(10, pro.getPRO_VALOR_UNITARIO());
            cs.setInt(11, pro.getPRO_GANANCIA());
            cs.setString(12, pro.getPRO_IVA_TIPO());
            cs.setString(13, pro.getPRO_USO());
            cs.setString(14, pro.getPRO_USO_EXTRA());
            cs.setString(15, pro.getPRO_IMG1());
            cs.setString(16, pro.getPRO_IMG2());
            cs.setString(17, pro.getPRO_IMG3());
            cs.setString(18, pro.getPRO_IMG4());
            cs.setString(19, pro.getPRO_ESTADO());
            cs.execute();
            System.out.println(ACTUALIZAR);
        } catch (SQLException ex) {
            System.out.println("ERROR AL ACTUALIZAR EL PRODUCTO");
            System.out.println(ex);
            return "El producto no fue actualizado con exito!";
        }
        return "El producto fue actualizado con exito!";
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
            System.out.println("Error al eliminar el producto!");
            System.out.println(ex);
            return "Error al eliminar el producto!";
        }
        return "El producto fue eliminada con exito!";
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
            System.out.println("ERROR AL DAR DE BAJA AL PRODUCTO");
            System.out.println(ex);
            return "Error al dar baja al producto!";
        }
        return "El producto fue dada de baja con exito!";
    }

}
