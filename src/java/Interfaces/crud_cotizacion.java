/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Model.COTIZACION;
import java.util.List;

/**
 *
 * @author perez
 */
public interface crud_cotizacion {

    public List listar();

    public COTIZACION list(int idCotizacion);

    public String add(COTIZACION mp);

    public String update(COTIZACION mp);

    public String delete(int id);

    public List listar_en_linea();

    public String actualizar_estado(int id, String estado);
}
