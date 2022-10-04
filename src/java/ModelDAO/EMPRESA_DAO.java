/*
 * EMPck nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * EMPck nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelDAO;

import DataBase.Conexion;
import Model.EMPRESA;
import Interfaces.crud_pagina_empresa;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author perez
 */
public class EMPRESA_DAO implements crud_pagina_empresa {

    
    EMPRESA c = new EMPRESA();
    Conexion cn = new Conexion();
    CallableStatement cs;
    Connection con;
    ResultSet rs;

    /* ============== VARIABLES PARA PROCEDIMIENTOS ALMACENADOS ==============*/
    String LISTAR = "CALL SELECT_EMPRESA()";
    String ACTUALIZAR = "CALL UPDATE_EMPRESA(?,?,?,?,?,?,?,?,?,?,?,?)";
    @Override
    public EMPRESA list() {
    try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR);
            rs = cs.executeQuery();
            while (rs.next()) {
                c.setID_EMPRESA(rs.getInt(1));
                c.setEMP_NOMBRE(rs.getString(2));
                c.setEMP_RUC(rs.getString(3));
                c.setEMP_TELEFONO(rs.getString(4));
                c.setEMP_EMAIL(rs.getString(5));
                c.setEMP_DIRECCION(rs.getString(6));
                c.setEMP_UBICACION(rs.getString(7));
                c.setEMP_FACEBOOK(rs.getString(8));
                c.setEMP_INSTAGRAM(rs.getString(9));
                c.setEMP_TIKTOK(rs.getString(10));
                c.setEMP_TWITTER(rs.getString(11));
                c.setEMP_IMG(rs.getString(12));
            }
            System.out.println(LISTAR);
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LA EMPRESA" + ex);
        }
        return c;    
    }

    @Override
    public String update(EMPRESA emp) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ACTUALIZAR);
            cs.setInt(1, emp.getID_EMPRESA());
            cs.setString(2, emp.getEMP_NOMBRE());
            cs.setString(3, emp.getEMP_RUC());
            cs.setString(4, emp.getEMP_TELEFONO());
            cs.setString(5, emp.getEMP_EMAIL());
            cs.setString(6, emp.getEMP_DIRECCION());
            cs.setString(7, emp.getEMP_UBICACION());
            cs.setString(8, emp.getEMP_FACEBOOK());
            cs.setString(9, emp.getEMP_INSTAGRAM());
            cs.setString(10, emp.getEMP_TIKTOK());
            cs.setString(11, emp.getEMP_TWITTER());
            cs.setString(12, emp.getEMP_IMG());
            System.out.println(ACTUALIZAR);
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR AL ACTUALIZAR EL EMPENTE");
            System.out.println(ex);
            return "El EMPente no fue actualizado!";
        }
        return "El EMPente fue actualizado con exito!";
    }

}
