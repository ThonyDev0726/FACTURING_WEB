/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Model.DETALLE_EMAIL;
import java.util.List;

/**
 *
 * @author perez
 */
public interface crud_detalle_emails {
 
   public List listar();

    public DETALLE_EMAIL list(int idDetalle_email);

    public String add(DETALLE_EMAIL mp);

    public String update(DETALLE_EMAIL mp);

    public String delete(int id);
    
    public List listar_en_linea();

    public String actualizar_estado(int id, String estado);
    
    
}
