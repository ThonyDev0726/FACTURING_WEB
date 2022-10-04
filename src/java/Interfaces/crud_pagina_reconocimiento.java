/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Model.PAGINA_RECONOCIMIENTO;
import java.util.List;

/**
 *
 * @author perez
 */
public interface crud_pagina_reconocimiento {

    public List listar();

    public PAGINA_RECONOCIMIENTO list(int idPag_reconocimiento);

    public String add(PAGINA_RECONOCIMIENTO mp);

    public String update(PAGINA_RECONOCIMIENTO mp);

    public String delete(int id);

    public List listar_en_linea();

    public String actualizar_estado(int id, String estado);
}
