/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Model.FACTURA;
import java.util.List;

/**
 *
 * @author perez
 */
public interface crud_factura {

    public List listar();

    public FACTURA list(int idFactura);

    public String add(FACTURA mp);

    public String update(FACTURA mp);

    public String delete(int id);

    public List listar_en_linea();

    public String actualizar_estado(int id, String estado);

}
