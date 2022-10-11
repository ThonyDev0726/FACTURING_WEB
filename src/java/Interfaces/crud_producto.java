/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Model.CATEGORIA_PRODUCTO;
import Model.PRODUCTO;
import java.util.List;

/**
 *
 * @author perez
 */
public interface crud_producto{

    public List listar();

    public PRODUCTO list(int idProducto);

    public String add(PRODUCTO mp);

    public String update(PRODUCTO mp);

    public String delete(int id);

    public List listar_en_linea();

    public String actualizar_estado(int id, String estado);
}
