/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Model.NOTA_VENTA;
import java.util.List;

/**
 *
 * @author perez
 */
public interface crud_nota_venta {

    public List listar();

    public NOTA_VENTA list(int idNot_venta);

    public String add(NOTA_VENTA mp);

    public String update(NOTA_VENTA mp);

    public String delete(int id);

    public List listar_en_linea();

    public String actualizar_estado(int id, String estado);
}
