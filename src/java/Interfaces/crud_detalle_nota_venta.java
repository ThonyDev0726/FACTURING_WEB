/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Model.DETALLE_NOTA;
import java.util.List;

/**
 *
 * @author perez
 */
public interface crud_detalle_nota_venta {

    public List listar();

    public DETALLE_NOTA list(int idNota_venta);

    public String add(DETALLE_NOTA mp);

    public String update(DETALLE_NOTA mp);

    public String delete(int id);

    public List listar_en_linea();

    public String actualizar_estado(int id, String estado);
}
