/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Model.DETALLE_PRODUCTO;
import java.util.List;

/**
 *
 * @author perez
 */
public interface crud_detalle_producto {

    public List listar();

    public DETALLE_PRODUCTO list(int idDetalle_producto);

    public String add(DETALLE_PRODUCTO mp);

    public String update(DETALLE_PRODUCTO mp);

    public String delete(int id);

    public List listar_en_linea();

    public String actualizar_estado(int id, String estado);

}
