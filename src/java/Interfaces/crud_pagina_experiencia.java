/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Model.PAGINA_EXPERIENCIA;
import java.util.List;

/**
 *
 * @author perez
 */
public interface crud_pagina_experiencia {

    public List listar();

    public PAGINA_EXPERIENCIA list(int idPag_experiencia);

    public String add(PAGINA_EXPERIENCIA mp);

    public String update(PAGINA_EXPERIENCIA mp);

    public String delete(int id);

    public List listar_en_linea();

    public String actualizar_estado(int id, String estado);

}
