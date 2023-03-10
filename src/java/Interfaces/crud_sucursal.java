/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Model.SUCURSAL;
import java.util.List;

/**
 *
 * @author perez
 */
public interface crud_sucursal {

    public List listar();

    public SUCURSAL list(int idSucursal);

    public String add(SUCURSAL mp);

    public String update(SUCURSAL mp);

    public String delete(int id);

    public List listar_en_linea();

    public String actualizar_estado(int id, String estado);

}
