/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Model.CATEGORIA_PRODUCTO;
import java.util.List;

/**
 *
 * @author perez
 */
public interface crud_categoria_producto {

    public List listar();

    public CATEGORIA_PRODUCTO list(int idCategoria_producto);

    public String add(CATEGORIA_PRODUCTO mp);

    public String update(CATEGORIA_PRODUCTO mp);

    public String delete(int id);

    public List listar_en_linea();

    public String actualizar_estado(int id, String estado);

}
