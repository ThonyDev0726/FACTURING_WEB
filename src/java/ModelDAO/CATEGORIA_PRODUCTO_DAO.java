/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelDAO;

import DataBase.Conexion;
import Model.CATEGORIA_PRODUCTO;
import java.util.List;
import Interfaces.crud_categoria_producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author perez
 */
public class CATEGORIA_PRODUCTO_DAO implements crud_categoria_producto {

    CATEGORIA_PRODUCTO c = new CATEGORIA_PRODUCTO();
    Conexion cn = new Conexion();
    CallableStatement cs;
    Connection con;
    ResultSet rs;

    /* ============== VARIABLES PARA PROCEDIMIENTOS ALMACENADOS ==============*/
    String LISTAR_EN_LINEA = "CALL A_SELECT_CLIENTE_LINEA()";
    String LISTAR = "CALL A_SELECT_CATEGORIA()";
    String LISTAR_ID = "CALL A_SELECT_ID_CATEGORIA(?)";
    String CREAR = "CALL INSERT_CATEGORIA(?,?,?)";
    String ACTUALIZAR = "CALL UPDATE_CATEGORIA_PRODUCTO(?,?,?)";
    String ELIMINAR = "CALL DELETE_CATEGORIA_PRODUCTO(?)";
    String ACTUALIZAR_ESTADO = "CALL UPDATE_CATEGORIA_ESTADO(?,?)";

    @Override
    public List listar() {
        ArrayList<CATEGORIA_PRODUCTO> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR);
            rs = cs.executeQuery();
            while (rs.next()) {
                CATEGORIA_PRODUCTO cli = new CATEGORIA_PRODUCTO();
                cli.setID_CATEGORIA(rs.getInt(1));
                cli.setCAT_DESCRIPCION(rs.getString(2));
                cli.setCAT_ESTADO(rs.getString(3));
                lista.add(cli);
            }
            System.out.println(LISTAR);
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS CLIENTES" + ex);
        }
        return lista;
    }

    @Override
    public CATEGORIA_PRODUCTO list(int idCategoria_producto) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR_ID);
            cs.setInt(1, idCategoria_producto);
            rs = cs.executeQuery();
            while (rs.next()) {
                c.setID_CATEGORIA(rs.getInt(1));
                c.setCAT_DESCRIPCION(rs.getString(2));
                c.setCAT_ESTADO(rs.getString(3));
            }
            System.out.println(LISTAR_ID);
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LA CATEGORIA" + ex);
        }
        return c;
    }

    @Override
    public String add(CATEGORIA_PRODUCTO cat) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(CREAR);
            cs.setString(1, cat.getCAT_DESCRIPCION());
            cs.setString(2, cat.getCAT_ESTADO());
            cs.setString(3, cat.getCAT_IP());
            cs.execute();
            System.out.println(CREAR);
        } catch (SQLException ex) {
            System.out.println("ERROR AL CREAR EL CLIENTE");
            System.out.println(ex);
            return "La categoria no fue creada con exito!";
        }
        return "La categoria fue creada con exito!";
    }

    @Override
    public String update(CATEGORIA_PRODUCTO ct) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ACTUALIZAR);
            cs.setInt(1, ct.getID_CATEGORIA());
            cs.setString(2, ct.getCAT_DESCRIPCION());
            cs.setString(3, ct.getCAT_ESTADO());
            System.out.println(ACTUALIZAR);
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR AL ACTUALIZAR LA CATEGORIA DE PRODUCTO");
            System.out.println(ex);
            return "La categoria de producto no fue actualizada!";
        }
        return "La categoria de producto fue actualizada con exito!";
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
            System.out.println("Error al eliminar la categoria!");
            System.out.println(ex);
            return "Error al eliminar la categoria!";
        }
        return "La categoria fue eliminada con exito!";
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
            System.out.println("ERROR AL DAR DE BAJA A LA CATEGORIA DE PRODUCTO");
            System.out.println(ex);
            return "Error al dar baja a la categoria de producto!";
        }
        return "La categoria de producto fue dada de baja con exito!";
    }

}
