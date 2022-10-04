/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Model.PROVEEDOR;
import java.util.List;

/**
 *
 * @author perez
 */
public interface crud_proveedor {

    public List listar();

    public PROVEEDOR list(int idProveedor);

    public String add(PROVEEDOR mp);

    public String update(PROVEEDOR mp);

    public String delete(int id);

    public List listar_en_linea();

    public String actualizar_estado(int id, String estado);
}
