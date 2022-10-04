/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Model.PAG_INICIO;
import java.util.List;

/**
 *
 * @author perez
 */
public interface crud_pagina_inicio {

    public List listar();

    public PAG_INICIO list(int idPag_inicio);

    public String add(PAG_INICIO mp);

    public String update(PAG_INICIO mp);

    public String delete(int id);

    public List listar_en_linea();

    public String actualizar_estado(int id, String estado);
}
