/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Model.FACTURACION_CALCULO;
import java.util.List;

/**
 *
 * @author perez
 */
public interface crud_factura_calculo {

    public List listar();

    public FACTURACION_CALCULO list(int idFacturacion_calculo);

    public String add(FACTURACION_CALCULO mp);

    public String update(FACTURACION_CALCULO mp);

    public String delete(int id);

    public List listar_en_linea();

    public String actualizar_estado(int id, String estado);
}
